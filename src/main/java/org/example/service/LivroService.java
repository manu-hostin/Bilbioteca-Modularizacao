package org.example.service;

import org.example.model.Livros;
import org.example.repository.LivroRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    public static void cadastrarLivro (Livros livro) throws SQLException {
        var livroDao = new LivroRepository();

        livroDao.inserirLivro(livro);

    }
    public static void consultarLivrosCadastrados () throws SQLException{
        var livroDao = new LivroRepository();

        List<Livros> lista = new ArrayList<>();
        lista = livroDao.consultarLivros();

        System.out.println("\nListando todos os livros...");
        lista.forEach(livros -> {
            System.out.println("\nTítulo: "+livros.getTitulo());
            System.out.println("Autor: "+livros.getAutor());
            System.out.println("Ano: "+livros.getAno());
            System.out.println("Disponível: "+livros.getDisponivel());
        });
    }
}
