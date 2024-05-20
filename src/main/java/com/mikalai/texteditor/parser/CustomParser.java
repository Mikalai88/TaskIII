package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;

public interface CustomParser {
  void parse(String text, CompositeTextComponent parent);
}
