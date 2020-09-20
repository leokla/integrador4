package projeto.integrador.model;

import java.util.ArrayList;

public class Post {
    private Usuario user;
    private String conteudo;
    private ArrayList<Comentario> comentarios;

    public Post(Usuario user, String conteudo) {
        this.user = user;
        this.conteudo = conteudo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
