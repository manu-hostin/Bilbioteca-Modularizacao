package org.example.model;

import java.time.LocalDate;

public class Emprestimos {

    private int id;

    private int livro_id;

    private String usuario;

    private LocalDate data_emprestimo;

    private LocalDate data_devolucao;

    public Emprestimos(int livro_id, int id, String usuario, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.livro_id = livro_id;
        this.id = id;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }
    public Emprestimos(int livro_id, String usuario, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.livro_id = livro_id;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimos(int id, LocalDate data_devolucao) {
        this.id = id;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
