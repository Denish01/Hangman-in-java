################# A WORDGAME: HANGMAN ####################

Note: Do not be intimidated by this problem! It's actually easier than it looks. We will 'scaffold' this problem into Java and C++ files defining necessary functions.

For this problem, you will implement a variation of the classic wordgame Hangman. For those of you who are unfamiliar with the rules, you may read all about it here. 
https://en.wikipedia.org/wiki/Hangman_(game). 
In this problem, the second player will always be the computer, who will be picking a word at random.

In this problem, you will implement a class, called HangMan, that will start up and carry out an interactive Hangman game between a player and the computer. 

For this problem, you will need the code files HangManGame.java, HangManGame.cpp and words.txt which are already created for you. 
Please download the files from 
http://testprep2016.msitprogram.net/exam_setup_guide

####Problem Description:
The computer must select a word at random from the list of available words that was provided in words.txt. 
The functions for loading the word list and selecting a random word have already been provided for you.
The game must be interactive; the flow of the game should go as follows:

At the start of the game, let the user know how many letters the computer's word contains.
Ask the user to supply one guess (i.e. letter) per round.
The user should receive feedback immediately after each guess about whether their guess appears in the computer's word.
After each round, you should also display to the user the partially guessed word so far, as well as letters that the user has not yet guessed.
Some additional rules of the game:
A user is allowed 8 guesses. Make sure to remind the user of how many guesses s/he has left after each round. Assume that players will only ever submit one character at a time (A-Z).
A user loses a guess only when s/he guesses incorrectly.
If the user guesses the same letter twice, do not take away a guess - instead, print a message letting them know they've already guessed that letter and ask them to try again.
The game should end when the user constructs the full word or runs out of guesses. If the player runs out of guesses (s/he "loses"), reveal the word to the user when the game ends.

####List of Functions:
loadWords():
	Implement the function loadWords that takes a filename as an argument and returns a list of words in an List<String>.
isWordGuessed():
	Implement the function isWordGuessed that takes in two parameters - a string, secretWord, and a list of letters, lettersGuessed. 
	This function returns a boolean - True if secretWord has been guessed (ie, all the letters of secretWord are in lettersGuessed) and False otherwise.
	Example:
		>>> secretWord = 'apple' 
		>>> lettersGuessed = ['e', 'i', 'k', 'p', 'r', 's']
		>>> print isWordGuessed(secretWord, lettersGuessed)
		False
getGuessedWord():
	Implement the function getGuessedWord that takes in two parameters - a string, secretWord, and a list of letters, lettersGuessed. 
	This function returns a string that is comprised of letters and underscores, based on what letters in lettersGuessed are in secretWord. 
	This shouldn't be too different from isWordGuessed!
	When inserting underscores into your string, it's a good idea to add at least a space after each one, so it's clear to the user how many unguessed letters are left in the string 
	(compare the readability of ____ with _ _ _ _ ). 
	Example: 
		>>> secretWord = 'apple' 
		>>> lettersGuessed = ['e', 'i', 'k', 'p', 'r', 's']
		>>> print getGuessedWord(secretWord, lettersGuessed)
		'_ pp_ e'
getAvailableLetters():
	Implement the function getAvailableLetters that takes in one parameter - a list of letters, lettersGuessed. 
	This function returns a string that is comprised of lowercase English letters - all lowercase English letters that are not in lettersGuessed.
	Example:
		>>> lettersGuessed = ['e', 'i', 'k', 'p', 'r', 's']
		>>> print getAvailableLetters(lettersGuessed)
		abcdfghjlmnoqtuvwxyz
chooseWord():
        Implement the function to that takes in one parameter- a list of words. This function should return a random word from the words list.these random word will be the secret word for the game.
startHangMan():(This function is checked at the time of viva.it doesn't have the test cases)
	Now Implement the function hangman, which takes one parameter - the secretWord the user is to guess. 
	This starts up an interactive game of Hangman between the user and the computer. 
	Be sure you take advantage of the three helper functions, isWordGuessed, getGuessedWord, and getAvailableLetters, that you've defined in the previous part.
	There are four important pieces of information you may wish to store:
		secretWord: The word to guess.
		lettersGuessed: The letters that have been guessed so far.
		mistakesMade: The number of incorrect guesses made so far.
		availableLetters: The letters that may still be guessed. Every time a player guesses a letter, the guessed letter must be removed from availableLetters (and if they guess a letter that is not in availableLetters, you should print a message telling them they've already guessed that - so try again!).
You will want to do all of your coding for this problem within these java and c++ files because you will be writing a program that depends on each function you write.

####Sample Output
The output of a winning game should look like this...
	Welcome to the game, Hangman!
	I am thinking of a word that is 4 letters long.
	Loading word list from file...
	I am thinking of a word that is 4 letters long.
	-------------
	You have 8 guesses left.
	Available letters: abcdefghijklmnopqrstuvwxyz
	Please guess a letter: a
	Good guess: _ a_ _
	------------
	You have 8 guesses left.
	Available letters: bcdefghijklmnopqrstuvwxyz
	Please guess a letter: a
	Oops! You've already guessed that letter: _ a_ _
	------------
	You have 8 guesses left.
	Available letters: bcdefghijklmnopqrstuvwxyz
	Please guess a letter: s
	Oops! That letter is not in my word: _ a_ _
	------------
	You have 7 guesses left.
	Available letters: bcdefghijklmnopqrtuvwxyz
	Please guess a letter: t
	Good guess: ta_ t
	------------
	You have 7 guesses left.
	Available letters: bcdefghijklmnopqruvwxyz
	Please guess a letter: r
	Oops! That letter is not in my word: ta_ t
	------------
	You have 6 guesses left.
	Available letters: bcdefghijklmnopquvwxyz
	Please guess a letter: m
	Oops! That letter is not in my word: ta_ t
	------------
	You have 5 guesses left.
	Available letters: bcdefghijklnopquvwxyz
	Please guess a letter: c
	Good guess: tact
	------------
	Congratulations, you won!

####TESTCASES:
Input: loadWords(words.txt) 
Output: true

Input: isWordGuessed(apple,{'a','p','l','e'}) 
Output: true

Input: isWordGuessed(apple,{'a','p','l','i'}) 
Output: false

Input: isWordGuessed(mississippi,{'m','s','i','p'}) 
Output: true

Input: isWordGuessed(magneto,{'m','e','t','o','g','a','n'}) 
Output: true

Input: isWordGuessed(extrovert,{'e','t','r','x'}) 
Output: false

Input: getAvailableLetters({'a','p','l','i'}) 
Output: bcdefghjkmnoqrstuvwxyz

Input: getAvailableLetters({'a','b','x','z','y'}) 
Output: cdefghijklmnopqrstuvw

Input: getGuessedWord(inspire,{'i','p','r'}) 
Output: in _ pir _

Input: getGuessedWord(apple,{'a','p'}) 
Output: app _ _
 