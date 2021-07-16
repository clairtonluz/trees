package strings.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static List<Integer> contacts(List<List<String>> queries) {
        var result = new LinkedList<Integer>();
        var database = new HashMap<String, Integer>();

        for (var operation : queries) {
            var command = operation.get(0);
            var value = operation.get(1);
            if (command.equals("add")) {
                for (int i = 1; i <= value.length(); i++) {
                    var subValue = value.substring(0, i);
                    if (!database.containsKey(subValue)) {
                        database.put(subValue, 1);
                    } else {
                        database.put(subValue, database.get(subValue) + 1);
                    }
                }
            }

            if (command.equals("find")) {
                result.add(database.getOrDefault(value, 0));
            }
        }

        return result;
    }
}
