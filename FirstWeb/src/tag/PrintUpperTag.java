package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class PrintUpperTag extends SimpleTagSupport{
    private String time;

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public void doTag() throws JspException, IOException {
        int count;
        count = Integer.parseInt(time);
        JspFragment jspBody = getJspBody();
        //利用StringWriter得到标签体的内容
        StringWriter sw = new StringWriter();
        jspBody.invoke(sw);
        for (int i = 0; i < count; i++) {
            String content = sw.toString().toUpperCase();
            getJspContext().getOut().write(content+"<br>");
        }
    }
}
