package Ejercicio4;

public abstract class LibraryItem {
    private String title;
    private int itemID; // unico
    private boolean isLoaned; // estaPrestado? true (no disponible) false (disponible)

    public LibraryItem(String title, int itemID) {
        this.title = title;
        this.itemID = itemID;
        this.isLoaned = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public abstract void showDetails();
}
