package org.example.service;

import org.example.model.Usuarios;
import org.example.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public static int pegarID (String nome) throws SQLException{
        UsuarioRepository userDao = new UsuarioRepository();

        int id = userDao.pegarIDUser(nome);

        return id;
    }
    public static void cadastrarUsuario (Usuarios user) throws SQLException{
        UsuarioRepository userDao = new UsuarioRepository();
        userDao.cadastrarUser(user);
    }
    public static void consultarUser () throws SQLException{
        var user = new UsuarioRepository();

        List<Usuarios> lista = new ArrayList<>();
        lista = user.consultarUsuarios();

        System.out.println("\nListando todos os usuários...");
        lista.forEach(usuarios -> {
            System.out.println("\nUsuário "+usuarios.getNome());
            System.out.println("Email: "+usuarios.getEmail());

        });
    }
}
