package projeto.integrador.model;

public class Comentario {
    private Usuario user;
    private String coment;

    public Comentario(Usuario user, String coment) {
        this.user = user;
        this.coment = coment;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
