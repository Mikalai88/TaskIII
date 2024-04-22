package com.mikalai.texteditor.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Word extends AbstractTextComponent {
  private static final Logger logger = LogManager.getLogger(Word.class);
  private String text;

  public Word(String text) {
    this.text = text;
  }

  @Override
  public void add(AbstractTextComponent component) {
    // Word cannot have children
    logger.error("Attempt to add a child to a Word component");
    throw new UnsupportedOperationException("Cannot add children to a Word");
  }

  @Override
  public void remove(AbstractTextComponent component) {
    // Word cannot have children
    logger.error("Attempt to remove a child from a Word component");
    throw new UnsupportedOperationException("Cannot remove children from a Word");
  }

  @Override
  public String getText() {
    return text;
  }
}
