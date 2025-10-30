package org.example.model;

import java.util.Date;

public class Emprestimos {

    private int id;

    private int livro_id;

    private String usuario;

    private Date data_emprestimo;

    private Date data_devolucao;

    public Emprestimos(int livro_id, int id, String usuario, Date data_emprestimo, Date data_devolucao) {
        this.livro_id = livro_id;
        this.id = id;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }
    public Emprestimos(int livro_id, String usuario, Date data_devolucao) {
        this.livro_id = livro_id;
        this.usuario = usuario;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimos(int id, Date data_devolucao) {
        this.id = id;
        this.data_devolucao = data_devolucao;
    }
    public Emprestimos(int livro_id, String usuario, Date data_emprestimo, Date data_devolucao) {
        this.livro_id = livro_id;
        this.usuario = usuario;
        this.data_emprestimo = data_emprestimo;
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

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
