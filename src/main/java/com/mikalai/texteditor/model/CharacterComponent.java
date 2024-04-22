package com.mikalai.texteditor.model;

public class CharacterComponent extends AbstractTextComponent {
  private String character;

  public CharacterComponent(String character) {
    this.character = character;
  }

  @Override
  public String getText() {
    return character;
  }
}
