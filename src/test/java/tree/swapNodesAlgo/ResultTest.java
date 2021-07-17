package tree.swapNodesAlgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class ResultTest {

    @Test
    void swapNodes() {
        List<List<Integer>> indexes = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(-1, 4),
                Arrays.asList(-1, 5),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1)
        );
        List<Integer> queries = Collections.singletonList(2);
        var result = Result.swapNodes(indexes, queries);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("4 2 1 5 3", result.get(0).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" ")));
    }

    @Test
    void testCase1() {
        List<List<Integer>> indexes = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, -1),
                Arrays.asList(-1, 7),
                Arrays.asList(8, 9),
                Arrays.asList(10, 11),
                Arrays.asList(12, 13),
                Arrays.asList(-1, 14),
                Arrays.asList(-1, -1),
                Arrays.asList(15, -1),
                Arrays.asList(16, 17),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1)
        );
        List<Integer> queries = Arrays.asList(2, 3);
        var result = Result.swapNodes(indexes, queries);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16", result.get(0).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" ")));
        Assertions.assertEquals("9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15", result.get(1).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" ")));
    }

    @Test
    void testCase2() {
        List<List<Integer>> indexes = Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(4, -1),
                Arrays.asList(5, -1),
                Arrays.asList(6, -1),
                Arrays.asList(7, 8),
                Arrays.asList(-1, 9),
                Arrays.asList(-1, -1),
                Arrays.asList(10, 11),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1),
                Arrays.asList(-1, -1)
        );
        List<Integer> queries = Arrays.asList(2, 4);
        var result = Result.swapNodes(indexes, queries);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("2 9 6 4 1 3 7 5 11 8 10", result.get(0).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" ")));
        Assertions.assertEquals("2 6 9 4 1 3 7 5 10 8 11", result.get(1).stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" ")));
    }
}