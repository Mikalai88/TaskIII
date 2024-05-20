package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class ParagraphParser implements CustomParser {
  public static final String PARAGRAPH_BOUNDARY_REGEX = "(?<=\\.)|(?<=!)|(?<=\\?)";
  private CustomParser nextParser;

  public ParagraphParser() {
    this.nextParser = new SentenceParser();
  }

  @Override
  public void parse(String text, CompositeTextComponent parent) {
    String[] sentences = text.split(PARAGRAPH_BOUNDARY_REGEX);
    for (String sentenceText : sentences) {
      CompositeTextComponent sentence = new TextComposite(TextType.SENTENCE);
      parent.add(sentence);
      nextParser.parse(sentenceText.trim(), sentence);
    }
  }
}


// REGEX в константу