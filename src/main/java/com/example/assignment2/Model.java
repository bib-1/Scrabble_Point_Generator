package com.example.assignment2;

import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    //to store the previously entered numbers
    private ArrayList<String> previousWords = new ArrayList<>();

    //array to store the alphabets
    private String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //array to store the corresponding Scrabble
    private int[] alphaPoints = {9, 2, 2, 4, 12, 2, 3, 2, 8, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};

    private int[] eachPoints = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    //int to store the total point
    private int totalPoint = 0;
    //to store the previously entered numbers
    private ArrayList<String> wordsToGreyOut = new ArrayList<>();

    public ArrayList<String> getWordsToGreyOut(){
            return wordsToGreyOut;
            }

    public void checkWordToGreyOut(){
        for(int i = 0; i < 26; i++){
            if(alphaPoints[i] < 1) { //checking if the word has zero value
                String word = String.valueOf(alphabet.charAt(i));
                wordsToGreyOut.add(word); //added in the list of word to gray out
            }
        }
    }



    //calculate the total point
    public String calculateTotalPoint(String word){
        word = word.toUpperCase(); //to compare with caps letters
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            String s = String.valueOf(word.charAt(i)); //extracting each letter of the word
            int index = alphabet.indexOf(s);
            count += eachPoints[index]; //adding the points in the count
            alphaPoints[index]  = alphaPoints[index] - 1; //reducing the value after once used
        }
        System.out.println("Count of "+word+ " is " + count);
        totalPoint += count;
        checkWordToGreyOut(); //executing btn check function

        return String.valueOf(count);
    }

    //check if the total point of the word is countable
    public boolean isPointCountable (String word){
        word = word.toUpperCase();
        int[] alphaPointCopy = alphaPoints.clone();
        for(int i = 0; i < word.length(); i++){
            String s = String.valueOf(word.charAt(i)); //extracting each letter of the word
            int index = alphabet.indexOf(s); //finding the index of the word
            if(alphaPointCopy[index] == 0){ //checking if the word has zero value
                wordsToGreyOut.add(s); //added in the list of word to gray out
                System.out.println(alphaPointCopy[index]);
                return false;
            }
            alphaPointCopy[index] = alphaPointCopy[index] - 1;
        }
        return true;
    }

    public String getPreviousWords() {
        String words = "";

        if(previousWords.isEmpty()){
            return words;
        }
        for (String element : previousWords) {
            words += element + ", ";
        }
        return words.substring(0, words.length()-2);
    }

    public void setPreviousWords(String word){
        previousWords.add(word);
    }

    public int[] getAlphaPoints() {
        return alphaPoints;
    }

    public boolean wordContainsVowels(String word){
        word = word.toUpperCase();
        if(word.contains("A") || word.contains("E") || word.contains("I") || word.contains("O") || word.contains("U")){
            return true;
        }
        return false;
    }
    public String checkError(String word){
        //Word is blank
        if(word.length() == 0){
            return "Word is blank";
        }
        //Word is too short (only 1 character)
        if(word.length() < 2){
            return "Word is too short";
        }
        //Word does not include vowel
        if(wordContainsVowels(word) == false){
         return "Word doesn't contains vowels";
        }
        //Word is too long
        if(word.length() > 8){
            return "Word is too long";
        }
        //Word contains letter no longer available in bag
        if(previousWords.contains(word)){
            return "Words are already in the bag";
        }
        return "No error";

    }

    public boolean checkGameOver(){
        //check if all the vowels are over
        if(areAllVowelGone()){
            return true;
        }

        //check if every alphaPoints are not zero
       if(onlyLetterRemaining()){
           return true;
       }

        return false;
    }

    //only consonants remaining in bagHistory of Previous Words
    public boolean areAllVowelGone(){

        if(alphaPoints[0] == 0 && alphaPoints[4] == 0 && alphaPoints[8] == 0 && alphaPoints[14] == 0 && alphaPoints[20] == 0 ){
            return true;
        }
        return false;
    }

    //only one letter remaining in bag
    public boolean onlyLetterRemaining(){
        int nonZeroCount = 0;
        for (int i : alphaPoints) {
            if(i != 0){
                nonZeroCount++;
            }
        }
        if(nonZeroCount == 1){
            return true;
        }
        return false;
    }
    public String getTotalPoint(){
        return String.valueOf(totalPoint);
    }
}



