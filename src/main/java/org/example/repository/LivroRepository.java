package org.example.repository;

import org.example.infraestrutura.database.Conexao;
import org.example.model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            System.out.println("\n✅ Livro Adicionado com Sucesso!");
        }
    }

}
