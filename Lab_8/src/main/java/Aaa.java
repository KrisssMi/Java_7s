import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// http://localhost:8080/PII_8/Aaa

public class Aaa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        PostMethod postRequest = new PostMethod("http://localhost:8080/PII_8/Bbb");
        NameValuePair[] parms = {
                new NameValuePair("QueryParam1", "requestPost1"),
                new NameValuePair("QueryParam2", "requestPost2"),
                new NameValuePair("QueryParam3", "requestPost3")
        };
        postRequest.addParameters(parms);
        postRequest.addRequestHeader ("AaaHeader1", "Aaa requestPost1");
        postRequest.addRequestHeader ("AaaHeader2", "Aaa requestPost2");
        postRequest.addRequestHeader ("AaaHeader3", "Aaa requestPost3");
        hc.executeMethod(postRequest);

        PrintWriter pw = response.getWriter();
        pw.println("<h1>----------Body From Bbb----------</h1>");
        pw.println(postRequest.getResponseBodyAsString());
        pw.println("<h1>----------Body From Bbb----------</h1>");

        pw.println("<h1>----------Headers From Bbb response----------</h1>");
        for (Header responseHeader : postRequest.getResponseHeaders()) {
            pw.println(responseHeader.getName() + "=" + responseHeader.getValue() + "<br>");
        }
        pw.println("<h1>----------Headers From Bbb----------</h1>");
        pw.flush();
    }
}