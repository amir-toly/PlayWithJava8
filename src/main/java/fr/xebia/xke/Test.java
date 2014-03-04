package fr.xebia.xke;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;
import java.util.function.Predicate;

public class Test {

    public static void main(String... args) throws IOException {
        find();
        find();


        long time = System.currentTimeMillis();
        System.out.println("walk = " + find());

        System.out.println("time= " + (System.currentTimeMillis() - time));

        //Files.list(Paths.get(".")).forEach(System.out::println);
        //  Files.walk(Paths.get(".")).forEach(p -> System.out.println(p.getFileName()));

        //ystem.out.println("any = " + any);
    }

    private static Optional<File> walk() throws IOException {

        PrintFiles visitor = new PrintFiles();
        Files.walkFileTree(Paths.get("/Users/ivan/dev"), visitor);
        return Optional.ofNullable(visitor.path.toFile());

        // Optional<File> first = Files.walk(Paths.get("/Users/ivan/dev")).map(p -> p.toFile()).filter(f -> f.getName().endsWith(".java")).findFirst();
        //return first;

    }

    private static Optional<File> find() throws IOException {
        return Files.walk(Paths.get(".")).map(Path::toFile).filter(p -> !p.getName().startsWith(".")).filter(findTest()).findFirst();
    }

    private static Predicate<File> findTest() throws IOException {
        return file -> {
            try {
                System.out.println("file = " + file.getName());
                return file.isFile() && !file.isHidden() && Files.lines(Paths.get(file.toURI())).anyMatch(line -> line.contains("TextAnalyserValidationTest"));
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static class PrintFiles
            extends SimpleFileVisitor<Path> {

        Path path;

        // Print information about
        // each type of file.
        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attr) {
            if (attr.isRegularFile()) {
                String fileName = file.getFileName().toString();
                if (fileName.endsWith("java")) {
                    path = file;
                    return FileVisitResult.TERMINATE;
                }
            }

            return FileVisitResult.CONTINUE;
        }
    }
}
