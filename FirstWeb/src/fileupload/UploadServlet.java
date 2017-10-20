package fileupload;

import com.sun.prism.shader.FillEllipse_Color_AlphaTest_Loader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "UploadServlet",urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String desc = req.getParameter("desc");
//        String file = req.getParameter("file");
//        System.out.println(desc);
//        System.out.println(file);
        Properties prop = new Properties();
        InputStream is = new FileInputStream("D:\\JavaProject\\Tecent_Lesson\\FirstWeb\\src\\fileupload\\upload.properties");
        prop.load(is);
        String extension = prop.getProperty("extension");
        System.out.println("extension: "+extension);
        req.setCharacterEncoding("UTF-8");
        //1.得到FileItem集合
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //500k，临界值，超出这个临界值文件会被保存在临时目录中
        factory.setSizeThreshold(1024 * 500);
        //创建文件临时解析的目录
        File temporyFile = new File("c:\\temporyFile");
        factory.setRepository(temporyFile);
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //请求消息实体内容的最大允许大小,也就是上传文件的最大容量
        fileUpload.setSizeMax(1024 * 1024 * 5);//5M
        fileUpload.setHeaderEncoding("UTF-8");//防止文件名乱码
        List<FileItem> fileItems = null;
        try {
            fileItems  = fileUpload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //2.遍历items
        if (fileItems != null && fileItems.size() >  0) {
            for (FileItem fileItem : fileItems) {
                //表单域
                if (fileItem.isFormField()) {
                    //表单域名称
                    String name = fileItem.getFieldName();
                    //表单域值
                    String string = fileItem.getString();
                    System.out.println(name+"----"+string);
                } else {
                    //文件
                    String fieldName = fileItem.getFieldName();
                    String filename = fileItem.getName();
                    String contentType = fileItem.getContentType();
                    //文件大小，字节
                    long size = fileItem.getSize();
                    System.out.println(fieldName+"---"+filename+"---"+contentType+"---"+size);
                    InputStream in = fileItem.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    filename = "c:\\files\\"+filename;
                    System.out.println(filename);
                    OutputStream out = new FileOutputStream(filename);
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                }
            }
        }
    }
}
/*
* 文本文件
* file---新建文本文档.txt---text/plain---25185
* 图片
* file---QQ图片20171017164804.jpg---image/jpeg---58714
* */