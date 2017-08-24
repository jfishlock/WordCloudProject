package address.model;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListToFont {

    public void loopyLoo(List<String> largestList, List<String> secondlargestList, List<String> thirdlargestList) {
        Text largest = new Text();
        Text secondLargest = new Text();

        for(String temp1 : largestList){
            largest = new Text(temp1);
        } for (String temp2 : secondlargestList){
            secondLargest = new Text( temp2);
        }
        aScene(largest, secondLargest );

    }

    public void aScene(Text largeList, Text secLargeList) {
        String family = "Arial";
        double size = 50;
        double sizesmlr = 40;
        TextFlow textFlow = new TextFlow();


        largeList.setFont(Font.font(family, size));
        largeList.setFill(Color.RED);


        secLargeList.setFont(Font.font(family, sizesmlr));
        secLargeList.setFill(Color.RED);


        textFlow.setLayoutX(40);
        textFlow.setLayoutY(40);


        textFlow.getChildren().addAll(largeList, secLargeList);

        Group group = new Group(textFlow);
        Scene scene = new Scene(group, 1200, 800, Color.WHITE);
        Stage stage = new Stage();
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();


    }



}





