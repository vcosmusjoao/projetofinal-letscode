package br.com.letscode.spring.projetofinal.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsuariosLogados {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuariosLogados() {
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios.add(usuarios);
    }

    public Usuario getUsuarios(int index) {
        return this.usuarios.get(index);
    }
}
