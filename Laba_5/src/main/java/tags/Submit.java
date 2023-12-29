package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Submit extends TagSupport {
    private String submitContent = "<input type='submit' value='Ok' style='background-color: #4CAF50; " +
            "color: white; border: none; padding: 10px 20px; margin: 10px;' />" +
            " <input type='button' value='Cancel' style='background-color: #f44336; " +
            "color: white; border: none; padding: 10px 20px; margin: 10px;' />";

    @Override
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();
        try
        {
            out.print(submitContent);
        }
        catch (IOException e)
        {
            System.out.println("Submit:" + e);
        }
        return SKIP_BODY;
    }
}