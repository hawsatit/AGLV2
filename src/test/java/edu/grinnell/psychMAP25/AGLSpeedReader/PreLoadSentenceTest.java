package edu.grinnell.psychMAP26.AGLV2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreLoadSentenceTest {
    private PreLoadSentence preload;

    @BeforeEach
    public void setUp() {
        preload = new PreLoadSentence();
    }

    @Test
    public void testLearningSentenceCount() {
        List<List<SymbolPair>> sentences = preload.sentences;
        assertEquals(50, sentences.size(), "There should be 50 learning phase sentences.");
    }

    @Test
    public void testLearningSentenceLengths() {
        for (List<SymbolPair> sentence : preload.sentences) {
            assertTrue(sentence.size() >= 3 && sentence.size() <= 5,
                "Learning sentence length should be between 3 and 5 symbols.");
        }
    }

    @Test
    public void testTestPairCount() {
        List<List<LabeledSentence>> testPairs = preload.testSentences;
        assertEquals(24, testPairs.size(), "There should be 24 test question pairs.");
    }

    @Test
    public void testEachTestPairHasTwoItems() {
        for (List<LabeledSentence> pair : preload.testSentences) {
            assertEquals(2, pair.size(), "Each test question pair must have exactly 2 sentences.");
        }
    }

    @Test
    public void testEachTestPairHasOneCorrectSentence() {
        for (List<LabeledSentence> pair : preload.testSentences) {
            long correctCount = pair.stream().filter(s -> s.isCorrect == 1).count();
            assertEquals(1, correctCount, "Each test pair must have exactly one correct sentence.");
        }
    }

    @Test
    public void testNoNullSentences() {
        for (List<SymbolPair> sentence : preload.sentences) {
            assertNotNull(sentence, "Learning sentence should not be null.");
            for (SymbolPair pair : sentence) {
                assertNotNull(pair, "SymbolPair in learning sentence should not be null.");
                assertNotNull(pair.category, "SymbolPair category should not be null.");
            }
        }

        for (List<LabeledSentence> pair : preload.testSentences) {
            for (LabeledSentence labeled : pair) {
                assertNotNull(labeled, "LabeledSentence should not be null.");
                assertNotNull(labeled.sentence, "LabeledSentence sentence list should not be null.");
            }
        }
    }
}
