import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Medlemmarna");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(12);
        gridPane.setHgap(12);

        Label firstNameLabel = new Label("Ange förnamn:");
        gridPane.setConstraints(firstNameLabel, 0, 1);
        TextField firstName = new TextField();
        firstName.setPromptText("Förnamn");
        gridPane.setConstraints(firstName, 1, 1);

        Label lastNameLabel = new Label("Ange Efternamn:");
        gridPane.setConstraints(lastNameLabel, 0, 2);
        TextField lastName = new TextField();
        lastName.setPromptText("Efternamn");
        gridPane.setConstraints(lastName, 1, 2);

        Label phoneLabel = new Label("Ange telefonnummer:");
        gridPane.setConstraints(phoneLabel, 0, 3);
        TextField phoneNumber = new TextField();
        phoneNumber.setPromptText("Telefonnummer");
        gridPane.setConstraints(phoneNumber, 1, 3);

        Label adressLabel = new Label("Ange gatuadress:");
        gridPane.setConstraints(adressLabel, 0, 4);
        TextField adressText = new TextField();
        adressText.setPromptText("Gatuadress");
        gridPane.setConstraints(adressText, 1, 4);

        Label postNumberLabel = new Label("Ange postnummer:");
        gridPane.setConstraints(postNumberLabel, 0, 5);
        TextField postText = new TextField();
        postText.setPromptText("Postnummer");
        gridPane.setConstraints(postText, 1, 5);

        Label postAdressLabel = new Label("Ange postadress");
        gridPane.setConstraints(postAdressLabel, 0, 6);
        TextField postAdressText = new TextField();
        postAdressText.setPromptText("Postadress");
        gridPane.setConstraints(postAdressText, 1, 6);

        Button saveMember = new Button("Spara medlem");
        gridPane.setConstraints(saveMember, 1, 10);

        Label newMember = new Label("Välkommen, fyll i ny medlem");
        Label saveInLabel = new Label();

        saveMember.setOnAction(e -> {
            String s = "Sparat: " + firstName.getText() + ", " + lastName.getText() + ", " + phoneNumber.getText() + ", "
                    + adressText.getText() + ", " + postText.getText() + ", " + postAdressText.getText();
            saveInLabel.setText(s);
            gridPane.setConstraints(saveInLabel, 1, 7);
        });

        Button startButton = new Button("Starta");
        gridPane.setConstraints(startButton, 1, 11);

        Label timerLabel = new Label();
        gridPane.setConstraints(timerLabel, 1, 13);

        Button stopButton = new Button("Stopp");
        gridPane.setConstraints(stopButton, 2, 11);

        Stopwatch stopwatch = new Stopwatch();

        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long l) {
                runStopwatch(stopwatch, timerLabel);
            }
        };
        startButton.setOnAction(e -> {
            timer.start();
        });
        stopButton.setOnAction(e -> {
            timer.stop();
        });
        gridPane.getChildren().addAll(firstNameLabel, firstName, lastNameLabel, lastName, phoneLabel, phoneNumber,
                adressLabel, adressText, postNumberLabel, postText, postAdressLabel, postAdressText,
                saveMember, saveInLabel, newMember, startButton, stopButton, timerLabel);

        Scene scene = new Scene(gridPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private static void runStopwatch(Stopwatch stopwatch, Label timerLabel) {
        stopwatch.increment();
        Platform.runLater(() -> timerLabel.setText(stopwatch.showTime()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }
}

