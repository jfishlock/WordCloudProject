package address.model;


import java.util.*;


public class LoopTheList {


    void loopingList(HashMap<String, Integer> wordToCountMap) {


//        List<Integer> values = wordToCountMap.values().stream().collect(Collectors.toList());
//        Collections.sort(values);
//        Collections.reverse(values);
//        //System.out.println(values);

        //Sorting the words proportionate to the count and adding them to a map where count is key and list of words are a value reversed to have highest first
        NavigableMap<Integer, List<String>> countToWordsMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordToCountMap.entrySet()) {
            Integer count = entry.getValue();
            List<String> list = countToWordsMap.getOrDefault(count, new ArrayList<>());
            list.add(entry.getKey());
            countToWordsMap.put(count, list);


        }
        //System.out.println(countToWordsMap);
        //putting the values into their own list as they are now sorted in the correct order
        List<List> list2 = new ArrayList<>();


        list2.addAll(countToWordsMap.values());


        DisplayWords listToFont = new DisplayWords();
        listToFont.LoopingToScene(list2);


    }
}





