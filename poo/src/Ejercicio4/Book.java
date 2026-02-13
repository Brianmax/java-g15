package Ejercicio4;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemID, String author) {
        super(title, itemID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void showDetails() {
        System.out.println("Libro - Titulo: " + getTitle() + ", ID: " + getItemID() + ", Autor: " + author + ", Prestado: " + isLoaned());
    }
}
