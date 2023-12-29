import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

// http://localhost:8080/Lab_10/callProcedure?product_id=3

@WebServlet("/callProcedure")
public class ThirdTask extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            Connection connection = DbConnection.GetConnection();

            CallableStatement callableStatement = connection.prepareCall("exec GetStudentById ?, ?");
            callableStatement.setInt(1, Integer.parseInt(request.getParameter("student_id")));
            callableStatement.registerOutParameter(2, Types.NVARCHAR);
            callableStatement.execute();

            String Name = callableStatement.getString(2);   // get the out parameter value
            writer.println("Student: \t" + Name);

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            writer.close();
        }
    }
}