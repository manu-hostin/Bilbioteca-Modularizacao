package org.example.view;

import org.example.model.Emprestimos;
import org.example.model.Livros;
import org.example.model.Usuarios;
import org.example.repository.LivroRepository;
import org.example.service.EmprestimoService;
import org.example.service.LivroService;
import org.example.service.UsuarioService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class BibliotecaView {
    static Scanner SC = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n================ MENU ===============");
        System.out.println("| 1. Cadastrar Livro;               |");
        System.out.println("| 2. Cadastrar Empréstimo;          |");
        System.out.println("| 3. Devolver Livro;                |");
        System.out.println("| 4. Consultar Livros Cadastrados;  |");
        System.out.println("|-----------------------------------|");
        System.out.println("|                           0. Sair |");
        System.out.println("|-----------------------------------|");

        System.out.print("Digite a opção que deseja acessar: ");

    }
    public static void capturarOpcao() {

        while (true) {
            mostrarMenu();
            int opcao = SC.nextInt();
            SC.nextLine();

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1 -> {
                    cadastrarLivro();
                    break;
                }
                case 2 -> {
                    registrarEmprestimo();
                    break;
                }
                case 3 -> {
                    devolverLivro();
                    break;
                }
                case 4 -> {

                    break;
                }
                case 0 ->{
                    System.out.println("Saindo...");
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

        System.out.println("Pronto! O livro será marcado com disponível.");
//        int opcaoDisponivel = SC.nextInt();
//        SC.nextLine();

//        boolean disponibilidade = false;
//        if(opcaoDisponivel == 1){
//            disponibilidade = true;
//        } else {
//            disponibilidade = false;
//        }

        var livro = new Livros(titulo, autor, ano, true);
        try {
            LivroService.cadastrarLivro(livro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void registrarEmprestimo(){
        var usuarioService = new UsuarioService();
        System.out.println("\n----- REALIZAR EMPRÉSTIMO -----");
        System.out.print("Digite o ID do livro que deseja emprestar: ");
        int idLivro = SC.nextInt();
        SC.nextLine();

        System.out.print("\nDigite o nome do usuário que deseja realizar o empréstimo: ");
        String usuarioNome = SC.nextLine();

        int idUser = 0;
        try {
            idUser = usuarioService.pegarID(usuarioNome);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int opcao = 0;
        if (idUser == -1) {
            System.out.println("Usuário não existe!");
            System.out.println("1. Quero cadastrar um novo usuário;");
            System.out.println("2. Voltar ao menu principal.");
            System.out.print("> ");
            opcao = SC.nextInt();
            SC.nextLine();

            if (opcao == 1){
                cadastrarUser();
                return;
            } else if (opcao == 2) {
                mostrarMenu();
            } else {
                System.out.println("Opção não reconhecida.");
                return;
            }
        } else {

            System.out.println("Pronto! Agora a data do empréstimo será marcada como hoje e a de devolução será nula até que aja uma devolução.");

            LocalDate data = LocalDate.now();

            var emprestimo = new Emprestimos(idLivro, usuarioNome, data, null);
            try {
                EmprestimoService.cadastrarEmprestimo(emprestimo);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void devolverLivro(){
        System.out.println("\n----- DEVOLUÇÃO -----");
        System.out.print("Digite o ID do empréstimo em que deseja realizar a devolução: ");
        int idEmprestimo = SC.nextInt();
        SC.nextLine();

        System.out.print("Digite a data de devolução: ");
        LocalDate dataDev = LocalDate.parse(SC.nextLine());

        var devolucao = new Emprestimos(idEmprestimo, dataDev);
        try {
            EmprestimoService.realizarDevolucao(devolucao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void cadastrarUser(){
        System.out.println("Cadastrar usuário:");
        System.out.print("Digite o nome do usuário: ");
        String nome = SC.nextLine();

        System.out.print("\nDigite o email: ");
        String email = SC.nextLine();

        var user = new Usuarios(nome, email);
        try {
            UsuarioService.cadastrarUsuario(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
