package org.example.view;

import org.example.model.Livros;
import org.example.repository.LivroRepository;
import org.example.service.LivroService;

import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaView {
    static Scanner SC = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("================ MENU ===============");
        System.out.println("| 1. Cadastrar Livro;               |");
        System.out.println("| 2. Cadastrar Empréstimo;          |");
        System.out.println("| 3. Devolver Livro;                |");
        System.out.println("| 4. Consultar Livros Cadastrados;  |");

        System.out.print("Digite a opção que deseja acessar: ");

    }
    public static void capturarOpcao() {
        boolean sair = false;

        while (!sair) {
            int opcao = SC.nextInt();
            SC.nextLine();

            switch (opcao) {
                case 1 -> {
                    cadastrarLivro();
                    break;
                }
                case 2 -> {

                    break;
                }
                case 3 -> {

                    break;
                }
                case 4 -> {

                    break;
                }
            }
        }

    }
    public static void cadastrarLivro() {
        System.out.println("\n--------- CADASTRAR LIVRO ----------");
        System.out.println("Digite o nome do livro: ");
        String titulo = SC.nextLine();

        System.out.println("Digite o nome do autor: ");
        String autor = SC.nextLine();

        System.out.println("Digite o ano de lançamento: ");
        int ano = SC.nextInt();
        SC.nextLine();

        System.out.println("Digite se está disponível ou não: \n1- Sim;\n2- Não");
        int opcaoDisponivel = SC.nextInt();
        SC.nextLine();

        boolean disponibilidade = false;
        if(opcaoDisponivel == 1){
            disponibilidade = true;
        } else {
            disponibilidade = false;
        }

        var livro = new Livros(titulo, autor, ano, disponibilidade);
        try {
            LivroService.cadastrarLivro(livro);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
