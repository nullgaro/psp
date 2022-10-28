package com.dani.psp;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        Path FilesPath = Paths.get(root, "out", "production", "WordCounter", "com", "dani", "psp", "files");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(FilesPath)) {
            for (Path file: stream) {
                Thread WordCounter = new WordCounter(file);
                WordCounter.run();
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }

    }
}