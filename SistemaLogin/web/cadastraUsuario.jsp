<%-- 
    Document   : cadastraUsuario
    Created on : 9 de set. de 2024, 08:04:05
    Author     : Marcio Schoenfelder
--%>

<%@page import="SistemaLogin.Usuario"%>
<%
    String user =  request.getParameter("username");
    String senha =  request.getParameter("senha");
    
    Usuario usu = new Usuario();
    usu.setEmail(user);
    usu.setSenha(senha);
    
    if (usu.incluirUsuario()){       
        response.sendRedirect("index.html");
    }


%>
