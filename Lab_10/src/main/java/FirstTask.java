import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// http://localhost:8080/Lab_10/staticRequest

@WebServlet("/staticRequest")
public class FirstTask extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();  // to write to the response body
        try {
            Connection connection = DbConnection.GetConnection();

            Statement stm = connection.createStatement();
            String sql = "select * from Students";
            ResultSet result = stm.executeQuery(sql);

            while (result.next()) {
                writer.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            writer.close();
        }
    }
}