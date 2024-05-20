package com.mikalai.texteditor.composite;

import java.util.List;

public interface CompositeTextComponent extends TextComponent {
  void add(TextComponent component);
  void remove(TextComponent component);
  TextComponent getElement(int index);
  List<TextComponent> getComponents();
}
