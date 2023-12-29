package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Lastname extends TagSupport {
    private String value = "";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {   // нужен для того, чтобы напечатать что-то на странице
        JspWriter out = pageContext.getOut();       // получаем поток вывода
        try {
            out.print("<label style=\"font-weight: bold; margin-right: 10px;\">Lastname:</label>");
            out.print("<input name=\"lastname\" type=\"text\" style=\"width: 150px; padding: 5px; border: 1px solid #ccc;\" maxlength=\"30\" ");

            if (!this.value.equals("")) {
                out.print("value=\"" + this.value + "\"");
            }

            out.print(" />");
        } catch (IOException e) {
            System.out.println("Lastname: " + e);
        }
        return SKIP_BODY;
    }
}