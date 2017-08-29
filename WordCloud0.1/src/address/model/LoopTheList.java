package address.model;


import java.util.*;
import java.util.stream.Collectors;

public class LoopTheList {


    public void loopingList(HashMap<String, Integer> wordToCountMap) {

        //System.out.println(wordToCountMap);

        List<Integer> values = wordToCountMap.values().stream().collect(Collectors.toList());
        Collections.sort(values);
        Collections.reverse(values);
        //System.out.println(values);

//        Integer highestValue = values.get(0);
//        List<Map.Entry<String, Integer>> wordsWithHighestValue = wordToCountMap.entrySet().stream().filter(e -> e.getValue().equals(highestValue)).collect(Collectors.toList());

        //System.out.println(wordsWithHighestValue);

        NavigableMap<Integer, List<String>> countToWordsMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordToCountMap.entrySet()) {
            Integer count = entry.getValue();
            List<String> list = countToWordsMap.getOrDefault(count, new ArrayList<>());
            list.add(entry.getKey());
            countToWordsMap.put(count, list);


        }
        List<List> list2 = new ArrayList<>();
        for (List d : countToWordsMap.values()) {
            list2.add(d);
        }

        //System.out.println(countToWordsMap.values());
        //System.out.println(list2.get(0));
        ListToFont listToFont = new ListToFont();
        listToFont.LoopingToScene(list2);


    }
}





