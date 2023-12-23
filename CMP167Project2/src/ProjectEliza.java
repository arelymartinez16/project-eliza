import java.util.Scanner;

public class ProjectEliza {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		
		// Create a object for access to PromptBank methods
		PromptBank object = new PromptBank();
		
		// just like the calculator project, I created a boolean variable to help with the while loop.
		// the purpose would be to keep the conversation going
		boolean keepGoing = true;
		
		// this variable stores the choice if they want to run the session again
		String choice = "";
		
		// greet the user and ask them for their name
		System.out.println("Hello, my name is Eliza. What is your name?");
		
		// create a string variable that will store the name of the user
		String name = scnr.nextLine();
		
		String convo = "";
		
		// Prompt the user for input to start the therapy session
		System.out.println("Hello " + name + ". Tell me what is on your mind today in 1 sentence.");
		
		
		// collect the input
		convo = scnr.nextLine();
		
		// create a while loop around here
		while (keepGoing) {
			// call the populate methods first before checking the punctuation
			object.populateQuestionsArray();
			object.populateStatementsArray();
				
			// if convo ends with ?, prompt the user with a question
			if (convo.endsWith("?")) {
				// I called these methods to update the questions including the first and last word of the sentence
				String firWord = object.getFirstWord(convo);
				object.setFirstWord(firWord);
				String lastW = object.getLastWord(convo);
				object.setLastWord(lastW);
				object.updateQuestionsArray();
				System.out.println(object.getRandomQuestionTrunk());
			}
			// else if convo ends with !, first print "WOW! Dramatic!" and then call the getRandomStatementTrunk() method
			else if (convo.endsWith("!")) {
				// similar to the questions, I called these methods to update the statements with the first words and last words of the sentence
				String fiWord = object.getFirstWord(convo);
				object.setFirstWord(fiWord);
				String lWord = object.getLastWord(convo);
				object.setLastWord(lWord);
				object.updateStatementsArray();
				System.out.print("WOW! Dramatic! ");
				System.out.println(object.getRandomStatementTrunk());
			}
			// else just print the random statement
			else {
				// similar to the questions, I called these methods to update the statements with the first words and last words of the sentence
				String fWord = object.getFirstWord(convo);
				object.setFirstWord(fWord);
				String lastWord = object.getLastWord(convo);
				object.setLastWord(lastWord);
				object.updateStatementsArray();
				System.out.println(object.getRandomStatementTrunk());
			}
			// this will help keep the conversation going :3
			convo = scnr.nextLine();
				
			if (convo.equalsIgnoreCase("Exit")) {
				System.out.println("Do you want to run the session again?");
				choice = scnr.next();
					
				// fix this part so the random statement or question doesn't show at the same time as the following if statement
				if (choice.equalsIgnoreCase("yes")) {
					System.out.println("Hello " + name + ". Tell me what is on your mind today in 1 sentence.");
					// this statement will prevent the random statement or question from printing below the above print sttement right away
					scnr.nextLine();
					convo = scnr.nextLine();
				} 
				
				// this would end the program
				if (!choice.equalsIgnoreCase("Yes")) {
					System.out.println("Goodbye, until next time.");
					scnr.close();
					keepGoing = false;
					break;
				}
			}
				
		} // while loop
		
		
		
	} // main method

}
