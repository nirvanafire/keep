package top.vkeep.chapter5.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.chapter5.entity.User;
import top.vkeep.chapter5.util.DatabaseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-17
 **/
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");

        DefaultPasswordService passwordService = new DefaultPasswordService();
        String encryptPassword = passwordService.encryptPassword(password);

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("username", username);
        userMap.put("password", encryptPassword);
        boolean result = DatabaseHelper.insertEntity(User.class, userMap);

        if (result) {
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(username, password));
            } catch (IncorrectCredentialsException e) {
                logger.error("incorrect credentials", e);
            }

            resp.sendRedirect("/");
            return;
        } else {
            logger.debug("注册失败");
            resp.sendRedirect("/register");
        }

    }
}
