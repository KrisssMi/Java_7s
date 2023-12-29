import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// http://localhost:8080/Lab_10/dynamicRequest?id=3

@WebServlet("/dynamicRequest")
public class SecondTask extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        try {

            Connection connection = DbConnection.GetConnection();

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            PreparedStatement stm = connection.prepareStatement("Select * from Students where student_id =? ");
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();

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
