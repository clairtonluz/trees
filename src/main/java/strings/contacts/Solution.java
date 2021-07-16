package strings.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static List<Integer> contacts(List<List<String>> queries) {
        var result = new ArrayList<Integer>();
        var database = new HashMap<String, List<String>>();

        for (var operation : queries) {
            var command = operation.get(0);
            var value = operation.get(1);
            if (command.equals("add")) {
                for (int i = 1; i <= value.length(); i++) {
                    var subValue = value.substring(0, i);
                    if (!database.containsKey(subValue)) {
                        var values = new ArrayList<String>();
                        values.add(value);
                        database.put(subValue, values);
                    } else {
                        database.get(subValue).add(value);
                    }
                }
            }

            if (command.equals("find")) {
                int count = database.getOrDefault(value, new ArrayList<>()).size();
                result.add(count);
            }
        }

        return result;
    }
}
