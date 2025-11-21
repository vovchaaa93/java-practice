package org.practice.chapter2.task1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    @Test
    void testMultipleMostFrequent() {
        TextAnalyzer analyzer = new TextAnalyzer("а а б б в");
        List<String> result = analyzer.getMostFrequentWords();
        assertEquals(2, result.size());
        assertTrue(result.contains("а"));
        assertTrue(result.contains("б"));
    }

    @Test
    void testEmptyText() {
        TextAnalyzer analyzer = new TextAnalyzer("");
        assertTrue(analyzer.getMostFrequentWords().isEmpty());
        assertEquals(0.0, analyzer.getAverageWordLength());
    }
}