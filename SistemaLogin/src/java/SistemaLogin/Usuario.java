package SistemaLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Conexao;

public class Usuario {
    private String email;
    private String senha;

    
    // Inclusão de Usuario
   public boolean incluirUsuario() throws ClassNotFoundException {
    String sql = "INSERT INTO usuario (email, senha) VALUES (?, ?)";
    try (Connection con = Conexao.conectar(); 
         PreparedStatement stm = con.prepareStatement(sql)) {

        stm.setString(1, this.getEmail());
        stm.setString(2, this.getSenha());

        stm.execute();
        return true;

    } catch (SQLException e) {
          // Exibe a pilha completa de erros para depuração
        System.out.println("Erro na inclusão do usuário: " + e.getMessage());
        return false;
    }
}

    
    // autenticacao do usuario
    public Usuario autenticarUsuario() throws ClassNotFoundException {
        Connection con = Conexao.conectar();
        Usuario usu = null;
        String sql = "SELECT email FROM usuario WHERE email = ? AND senha = ?     ";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getEmail());
            stm.setString(2, this.getSenha());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                usu = new Usuario();
                usu.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
                System.out.println("Erro na consulta do usuario");
                return null;
        }
        return usu;
}
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }       
}