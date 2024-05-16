package com.mikalai.texteditor.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

  public static String readFile(String filePath) throws IOException {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
      String line;
      while ((line = br.readLine()) != null) {
        contentBuilder.append(line).append("\n");
      }
    }
    return contentBuilder.toString();
  }

}

