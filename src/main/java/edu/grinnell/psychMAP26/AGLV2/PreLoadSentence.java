/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.psychMAP26.AGLV2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fui
 */
public class PreLoadSentence {

    //for the learning phase
    List<List<SymbolPair>> sentences = new ArrayList<>();

    //for the test phase
    List<List<LabeledSentence>> testSentences1 = new ArrayList<>();
    List<List<LabeledSentence>> testSentences2 = new ArrayList<>();
    
    //load the sentences into the list
    public PreLoadSentence() {
        sentences.clear();

        // Rule: ACF
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 0), new SymbolPair("F", 0)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 1), new SymbolPair("F", 1)));
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 2), new SymbolPair("F", 2)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 3), new SymbolPair("F", 3)));
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 1), new SymbolPair("F", 0)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 0), new SymbolPair("F", 2)));
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 3), new SymbolPair("F", 1)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 2), new SymbolPair("F", 3)));

        // Rule: ADCF
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 1), new SymbolPair("F", 0)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("F", 1)));
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("F", 2)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 0), new SymbolPair("F", 3)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("F", 0)));
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("F", 3)));
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("D", 1), new SymbolPair("C", 1), new SymbolPair("F", 2)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("F", 1)));

        // Rule: ACGF
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 0))); // biff cav tiz dupp
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 1))); // hep lum pilk loke
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 2))); // mib neb tiz jux
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 3))); // rud sig pilk vot
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 0))); // rud neb pilk dupp
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 1), new SymbolPair("G", 0), new SymbolPair("F", 1))); // mib lum tiz loke
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 0), new SymbolPair("G", 1), new SymbolPair("F", 2))); // biff cav pilk jux
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 3), new SymbolPair("G", 0), new SymbolPair("F", 3))); // hep sig tiz vot

        // Rule: ADCGF
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("G", 1), new SymbolPair("F", 2))); // biff klor cav pilk jux
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("G", 0), new SymbolPair("F", 3))); // biff pell sig tiz vot
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 1), new SymbolPair("G", 0), new SymbolPair("F", 0))); // rud pell lum tiz dupp
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 1))); // mib klor lum pilk loke
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("D", 1), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 2))); // mib pell cav tiz jux
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 3))); // rud klor sig pilk vot
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 1))); // hep klor neb tiz loke
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 0))); // rud pell neb pilk dupp

        // Rule: ACFC
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 3), new SymbolPair("F", 0), new SymbolPair("C", 0)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 0), new SymbolPair("F", 1), new SymbolPair("C", 2)));
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 1), new SymbolPair("F", 2), new SymbolPair("C", 3)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 2), new SymbolPair("F", 3), new SymbolPair("C", 1)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 0), new SymbolPair("F", 2), new SymbolPair("C", 1)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 3), new SymbolPair("F", 1), new SymbolPair("C", 2)));

        // Rule: ADCFC
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("F", 3), new SymbolPair("C", 3)));
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 1), new SymbolPair("F", 1), new SymbolPair("C", 2)));
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("F", 0), new SymbolPair("C", 1)));
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("F", 2), new SymbolPair("C", 0)));

        // Rule: ACGFC
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 2), new SymbolPair("C", 1))); // biff cav tiz jux lum
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 3), new SymbolPair("C", 3))); // hep lum pilk vot sig
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 0), new SymbolPair("C", 0))); // mib sig pilk dupp cav
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 1), new SymbolPair("C", 1))); // rud neb tiz loke lum

        // Rule: ACFCG
        sentences.add(List.of(new SymbolPair("A", 0), new SymbolPair("C", 2), new SymbolPair("F", 2), new SymbolPair("C", 1), new SymbolPair("G", 0))); // biff neb jux lum tiz
        sentences.add(List.of(new SymbolPair("A", 1), new SymbolPair("C", 0), new SymbolPair("F", 1), new SymbolPair("C", 2), new SymbolPair("G", 1))); // hep cav loke neb pilk
        sentences.add(List.of(new SymbolPair("A", 2), new SymbolPair("C", 3), new SymbolPair("F", 0), new SymbolPair("C", 0), new SymbolPair("G", 1))); // mib sig dupp cav pilk
        sentences.add(List.of(new SymbolPair("A", 3), new SymbolPair("C", 1), new SymbolPair("F", 3), new SymbolPair("C", 3), new SymbolPair("G", 0))); // rud lum vot sig tiz

        // Test sentences (correct and incorrect grouped together)
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 2)), 1, 1),
                new LabeledSentence(List.of(new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 2)), 0, 1)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("C", 1), new SymbolPair("G", 0), new SymbolPair("F", 0)), 0, 1),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("C", 1), new SymbolPair("G", 0), new SymbolPair("F", 0)), 1, 1)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 3)), 1, 1),
                new LabeledSentence(List.of(new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 3)), 0, 1)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 1)), 0, 1),
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 1)), 1, 1)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 0)), 1, 1),
                new LabeledSentence(List.of(new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 0)), 0, 1)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 0)), 0, 1),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 0)), 1, 1)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 2)), 1, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("G", 1), new SymbolPair("C", 1), new SymbolPair("D", 0), new SymbolPair("F", 2)), 0, 2)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("G", 1), new SymbolPair("C", 0), new SymbolPair("D", 1), new SymbolPair("F", 0)), 0, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("C", 0), new SymbolPair("G", 1), new SymbolPair("F", 0)), 1, 2)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("G", 0), new SymbolPair("F", 3)), 1, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("G", 0), new SymbolPair("C", 3), new SymbolPair("D", 0), new SymbolPair("F", 3)), 0, 2)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("G", 1), new SymbolPair("C", 2), new SymbolPair("D", 1), new SymbolPair("F", 1)), 0, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 1)), 1, 2)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("G", 0), new SymbolPair("C", 0), new SymbolPair("D", 1), new SymbolPair("F", 0)), 0, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 1), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 0)), 1, 2)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 0), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 3)), 1, 2),
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("G", 1), new SymbolPair("C", 1), new SymbolPair("D", 0), new SymbolPair("F", 3)), 0, 2)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 2)), 0, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 0), new SymbolPair("C", 2), new SymbolPair("F", 1)), 1, 3)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("C", 1), new SymbolPair("G", 1), new SymbolPair("F", 2)), 1, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("C", 1), new SymbolPair("G", 1)), 0, 3)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("G", 0)), 0, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("G", 0), new SymbolPair("F", 3)), 1, 3)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("G", 0), new SymbolPair("F", 0)), 1, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("G", 0)), 0, 3)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 3)), 0, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 0), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("F", 2)), 1, 3)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("C", 2), new SymbolPair("G", 0), new SymbolPair("F", 3)), 1, 3),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("C", 2), new SymbolPair("G", 0)), 0, 3)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("F", 0)), 0, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 3), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("F", 0)), 1, 4)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 0), new SymbolPair("F", 2)), 1, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("F", 2)), 0, 4)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("F", 3)), 0, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 0), new SymbolPair("C", 1), new SymbolPair("F", 3)), 1, 4)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("C", 3), new SymbolPair("G", 1), new SymbolPair("F", 1)), 1, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("F", 1)), 0, 4)
        ));
        testSentences1.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("F", 2)), 0, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 1), new SymbolPair("D", 1), new SymbolPair("C", 2), new SymbolPair("G", 1), new SymbolPair("F", 2)), 1, 4)
        ));
        testSentences2.add(List.of(
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("C", 3), new SymbolPair("G", 0), new SymbolPair("F", 1)), 1, 4),
                new LabeledSentence(List.of(new SymbolPair("A", 2), new SymbolPair("D", 0), new SymbolPair("F", 1)), 0, 4)
        ));

                // ===== 24 NEW CHECKED TEST PAIRS =====
        
        // Rule 1
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("C",2), new SymbolPair("G",1), new SymbolPair("F",0)),1,1), new LabeledSentence(List.of(new SymbolPair("C",1), new SymbolPair("G",0), new SymbolPair("C",2), new SymbolPair("F",0)),0,1)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("C",2), new SymbolPair("F",2)),1,1), new LabeledSentence(List.of(new SymbolPair("C",2), new SymbolPair("G",0), new SymbolPair("F",2)),0,1)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",1), new SymbolPair("C",2), new SymbolPair("G",0), new SymbolPair("F",3)),1,1), new LabeledSentence(List.of(new SymbolPair("C",3), new SymbolPair("G",0), new SymbolPair("C",2), new SymbolPair("G",0), new SymbolPair("F",3)),0,1)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("D",0), new SymbolPair("C",3), new SymbolPair("G",0), new SymbolPair("F",2)),1,1), new LabeledSentence(List.of(new SymbolPair("C",2), new SymbolPair("G",1), new SymbolPair("C",3), new SymbolPair("G",0), new SymbolPair("F",2)),0,1)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("C",1), new SymbolPair("G",0), new SymbolPair("F",1)),1,1), new LabeledSentence(List.of(new SymbolPair("C",1), new SymbolPair("G",1), new SymbolPair("C",1), new SymbolPair("F",1)),0,1)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("C",1), new SymbolPair("F",1)),1,1), new LabeledSentence(List.of(new SymbolPair("C",1), new SymbolPair("G",1), new SymbolPair("F",1)),0,1)));
        
        // Rule 2
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("D",0), new SymbolPair("C",0), new SymbolPair("G",0), new SymbolPair("F",2)),1,2), new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("G",0), new SymbolPair("C",0), new SymbolPair("D",0), new SymbolPair("F",2)),0,2)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",0), new SymbolPair("C",3), new SymbolPair("G",1), new SymbolPair("F",2)),1,2), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("G",1), new SymbolPair("C",3), new SymbolPair("D",0), new SymbolPair("F",2)),0,2)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",0), new SymbolPair("C",2), new SymbolPair("G",1), new SymbolPair("F",3)),1,2), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("G",1), new SymbolPair("C",2), new SymbolPair("D",0), new SymbolPair("F",3)),0,2)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",0), new SymbolPair("C",3), new SymbolPair("G",1), new SymbolPair("F",3)),1,2), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("G",1), new SymbolPair("C",3), new SymbolPair("D",0), new SymbolPair("F",3)),0,2)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",1), new SymbolPair("C",3), new SymbolPair("G",1), new SymbolPair("F",0)),1,2), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("G",1), new SymbolPair("C",3), new SymbolPair("D",1), new SymbolPair("F",0)),0,2)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("D",1), new SymbolPair("C",3), new SymbolPair("G",1), new SymbolPair("F",2)),1,2), new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("G",1), new SymbolPair("C",3), new SymbolPair("D",1), new SymbolPair("F",2)),0,2)));
        
        // Rule 3
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",0), new SymbolPair("C",1), new SymbolPair("G",0), new SymbolPair("F",2)),1,3), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("D",0), new SymbolPair("C",1), new SymbolPair("G",0), new SymbolPair("C",0)),0,3)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("D",0), new SymbolPair("C",0), new SymbolPair("G",0), new SymbolPair("F",0)),1,3), new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("D",0), new SymbolPair("C",0), new SymbolPair("G",0), new SymbolPair("C",1)),0,3)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("C",1), new SymbolPair("F",2)),1,3), new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("C",1), new SymbolPair("G",0)),0,3)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("C",0), new SymbolPair("G",0), new SymbolPair("F",0)),1,3), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("C",0), new SymbolPair("G",0), new SymbolPair("C",0)),0,3)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("D",1), new SymbolPair("C",0), new SymbolPair("F",0)),1,3), new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("D",1), new SymbolPair("C",0), new SymbolPair("G",1)),0,3)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("C",2), new SymbolPair("F",3)),1,3), new LabeledSentence(List.of(new SymbolPair("A",3), new SymbolPair("C",2), new SymbolPair("G",0)),0,3)));
        
        // Rule 4
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("C",3), new SymbolPair("G",0), new SymbolPair("F",2)),1,4), new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("F",2), new SymbolPair("C",3), new SymbolPair("G",0)),0,4)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("D",0), new SymbolPair("C",0), new SymbolPair("G",1), new SymbolPair("F",3)),1,4), new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("D",0), new SymbolPair("F",3), new SymbolPair("C",0), new SymbolPair("G",1)),0,4)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("D",1), new SymbolPair("C",1), new SymbolPair("G",1), new SymbolPair("F",3)),1,4), new LabeledSentence(List.of(new SymbolPair("A",1), new SymbolPair("D",1), new SymbolPair("F",3), new SymbolPair("C",1), new SymbolPair("G",1)),0,4)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("D",0), new SymbolPair("C",3), new SymbolPair("F",3)),1,4), new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("D",0), new SymbolPair("F",3), new SymbolPair("C",3)),0,4)));
        testSentences1.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("C",0), new SymbolPair("F",1)),1,4), new LabeledSentence(List.of(new SymbolPair("A",0), new SymbolPair("F",1), new SymbolPair("C",0)),0,4)));
        testSentences2.add(List.of(new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("C",0), new SymbolPair("F",2)),1,4), new LabeledSentence(List.of(new SymbolPair("A",2), new SymbolPair("F",2), new SymbolPair("C",0)),0,4)));
        }
}
