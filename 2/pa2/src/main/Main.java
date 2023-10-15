import java.util.Scanner;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

// Main.java file is not for submission.
// It is here for you to give means of testing.
// You can use any packages in "this" file but be careful on the submission files.

public class Main {
	public static void main(String[] args) {
		// implement your main function here

		IMatchMaker m = new MatchMaker();

		int numPlayers = 10;
		Player[] players = new Player[numPlayers];
		for(int i = 0; i < numPlayers; i++){
			if(i == 0 || i == 6) players[i] = new Player(Tier.GOLD);
			else if(i == 1) players[i] = new Player(Tier.IRON);
			else if(i == 3) players[i] = new Player(Tier.BRONZE);
			else players[i] = new Player(Tier.SILVER);
		}

		for(int i = 0; i < numPlayers; i++){
			System.out.println(players[i]);
			System.out.println(players[i].getTier());
		}

		System.out.println("-----------------");


		for(int i = 0; i < numPlayers - 1; i++){
			m.newPlayer(players[i]);
		}
		Player[] ret = m.newPlayer(players[numPlayers - 1]);

		for(int i = 0; i < 6; i++){
			System.out.println(ret[i]);
		}
	}
}
