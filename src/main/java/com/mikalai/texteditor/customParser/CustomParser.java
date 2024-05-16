package com.mikalai.texteditor.customParser;

import com.mikalai.texteditor.composite.TextComponent;

public interface CustomParser {
  void parse(String text, TextComponent parent);
}
