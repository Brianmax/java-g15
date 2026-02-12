package pooTeoria;

public class Usuario {
    // atributos
    String username;
    String email;
    public int edad;
    public String sexo;
    public String pais;

    public Usuario(String username, String email, int edad, String sexo, String pais) {
        this.username = username;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.pais = pais;
    }

    public Usuario(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Usuario() {

    };

    // public
    // private

    // metodos getter y setter

}
