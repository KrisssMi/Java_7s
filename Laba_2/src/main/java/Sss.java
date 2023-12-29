import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet
{
    public Sss()
    {
        super();
        System.out.println("Sss: Constructor");
    }
    public void init(ServletConfig sc) throws ServletException
    {
        super.init();
        System.out.println("Sss: Init");
    }
    public void destroy()
    {
        super.destroy();
        System.out.println("Sss: Destroy");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Sss: Service, METHOD - " + request.getMethod());

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>"
                + "<h2>Sss - servlet. Service method: " + request.getMethod() + "</h2>"
                + "<h3>Server Name: " + request.getServerName() + "</h3>"
                + "<h3>IP-Address: " + request.getLocalAddr() + "</h3>"
                + "<br>Sss: Service -> Firstname: " + request.getParameter("firstname")
                + "<br>Sss: Service -> Lastname: " + request.getParameter("lastname")
                + "</body></html>");

        switch(request.getMethod())
        {
            case "GET":
            {
                doGet(request,response);
            }
            case "POST":
            {
                doPost(request,response);
            }
            default:
            {
                response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) {
            // Поля пустые или отсутствуют
            pw.println("<html><body>"
                    + "<br>Sss: doPost. Error: Please enter both Firstname and Lastname."
                    + "</body></html>");
        } else {
            // Поля заполнены, выводим данные
            pw.println("<html><body>"
                    + "<br>Sss: doPost. Firstname: " + firstName
                    + "<br>Sss: doPost. Lastname: " + lastName
                    + "</body></html>");
        }
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>"
                +"<br>Sss: doGet. URL = " + request.getRequestURL()
                +"<br>Sss: doGet. Query String = " + request.getQueryString()
                +"<br>Sss: doGet. FirstName = " + request.getParameter("firstname")
                +"<br>Sss: doGet. LastName = " + request.getParameter("lastname")
                +"<br>Sss: doGet. getRemoteHost: " + request.getRemoteHost()
                +"</body></html>");
        pw.close();
    }
}