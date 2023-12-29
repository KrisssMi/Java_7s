package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Surname extends TagSupport
{
    static String in = "<label>Surname&nbsp &nbsp</label>"
            + "<input name =\"surname\" type = \"text\" width = \"150\" "
            + " maxlength= \"30\" ";

    public String value = "";

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<label style=\"font-weight: bold; margin-right: 10px;\">Surname:</label>");
            out.print("<input name=\"surname\" type=\"text\" style=\"width: 150px; padding: 5px; border: 1px solid #ccc;\" maxlength=\"30\" ");

            if (!this.value.equals("")) {
                out.print("value=\"" + this.value + "\"");
            }
            out.print(" />");
        } catch (IOException e) {
            System.out.println("Surname: " + e);
        }
        return SKIP_BODY;
    }
}