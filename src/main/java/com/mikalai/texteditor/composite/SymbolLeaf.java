package com.mikalai.texteditor.composite;

import java.util.List;

public class SymbolLeaf implements TextComponent {
  private char symbol;
  private TextType type;

  public SymbolLeaf(TextType type, char symbol) {
    this.symbol = symbol;
    this.type = type;
  }

  @Override
  public TextType getType() {
    return type;
  }

  public char getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
// назвать текстлиф или символлиф
// нет доставания элемента и тустринг

