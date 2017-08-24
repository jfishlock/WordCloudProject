package address.model;


import java.util.*;

public class LoopTheList {


    public void loopingList(HashMap<String, Integer> wordToCountMap) {
/*
Integer largestVal = null;
List<String> largestList = new ArrayList<>();
List<String> secondlargestList = new ArrayList<>();

/*List<String> thirdlargestList = new ArrayList<>();
List<String> fourthlargestList = new ArrayList<>();
List<String> sixthlargestList = new ArrayList<>();
List<String> seventhlargestList = new ArrayList<>();
* /
//to get a list of keys only with the maximum values
for (Map.Entry<String, Integer> i : wordToCountMap.entrySet()) {
if (largestVal == null || largestVal < i.getValue()) {
largestVal = i.getValue();
largestList.clear();
largestList.add(i.getKey());

} else if (largestVal == i.getValue()) largestList.add(i.getKey());

for (Map.Entry<String, Integer> k : wordToCountMap.entrySet()) {
if (largestVal == null || largestVal < (k.getValue() - 1)) {
largestVal = k.getValue();
secondlargestList.clear();
secondlargestList.add(k.getKey());
} else if (largestVal == (k.getValue() - 1)) secondlargestList.add(i.getKey());

}
for (Map.Entry<String, Integer> k : wordToCountMap.entrySet()) {
if (largestVal == null || largestVal < (k.getValue() - 1)) {
largestVal = k.getValue();
secondlargestList.clear();
secondlargestList.add(k.getKey());
} else if (largestVal == (k.getValue() - 1)) secondlargestList.add(i.getKey());

}
*/
        Map.Entry<String, Integer> max1 = null;
        Map.Entry<String, Integer> max2 = null;
        Map.Entry<String, Integer> max3 = null;
        List<String> largestList = new ArrayList<>();
        List<String> secondlargestList = new ArrayList<>();
        List<String> thirdlargestList = new ArrayList<>();

        //searching for biggest value
        for (Map.Entry<String, Integer> en : wordToCountMap.entrySet()) {
            if (max1 == null || en.getValue().compareTo(max1.getValue()) > 0) {
                max1 = en;
                largestList.clear();
                largestList.add(max1.getKey());


            }

        }
        //searching for second largest value
        for (Map.Entry<String, Integer> en : wordToCountMap.entrySet()) {
            if (en != max1 && (max2 == null || (en.getValue().compareTo(max2.getValue()) > 0))) {
                max2 = en;

                secondlargestList.add(max2.getKey());
            }
        }
        //searching for third largest value
        for (Map.Entry<String, Integer> en : wordToCountMap.entrySet()) {
            if (en != max1 && en != max2 && (max3 == null || (en.getValue().compareTo(max3.getValue()) > 0))) {
                max3 = en;

                secondlargestList.add(max3.getKey());
            }
        }


        ListToFont listToFont = new ListToFont();
        listToFont.loopyLoo(largestList, secondlargestList, thirdlargestList);
        System.out.println(largestList.toString() + secondlargestList.toString() + thirdlargestList);


    }

}

/*
Integer largestVal = null;
List<Entry<String, Integer>> wordCountMapArr = new ArrayList<Entry<String, Integer>>();
for (Entry<String, Integer> i : wordCountMap.entrySet()){
if (largestVal == null || largestVal  < i.getValue()){
largestVal = i.getValue();
wordCountMapArr .clear();
wordCountMapArr .add(i);
}else if (largestVal == i.getValue()){
wordCountMapArr .add(i);
}
*/

//        wordCountMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
//        System.out.printf("%s.%n ", wordCountMap);


/*
int fontCounter = wordsList.size();
int keyWordCounter = 0;
Map<String, Integer> wordScore = new HashMap<>();

while (fontCounter <= wordsList.size()) {
for (String word : wordsList) {
keyWordCounter++;
if (wordScore.containsKey(word)) {
int newKeyWordCounter = wordScore.get(word) + keyWordCounter;
wordScore.put(word, newKeyWordCounter);
fontCounter--;
} else {
wordScore.put(word, keyWordCounter);
fontCounter--;
}
}
}
for(Map.Entry<String, Integer> entry : wordScore.entrySet()){
String word = entry.getKey().toString();
Integer count = entry.getValue();
System.out.println(word + " :" + count);
}
*/




