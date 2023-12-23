
public class PromptBank {
	// instance variables
	String[] questions;
	String[] statements;
	
	String firstWord;
	String lastWord;
	
	public PromptBank () {
		questions = new String[5]; // initialize your array to the correct length to match your number of questions you populate it with
		statements = new String[5]; // initialize your array to the correct length to match your number of statements you populate it with
	}
	
	// this sets the first word after the getter method extracts the first word of the string
	public void setFirstWord(String newWord) {
		this.firstWord = newWord;
	}
	
	// This works similar to firstWord 
	public void setLastWord(String newWord) {
		this.lastWord = newWord;
	}
		
	
	// these methods are made to update the statements and questions after the user writes their sentence to collect the first and last word of the sentence
	public void updateStatementsArray() {
		firstWord = getFirstWord();
		lastWord = getLastWord();
		statements[0] = "Tell me more about " + firstWord + " and " + lastWord;
		statements[1] = firstWord + " seems important to you, so does " + lastWord + ". Please tell me more.";
		statements[2] = firstWord + " and " + lastWord + " seem to be on your mind. Let's talk about it.";
		statements[3] = "I see. Let's explore " + firstWord +  " and " + lastWord + " a bit more.";
		statements[4] = "I am interested in " + firstWord + " and " + lastWord + ". Let's talk more about it.";
	}
	
	
	public void updateQuestionsArray() {
		firstWord = getFirstWord();
		lastWord = getLastWord();
		questions[0] = "Is there anything else about " + firstWord + " and " + lastWord + "?";
		questions[1] = "Does " + firstWord + " bother you? How about " + lastWord + "?";
		questions[2] = "Are " + firstWord +  " and " + lastWord + " things you often think about?";
		questions[3] = "Do you know anything regarding " + firstWord + " and " + lastWord + "?";
		questions[4] = "What is the relationship between " + firstWord + " and " + lastWord + "?";
	}

	public void populateStatementsArray() {
		statements[0] = "Tell me more about " + firstWord + " and BLANK2";
		statements[1] = firstWord + " seems important to you, so does BLANK2. Please tell me more.";
		statements[2] = firstWord + " and BLANK2 seem to be on your mind. Let's talk about it.";
		statements[3] = "I see. Let's explore " + firstWord +  " and BLANK2 a bit more.";
		statements[4] = "I am interested in " + firstWord + " and BLANK2. Let's talk more about it.";
	}
		
	public void populateQuestionsArray() {
		questions[0] = "Is there anything else about BLANK1 and BLANK2?";
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";
		questions[2] = "Are BLANK1 and BLANK2 things you often think about?";
		questions[3] = "Do you know anything regarding BLANK1 and BLANK2?";
		questions[4] = "What is the relationship between BLANK1 and BLANK2?";
	}
	
	
	public String getRandomStatementTrunk() {
		int randomIndex = (int) (Math.random() * statements.length);
		return statements[randomIndex];
		
		// fill in the method so it randomly selects the statement template
		// from the statements array ... hint use Math.random() to get the random index
		// so you can replace BLANK1 and BLANK2 with the appropriate words
	}
	
	public String getRandomQuestionTrunk() {
		// fill in the method so it randomly selects the question template
		// from the questions array ... hint use Math.random() to get the random index
		// so you can replace BLANK1 and BLANK2 with the appropriate words 
		int randomIndex = (int) (Math.random() * questions.length);
		return questions[randomIndex];
	}
	
	// this method and the getLastWord method w/o parameters was made to help with updating the questions and statements with the appropriate words
	public String getFirstWord() {
		return firstWord;
	}
	
	public String getFirstWord(String sentence) {
		
		String[] splitSentence = sentence.split(" ");
		
		if (splitSentence[0].endsWith("?") || splitSentence[0].endsWith("!") || splitSentence[0].endsWith(".") || splitSentence[0].endsWith(",")) {
			splitSentence[0] = splitSentence[0].replaceAll("\\p{Punct}", "");
		}
		
		firstWord = splitSentence[0];
		
		return firstWord;
	}
	
	public String getLastWord() {
		return lastWord;
	}
	
	// create another method to get the last word
	public String getLastWord(String sentence) {
		// check for punctuation in last word
		if (sentence.endsWith("?") || sentence.endsWith("!") || sentence.endsWith(".")) {
			// https://www.techiedelight.com/remove-punctuation-from-string-java/
			// "
			sentence = sentence.replaceAll("\\p{Punct}", "");
			// "
		} 
		
		String[] splitSentence = sentence.split(" ");
		
		// lastWord = splitSentence[sentence.length() - 1];
		lastWord = splitSentence[splitSentence.length - 1];
		return lastWord;
	
	}
	
}
