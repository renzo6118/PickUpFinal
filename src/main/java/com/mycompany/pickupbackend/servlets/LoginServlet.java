package com.mycompany.pickupbackend.servlets;

import com.mycompany.pickupbackend.DAO.UsuarioDAO;
import com.mycompany.pickupbackend.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario = usuarioDAO.validarUsuario(username, password);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("nombreUsuario", usuario.getNombre());
            session.setAttribute("emailUsuario", usuario.getEmail());
            session.setAttribute("telefonoUsuario", usuario.getTelefono());
            session.setAttribute("direccionUsuario", usuario.getDireccion());
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
