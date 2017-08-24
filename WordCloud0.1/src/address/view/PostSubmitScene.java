package address.view;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.AttributedString;
import java.util.Random;

/*
taken from and edited: https://stackoverflow.com/questions/32940574/how-do-i-transfer-data-from-one-scene-to-another-in-java-fx
and week 5 labs CMT205 Cardiff University
 */

public class PostSubmitScene {

    public void createNewScene() {

        Stage window = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.WHITE);
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt((int) scene.getWidth());
            int y = rand.nextInt((int) scene.getHeight());
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            Text text = new Text(x, y, "miriam is always right opf course");

            ;
            text.setFill(Color.rgb(red, green, blue, .99));
            text.setFont(Font.font("Arial", 18));

            root.getChildren().add(text);

            //adding elements to the layout
            VBox layout1 = new VBox(200);
            layout1.getChildren().addAll(text);

            //setting the layout size
            Scene scene1 = new Scene(layout1, 600, 400);
            window.setScene(scene1);
            window.show();
        }

    }

}





