package com.mikalai.texteditor.reader;

import com.mikalai.texteditor.exception.CustomException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReaderImpl implements TextReader {
  public static final String NEWLINE_REGEX = "\n";

  public String readFile(String filePath) throws CustomException {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
      String line;
      while ((line = br.readLine()) != null) {
        contentBuilder.append(line).append(NEWLINE_REGEX);
      }
    } catch (IOException e) {
      throw new CustomException("Failed to read file: " + filePath, e);
    }
    return contentBuilder.toString();
  }
}

// Custom exception
// static убрать потому что не окончательная версия
// textReader сделать интерфейсом (exctract interface IDE)
// \n в константу
// не утил а ридер пакет

