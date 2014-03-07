package fr.xebia.xke.java7.step4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class TextAnalyser {

    public static final String REGEX_CHAR_ONLY = "^[a-z]+$";

    private Path filePath;

    public TextAnalyser(String path) {
        filePath = new File(path).toPath();
    }

    public Set<String> words() throws IOException {
        try (Scanner scanner = new Scanner(filePath)) {
            scanner.useDelimiter("[\\s\\n]");

            Set<String> words = new HashSet<>();
            while (scanner.hasNext()) {
                String next = scanner.next().toLowerCase();
                if (next.matches(REGEX_CHAR_ONLY)) {
                    words.add(next);
                }
            }

            return words;
        }

    }

    public Map<String, Long> wordOccurrence() throws IOException {
        try (Scanner scanner = new Scanner(filePath)) {
            scanner.useDelimiter("[\\s\\n]");

            Map<String, Long> wordsOccurrence = new HashMap<>();
            while (scanner.hasNext()) {
                String next = scanner.next().toLowerCase();
                if (next.matches(REGEX_CHAR_ONLY)) {
                    Long count = wordsOccurrence.get(next);
                    if (count == null) {
                        wordsOccurrence.put(next, 1L);
                    } else {
                        wordsOccurrence.put(next, count + 1);
                    }
                }
            }

            return wordsOccurrence;
        }
    }

}