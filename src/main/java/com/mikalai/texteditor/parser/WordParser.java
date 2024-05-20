package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.SymbolLeaf;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextType;

public class WordParser implements CustomParser {
  @Override
  public void parse(String text, CompositeTextComponent parent) {
    for (char c : text.toCharArray()) {
      TextComponent symbol = new SymbolLeaf(TextType.LETTER, c);
      parent.add(symbol);
    }
  }
}



