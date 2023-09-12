package app;

import DataBase.DataBaseManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AuthenticationApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("JavaFX Application 1.0");
        primaryStage.setScene(getAuthorizationScene());
        primaryStage.show();
    }

    private Scene getAuthorizationScene(){

        VBox vbox = new VBox(10);
        Scene scene = new Scene(vbox, 300, 250);

        Font customFont = Font.font("Arial", 16);

        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setFont(customFont);

        Label usernameLabel = new Label("Имя пользователя:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Пароль:");
        PasswordField passwordField = new PasswordField();

        Button authenticateButton = new Button("Войти");

        Text resultText = new Text();

        authenticateButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (DataBaseManager.authenticateUser(username, password)) {
                resultText.setFill(Color.GREEN);
                resultText.setText("Аутентификация успешна!");
            } else {
                resultText.setFill(Color.RED);
                resultText.setText("Ошибка аутентификации. Попробуйте снова.");
            }
        });

        vbox.getChildren().addAll(welcomeLabel, usernameLabel, usernameField, passwordLabel, passwordField, authenticateButton, resultText);

        return scene;

    }

    @Override
    public void init() throws Exception {
        System.out.println("Called method init()");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Called method stop()");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
