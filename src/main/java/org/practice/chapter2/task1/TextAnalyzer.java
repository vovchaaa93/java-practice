package org.practice.chapter2.task1;

import java.util.*;
import java.util.stream.Collectors;

public class TextAnalyzer {

    private final String text;

    public TextAnalyzer (String text) {
        this.text = text.toLowerCase().replaceAll("[^a-zа-яё0-9 ]", "");
    }

    public Map<String, Integer> getWordFrequency () {
        Map<String, Integer> result = new HashMap<>();
        if (text.isEmpty()) return result;
        String[] words = text.split(" ");
        for (String word : words) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }
        return result;
    }

    public List<String> getMostFrequentWords () {
        Map<String, Integer> wordFreq = getWordFrequency();
        if (wordFreq.isEmpty()) {
            return Collections.emptyList();
        }
        int maxCount = Collections.max(wordFreq.values());
        return wordFreq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public double getAverageWordLength () {
        if (text.isEmpty()) return 0.0;

        String[] words = text.split(" ");
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return (double) totalLength / words.length;
    }

    public Set<String> getWordsLongerThan (int length) {
        Set<String> result = new HashSet<>();
        String[] textArr = text.split(" ");
        for (String word : textArr) {
            if (word.length() > length) {
                result.add(word);
            }
        }
        return result;
    }
}
