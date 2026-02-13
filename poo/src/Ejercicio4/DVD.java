package Ejercicio4;

public class DVD extends LibraryItem {
    private String director;
    private int duration;

    public DVD(String title, int itemID, String director, int duration) {
        super(title, itemID);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void showDetails() {
        System.out.println("DVD - Titulo: " + getTitle() + ", ID: " + getItemID() + ", Director: " + director + ", Duracion: " + duration + " min, Prestado: " + isLoaned());
    }
}
