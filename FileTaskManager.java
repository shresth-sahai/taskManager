package tech.codingclub.wordTopFrequencyAnalyser.Utility;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileTaskManager {

    Map<String, Integer> map;
    public FileTaskManager(Map<String, Integer> map)
    {
        this.map = map;
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    public void printMap()
    {
        int ct=0;
        this.map = sortByValue(this.map, false);
        for(Map.Entry<String, Integer> entry: this.map.entrySet())
        {
            System.out.println(entry.getValue() + " " + entry.getKey());
            if(ct==8)
                System.exit(0);
            ct++;
        }
    }
}
