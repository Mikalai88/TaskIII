package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.model.AbstractTextComponent;

public interface Parser {
  void parse(String text, AbstractTextComponent parent);
}

