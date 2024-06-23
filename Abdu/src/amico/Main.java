package amico;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("JavaFX Portfolio");

        showMainView();
        showHomePage();
    }

    private void showMainView() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/resources/MainLayout.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showHomePage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/resources/Home.fxml"));
        BorderPane homePage = loader.load();
        mainLayout.setCenter(homePage);
    }

    public static void showAboutPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/resources/About.fxml"));
        BorderPane aboutPage = loader.load();
        mainLayout.setCenter(aboutPage);
    }

    public static void showContactPage() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/resources/Contact.fxml"));
            AnchorPane contactPane = loader.load();
            Scene scene = new Scene(contactPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
	