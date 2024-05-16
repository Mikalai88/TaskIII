package com.mikalai.texteditor.composite;

import java.util.List;

public class Leaf implements TextComponent {
  private char symbol;
  private TextType type;

  public Leaf(TextType type, char symbol) {
    this.symbol = symbol;
    this.type = type;
  }

  @Override
  public void add(TextComponent component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void remove(TextComponent component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public TextComponent getElement(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<TextComponent> getComponents() {
    throw new UnsupportedOperationException();
  }

  @Override
  public TextType getType() {
    return type;
  }
}

