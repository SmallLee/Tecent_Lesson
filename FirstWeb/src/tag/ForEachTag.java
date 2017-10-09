package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ForEachTag extends SimpleTagSupport {
    private Collection<?> items;
    private String var;
    public void setItems(Collection<?> items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = getJspBody();
        for (Object obj : items) {
            //把对象放入到pageContext中，键是var，值是对象
           getJspContext().setAttribute(var,obj);
           jspBody.invoke(null);
       }
    }
}
