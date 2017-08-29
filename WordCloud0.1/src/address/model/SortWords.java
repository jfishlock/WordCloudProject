package address.model;

import address.view.PostSubmitScene;
import javafx.geometry.Pos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;
import java.util.stream.Collectors;


public class SortWords {


    public  void sortWords(List<String> arList) {

        final String STOPWORDSLIST = "C:\\Users\\Jake Fishlock\\Desktop\\wordcloud0.2\\WordCloud0.1\\src\\resources\\stopwords.txt";
        // read Stopwords.txt
        // read file

        List<String> stopWordList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(STOPWORDSLIST))) {
            stopWordList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }



        HashMap<String, Integer> wordToCountMap = new HashMap<>();
        List wordsList = new ArrayList<>();
        //Compare words against the stopword list
        for (String word : arList) {
            if (!stopWordList.contains(word)) {
                wordsList.add(word);
                Integer wordCounter = wordToCountMap.getOrDefault(word, 0);
                ++wordCounter;
                wordToCountMap.put(word, wordCounter);
            }
        }
        //giving the filled map to a new class
        LoopTheList loopTheList = new LoopTheList();
        loopTheList.loopingList(wordToCountMap);



    }

}





