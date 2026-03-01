package edu.grinnell.psychMAP26.AGLV2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * SymbolSentenceGenerator generates symbol sequences for both the learning and test phases.
 */
public class SymbolSentenceGenerator {
    private final SymbolLoader loader;
    private final Queue<List<BufferedImage>> sequenceQueue;
    private final Queue<Pair<List<LabeledSentence>, List<List<BufferedImage>>>> testQueue;
    
    //takes in a SymbolLoader which has the two lists of symbols
    public SymbolSentenceGenerator(SymbolLoader loader, int testGroup, boolean loadLearning) {
        this.loader = loader;
        this.sequenceQueue = new LinkedList<>();
        this.testQueue = new LinkedList<>();
        preloadSequences(testGroup, loadLearning);
    }
    
    public SymbolSentenceGenerator(SymbolLoader loader) {
        this(loader, 1, true); // default: Day 1 behavior
    }
    
    
    //Loads the images into the queues for learning and test phase
    private void preloadSequences(int testGroup, boolean loadLearning) {
        PreLoadSentence preload = new PreLoadSentence();
        List<List<SymbolPair>> sentences = preload.sentences;
        List<List<LabeledSentence>> testSentences;

        if (testGroup == 1) {
            testSentences = preload.testSentences1;
        } else {
            testSentences = preload.testSentences2;
        }

        // Only shuffle + load learning sentences if requested (Day 1)
        if (loadLearning) {
            Collections.shuffle(sentences);

            // Load learning phase sequences
            for (List<SymbolPair> sentence : sentences) {
                List<BufferedImage> images = new ArrayList<>();
                for (SymbolPair p : sentence) {
                    images.add(loader.getFromCategory(p.category, p.index));
                }
                sequenceQueue.add(images);
            }
        }

        /**
         *
         * Load test phase sentences in pairs (correct + incorrect)
         *
         * Goes through every pair of test sentences (correct + incorrect).
         * Converts each sentence into a list of images using their symbol
         * components. Pairs the original sentence objects and their image
         * versions together. Stores them in testQueue for later use (e.g.,
         * displaying them in the experiment).
         *
         *
         */
        for (List<LabeledSentence> labeledPair : testSentences) {
            List<List<BufferedImage>> imagesList = new ArrayList<>();
            for (LabeledSentence labeled : labeledPair) {
                List<BufferedImage> images = new ArrayList<>();
                for (SymbolPair p : labeled.sentence) {
                    images.add(loader.getFromCategory(p.category, p.index));
                }
                imagesList.add(images);
            }
            testQueue.add(new Pair<>(labeledPair, imagesList));
        }

        // Shuffle test question order but keep pairs together
        List<Pair<List<LabeledSentence>, List<List<BufferedImage>>>> temp = new ArrayList<>(testQueue);
        Collections.shuffle(temp);
        testQueue.clear();
        testQueue.addAll(temp);
    }

    /**
     * Retrieves the next sentence in the learning phase.
     * @return a list of BufferedImages for the next sentence
     */
    public List<BufferedImage> getNextLearning() {
        return sequenceQueue.poll();
    }
    
    //checks if the learning queue is empty
    public boolean hasNextLearning() {
        return !sequenceQueue.isEmpty();
    }

    /**
     * Retrieves the next test question pair (correct + incorrect).
     * @return a pair containing the labeled sentences and their corresponding images
     */
    public Pair<List<LabeledSentence>, List<List<BufferedImage>>> getNextTestPair() {
        return testQueue.poll();
    }

    //checks if the test queue is empty
    public boolean hasNextTest() {
        return !testQueue.isEmpty();
    }
    
    /**
    * Adds more learning phase sequences from a new SymbolLoader.
    * This allows extending the current sequenceQueue.
    * @param otherLoader the SymbolLoader to pull additional images from
    */
   public void add(SymbolLoader otherLoader) {
       PreLoadSentence preload = new PreLoadSentence();
       List<List<SymbolPair>> sentences = preload.sentences;
       Collections.shuffle(sentences);

       for (List<SymbolPair> sentence : sentences) {
           List<BufferedImage> images = new ArrayList<>();
           for (SymbolPair p : sentence) {
               images.add(otherLoader.getFromCategory(p.category, p.index));
           }
           sequenceQueue.add(images);
       }
   }
}
