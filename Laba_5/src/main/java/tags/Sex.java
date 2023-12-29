package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Sex extends TagSupport
{
    private String content = "<label style=\"font-weight: bold; margin-right: 10px;\">Sex:</label>"
            + "<input name=\"sex\" value=\"Male\" type=\"radio\" style=\"margin-right: 5px;\">Male"
            + "<input name=\"sex\" value=\"Female\" type=\"radio\" style=\"margin-right: 5px;\">Female";

    @Override
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();
        try
        {
            out.print(content);
        }
        catch (IOException e)
        {
            System.out.println("Sex: " + e);
        }
        return SKIP_BODY;
    }
}