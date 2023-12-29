import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
public class Sss extends HttpServlet
{
    public Sss()
    {
        super();
        System.out.println("Sss:constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        System.out.println("Sss:init");
    }

    @Override
    public void destroy()
    {
        super.destroy();
        System.out.println("Sss:destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.service(req, resp);
        System.out.println("Sss:service");

        RequestDispatcher requestDispatcher = null;
        String parm = req.getParameter("parm");
        PrintWriter printWriter = resp.getWriter();

        switch (parm) {
            case  ("MyParameter"):
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
                break;
            case ("GetGggRedirect"):
                resp.sendRedirect("Ggg");
                break;
            case ("PostGggForward"):
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
                break;
            case ("PostGggRedirect"):
                resp.setStatus(307);
                resp.setHeader("Location", "http://localhost:8080/Laba_3/Ggg");
                break;
            case ("GetHtmlForward"):
                requestDispatcher = req.getRequestDispatcher("redirect.html");
                requestDispatcher.forward(req, resp);
                break;
            case ("GetHtmlRedirect"):
                resp.sendRedirect("redirect.html");
                break;
            case ("GetTwoHtmlForward"):
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
                break;
            case ("GetTwoHtmlRedirect"):
                resp.sendRedirect("Ggg");
                break;
            case ("GetTwoInfoForward"):
                printWriter.write("Info from Sss");
                requestDispatcher = req.getRequestDispatcher("Ggg");
                requestDispatcher.forward(req, resp);
                break;
            case ("GetTwoInfoRedirect"):
                printWriter.write("Info from Sss");
                resp.sendRedirect("Ggg");
                break;
            case ("HttpClientGet"):
                HttpClient hc = new HttpClient();
                GetMethod gm = new GetMethod("http://localhost:8080/Laba_3/Ggg?parm=HttpClient&name=Kristina");
                hc.executeMethod(gm);
                PrintWriter pw = resp.getWriter();
                pw.println(gm.getResponseBodyAsString());   // позволяет получить содержимое HTTP-ответа в виде строки
                pw.flush();                                 // запись данных из буфера в выходной поток
                pw.close();
                break;
            case ("HttpClientPost"):
                HttpClient hc2 = new HttpClient();
                PostMethod gm2 = new PostMethod("http://localhost:8080/Laba_3/Ggg?parm=HttpClient&name=Kristina");
                hc2.executeMethod(gm2);
                PrintWriter pw2 = resp.getWriter();
                pw2.println(gm2.getResponseBodyAsString());
                pw2.flush();
                pw2.close();
                break;
            default:
                break;
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>Sss: doGet</h1>");
        System.out.println("Sss:doGet");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>Sss: doPost</h1>");
        System.out.println("Sss:doPost");
    }
}