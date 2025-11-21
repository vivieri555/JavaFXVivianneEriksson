import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {

    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Medlemmarna");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label firstLabel = new Label("Ange förnamn:");
        gridPane.setConstraints(firstLabel, 0, 1);
        TextField firstName = new TextField();
        firstName.setPromptText("Förnamn");
        gridPane.setConstraints(firstName, 1, 1);

        Label lastLabel = new Label("Ange Efternamn:");
        gridPane.setConstraints(lastLabel, 0, 2);
        TextField lastName = new TextField();
        gridPane.setConstraints(lastName, 1,2);

        Label phoneLabel = new Label("Ange telefonnummer:");
        gridPane.setConstraints(phoneLabel, 0, 3);
        TextField phoneNumber = new TextField();
        gridPane.setConstraints(phoneNumber, 1, 3);

        Label adressLabel = new Label("Ange adress:");
        gridPane.setConstraints(adressLabel, 0, 4);
        TextField adressText = new TextField();
        gridPane.setConstraints(adressText, 1, 4);

        Label postLabel = new Label("Ange postnummer:");
        gridPane.setConstraints(postLabel, 0, 5);
        TextField postText = new TextField();
        gridPane.setConstraints(postText, 1, 5);

        Label postAdressLabel = new Label("Ange postadress");
        gridPane.setConstraints(postAdressLabel, 0, 6);
        TextField postAdressText = new TextField();
        gridPane.setConstraints(postAdressText, 1, 6);


        Button saveMember = new Button("Spara medlem");
        gridPane.setConstraints(saveMember, 10, 10);

        Label newMember = new Label("Skriv in ny medlem");
        Label saveInLabel = new Label();

        saveMember.setOnAction(e -> {
        //Få knappen att skriva Sparat och skriva ut text
            String s = "Sparat: " + firstName.getText() + ", " + lastName.getText() + ", " + phoneNumber.getText() + ", "
                    + adressText.getText() + ", " + postText.getText() + ", " + postAdressText.getText();
            saveInLabel.setText(s);
            gridPane.setConstraints(saveInLabel, 1, 8);
        });

        gridPane.getChildren().addAll(firstLabel, firstName, lastLabel, lastName, phoneLabel, phoneNumber,
                adressLabel, adressText, postLabel, postText, postAdressLabel, postAdressText, saveMember, saveInLabel, newMember);
        Scene scene = new Scene(gridPane, 300, 500);
        stage.setScene(scene);
        stage.show();

    }
}