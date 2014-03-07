package fr.xebia.xke.step3;

import fr.xebia.xke.fr.xebia.xke.java8.data.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserParser {

    public static List<User> fromCsv(String csvPath) {
        //TODO: Replace By Files.line

        try (BufferedReader reader = new BufferedReader(new FileReader(getFileFromPath(csvPath).toFile()))) {
            String line;
            boolean firstLine = true;
            List<User> users = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (!firstLine) {
                    users.add(lineToUser(line));
                }
                firstLine = false;
            }

            return users;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Path findRecursivelyFileByName(String path, String fileName) {
        //TODO:replace by Files.walk

        Path rootDictory = Paths.get(path);

        SearchVisitor searchVisitor = new SearchVisitor(fileName);

        try {
            Files.walkFileTree(rootDictory, searchVisitor);
            return searchVisitor.fileFound;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static User lineToUser(String line) {
        String[] columns = line.split(",");
        User user = new User(columns[0], columns[1], columns[2]);
        user.withLogin(columns[3])
                .withPassword(columns[4])
                .withExpireDate(LocalDate.parse(columns[5], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.")))
        ;


        return user;
    }

    private static Path getFileFromPath(String csvPath) throws URISyntaxException {
        return Paths.get(UserParser.class.getClassLoader().getResource(csvPath).toURI());
    }

    public static class SearchVisitor extends SimpleFileVisitor<Path> {

        private Path fileFound;
        private String fileNameToSearch;

        public SearchVisitor(String fileNameToSearch) {
            this.fileNameToSearch = fileNameToSearch;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile() && file.getFileName().toString().equals(fileNameToSearch)) {
                fileFound = file;
                return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}