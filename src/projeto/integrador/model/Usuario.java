package projeto.integrador.model;

public class Usuario {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String genero;


    public Usuario(int id, String nome, String telefone, String email, String genero) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.genero = genero;
    }

    public Usuario(String nome, String telefone, String email, String genero) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
