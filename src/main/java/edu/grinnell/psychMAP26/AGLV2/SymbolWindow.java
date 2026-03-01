package edu.grinnell.psychMAP26.AGLV2;

import javax.swing.*;
import java.awt.*;

/**
 * A custom window for displaying symbols in the AGL Speed Reader experiment.
 */
public class SymbolWindow extends JFrame {

    private final JPanel panel;       // Main drawing panel
    private final Graphics graphics;  // Graphics context for drawing symbols

    /**
     * Constructs the symbol display window with specified dimensions.
     *
     * @param width Width of the window in pixels
     * @param height Height of the window in pixels
     */
    public SymbolWindow() {
        this.setTitle("AGL Speed Reader");
        this.setUndecorated(true); // Remove window borders
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent accidental closure

        // Create a panel with custom painting logic
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight()); // Clear panel with white
            }
        };
        panel.setBackground(Color.WHITE);

        this.setContentPane(panel);

        // Set fullscreen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(this);

        // Bring to front
        this.setAlwaysOnTop(true);
        this.toFront();
        this.requestFocus();
        this.setAlwaysOnTop(false);

        graphics = panel.getGraphics();
    }

    /**
     * Returns the Graphics object for drawing onto the panel.
     *
     * @return Graphics context
     */
    public Graphics getDrawGraphics() {
        return graphics;
    }

    /**
     * Clears the panel by wiping it with the background color.
     */
    public void clear() {
        graphics.clearRect(0, 0, panel.getWidth(), panel.getHeight());
    }

    /**
     * Brings the window to the front of the screen and refreshes focus.
     */
    public void bringToFront() {
        this.setAlwaysOnTop(true);
        this.toFront();
        this.repaint();
        this.requestFocus();
        this.setAlwaysOnTop(false);
    }

    /**
     * Closes and disposes of the window.
     */
    public void close() {
        this.dispose();
    }
}