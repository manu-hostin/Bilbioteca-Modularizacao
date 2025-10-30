package org.example.repository;

import org.example.infraestrutura.database.Conexao;
import org.example.model.Usuarios;

import java.io.PipedInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public int pegarIDUser (String nome) throws SQLException{
        String query = "SELECT id FROM usuarios WHERE nome = ?";

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
    public List<Usuarios> consultarUsuarios () throws SQLException{
        String query = "SELECT nome, email FROM usuarios";

        List<Usuarios> lista = new ArrayList<>();
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                var user = new Usuarios(nome, email);
                lista.add(user);
            }
        }
        return lista;
    }

}
