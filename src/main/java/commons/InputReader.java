package commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {
    public static List<String> readLines(String filepath) {
        try {
            Path path = Paths.get(filepath);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
