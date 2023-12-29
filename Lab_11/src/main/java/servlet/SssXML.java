package servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class SssXML extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Random random = new Random();
            int n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder result = new StringBuilder("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>");

            int count = random.nextInt(10 - 5 + 1) + 5;

            result.append("<rand>");
            for (int i = 0; i < count; i++) {
                Integer number = random.nextInt(2 * n + 1) - n;
                result.append("<num>").append(number).append("</num>");
            }
            result.append("</rand>");

            Thread.sleep(5000);

            response.setContentType("text/xml");
            response.getWriter().println(result);

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
