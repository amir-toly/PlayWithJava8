package fr.xebia.xke.java8.step4;

import fr.xebia.xke.java8.data.Address;
import fr.xebia.xke.java8.data.Role;
import fr.xebia.xke.java8.data.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<User> loadUsersFromCsv(Path csvPath) {
        try {
            List<String> lines = Files.lines(csvPath).collect(Collectors.toList());
            
			List<User> users = lines.stream()
					.filter(l -> lines.indexOf(l) != 0).map(l -> lineToUser(l))
					.collect(Collectors.toList());

            return users;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Path findRecursivelyFileByName(String path, String fileName) throws IOException {
        Path rootDictory = Paths.get(path);

		return Files.walk(rootDictory)
				.filter(p -> fileName.equals(p.getFileName().toString()))
				.findFirst().orElseThrow(FileNotFoundException::new);
    }

    private static User lineToUser(String line) {
        String[] columns = line.split(",");
        User user = new User(columns[0], columns[1], columns[2]);
        user.withLogin(columns[3])
                .withPassword(columns[4])
                .withExpireDate(LocalDate.parse(columns[5], DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.")))
                .withRole(Role.valueOf(columns[6]))
        ;
        if (columns.length > 8) {
            user.withAddress(new Address(columns[7], columns[8], columns[9]));
        }

        return user;
    }

}
