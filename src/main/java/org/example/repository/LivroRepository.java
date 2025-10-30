package org.example.repository;

import org.example.infraestrutura.database.Conexao;
import org.example.model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    public void inserirLivro (Livros livro) throws SQLException {
        String query = "INSERT INTO livros (titulo, autor, ano, disponivel) VALUES (?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setBoolean(4, livro.getDisponivel());
            stmt.executeUpdate();

            System.out.println("\nLivro Adicionado com Sucesso!");
        }
    }
    public void atualizarDisponibilidade (boolean disp, int id) throws SQLException{
        String query = "UPDATE livros SET disponivel = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBoolean(1, disp);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        }
    }
    public List<Livros> consultarLivros () throws SQLException{
        String query = "SELECT titulo, autor, ano, disponivel FROM livros";

        List<Livros> lista = new ArrayList<>();
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano = rs.getInt("ano");
                boolean disp = rs.getBoolean("disponivel");

                var livro = new Livros(titulo, autor, ano, disp);
                lista.add(livro);
            }
        }
        return lista;
    }

}
