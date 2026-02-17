package Ejercicio4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryItem libraryItem1 = new DVD("DVD1", 1, "Director Test", 120);
        LibraryItem libraryItem2 = new DVD("DVD2", 2, "Director Test", 120);
        LibraryItem libraryItem3 = new DVD("DVD3", 3, "Director Test", 120);
        LibraryItem libraryItem4 = new DVD("DVD4", 4, "Director Test", 120);
        LibraryItem libraryItem5 = new DVD("DVD5", 5, "Director Test", 120);
        LibraryItem libraryItem6 = new DVD("DVD6", 6, "Director Test", 120);

        LibraryUser user1 = new LibraryUser("george12", "U-12");
        LibraryUser user2 = new LibraryUser("sarah_smith", "U-23");
        LibraryUser user3 = new LibraryUser("mike_jones", "U-34");
        LibraryUser user4 = new LibraryUser("emma_wilson", "U-45");
        LibraryUser user5 = new LibraryUser("david_brown", "U-56");
        LibraryUser user6 = new LibraryUser("laura_davis", "U-67");
        LibraryUser user7 = new LibraryUser("john_garcia", "U-78");
        LibraryUser user8 = new LibraryUser("anna_martinez", "U-89");
        LibraryUser user9 = new LibraryUser("robert_lee", "U-90");
        LibraryUser user10 = new LibraryUser("sophia_taylor", "U-101");

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);
        library.addUser(user4);
        library.addUser(user5);
        library.addUser(user6);
        library.addUser(user7);
        library.addUser(user8);
        library.addUser(user9);
        library.addUser(user10);
        library.addItem(libraryItem1);
        library.addItem(libraryItem2);
        library.addItem(libraryItem3);
        library.addItem(libraryItem4);
        library.addItem(libraryItem5);
        library.addItem(libraryItem6);



        library.loanItem(19, "U-34");
        library.showAllItems(false);
        // dado un id de un item
        // quiero saber si esta prestado
        // y si esta prestado a que usuario le pertenece el prestamo

//        new HashMap<Boolean, Float>().
        // ingreso un itemId = 19
        // verifica si esta prestado
        // si esta prestado imprime la informacion del usuario al que le pertenece el prestamo
        // HashMap<? <12, "Jorge">, <76, "Jose">,
    }
}
