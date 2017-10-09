package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class TestBodyTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = getJspBody();
//        jspBody.getJspContext().getOut()
//        jspBody.invoke(null);
        //1.利用StringWriter得到标签体的内容
        StringWriter stringWriter = new StringWriter();
        jspBody.invoke(stringWriter);
        //把标签体的内容变为大写
        String content = stringWriter.toString().toUpperCase();
        //输出到页面上
        getJspBody().getJspContext().getOut().write(content);
        System.out.println(stringWriter);
    }
}
