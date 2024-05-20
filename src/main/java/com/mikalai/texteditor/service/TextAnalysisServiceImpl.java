package com.mikalai.texteditor.service;


import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;
import com.mikalai.texteditor.composite.TextType;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextAnalysisServiceImpl implements TextAnalysisService {

  @Override
  public List<CompositeTextComponent> sortParagraphsByNumberOfSentences(CompositeTextComponent text) {
    return text.getComponents().stream()
            .filter(p -> p.getType() == TextType.PARAGRAPH && p instanceof CompositeTextComponent)
            .map(p -> (CompositeTextComponent) p)
            .sorted(Comparator.comparingInt(p -> p.getComponents().size()))
            .collect(Collectors.toList());
  }

  @Override
  public List<TextComponent> findSentencesWithLongestWord(CompositeTextComponent text) {
    return text.getComponents().stream()
            .filter(p -> p instanceof CompositeTextComponent)
            .map(p -> (CompositeTextComponent) p)
            .flatMap(p -> p.getComponents().stream())
            .filter(s -> s.getType() == TextType.SENTENCE)
            .sorted(Comparator.comparingInt(s -> findLongestWordLength((CompositeTextComponent) s)))
            .collect(Collectors.toList());
  }

  @Override
  public void removeSentencesWithFewerWords(CompositeTextComponent text, int minWordsCount) {
    for (TextComponent paragraphComponent : text.getComponents()) {
      if (paragraphComponent.getType() == TextType.PARAGRAPH && paragraphComponent instanceof CompositeTextComponent) {
        CompositeTextComponent paragraph = (CompositeTextComponent) paragraphComponent;

        List<TextComponent> sentencesToRemove = paragraph.getComponents().stream()
                .filter(sentence -> sentence instanceof CompositeTextComponent)
                .filter(sentence -> ((CompositeTextComponent) sentence).getComponents().size() < minWordsCount)
                .collect(Collectors.toList());

        sentencesToRemove.forEach(paragraph::remove);
      }
    }
  }

  @Override
  public Map<String, Integer> findAllWordsAndCount(CompositeTextComponent text) {
    Map<String, Integer> wordCount = new HashMap<>();
    text.getComponents().stream()
            .filter(p -> p instanceof CompositeTextComponent)
            .map(p -> (CompositeTextComponent) p)
            .flatMap(p -> p.getComponents().stream())
            .filter(s -> s instanceof CompositeTextComponent)
            .map(s -> (CompositeTextComponent) s)
            .flatMap(s -> s.getComponents().stream())
            .map(w -> w.toString().toLowerCase())
            .forEach(word -> wordCount.merge(word, 1, Integer::sum));
    return wordCount;
  }

  @Override
  public Map<String, Integer> countVowelsAndConsonants(TextComponent sentence) {
    int vowels = 0, consonants = 0;
    String vowelsPattern = "aeiouAEIOU";

    if (sentence instanceof CompositeTextComponent) {
      CompositeTextComponent compositeSentence = (CompositeTextComponent) sentence;
      for (TextComponent word : compositeSentence.getComponents()) {
        for (char c : word.toString().toCharArray()) {
          if (Character.isLetter(c)) {
            if (vowelsPattern.indexOf(c) >= 0) {
              vowels++;
            } else {
              consonants++;
            }
          }
        }
      }
    }

    Map<String, Integer> counts = new HashMap<>();
    counts.put("vowels", vowels);
    counts.put("consonants", consonants);
    return counts;
  }

  private int findLongestWordLength(TextComponent sentence) {
    if (sentence instanceof CompositeTextComponent) {
      CompositeTextComponent compositeSentence = (CompositeTextComponent) sentence;
      return compositeSentence.getComponents().stream()
              .mapToInt(w -> w.toString().length())
              .max()
              .orElse(0);
    }
    return 0;
  }
}
