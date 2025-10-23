package org.example.service;

import org.example.model.Livros;
import org.example.repository.LivroRepository;

import java.sql.SQLException;

public class LivroService {

    public static void cadastrarLivro (Livros livro) throws SQLException {
        var livroDao = new LivroRepository();

        livroDao.inserirLivro(livro);

    }
    public static void consultarLivrosCadastrados () throws SQLException{

    }
    public static void registrarEmprestimo () throws SQLException{

    }
    public static void registrarDevolucao () throws SQLException{

    }
}
