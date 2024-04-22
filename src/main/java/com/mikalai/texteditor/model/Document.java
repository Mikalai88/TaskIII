package com.mikalai.texteditor.model;
import java.util.stream.Collectors;

public class Document extends AbstractTextComponent {
  @Override
  public String getText() {
    return getChildren().stream()
            .map(AbstractTextComponent::getText)
            .collect(Collectors.joining("\n"));
  }
}

