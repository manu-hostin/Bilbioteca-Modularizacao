package org.example.service;

import org.example.model.Usuarios;
import org.example.repository.UsuarioRepository;

import java.sql.SQLException;

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
}
