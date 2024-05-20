package com.mikalai.texteditor.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements CompositeTextComponent {
  private List<TextComponent> components = new ArrayList<>();
  private TextType type;

  public TextComposite(TextType type) {
    this.type = type;
  }

  @Override
  public void add(TextComponent component) {
    components.add(component);
  }

  @Override
  public void remove(TextComponent component) {
    components.remove(component);
  }

  @Override
  public TextComponent getElement(int index) {
    return components.get(index);
  }

  @Override
  public List<TextComponent> getComponents() {
    return components;
  }

  @Override
  public TextType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "TextComposite{" +
            "components=" + components +
            ", type=" + type +
            '}';
  }
}



// тустринг должен быть чтобы все собирал как у Анастасии
//