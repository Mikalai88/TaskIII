package com.mikalai.texteditor.service;

import com.mikalai.texteditor.composite.CompositeTextComponent;
import com.mikalai.texteditor.composite.TextComponent;

import java.util.List;
import java.util.Map;

public interface TextAnalysisService {
  List<CompositeTextComponent> sortParagraphsByNumberOfSentences(CompositeTextComponent text);
  List<TextComponent> findSentencesWithLongestWord(CompositeTextComponent text);
  void removeSentencesWithFewerWords(CompositeTextComponent text, int minWordsCount);
  Map<String, Integer> findAllWordsAndCount(CompositeTextComponent text);
  Map<String, Integer> countVowelsAndConsonants(TextComponent sentence);
}