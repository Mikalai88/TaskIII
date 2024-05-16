package com.mikalai.texteditor.customParser;

import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextComposite;
import com.mikalai.texteditor.composite.TextType;

public class DocumentParser implements CustomParser {
  private CustomParser nextParser;

  public DocumentParser() {
    this.nextParser = new ParagraphParser();
  }

  @Override
  public void parse(String text, TextComponent parent) {
    String[] paragraphs = text.split("\n\n");
    for (String paragraphText : paragraphs) {
      TextComponent paragraph = new TextComposite(TextType.PARAGRAPH);
      parent.add(paragraph);
      nextParser.parse(paragraphText, paragraph);
    }
  }
}
