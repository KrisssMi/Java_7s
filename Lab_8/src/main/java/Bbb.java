import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("BbbHeader1", "Bbb responsePost1");
        response.addHeader("BbbHeader2", "Bbb responsePost2");
        PrintWriter pw = response.getWriter();
        String s;
        response.setContentType("text/html");
        pw.print("<h1>Query Params</h1>");
        Enumeration parms = request.getParameterNames();
        while (parms.hasMoreElements()) {   // get all the request parameters
            s = (String)parms.nextElement();
            pw.println("<br />" + s + "= " + request.getParameter(s));
        }
        pw.print("<h1>Headers from request</h1>");
        Enumeration enh = request.getHeaderNames();
        while (enh.hasMoreElements()) {
            s = (String) enh.nextElement();
            pw.println("<br />" + s + "= " + request.getHeader(s));
        }
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
