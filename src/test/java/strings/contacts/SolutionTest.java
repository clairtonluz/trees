package strings.contacts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {

    @Test
    void contacts() {
        var queries = Arrays.asList(
                Arrays.asList("add", "hack"),
                Arrays.asList("add", "hackerrank"),
                Arrays.asList("find", "hac"),
                Arrays.asList("find", "hak")
        );
        var result = Solution.contacts(queries);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(2, result.get(0));
        Assertions.assertEquals(0, result.get(1));
    }

    @Test
    void testCase1() {
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("add", "s"),
                Arrays.asList("add", "ss"),
                Arrays.asList("add", "sss"),
                Arrays.asList("add", "ssss"),
                Arrays.asList("add", "sssss"),
                Arrays.asList("find", "s"),
                Arrays.asList("find", "ss"),
                Arrays.asList("find", "sss"),
                Arrays.asList("find", "ssss"),
                Arrays.asList("find", "sssss"),
                Arrays.asList("find", "ssssss")
        );


        var result = Solution.contacts(queries);


        Assertions.assertEquals(5, result.get(0));
        Assertions.assertEquals(4, result.get(1));
        Assertions.assertEquals(3, result.get(2));
        Assertions.assertEquals(2, result.get(3));
        Assertions.assertEquals(1, result.get(4));
        Assertions.assertEquals(0, result.get(5));
    }
}