import java.util.Scanner;
class Main {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the number of players: (between 2 and 7)");
    int players = Integer.parseInt(scan.nextLine());
		game test = new game(players);
		test.playGame();

	}

	
}