package address.model;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextBorderExample extends Application {

    @Override
    public void start (Stage primaryStage){
        final HBox  root = new HBox(5 );
        final Text red = new Text("red");
        final Rectangle redBorder = new Rectangle(0,0, Color.TRANSPARENT);
        redBorder.setStroke(Color.RED);
        redBorder.setManaged(false);
        red.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
                redBorder.setLayoutX(red.getBoundsInParent().getMinX());
                redBorder.setLayoutY(red.getBoundsInParent().getMinY());
                redBorder.setWidth(red.getBoundsInParent().getWidth());
                redBorder.setHeight(red.getBoundsInParent().getHeight());
            }
        });
        root.getChildren().addAll(new Text("this"), new Text("is"), new Text("a"), red, new Text("TExt"));
        root.getChildren().add(redBorder);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
