
import java.util.*;
import java.util.concurrent.*;

public class game {
	private ArrayList<crazyEightsHand> players;
	private Deck playDeck;
	private Card currentCard;
	
	//Creates a game, players must be between 2 and 10
	public game(int num) {
		playDeck = new Deck();
		playDeck.shuffle();
		//creates a list of hands, one for each player
		players = new ArrayList<crazyEightsHand>();
		//deals out cards to each player
		for(int i = 0; i < num; i++) {
			if(num == 2) {
				players.add( new crazyEightsHand(playDeck.deal(7)));
			}
			else {
				players.add( new crazyEightsHand(playDeck.deal(5)));
			}
			
		}
		//Chosses the first card
		currentCard = playDeck.deal();
		
	}
	
	//plays the game through a loop, iterating throufgh each hand
	public void playGame() {
		boolean gameOver = false;
		while (gameOver == false) {

			//allows each player to play. Iterating through the players
			//simulates turns
			for(int i = 0; i < players.size(); i++) {
				
				
				//adds new lines so that other players hands can't be viewed (3/29/2021)
        //waits a couple seconds to ensure prior turn can be read
        
        try{
          TimeUnit.SECONDS.sleep(2); 

        }
        catch(InterruptedException e){


        }
        //Ansi clear console escape code
        System.out.print("\033[H\033[2J");
        
				System.out.println("Player " + (i+1) + "'s turn ** \n\n");
				
				//updates the current card based on the players move
				currentCard = players.get(i).play(currentCard, playDeck);
				//Checks if that player has won, and displays
				if(players.get(i).win()) {
					gameOver = true;
					System.out.println("Player " + (i+1) + " wins.");
					break;
				}
			}
			
			
			
		}
	}
	
}
