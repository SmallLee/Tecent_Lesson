import java.io.UnsupportedEncodingException;

public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = new String("我".getBytes(),"utf-8");
        String str2 = new String("我".getBytes(),"gbk");
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str.equals(str2));
    }
}
