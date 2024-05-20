package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class SentenceParser implements CustomParser {
  public static final String WORD_BOUNDARY_REGEX = "(?<=\\s)|(?=\\s)";
  private CustomParser nextParser;

  public SentenceParser() {
    this.nextParser = new WordParser();
  }

  @Override
  public void parse(String text, CompositeTextComponent parent) {
    String[] words = text.split(WORD_BOUNDARY_REGEX);
    for (String wordText : words) {
      if (!wordText.trim().isEmpty()) {
        CompositeTextComponent word = new TextComposite(TextType.WORD);
        parent.add(word);
        nextParser.parse(wordText.trim(), word);
      }
    }
  }
}

// вылавливаются лексемы и нужно вылавливать слова
