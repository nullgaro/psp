package com.dani.psp;

import java.io.*;
import java.nio.file.Path;

public class WordCounter extends Thread {
    private final Path _file;
    public WordCounter(Path file) {
        _file = file;
    }

    public void run() {
        int numOfWords = 0;

        try(FileReader fr = new FileReader(_file.toString())) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            while(line != null){
                String[] splitLine = line.split("\\s+");
                numOfWords += splitLine.length;
                line = br.readLine();
            }
            String fileName = String.valueOf(_file.getFileName());
            System.out.println("File " + fileName + " has " + numOfWords + " words");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
