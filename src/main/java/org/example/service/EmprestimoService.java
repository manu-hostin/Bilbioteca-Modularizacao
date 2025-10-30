package org.example.service;

import org.example.model.Emprestimos;
import org.example.model.Livros;
import org.example.repository.EmprestimoRepository;
import org.example.repository.LivroRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        emprestimoDao.realizarDevolucao((Date) emprestimo.getData_devolucao(), emprestimo.getId());
        livroDao.atualizarDisponibilidade(true, emp);
    }
    public static void consultarEmprestimos () throws SQLException{
        var emprestimoDao = new EmprestimoRepository();

        List<Emprestimos> lista = new ArrayList<>();
        lista = emprestimoDao.consultarEmprestimos();

        System.out.println("\nListando todos os empréstimos...");
        lista.forEach(emprestimos -> {
            System.out.println("\nID do livro: "+emprestimos.getLivro_id());
            System.out.println("Usuário: "+emprestimos.getUsuario());
            System.out.println("Data de empréstimo: "+emprestimos.getData_emprestimo());
            System.out.println("Data de devolução: "+emprestimos.getData_devolucao());
        });
    }
}
