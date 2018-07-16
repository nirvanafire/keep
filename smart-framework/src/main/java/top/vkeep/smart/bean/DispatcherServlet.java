package top.vkeep.smart.bean;

import top.vkeep.smart.HelperLoader;
import top.vkeep.smart.helper.*;
import top.vkeep.smart.util.JsonUtil;
import top.vkeep.smart.util.ReflectUtil;
import top.vkeep.smart.util.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 请求转发器
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/4
 **/
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 初始化相关Helper类
        HelperLoader.init();
        // 获取ServletContext对象（用于注册Servlet）
        ServletContext servletContext = config.getServletContext();

        // 注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        // 注册处理器静态资源的默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssertPath());

        // 初始化文件Helper类
        UploaderHelper.init(servletContext);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方法与请求路径
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();

        // 过滤favicon.ico请求
        if (requestPath.equals("/favicon.ico")) {
            return ;
        }

        // 获取Action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            // 获取Controller类及其Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            Param param;
            if (UploaderHelper.isMultipart(request)) {
                param = UploaderHelper.createParam(request);
            } else {
                param = RequestHelper.createParam(request);
            }

            Object result;
            // 调用Action方法
            Method actionMethod = handler.getActionMethod();
            if (param.isEmpty()) {
                result = ReflectUtil.invokeMethod(controllerBean, actionMethod);
            } else {
                result = ReflectUtil.invokeMethod(controllerBean, actionMethod, param);
            }

            // 处理Action返回值
            if (result instanceof View) {
                // 返回JSP页面
                View view = (View) result;
                handleViewResult(view, request, response);
            } else if (result instanceof Data) {
                // 返回JSON数据
                Data data = (Data) result;
                handleDateResult(data, request, response);
            }
        }

    }

    private void handleViewResult(View view, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = view.getPath();
        if (StringUtil.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                // 重定向
                response.sendRedirect(request.getContextPath() + path);
            } else {
                Map<String, Object> model = view.getModel();
                for (Map.Entry<String, Object> entry : model.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                // 转发
                request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path)
                        .forward(request, response);
            }
        }
    }

    private void handleDateResult(Data data, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object model = data.getModel();
        if (model != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
