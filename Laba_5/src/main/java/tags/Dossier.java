package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Dossier extends TagSupport {
    private String action = "";

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            out.println("<form id=\"f01\" name=\"f01\" method=\"POST\" action=\"" + this.action + "\">");
        } catch (IOException e) {
            System.out.println("Dossier: " + e);
        }
        return EVAL_BODY_INCLUDE;   // тело тега будет обработано
    }

    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("</form>");
        } catch (IOException e) {
            System.out.println("stafftag.Dossier: " + e);
        }
        return EVAL_PAGE;           // продолжить обработку JSP-страницы
    }
}