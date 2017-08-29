package address.view;

import address.Main;
import address.model.ListToFont;
import address.model.LoopTheList;
import address.model.SortWords;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import address.model.FontSize;

public class TextViewerController {



    @FXML
    private TextArea textArea;

    @FXML
    private Button submitButton;

    @FXML


    //reference to main application
    private Main main;

    /*
    the constructor
    contrsuctor called before init method
     */
    public TextViewerController(){


    }
    /*
    init the controller class. this method is automatically called after the fxml file has been loaded.
     */

    @FXML

    private void initalize()throws IOException{


        //to send text to be sorted against stop word list
        submitButton.setOnAction(event -> {
                    String uText = textArea.getText();
                    List<String> arList = new ArrayList<>(Arrays.asList(uText.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")));

                    //System.out.println(arList.toString());
                    SortWords sortWords = new SortWords();
            sortWords.sortWords(arList);


        });
    }







    public void setMain(Main main){
        this.main = main;
    }
}

