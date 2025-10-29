package org.example.repository;

import org.example.infraestrutura.database.Conexao;
import org.example.model.Usuarios;

import java.io.PipedInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {

    public int pegarIDUser (String nome) throws SQLException{
        String query = "SELECT id FROM Usuarios WHERE nome = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }
    public void cadastrarUser (Usuarios user) throws SQLException{
        String query = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();

        }
    }

}
