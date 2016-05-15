import model.Usuario;
import model.UsuarioDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Inicializando filtro...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            PrintWriter out = servletResponse.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title> Login </title>");
            out.println("</head>");
            out.println("<body>");

            String usuario = servletRequest.getParameter("usuario");
            String senha = servletRequest.getParameter("senha");

            Usuario u = UsuarioDAO.porNomeSenha(usuario, senha);

            if(u != null) {
                RequestDispatcher rd = servletRequest.getRequestDispatcher("/LoginOk");
                rd.include(servletRequest, servletResponse);
            }
            else{
                filterChain.doFilter(servletRequest, servletResponse);
            }

            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo filtro...");
    }
}
