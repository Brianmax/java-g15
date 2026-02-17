package Ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<LibraryItem> items;
    private ArrayList<LibraryUser> users;

    Library() {
        items = new ArrayList<>();
        users = new ArrayList<>();
    }

    // crear el metodo de agregar usuario
    public void addUser(LibraryUser user) {
        for(LibraryUser userArray: users ) {
            if(user.getUserId().equals(userArray.getUserId())) {
                System.out.println("El usuario con el ID " + user.getUserId() + " ya existe");
                return;
            }
        }
        users.add(user);
    }

    public void addItem(LibraryItem item) {
        for(LibraryItem item1: items) {
            if(item.getItemID() == item1.getItemID()) {
                System.out.println("El item con el ID " + item1.getItemID() + " ya existe");
                return;
            }
        }
        items.add(item);
    }

    // incluir un parametro que indique si se desea mostrar los items no disponibles
    public void showAllItems(boolean showAll) { // si es true muestra todos los items
        // < 1(true), 2(false), 3(true) >  showAll false
        for(LibraryItem item: items) {
            if(showAll) {
                item.showDetails();
            } else {
                if (!item.isLoaned()) item.showDetails();
            }
            System.out.println("------------------------------");
        }
    }

    public void loanItem(int itemId, String userId) {
        // verificar que el itemId exista
        LibraryItem item = findItem(itemId);
        LibraryUser user = findLibraryUser(userId);

        if( item == null || user == null) {
            System.out.println("Item o usuario no existe"); // cancelando la operacion
            return;
        }

        user.getItems().add(item); // aniadiendo el item a la coleccion de items prestados del usuarios
        item.setLoaned(true); // marcamos el item como prestado
    }

    private LibraryItem findItem(int itemId) {
        for (LibraryItem libraryItem: items) {
            if(itemId == libraryItem.getItemID()) {
                System.out.println("Item encontrado");
                return libraryItem;
            }
        }
        return null;
    }

    private LibraryUser findLibraryUser(String userId) {
        for (LibraryUser libraryUser: users) {
            if(userId.equals(libraryUser.getUserId())) {
                System.out.println("Item encontrado");
                return libraryUser;
            }
        }
        return null;
    }
}