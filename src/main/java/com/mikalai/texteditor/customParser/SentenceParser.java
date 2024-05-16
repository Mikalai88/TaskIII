package com.mikalai.texteditor.customParser;

import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class SentenceParser implements CustomParser {
  private CustomParser nextParser;

  public SentenceParser() {
    this.nextParser = new WordParser();
  }

  @Override
  public void parse(String text, TextComponent parent) {
    String[] words = text.split("\\s+");
    for (String wordText : words) {
      TextComponent word = new TextComposite(TextType.WORD);
      parent.add(word);
      nextParser.parse(wordText, word);
    }
  }
}
