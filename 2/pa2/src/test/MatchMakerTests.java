import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class MatchMakerTests {
	@Test
	@Score(1)
	public void test() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			for(int i = 0; i < numPlayers; i++){
				if(i == 0 || i == 6) players[i] = new Player(Tier.GOLD);
				else if(i == 1) players[i] = new Player(Tier.IRON);
				else if(i == 3) players[i] = new Player(Tier.BRONZE);
				else players[i] = new Player(Tier.SILVER);
			}

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret = m.newPlayer(players[numPlayers - 1]);
			assertThat(ret.length, is(6));
			assertThat(ret[0], is(players[0]));
			assertThat(ret[1], is(players[2]));
			assertThat(ret[2], is(players[4]));
			assertThat(ret[3], is(players[5]));
			assertThat(ret[4], is(players[7]));
			assertThat(ret[5], is(players[8]));
		});
	}
}
