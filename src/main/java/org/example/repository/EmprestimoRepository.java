package org.example.repository;

import org.example.infraestrutura.database.Conexao;
import org.example.model.Emprestimos;

import java.sql.*;
import java.time.LocalDate;

public class EmprestimoRepository {

    public void realizarEmprestimo (Emprestimos emprestimo) throws SQLException {
        String query = "INSERT INTO emprestimos (livro_id, usuario, data_emprestimo, data_devolucao) VALUES (?, ?, ?, null)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, emprestimo.getLivro_id());
            stmt.setString(2, emprestimo.getUsuario());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_emprestimo()));
            stmt.executeUpdate();

            System.out.println("\nEmpréstimo cadastrado com sucesso!");
        }
    }
    public boolean livrosExistentes(int id) throws SQLException{
        String query = "SELECT (id) FROM livros WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        }
        return false;
    }
    public void realizarDevolucao (LocalDate data, int id) throws SQLException {
        String query = "UPDATE emprestimos SET data_devolucao = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, Date.valueOf(data));
            stmt.setInt(2, id);
            stmt.executeUpdate();

            System.out.println("\nDevolução realizada com sucesso!");
        }
    }
    public int buscarIDLivro (int id) throws SQLException{
        String query = "SELECT livro_id FROM emprestimos WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("livro_id");
            }
        }
        return -1;
    }

}
