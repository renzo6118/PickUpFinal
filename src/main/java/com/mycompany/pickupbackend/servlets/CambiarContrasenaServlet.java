import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Importar UsuarioDAO y otros elementos necesarios
import com.mycompany.pickupbackend.DAO.UsuarioDAO;

@WebServlet("/CambiarContrasenaServlet")
public class CambiarContrasenaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nuevaContrasena = request.getParameter("nuevaContrasena");
        String confirmarContrasena = request.getParameter("confirmarContrasena");
        String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");

        System.out.println("Nombre de usuario: " + nombreUsuario);
        System.out.println("Nueva contraseña: " + nuevaContrasena);

        try {
            if (nombreUsuario == null || nombreUsuario.isEmpty()) {
                request.setAttribute("error", "No se encontró el usuario en la sesión. Inicia sesión nuevamente.");
                request.getRequestDispatcher("cambiarContrasena.jsp").forward(request, response);
                return;
            }

            // Verificar si las contraseñas coinciden
            if (!nuevaContrasena.equals(confirmarContrasena)) {
                request.setAttribute("error", "Las nuevas contraseñas no coinciden.");
                request.getRequestDispatcher("cambiarContrasena.jsp").forward(request, response);
                return;
            }

            // Intentar actualizar la contraseña
            if (usuarioDAO.actualizarContrasena(nombreUsuario, nuevaContrasena)) {
                request.setAttribute("mensaje", "Contraseña cambiada exitosamente.");
            } else {
                request.setAttribute("error", "Hubo un problema al actualizar la contraseña.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error interno. Inténtalo nuevamente.");
        }

        request.getRequestDispatcher("cambiarContrasena.jsp").forward(request, response);
    }
}

