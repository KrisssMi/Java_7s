package by.belstu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Sss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet:Sss");
        String docDir = getServletContext().getInitParameter("doc-dir");
        System.out.println(docDir);
        resp.getWriter().println("Servlet:Sss");
    }
}
