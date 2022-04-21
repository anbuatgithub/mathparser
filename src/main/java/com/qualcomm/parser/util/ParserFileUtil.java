package com.qualcomm.parser.util;

import com.qualcomm.parser.exception.ParserFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserFileUtil {

    public static List<String> loadFile(String filename) throws ParserFileException {
        try {
            return Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new ParserFileException("Error loading the file "+ e.getMessage());
        }
    }

    public static void saveContent(String fileName,List<String> contents) throws ParserFileException {
        try {
            Files.write(Paths.get(fileName),contents);
        } catch (IOException e) {
            throw new ParserFileException("Error writing the file "+ e.getMessage());
        }
    }


}
