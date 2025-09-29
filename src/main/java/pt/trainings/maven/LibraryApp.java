package pt.trainings.maven;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class LibraryApp extends Application {
    public void start(Stage stage){

        Button button1 = new Button("Wyszukaj książke");
        Button button2 = new Button("Wyświetl kolekcje");
        Button button3 = new Button("Dodaj Książke");

        TextField textField = new TextField();
        TextField textFieldTytul = new TextField("Podaj tytuł");
        TextField textFieldAutor = new TextField("Podaj autora");
        TextField textFieldRok = new TextField("Podaj rok");

        TextArea textArea = new TextArea();

        Library library = new Library(textArea);

        button1.setOnAction(_ -> library.findBookByTitle(textField.getText()));

        button2.setOnAction(_ -> library.listBooks());

        button3.setOnAction(_ ->{
            Book newBook = new Book(textFieldTytul.getText(), textFieldAutor.getText(), Integer.parseInt(textFieldRok.getText()));
            library.addBook(newBook);
        });

        HBox hBox = new HBox(button1, button2, button3);

        VBox vBox = new VBox(textField,hBox,textFieldTytul,textFieldAutor,textFieldRok, textArea);
        Scene scene = new Scene(vBox,500,500);
        stage.setScene(scene);
        stage.show();

    }
}

