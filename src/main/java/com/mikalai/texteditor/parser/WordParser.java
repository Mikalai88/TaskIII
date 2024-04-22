package com.mikalai.texteditor.parser;

import com.mikalai.texteditor.model.AbstractTextComponent;
import com.mikalai.texteditor.model.CharacterComponent;
import com.mikalai.texteditor.model.Word;

public class WordParser implements Parser {
  @Override
  public void parse(String text, AbstractTextComponent parent) {
    if (containsSpecialCharacters(text)) {
      processSpecialWord(text, parent);
    } else {
      AbstractTextComponent word = new Word(text);
      parent.add(word);
    }
  }

  private boolean containsSpecialCharacters(String text) {
    return text.matches(".*[0-9+-/*()].*");
  }

  private void processSpecialWord(String text, AbstractTextComponent parent) {
    for (char c : text.toCharArray()) {
      AbstractTextComponent character = new CharacterComponent(Character.toString(c));
      parent.add(character);
    }
  }
}


