package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TestParentTag extends SimpleTagSupport {

    private String name = "atguigu";

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("父标签的name: "+name);
        getJspBody().invoke(null);
    }
}
