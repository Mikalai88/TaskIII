package com.mikalai.texteditor.customParser;

import com.mikalai.texteditor.composite.Leaf;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextType;

public class WordParser implements CustomParser {
  @Override
  public void parse(String text, TextComponent parent) {
    for (char c : text.toCharArray()) {
      TextComponent symbol = new Leaf(TextType.LETTER, c);
      parent.add(symbol);
    }
  }
}

