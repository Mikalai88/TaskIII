package com.mikalai.texteditor.customParser;

import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class ParagraphParser implements CustomParser {
  private CustomParser nextParser;

  public ParagraphParser() {
    this.nextParser = new SentenceParser();
  }

  @Override
  public void parse(String text, TextComponent parent) {
    String[] sentences = text.split("(?<=\\.)|(?<=!)|(?<=\\?)");
    for (String sentenceText : sentences) {
      TextComponent sentence = new TextComposite(TextType.SENTENCE);
      parent.add(sentence);
      nextParser.parse(sentenceText.trim(), sentence);
    }
  }
}
