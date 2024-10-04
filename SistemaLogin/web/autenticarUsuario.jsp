<%-- 
    Document   : autenticarUsuario
    Created on : 9 de set. de 2024, 08:32:22
    Author     : Professor
--%>

<%@page import="SistemaLogin.Usuario"%>
<%
    String email =  request.getParameter("email");
    String senha =  request.getParameter("senha");
    
    Usuario usu = new Usuario();
    usu.setEmail(email);
    usu.setSenha(senha);
    
    usu = usu.autenticarUsuario();
    if (usu != null){
        // criar uma sessão para o uusário que está autenticado
        session.setAttribute("usuario", email);
        response.sendRedirect("menu.jsp");
    } else {
        response.sendRedirect("usuarioNaoCadastrado.html");
    }


%>