import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.Math;

class HangMan {

    private List<String> wordsList;
    private String availableLetters;
    private String secretWord;
    private char[] lettersGussed;

    public HangMan() {
        for(int i=0; i<25; i++)
            availableLetters = availableLetters + (char)(97+i);
       
    }

    public List<String> loadWords(String fileName) {
        wordsList = new ArrayList<String>();
        //your code goes here


    File f = new File(fileName);
    
    // Scanner sc= new Scanner(f);
    // while(sc.hasNextLine()){
    //     System.out.println(sc.next());
    // }
  char c;
  String word="";
try {
      FileInputStream fis = new FileInputStream(f);
      char current;
      while (fis.available() > 0) {
        c = (char) fis.read();
        if(((int)c>=65 && (int)c<=90))
        {
            System.out.println(word);
            wordsList.add(word);
            word="";
        }
        word+=c;
        System.out.println(c);
        
        //System.out.print(current);
      }
      wordsList.add(word);
      wordsList.remove(0);
      for(int i=0;i<wordsList.size();i++)
      {
        System.out.println(wordsList.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }




        return wordsList;
    }

    public boolean isWordGuessed(String secretWord, char[] lettersGussed) {
        //String lg = new String(lettersGussed);
        //your code goes here
        String result = "";
        for (int i = 0; i < secretWord.length(); i++) {
        if(!result.contains(String.valueOf(secretWord.charAt(i)))) {
            result += String.valueOf(secretWord.charAt(i));
        }
    }
    //System.out.println("result="+result);

        int flag=0,count=0;
        for(int i=0;i<result.length();i++)
        {   flag=1;
          for(int j=0;j<lettersGussed.length;j++ )
          {
            if(result.charAt(i)==lettersGussed[j])
            {
                count++;
          }}
          //if (flag==0)
            //break;
        }
        if (count==result.length())
        return true;
        else
        return false;

    }

    public String getGuessedWord(String secretWord, char[] lg) {
        //your code goes here
        //System.out.println(secretWord);
    String new_string="";
    int isSpace=0,flag=0,p=0;
    for (int i=0;i<secretWord.length();i++)
    {
        flag=0;
        p=0;
        for (int j=0;j<lg.length;j++)
        {   
            
            if (secretWord.charAt(i)==lg[j])
            {
                

                p=1;
                //System.out.println(new_string.length());
                if (new_string.length()>0)
                {
                 if (new_string.charAt(new_string.length()-1)=='_')
                    {//System.out.println(new_string.charAt(new_string.length()-1));
                
                        //System.out.println("deepak");
                        new_string+=" ";
                            }
                }
                new_string+=lg[j];
                break;
            }
            else
                flag=1;
        }
        if (flag==1 && p==0)
                new_string+=" _";
    }

    if (new_string.charAt(new_string.length()-1)==' '||new_string.charAt(0)==' ')
    {
        
        String s="";
        for(int i=0;i<new_string.length();i++)
        {
            if(!(new_string.charAt(i)==' '&&(i==0||i==(new_string.length()-1))))
                {s+=new_string.charAt(i);}
        }
        return s;
    }
else
    return new_string;
}

    public String getAvailableLetters(char[] lg) {
        String availableLetters = "";

            String alphabets="abcdefghijklmnopqrstuvwxyz";
        //    String avail_letters="";

            for(int i=0;i<alphabets.length();i++)

            {   int flag=0;

            for(int j=0;j<lg.length;j++){
                if(alphabets.charAt(i)==lg[j])
                {
                    flag=1;
                    break;
                }
               }
               if (flag==0)
                 availableLetters+=alphabets.charAt(i);
               

            }


        //your code goes here
        return availableLetters;
    }
    public String chooseWord(List<String> wordsList )
    {
        
        String word=wordsList.get((int)Math.random()*wordsList.size());

        //your code goes here
        return word;
    }
    public void startHangMan(String secretWord)
    {
        //your code goes here

    int guess=8,flag;
    char[] lettersGuessed=new char[30];
    int size=0;
    String letter;
    Scanner sc=new Scanner(System.in);
    String alphabets,new_string;
    System.out.println("Length of the word to be guessed is "+secretWord.length());
    System.out.println("\n-----------------------------------------------");    
    while (guess>0)
    {
        System.out.println("\nYou have "+guess+" guesses left");
        alphabets=getAvailableLetters(lettersGuessed);
        System.out.println("\nAvailable letters : "+alphabets);
        System.out.println("\nGuess a letter : ");
        letter=sc.nextLine();
        
        if(Arrays.asList(lettersGuessed).contains(letter )) {

            
            System.out.println("You have aleady guessed this letter");
            new_string=getGuessedWord(secretWord,lettersGuessed);
            for (int i=0;i<new_string.length();i++)
                    System.out.print(new_string.charAt(i));
            }
        else
        {   
            flag=0;
            lettersGuessed[size++]=letter.charAt(0);
            for(int i=0;i<secretWord.length();i++)
            {
                if (letter.charAt(0)==secretWord.charAt(i))
                    {flag=1;
                        break;}
                
            }
            if (flag==1)//if letter in secretWord
            {   System.out.println("\nCorrect guess!");
                new_string=getGuessedWord(secretWord,lettersGuessed);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
            }
            else
                {
                System.out.println("Oops! Wrong guess.");
                guess-=1;
                new_string=getGuessedWord(secretWord,lettersGuessed);
                for (int j=0;j<new_string.length();j++)
                    System.out.print(new_string.charAt(j));
                }
        }
        if (isWordGuessed(secretWord,lettersGuessed))
        {
            System.out.println("\nCongratulations!You have won the game :) ");
            break;
        }
        System.out.println("----------------------------------------------");
        
    }
    if (guess<=0)
       { System.out.println("Sorry,you have lost the game :(");
        System.out.println("The word was :"+secretWord);
    }





    }
}

public class HangManGame {
    public static void main(String[] args) {
        HangMan hangMan = new HangMan();
        String secretWord = hangMan.chooseWord(hangMan.loadWords("words.txt")).toLowerCase();
        hangMan.startHangMan(secretWord);
        //you can call your function here 
        //foo.function_name(arg1, arg2, ...);
    }
}