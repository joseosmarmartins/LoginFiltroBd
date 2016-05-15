import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginOk", urlPatterns = "/LoginOk")
public class LoginOk extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        PrintWriter out = response.getWriter();

        if (nome == null || senha == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/Login");
            rd.include(request, response);
        } else {
            out.println("<h1>Login OK</h1>");
            out.println("<h2> Usuario:" + nome + "</h2>");
            out.println("<h2> Senha:" + senha + "</h2>");
        }
    }
}
