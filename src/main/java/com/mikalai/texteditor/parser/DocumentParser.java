package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class DocumentParser implements CustomParser {
  private CustomParser nextParser;

  public DocumentParser() {
    this.nextParser = new ParagraphParser();
  }

  @Override
  public void parse(String text, CompositeTextComponent parent) {
    String[] paragraphs = text.split("\n\n");
    for (String paragraphText : paragraphs) {
      CompositeTextComponent paragraph = new TextComposite(TextType.PARAGRAPH);
      parent.add(paragraph);
      nextParser.parse(paragraphText, paragraph);
    }
  }
}
