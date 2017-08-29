package address;

import address.view.TextViewerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane TextViewer;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Jake Fishlock JavaFX");
        //this.primaryStage.getIcons().add(new Image("C:\\Users\\Jake Fishlock\\Desktop\\wordcloud0.2\\WordCloud0.1\\src\\resources\\cloud.png"));



        initRootLayout();
        showTextOverview();

    }

	/*
	 * Init root layout
	 */

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showTextOverview() {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/TextViewer.fxml"));
            AnchorPane TextViewer = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(TextViewer);

            // Give the controller access to the main app.
            TextViewerController controller = loader.getController();
            controller.setMain(this);


        } catch (IOException e) {
            e.printStackTrace();}
    }
    /*
     * returns to the main stage
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
