import pooTeoria.Computer;
import pooTeoria.Usuario;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        usuario1.username = "george123";
        usuario1.edad = 29;

        usuario2.username = "fiore12";
        usuario2.edad = 30;

        Computer computer1 = new Computer("Apple", "Macbook", 16, 444);
        computer1.brand = "Lenovo";
        computer1.model = "LNV-2323";

    }
}
