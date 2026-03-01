package edu.grinnell.psychMAP26.AGLV2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PreLoadSentenceMappingTest {

    private static final Map<String, String[]> SYMBOL_MAP = Map.of(
        "A", new String[]{"biff", "hep", "mib", "rud"},
        "C", new String[]{"cav", "lum", "neb", "sig"},
        "F", new String[]{"dupp", "loke", "jux", "vot"},
        "D", new String[]{"klor", "pell"},
        "G", new String[]{"tiz", "pilk"}
    );

    private String mapToWord(SymbolPair pair) {
        String[] words = SYMBOL_MAP.get(pair.category);
        if (words == null || pair.index >= words.length) return pair.toString();
        return words[pair.index];
    }

    private String sentenceToString(List<SymbolPair> sentence) {
        return sentence.stream().map(this::mapToWord).collect(Collectors.joining(" "));
    }

    private String labeledSentenceToString(LabeledSentence ls) {
        return sentenceToString(ls.sentence) + "," + ls.isCorrect + "," + ls.violatedRule;
    }

    @Test
    public void testLearningSentencesMatchExpected() throws IOException {
        PreLoadSentence pls = new PreLoadSentence();
        List<String> expected = Files.readAllLines(Path.of("expected_learning_sentences.txt"));

        List<String> actual = pls.sentences.stream()
                .map(this::sentenceToString)
                .collect(Collectors.toList());

        assertEquals(expected.size(), actual.size(), "Mismatch in number of learning sentences");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), "Mismatch at line " + (i + 1));
        }
    }

    @Test
    public void testTestSentencesMatchExpected() throws IOException {
        PreLoadSentence pls = new PreLoadSentence();
        List<String> expected = Files.readAllLines(Path.of("expected_test_sentences.csv"));

        List<String> actual = new ArrayList<>();
        for (List<LabeledSentence> pair : pls.testSentences) {
            for (LabeledSentence ls : pair) {
                actual.add(labeledSentenceToString(ls));
            }
        }

        assertEquals(expected.size(), actual.size(), "Mismatch in number of test sentences");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), "Mismatch at line " + (i + 1));
        }
    }
}
