package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.model.AbstractTextComponent;
import com.mikalai.texteditor.model.Word;

public class SentenceParser implements Parser {
  private Parser nextParser = new WordParser();

  @Override
  public void parse(String text, AbstractTextComponent parent) {
    String[] words = text.split("\\s+");
    for (String wordText : words) {
      AbstractTextComponent word = new Word(wordText);
      parent.add(word);
      nextParser.parse(wordText, word);
    }
  }
}

