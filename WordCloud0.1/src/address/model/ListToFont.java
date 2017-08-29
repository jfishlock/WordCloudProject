package address.model;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


import java.util.*;
import java.util.List;


public class ListToFont {


    public void LoopingToScene(List<List> list2) {
        TextFlow textFlow = new TextFlow();

        final Menu menu1 = new Menu("File");
        final Menu menu2 = new Menu("Options");
        final Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);


        Group group = new Group(textFlow);

        Stage stage = new Stage();
        //stage.getIcons().add(new Image("C:\\Users\\Jake Fishlock\\Desktop\\wordcloud0.2\\WordCloud0.1\\src\\resources\\cloud.png"));
        Scene scene = new Scene(group, 1200, 600, Color.WHITE);
        stage.setTitle("WordCloud");

        Integer size = 150;
        String family = "Arial";
        Text text;
        Random rand = new Random(System.currentTimeMillis());

        //Loop through arrayList to get each individual list
        for (List e : list2) {
            System.out.println(e);
            //this will decrease the font size for strings in each list
            size = (size - 30);
            //Random colour generator
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            for (Object d : e) {
                System.out.println(d);
                int x = rand.nextInt((int)scene.getWidth());
                int y = rand.nextInt((int)scene.getHeight());

                text = new Text(x, y, (String) d);
                //gives it font and size depending on index of the list
                text.setFont(Font.font(family, size));
                //random colour generator being used
                text.setFill(Color.rgb(red, green, blue, .99));
                text.setTextAlignment(TextAlignment.JUSTIFY);
                textFlow.setPrefWidth(Region.USE_COMPUTED_SIZE);
                textFlow.setPrefHeight(Region.USE_COMPUTED_SIZE);
                textFlow.setLayoutX(scene.getWidth());
                textFlow.setLayoutY(scene.getHeight());


                group.getChildren().addAll(text);
            }
        }
        stage.setScene(scene);
        stage.show();
    }
}









