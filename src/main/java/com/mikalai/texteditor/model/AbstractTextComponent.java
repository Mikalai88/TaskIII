package com.mikalai.texteditor.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class TextComponent {
  private static final Logger logger = LogManager.getLogger(TextComponent.class);

  private List<TextComponent> children = new ArrayList<>();

  public void add(TextComponent component) {
    logger.info("Adding component: " + component);
    children.add(component);
  }

  public void remove(TextComponent component) {
    logger.info("Removing component: " + component);
    children.remove(component);
  }

  public List<TextComponent> getChildren() {
    return children;
  }

  public abstract String getText();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TextComponent that = (TextComponent) o;
    return Objects.equals(children, that.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(children);
  }

  @Override
  public String toString() {
    return getText();
  }
}

