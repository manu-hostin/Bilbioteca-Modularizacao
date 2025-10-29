package org.example.service;

import org.example.model.Emprestimos;
import org.example.model.Livros;
import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;

import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoService {

    public static void cadastrarEmprestimo (Emprestimos emprestimo) throws SQLException {
        var emprestimoDAO = new EmprestimoRepository();
        var livroDAO = new LivroRepository();

        int id = emprestimo.getLivro_id();

        if (!emprestimoDAO.livrosExistentes(id)) {
            System.err.println("\nLivro com esse ID não existe!");
        }

        livroDAO.atualizarDisponibilidade(false, id);
        emprestimoDAO.realizarEmprestimo(emprestimo);
    }

    public static void realizarDevolucao (Emprestimos emprestimo) throws SQLException {
        var emprestimoDao = new EmprestimoRepository();
        var livroDao = new LivroRepository();

        int emp = emprestimoDao.buscarIDLivro(emprestimo.getId());

        emprestimoDao.realizarDevolucao(emprestimo.getData_devolucao(), emprestimo.getId());
        livroDao.atualizarDisponibilidade(true, emp);
    }
}
