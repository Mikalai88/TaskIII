package com.mikalai.texteditor.model;
import java.util.stream.Collectors;

public class Sentence extends AbstractTextComponent {
  @Override
  public String getText() {
    return getChildren().stream()
            .map(AbstractTextComponent::getText)
            .collect(Collectors.joining(" "));
  }
}
