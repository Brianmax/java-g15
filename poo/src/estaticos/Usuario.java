package estaticos;

public class Usuario {
    private String username;
    private String password;
    static int numeroUsuarios = 0;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        numeroUsuarios++;
    }
}
