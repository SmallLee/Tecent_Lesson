package servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import fileupload.FileUploadBean;
import fileupload.FileUploadProperties;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@WebServlet(name = "FileUploadServlet",urlPatterns = "/fileupload")
public class FileUploadServlet extends HttpServlet {
    public static final String FILE_PATH = "/WEB-INF/files";
    @Override
    public void init() throws ServletException {
        super.init();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fileupload/upload.properties");
        Properties pro = new Properties();
        try {
            pro.load(inputStream);
            String extension = pro.getProperty("extension");
            String fileMaxSize = pro.getProperty("fileMaxSize");
            String totalFileSize = pro.getProperty("totalFileSize");
            System.out.println(extension+""+fileMaxSize+""+totalFileSize);
            System.out.println("classloader: "+getClass().getClassLoader().getResource(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = getServletFileUpload();

        List<FileItem> fileItems = null;
        try {
            //文件路径和对应的FileItem对象
            Map<String,FileItem> uploadFiles = new HashMap<String,FileItem>();
            //解析请求，得到FileItem对象
            fileItems  = fileUpload.parseRequest(req);
                //1.构建FileUploadBean,填充uploadFiles
            List<FileUploadBean> beanList = buildFileUploadBeans(fileItems,uploadFiles);

                //2.检验扩展名
            validateExtension();
                //3.校验文件大小
                //4.上传
            upload(uploadFiles);
                //5.保存到数据库
            saveBeans(beanList);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void saveBeans(List<FileUploadBean> beanList) {
    }

    private void upload(Map<String, FileItem> uploadFiles) throws IOException {
        System.out.println("size： "+uploadFiles.entrySet().size());
        for (Map.Entry<String,FileItem> uploadFile : uploadFiles.entrySet()) {
            String filePath = uploadFile.getKey();
            FileItem fileItem = uploadFile.getValue();
            beginUpload(filePath,fileItem.getInputStream());
        }
    }

    public void beginUpload(String filePath,InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        OutputStream  out = new FileOutputStream(filePath);
        while((len = inputStream.read(buffer))!= -1) {
            out.write(buffer,0, len);
        }
        inputStream.close();
        out.close();
        System.out.println(filePath);
    }

    private void validateExtension() {
    }

    /**
     * 构建FileUploadBean,并填充uploadFiles
     * FileUploadBean一个文件对应的实体类，包括文件id,name,path
     * uploadFiles :Map<String,FileItem>,
     * @param fileItems
     * @param uploadFiles
     * @return
     */
    private List<FileUploadBean> buildFileUploadBeans(List<FileItem> fileItems, Map<String, FileItem> uploadFiles) {
        List<FileUploadBean> beanList = new ArrayList<FileUploadBean>();
        Map<String,String> descs = new HashMap<String,String>();
        for (FileItem item : fileItems) {
            if (item.isFormField()) {
                descs.put(item.getFieldName(),item.getString());
            }
        }
        for (FileItem item : fileItems) {
            if (!item.isFormField()) {
                String filedName = item.getFieldName();
                String index = filedName.substring(filedName.length() - 1);
                String fileName = item.getName();
                String desc = descs.get("desc" + index);
                String filePath = getFilePath(fileName);
                System.out.println("filePath: "+filePath);
                FileUploadBean fileUploadBean = new FileUploadBean(fileName,filePath,desc);
                beanList.add(fileUploadBean);
                uploadFiles.put(filePath,item);
            }
        }
        return beanList;
    }

    /**
     * 根据给定的文件名构建一个文件路径
     * @param filedName
     * @return
     */
    private String getFilePath(String filedName) {
        String ext = filedName.substring(filedName.lastIndexOf("."));
        Random random = new Random();
        long randomNumber = random.nextLong();
        String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + randomNumber + ext;
        return filePath;
    }

    /**
     * 构建ServletFileUpload对象，
     * 从配置文件中读取了属性，用于约束
     * @return
     */
    private ServletFileUpload getServletFileUpload() {
        //当表单的enctype改变以后，不能使用下面的方式获取请求参数了
        //        String desc = req.getParameter("desc");
//        String file = req.getParameter("file");
//        System.out.println(desc);
//        System.out.println(file);
//        InputStream s1 = getClass().getResourceAsStream("upload.properties");
//        InputStream s2 = getClass().getResourceAsStream("/fileupload/upload.properties");
//        System.out.println(s1+"----"+s2);
        String extension = FileUploadProperties.getInstance().getProperty("extension");
        String fileMaxSize = FileUploadProperties.getInstance().getProperty("fileMaxSize");
        String totalFileSize = FileUploadProperties.getInstance().getProperty("totalFileSize");
        System.out.println(extension+"--"+fileMaxSize+"--"+totalFileSize);

        //1.得到FileItem集合
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //500k，临界值，超出这个临界值文件会被保存在临时目录中
        factory.setSizeThreshold(1024 * 500);
        //创建文件临时解析的目录
        File temporyFile = new File("c:\\temporyFile");
        factory.setRepository(temporyFile);
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //请求消息实体内容的最大允许大小,也就是上传文件的最大容量
        fileUpload.setSizeMax(Long.parseLong(totalFileSize));//5M
        fileUpload.setFileSizeMax(Long.parseLong(fileMaxSize));
        fileUpload.setHeaderEncoding("UTF-8");//防止文件名乱码
        return fileUpload;
    }
}
/*
* 文本文件
* file---新建文本文档.txt---text/plain---25185
* 图片
* file---QQ图片20171017164804.jpg---image/jpeg---58714
*
*
* */
