/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package edu.grinnell.psychMAP26.AGLV2;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *Used to load the symbols image files
 * 
 * @author fui
 */
public class SymbolLoader {
    
    //the different categories
    private BufferedImage[] categoryA;
    private BufferedImage[] categoryC;
    private BufferedImage[] categoryD;
    private BufferedImage[] categoryF;
    private BufferedImage[] categoryG;
    
    public SymbolLoader(String group) throws IOException {
        categoryA = loadCategory("A", 4, group);
        categoryC = loadCategory("C", 4, group);
        categoryD = loadCategory("D", 2, group);
        categoryF = loadCategory("F", 4, group);
        categoryG = loadCategory("G", 2, group);
    }
    
    //Takes in the category and the group (the folder where the images are) and loads them in to a list of buffered images
    private BufferedImage[] loadCategory(String category, int count, String group) throws IOException {
        BufferedImage[] images = new BufferedImage[count];
        for (int i = 0; i < count; i++) {
            String path = group + "/" + category + "_" + i + ".png";
            images[i] = ImageIO.read(new File(path));
        }
        return images;
    }

    //Gets a random symbol from the specified category
    public BufferedImage getRandomFromCategory(String category) {
        switch (category) {
            case "A": return getRandomFrom(categoryA);
            case "C": return getRandomFrom(categoryC);
            case "D": return getRandomFrom(categoryD);
            case "F": return getRandomFrom(categoryF);
            case "G": return getRandomFrom(categoryG);
            default: return null;
        }
    }
    
    //gets the symbol from the category corresponding to the index
    public BufferedImage getFromCategory(String category, int index) {
        switch (category) {
            case "A":
                return categoryA[index];
            case "C":
                return categoryC[index];
            case "D":
                return categoryD[index];
            case "F":
                return categoryF[index];
            case "G":
                return categoryG[index];
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }

    //helper for get random
    private BufferedImage getRandomFrom(BufferedImage[] category) {
        return category[(int)(Math.random() * category.length)];
    }
}

