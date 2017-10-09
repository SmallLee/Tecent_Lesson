package tag;

import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;

public class ReadFileTag extends SimpleTagSupport {
    private String src;
    public void setSrc(String src) {
        System.out.println(src);
        this.src = src;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        try {
            InputStream is = pageContext.getServletContext().getResourceAsStream(src);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = bfr.readLine()) != null) {
                str = new String(str.getBytes(),"utf-8");
                pageContext.getOut().write(str);
                pageContext.getOut().write("<br>");
            }
        } catch (Exception e) {
            System.out.println("找不到文件");
        }
    }
}
