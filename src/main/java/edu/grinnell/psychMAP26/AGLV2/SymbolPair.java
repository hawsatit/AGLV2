package edu.grinnell.psychMAP26.AGLV2;

/**
 * A structure to hold symbol category and index.
 * 
 */
public class SymbolPair {
    public final String category;
    public final int index;

    public SymbolPair(String category, int index) {
        this.category = category;
        this.index = index;
    }

    @Override
    public String toString() {
        return category + "_" + index;
    }
}