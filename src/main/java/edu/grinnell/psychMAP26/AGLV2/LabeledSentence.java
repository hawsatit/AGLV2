/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.psychMAP26.AGLV2;
import java.util.List;


/**
 * R
 * Used for evaluating sentence-level grammaticality judgments in AGL experiments.
 *
 * Rule Violation Key:
 *   0 = No rule violation (Correct sentence)
 *   1 = Rule 1 — Missing A Phrase
 *   2 = Rule 2 — D must follow A, G must follow C
 *   3 = Rule 3 — Missing F Word
 *   4 = Rule 4 — C must precede F
 */
public class LabeledSentence {
    public final List<SymbolPair
            > sentence;
    public final int isCorrect;
    public final int violatedRule; // 0 = none, 1–4 = which rule is violated
    
     /**
     * Constructs a LabeledSentence for test evaluation.
     *
     * @param sentence      the sentence as a list of category/index SymbolPair
     * s
     * @param isCorrect     true if sentence is grammatically correct
     * @param violatedRule  the rule violated if incorrect (0 = none)
     */
    public LabeledSentence(List<SymbolPair> sentence, int isCorrect, int violatedRule) {
        this.sentence = sentence;
        this.isCorrect = isCorrect;
        this.violatedRule = violatedRule;
    }

}
