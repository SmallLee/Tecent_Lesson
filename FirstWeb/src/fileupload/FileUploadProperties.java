package fileupload;

import dao.Person;

import java.util.HashMap;
import java.util.Map;

public class FileUploadProperties {
    private Map<String,String> properties = new HashMap<String,String>();
    private FileUploadProperties(){};
    public FileUploadProperties(String name){

    };

    //静态内部类实现单例
    private static class FileUploadHolder{
       private static final FileUploadProperties INSTANCE = new FileUploadProperties();
    }

    public static final FileUploadProperties getInstance(){
        return FileUploadHolder.INSTANCE;
    }

    public void setProperty(String propertyName,String propertyValue){
        properties.put(propertyName,propertyValue);
    }
    public String getProperty(String propertyName){
        return properties.get(propertyName);
    }
}
