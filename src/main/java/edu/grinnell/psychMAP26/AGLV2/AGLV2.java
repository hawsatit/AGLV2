/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package edu.grinnell.psychMAP26.AGLV2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;


/**
 *
 * @author fui
 * 
 * The Driver of the program
 */
public class AGLV2 {
    public static volatile boolean running = true;
    
    //to clear the console
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // Try ANSI first
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Then fall back to 'cls' if ANSI fails to clear
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-like systems
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Just print empty lines if nothing else works
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    
    // Helper to get a validated integer input (e.g., participant number, time)
    private static int getValidatedIntegerInput(Scanner scanner, String prompt) {
        int result;
        while (true) {
            clearConsole();
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            try {
                result = Integer.parseInt(input);
                if (result > 0) {
                    return result;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Helper to get a valid choice of 1 or 2 or allow quitting with 'q'
    private static int getValidatedChoiceInput(Scanner scanner, int questionNumber) {
        while (true) {
            clearConsole();
            System.out.println("Question " + questionNumber + ": Which sequence is more similar to sentences of the unknown language from the first part of the experiment?" + '\n' + 
                    "(Enter \"1\" for the first sequence or \"2\" for the second sentence, \nthen press enter to continue to the next question)");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) {
                running = false;
                System.out.println("Exiting...");
                return -1;
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
    }
    
    private static String selectImageBank(Scanner scanner) {
        String[] banks = {"img", "img2"};  // Add more if needed

        while (true) {
            clearConsole();
            System.out.println("Select the shape bank for this participant:\n");

            for (int i = 0; i < banks.length; i++) {
                System.out.println((i + 1) + ") " + banks[i]);
            }

            System.out.println("\nEnter a number (1-" + banks.length + ") or 'q' to quit:");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                running = false;
                System.out.println("Exiting...");
                return null;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= banks.length) {
                    return banks[choice - 1];
                }
            } catch (NumberFormatException ignored) {}

            System.out.println("Invalid selection. Press Enter to try again.");
            scanner.nextLine();
        }
    }
    
    private static int getValidatedDayInput(Scanner scanner) {
        while (true) {
            clearConsole();
            System.out.println("Select session day:");
            System.out.println("1) Day 1 (Learning + TestBank 1)");
            System.out.println("2) Day 2 (Skip Learning + TestBank 2)");
            System.out.println("\nEnter 1 or 2 (or 'q' to quit):");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) {
                running = false;
                return -1;
            }
            if (input.equals("1") || input.equals("2")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid input. Press Enter to try again.");
            scanner.nextLine();
        }
    }

    
    //main funtion does not take any initial command line arguements
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Scanner to read in user input from the command line
        Scanner scanner = new Scanner(System.in);
        
        int day = getValidatedDayInput(scanner);
        if (!running) return;
        
        //set the testGroup based on day
        int testGroup = (day == 1) ? 1 : 2;  // Day 1 -> bank1, Day 2 -> bank2
        boolean doLearning = (day == 1);
        

        // Participant setup
        int participantNumber = getValidatedIntegerInput(scanner, "Please enter participant number:");
        int timeOn = getValidatedIntegerInput(scanner, "Please enter the display speed (in milliseconds):");
        
        //get the image group
        String group = selectImageBank(scanner);
        if (!running) return;
        

        clearConsole();
        
        if (doLearning) {
            System.out.print("Welcome... you will be shown sequences...");
        } else {
            System.out.print("Welcome back. You will now complete the second part of the experiment...");
        }
        
        scanner.nextLine();
        clearConsole();
        
        System.out.println("Press Enter to begin...");
        scanner.nextLine(); // wait for Enter key
        
        //constants and panel setup
        int timeBetween = 100;
        int xStart = 675;
        int y = 200;



        SymbolLoader loader = new SymbolLoader(group);
        SymbolSentenceGenerator generator = new SymbolSentenceGenerator(loader, testGroup, doLearning);
        //doubles the sentences (50 * 2) of the same
        //generator.add(loader);
        
        int count = 0;
        if (doLearning){
            
            SymbolWindow window = new SymbolWindow();
            Graphics g = window.getDrawGraphics();
            window.bringToFront();
            //1 sec pause at the start
            Thread.sleep(1000);

            //whie the learning queue has information and q is not pressed
            while (generator.hasNextLearning() && running && count < 3) {
                count++;

                //if you want to exit press q
                if (System.in.available() > 0) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("q")) {
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    }
                }


                List<BufferedImage> sequence = generator.getNextLearning();
                window.clear();
                for (BufferedImage img : sequence) {
                    //scaling the stimuli
                    int newWidth = img.getWidth() / 2;
                    int newHeight = img.getHeight() / 2;
                    g.drawImage(img, xStart, y, newWidth, newHeight, null);
                    //time on each symbol
                    Thread.sleep(timeOn);
                    window.clear(); 
                    //time between symbols
                    Thread.sleep(timeBetween);
                }
                //time between sentences
                Thread.sleep(2000);
            }


                    //uses original algorythim to generate a new sentence everytime total of "count" sentences
            /*
            int counter = 0;
            while (running) {
                window.clear();  // Clear before new sentence
                List<BufferedImage> sentence = generator.generateSentence();
                counter++;

                for (BufferedImage img : sentence) {
                    window.clear();
                    int newWidth = img.getWidth() / 2;
                    int newHeight = img.getHeight() / 2;
                    g.drawImage(img, xStart, y, newWidth, newHeight, null);
                    Thread.sleep(timeOn);
                    window.clear(); 
                    Thread.sleep(timeBetween);
                }      
                Thread.sleep(2000); 

                if (counter == 90){
                    running = false;
                }
            }
            */

            //close panel after learning phase
            window.close();
        }
        
        clearConsole();
        //test phase
        if (day == 1){
         System.out.println("The sequences you just saw were in an unknown language." + '\n' 
                + "In the second part of the experiment, you will be presented with two new sequences, seperated by a pause in between. \n" + 
                "Then, you will be asked to choose which of the two sequences seems more similar to the unknown language from part 1.");   
        } else {
            System.out.println("You will complete the second part of the experiment again, where you will be presented with two new sequences, seperated by a pause in between. \n" + 
                "Then, you will be asked to choose which of the two sequences seems more similar to the unknown language from part 1.");
        }
        
        System.out.println("Please notify your experimenter to continue!");
        scanner.nextLine();
        clearConsole();
        System.out.println("Press Enter to begin the next task...");
        scanner.nextLine();
        
        //creates the output file which will be exported to the results folder
        new java.io.File("results").mkdirs(); // make sure folder exists

        FileWriter logWriter = new FileWriter(
            "results/participant_" + participantNumber + "_day" + day + ".csv"
        );
        //write the header which is the Participant number, speed, and the column lables
        logWriter.write("Participant," + participantNumber + "\n");
        logWriter.write("Day," + day + "\n");
        logWriter.write("TestBank," + testGroup + "\n");
        logWriter.write("Speed (ms)," + timeOn + "\n");
        logWriter.write("Question,Chosen,Correct,CorrectIndex,Violation\n");

        int questionNumber = 1;
        
        int count2 = 0;
        //whie the test queue has information and q is not pressed
        while (generator.hasNextTest() && running && count2 < 3) {
            
            count2++;
                        
            //retrieve the pair of list of LabeledSentence and list of sentences as images
            Pair<List<LabeledSentence>, List<List<BufferedImage>>> testPair = generator.getNextTestPair();
            //unpair into labledStentences and imagePairs (pair of sentences for the questions)
            List<LabeledSentence> labeledSentences = testPair.first;
            List<List<BufferedImage>> imagePairs = testPair.second;
            
            //check to make sured the the test pairs have 2 sentences (correct and incorrec)
            if (labeledSentences.size() < 2 || imagePairs.size() < 2) {
                clearConsole();
                System.out.println("Skipping incomplete test pair (less than 2 items).");
                continue;
            }
            
            SymbolWindow window = new SymbolWindow(); 
            Graphics g = window.getDrawGraphics();
            window.bringToFront();
                        
            //1sec pause at the start
            Thread.sleep(1000);
            
            // Show sequences
            for (int i = 0; i < 2; i++) {
                window.clear();
                List<BufferedImage> sequence = imagePairs.get(i);
                for (BufferedImage img : sequence) {
                    int newWidth = img.getWidth() / 2;
                    int newHeight = img.getHeight() / 2;
                    g.drawImage(img, xStart, y, newWidth, newHeight, null);
                    Thread.sleep(timeOn);
                    window.clear();
                    Thread.sleep(timeBetween);
                }
                Thread.sleep(2000);
            }
            
            window.close();

            // Ask for participant to choose 1 or 2            
            int choice = getValidatedChoiceInput(scanner, questionNumber);
            if (!running) break;

            //finds the indext of the correct answer
            int correctIndex = labeledSentences.get(0).isCorrect == 1 ? 1 : 2;
            //finds whether or not the sentence is correct
            int chosenIsCorrect = labeledSentences.get(choice - 1).isCorrect;
            //finds the violation of the sentence
            int violation = labeledSentences.get(choice - 1).violatedRule;
            
            //fill in the chart
            logWriter.write(questionNumber + "," + choice + "," + chosenIsCorrect +
                            "," + correctIndex + "," + violation + "\n");

            questionNumber++;
            Thread.sleep(1000);
        }
        
        //close the file editor
        logWriter.close();
        clearConsole();
        System.out.print("Thank you, you have completed the computer portion of the experiment.\n" +
"Please notify the experimenter!");
        scanner.nextLine();
        clearConsole();
        System.out.println("Test phase completed. Results saved to 'results/participant_" + participantNumber + "_day" + day + ".csv'");
        System.out.println("Learning Sentences: " + count + " " + "Test Questions: " + count2 + '\n');

        System.exit(0);
    }
}

