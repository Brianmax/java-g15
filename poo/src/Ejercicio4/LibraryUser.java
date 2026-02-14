package Ejercicio4;

import java.util.ArrayList;

public class LibraryUser {
    private String username;
    private String userId;
    private ArrayList<LibraryItem> items;

    public LibraryUser(String username, String userId) {
        this.username = username;
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public void showDetails() {
        System.out.println("Username: " + username);
        System.out.println("User ID: " + userId);
        System.out.println("Items: " + items.size());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<LibraryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LibraryItem> items) {
        this.items = items;
    }
}
