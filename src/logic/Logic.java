/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
/**
 *Program is created to be like the game Mastermind
 * User has to guess the randomized order of 5 colors
 * @author Natalya
 */
public class Logic {
	
public static char[] randcolours; //Array used to store random colours
public static char[] colours = {'R','O','Y','G','B','P' };// Array to store colours user can pick from
public static char[] guess;
public static ArrayList<String> alreadyProcessed = new ArrayList<String> () ;
public static int exactmatches; // Number of positions the user has correct
public static int halfmatches;//Number of colours correct but in wrong position
public static int chances = 7;
        
// Method used to generate random colours for "randcolours" 
        public static char[] generateColours(){
            String colour = ""; 
                    //takes colours from "colours" at random to place in "randcolours"
                    for(int i = 0; i<4; i++){
                        Random random = new Random();
                        int r = random.nextInt(6);
                        colour += Character.toString(colours[r]);                                                    
                    }
            randcolours = colour.toCharArray(); 
            return randcolours;
                    
        }//end of method generateColours()

//Method used to store String into char Array guess        
       public static char[] parseString(String userGuess){
            
            guess = userGuess.toCharArray();
            return guess;
        }//end of method parseString()
        
/*Method takes the users guess and compares which positions 
are the same as "randcolours return exact matches*/
        
       public static int checkExacts(char[] guess, char[] randcolours){ 
     
                    for (int i = 0; i < guess.length; i++){
                        if(guess[i] == randcolours[i]){
                        exactmatches++;
                    }
                }      
            return exactmatches;
        }//end of method checkExacts()
        
/*Method takes users guess and see how many colours they 
have correct but in the wrong positions*/
        public static int checkPartials(char[] guess, char[] randcolours) {
         
                for (char color : guess){
                     for (int j = 0; j < randcolours.length; j++){
                        String a = Character.toString(randcolours[j]);
                        
                        if(Collections.frequency(alreadyProcessed, ) > 2){
                        alreadyProcessed.add(a);
                        }
                        
                        if (color == randcolours[j] && Collections.frequency(alreadyProcessed, a) > 2 ){
                        halfmatches++;                              
                        }  
                    }
                }
            return halfmatches;
        }//end of method checkPartials()


public static void main (String args[]){
    generateColours();
    System.out.println(randcolours);
 
   // do {
    String userGuess = JOptionPane.showInputDialog("Please enter a string of colors ROYGBP");
    
    parseString(userGuess);
    System.out.println(guess);
   
    exactmatches = checkExacts(guess, randcolours);
    System.out.println(exactmatches);
    halfmatches = checkPartials(guess, randcolours);
    System.out.println(halfmatches);
    System.out.println(alreadyProcessed);
    /*JOptionPane.showMessageDialog(null, randcolours +  "You entered "+ userGuess + "\n"+
            "You have "+ exactmatches + " exact matches"+"\n"+
            "You have "+ halfmatches + " colours right but in the wrong positon");
    
    if(exactmatches == 4){ 
        JOptionPane.showMessageDialog(null, "Congratulations! You beat the game");
    }
    else { 
        chances -= 1;
    }
          
    }while (chances != 0);
}*/
}
