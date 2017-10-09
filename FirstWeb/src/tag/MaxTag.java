package tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MaxTag implements SimpleTag {

    private String num1;
    private String num2;
    private JspContext jspContext;

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    @Override
    public void doTag() throws JspException, IOException {
        int a = 0;
        int b = 0;
        JspWriter out = jspContext.getOut();
        try {
            a = Integer.parseInt(num1);
            b = Integer.parseInt(num2);
            out.println(a > b ? a : b);
        } catch (Exception e){
            System.out.println("输入的参数格式不正确");
        }
    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.jspContext= jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
