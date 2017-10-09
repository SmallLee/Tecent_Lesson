package tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HelloSimpleTag implements SimpleTag {
    private PageContext pageContext;
    private String value;
    private int count;

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("doTag");
        pageContext.getOut().println("hello world");
        for (int i = 0; i < count; i++) {
            System.out.println(value);
        }
    }

    @Override
    public void setParent(JspTag jspTag) {
        System.out.println("setParent");
    }

    @Override
    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }
    //JSP引擎调用，把代表JSP页面的pageContext对象传入
    //pageContext可以获取JSP页面的其他8个隐含对象
    //所以，在JSP页面能做的，标签处理器都可以完成
    @Override
    public void setJspContext(JspContext jspContext) {
        pageContext = (PageContext) jspContext;
        System.out.println("setJspContext");
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        System.out.println("setJspBody");
    }

}
