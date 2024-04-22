package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.model.AbstractTextComponent;
import com.mikalai.texteditor.model.Sentence;

public class ParagraphParser implements Parser {
  private Parser nextParser = new SentenceParser();

  @Override
  public void parse(String text, AbstractTextComponent parent) {
    String[] sentences = text.split("(?<=[.!?])");
    for (String sentenceText : sentences) {
      AbstractTextComponent sentence = new Sentence();
      parent.add(sentence);
      nextParser.parse(sentenceText.trim(), sentence);
    }
  }
}

