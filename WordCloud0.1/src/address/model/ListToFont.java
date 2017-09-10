package address.model;

import com.iveloper.utils.packer.Node;
import com.iveloper.utils.packer.Packer;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ListToFont {
    int placedLine, newLine;
    private ArrayList<Text> textnodes;
    Random rand = new Random(System.currentTimeMillis());
    Double randomdegree = ThreadLocalRandom.current().nextDouble(0, 360);


    double fitX = 0;
    double fitY = 0;

    private ImageView pic;

    void LoopingToScene(List<List> list2) {


        HBox hBox = new HBox();
        textnodes = new ArrayList<>();


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuBar.useSystemMenuBarProperty().set(true);
        menuBar.getMenus().addAll(menuFile);
        MenuItem itmsave = new MenuItem("Save");
        menuFile.getItems().addAll(itmsave);
        Stage stage = new Stage();
        VBox menuVBox = new VBox(menuBar);
        menuVBox.setAlignment(Pos.TOP_RIGHT);
        Pane root = new Pane(menuVBox);
        Scene scene = new Scene(root, 800, 800);

//        itmsave.setOnAction(event -> {
//            saveToFile(Snapshot);
//        });


        Integer size = 150;
        Integer setX = 50;
        Integer setY = 50;
        String family = "Arial";


        ArrayList<Node> blocks = new ArrayList<>();


        //Loop through arrayList to get each individual list
        for (List e : list2) {

            int listsize = list2.size();
            Packer packer = new Packer(1000, 80, 80);


            //Need the size of the list to go to
            //System.out.println(e);
            //this will decrease the font size for strings in each list
            size = (size - 20);
            setX = (setX + 5);
            setY = (setY + 5);
            //Random colour generator
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);
            //
            // int nop = e.size();


            for (Object d : e) {
                int x = (int) (scene.getWidth() / 2);
                int y = (int) (root.getHeight() / 2);


                //System.out.println(e.size());
                //System.out.println(d);

                Text text = new Text(x, y, (String) d);
                /*
                if collision = true {
                    translate setx{
                    if still true {
                    translate sety 50{
                    if still true{
                    translate setx -50
                    if still true{
                    translate sety -50{
                    if still true {
                    start again but increase movement size by 20 each iteration.
                    translate setx =

                    x--->-x
                    |      |
                    ^      |
                    |      |
                    |     \/
                    x-<---x
                 */


                //gives it font and size depending on index of the list
                text.setFont(Font.font(family, size));
                //random colour generator being used
                text.setFill(Color.rgb(red, green, blue, .99));
//                textFlow.setLayoutX(scene.getWidth());
//                textFlow.setLayoutY(scene.getHeight());
                // gets height/width of text object with font style and size
                double getWidth = text.getBoundsInLocal().getWidth();
                double getHeight = text.getBoundsInLocal().getHeight();


                //Steph Added
                int getWidthInt = (int) getWidth;
                int getHeightInt = (int) getHeight;
                final Rectangle redBorder = new Rectangle(0, 0, Color.TRANSPARENT);
                redBorder.setStroke(Color.RED);
                redBorder.setManaged(false);
                text.boundsInParentProperty().addListener((observable, oldValue, newValue) -> {
                    redBorder.setLayoutX(text.getBoundsInParent().getMinX());
                    redBorder.setLayoutY(text.getBoundsInParent().getMinY());
                    redBorder.setWidth(text.getBoundsInParent().getWidth());
                    redBorder.setHeight(text.getBoundsInParent().getHeight());
                });


                blocks.add(new Node(text.toString(), getWidth, getHeight));

                //adding textobjects to
                textnodes.add(text);


                Collections.sort(blocks, (a, b) -> {
                    return (Double.compare(b.w, a.w)); //sort based on width
                });
//                packer.fit(blocks);
//                Iterator<Node> blocksItr = blocks.iterator();
//                while (blocksItr.hasNext()) {
//                    Node block = blocksItr.next();
//                    if (block.fit != null) {
//                        if (block.fit.isroot) {
//                            System.out.printf("%32s", "pack starts here");
//                            System.out.println("");
//                            System.out.printf("%32s%24s%16s%16s%16s", "Display name", "x", "y", "w", "h");
//                            System.out.println("");
//                        }
//                        System.out.printf("%32s%24s%16s%16s%16s", block.name, block.fit.x, block.fit.y, block.w, block.h);
//                        System.out.println("");
//
//
//                        System.out.println(block.fit.x + ", " + block.fit.y);
//                        fitX = block.fit.x;
//                        fitY = block.fit.y;
//
//
//                    }
//
//                    System.out.println("");
//                    System.out.println(fitX + "," + fitY);
//                    //text = new Text(fitX, fitY, (String) d);
//
//
//                }
//                {
//
//
                root.getChildren().addAll(text);
                checkShapeIntersection(textnodes.get(textnodes.size() - 1));

//
////                    checkShapeIntersection(nodes.get(nodes.size() - 1))
//                }


            }


        }


        //stage.getIcons().add(new Image("C:\\Users\\Jake Fishlock\\Desktop\\wordcloud0.2\\WordCloud0.1\\src\\resources\\cloud.png"));

        stage.setScene(scene);
        stage.setTitle("WordCloud");
        //hBox.getChildren().add(root);
        //HBox.setHgrow(root, Priority.ALWAYS);
        //Scene scene1 = new Scene(new StackPane(root), 800, 800);


        stage.setScene(scene);
        stage.show();
    }

    //this part does the collision detection

    private void checkShapeIntersection(Text text) {
        boolean collisionDetected = false;
        for (Shape static_bloc : textnodes) {
            if (static_bloc != text) {

                Shape intersect = Text.intersect(text, static_bloc);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    collisionDetected = true;
                }
            }
        }


        if (collisionDetected) {
            while (collisionDetected = true) {
                Path path = new Path();
                MoveTo moveTo = new MoveTo();

                text.setX(randomdegree);
                text.setY(randomdegree);
                path.getElements().add(moveTo);
                break;
            }
        }

    }

    public static void saveToFile(Image image) {
        File outputFile = new File("C:/WordCloudApp/");
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
            System.out.println("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


