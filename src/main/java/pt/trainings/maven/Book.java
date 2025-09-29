package pt.trainings.maven;

public class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Tytułxd: " + title + ", Autor: " + author + ", Rok wydania: " + year;
    }
}
