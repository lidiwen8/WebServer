package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class InsertImgServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doPost(request, response);
            }
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");//解决编码问题
            FileItemFactory factory = new DiskFileItemFactory();
                // 创建文件上传处理器
                ServletFileUpload upload = new ServletFileUpload(factory);
                // 开始解析请求信息
                List items = null;
                try {
                    items = upload.parseRequest(request);
                }
                catch (FileUploadException e) {
                    e.printStackTrace();
                }
                // 对所有请求信息进行判断
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    // 信息为普通的格式
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String value = item.getString();
                        request.setAttribute(fieldName, value);
                    }
                    // 信息为文件格式
                    else {
                        String fileName = item.getName();
                        System.out.println(fileName);
                        int index = fileName.lastIndexOf("\\");
                        fileName = fileName.substring(index + 1);
                        request.setAttribute("realFileName", fileName);
                        String basePath = request.getRealPath("C:\\Users\\16320\\Desktop\\课程\\java企业级开发\\Demo6\\web\\uplod\\images");
                        File file = new File(basePath, fileName);
                        try {
                            item.write(file);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    request.setAttribute("msg","文件上传成功!");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                }
        }

}
