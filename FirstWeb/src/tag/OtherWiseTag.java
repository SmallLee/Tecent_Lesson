package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class OtherWiseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag chooseTag = (ChooseTag) getParent();
        if (chooseTag.isFlag()) {
            getJspBody().invoke(null);
        }
    }
}
