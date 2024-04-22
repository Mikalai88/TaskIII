package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.model.AbstractTextComponent;
import com.mikalai.texteditor.model.Paragraph;

public class DocumentParser implements Parser {
  private Parser nextParser = new ParagraphParser();

  @Override
  public void parse(String text, AbstractTextComponent parent) {
    String[] paragraphs = text.split("\n\n");
    for (String paragraphText : paragraphs) {
      AbstractTextComponent paragraph = new Paragraph();
      parent.add(paragraph);
      nextParser.parse(paragraphText, paragraph);
    }
  }
}

