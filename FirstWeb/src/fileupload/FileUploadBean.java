package fileupload;

public class FileUploadBean {
    private int id;
    //文件名
    private String fileName;
    //文件路径
    private String filePath;
    //文件描述
    private String fileDesc;

    public int getId() {
        return id;
    }
    public FileUploadBean() {}

    public FileUploadBean(String fileName, String filePath, String fileDesc) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileDesc = fileDesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }
}
