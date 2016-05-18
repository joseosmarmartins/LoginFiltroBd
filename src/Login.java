import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendLogin(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void sendLogin(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>Login</h1>");
        out.println("<h1>José Beija Rapazes</h1>")
        out.println("<form method='post' action='Login'>");
        out.println("<label>Nome:</label>");
        out.println("<input type='text' value='' name='usuario'>");
        out.println("<label>Senha:</label>");
        out.println("<input type='password' value='' name='senha'>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
    }
}
