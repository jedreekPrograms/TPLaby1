package pt.trainings.maven;

import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private final TextArea textArea;
    List<Book> listaksiazek = new ArrayList<>();

    public Library(TextArea textArea) {
        this.textArea=textArea;
    }

    void addBook(Book book){
        boolean exists = listaksiazek.stream().
                anyMatch(b -> b.title.equalsIgnoreCase(book.title));

        if(exists){
            textArea.setText("Książka o tytule: " + book.title + " została już dodana.");
        }else{
            listaksiazek.add(book);
            textArea.setText("Dodano książke: " + book.title);
        }
    }

    void findBookByTitle(String tytul){

        Book found = listaksiazek.stream()
                .filter(b -> b.title.equalsIgnoreCase(tytul))
                .findFirst()
                .orElse(null);

        if(found != null){
            textArea.setText("Znaleziono: " + found);
        }else {
            textArea.setText("Nie znaleziono książki o tytule: " + tytul);
        }

    }

    void listBooks(){
        int licznik = 0;
        textArea.clear();
        for(Book b: listaksiazek){
            textArea.appendText(licznik + ". " + "Tytuł: " + b.title + ", Autor: " + b.author + ", Rok wydania: " + b.year + "\n");
            licznik++;
        }

    }
}
