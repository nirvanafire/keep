package top.vkeep.smart.helper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.bean.FileParam;
import top.vkeep.smart.bean.FormParam;
import top.vkeep.smart.bean.Param;
import top.vkeep.smart.util.CollectionUtil;
import top.vkeep.smart.util.FileUtil;
import top.vkeep.smart.util.StreamUtil;
import top.vkeep.smart.util.StringUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件上传助手
 * <p>@author: Zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018-07-15
 **/
public final class UploaderHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploaderHelper.class);

    /**
     * Apache Commons FileUpload提供的Servlet文件上传对象
     *
     */
    private static ServletFileUpload servletFileUpload;

    /**
     * 初始化
     */
    public static void init(ServletContext servletContext) {
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(
                DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository
        ));
        int uploadLimit = ConfigHelper.getAppUploadLimit();
        if (uploadLimit != 0) {
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }

    /**
     * 判断请求是否为multipart
     * 可以通过isMultipart方法来判断当前请求是否为文件上传请求
     */
    public static boolean isMultipart(HttpServletRequest request) {
        return ServletFileUpload.isMultipartContent(request);
    }

    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) {
        List<FormParam> formParamList = new ArrayList<>();
        List<FileParam> fileParamList = new ArrayList<>();

        try {
            Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if (CollectionUtil.isNotEmpty(fileItemListMap)) {
                for (Map.Entry<String, List<FileItem>> fileItemListEntry : fileItemListMap.entrySet()) {
                    String fieldName = fileItemListEntry.getKey();
                    List<FileItem> fileItemList = fileItemListEntry.getValue();
                    if (CollectionUtil.isNotEmpty(fileItemList)) {
                        for (FileItem fileItem : fileItemList) {
                            if (fileItem.isFormField()) {
                                // 表单参数
                                String fieldValue = fileItem.getString("UTF-8");
                                formParamList.add(new FormParam(fieldName, fieldValue));
                            } else {
                                // 文件参数
                                String fileName = FileUtil.getRealFileName(
                                        new String(fileItem.getName().getBytes(), "UTF-8"));
                                if (StringUtil.isNotEmpty(fieldName)) {
                                    long fileSize = fileItem.getSize();
                                    String contentType = fileItem.getContentType();
                                    InputStream inputStream = fileItem.getInputStream();
                                    fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, inputStream));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("create param failure", e);
            throw new RuntimeException(e);
        }
        return new Param(formParamList, fileParamList);
    }

    /**
     * 上传文件
     */
    public static void uploadFile(String basePath, FileParam fileParam) {
        InputStream inputStream = null;
        try {
            if (fileParam != null) {
                String filePath = basePath + fileParam.getFileName();
                FileUtil.createFile(filePath);
                inputStream = new BufferedInputStream(fileParam.getInputStream());
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
                StreamUtil.copyStream(inputStream, outputStream);
            }
        } catch (Exception e) {
            LOGGER.error("upload file failure", e);
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.error("close stream failure", e);
            }
        }
    }

    /**
     * 批量上传文件
     */
    public static void uploadFile(String basePath, List<FileParam> fileParamList) {
        try {
            if (CollectionUtil.isNotEmpty(fileParamList)) {
                for (FileParam fileParam : fileParamList) {
                    uploadFile(basePath, fileParam);
                }
            }
        } catch (Exception e) {
            LOGGER.error("upload file failure", e);
            throw new RuntimeException(e);
        }
    }
}
