package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TestSontTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        //获得父标签的引用
        JspTag parent = getParent();
        //获得父标签的name属性
        TestParentTag testParentTag = (TestParentTag) parent;
        String name = testParentTag.getName();
        //把name输出到页面上
        getJspContext().getOut().write(name);
    }
}
