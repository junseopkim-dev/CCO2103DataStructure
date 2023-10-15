import java.time.Duration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import testrunner.annotation.Score;

public class MatchMakerTests {
	@Test
	@Score(1)
	public void test1() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m1 = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			for(int i = 0; i < numPlayers; i++){
				if(i == 0 || i == 6) players[i] = new Player(Tier.GOLD);
				else if(i == 1) players[i] = new Player(Tier.IRON);
				else if(i == 3) players[i] = new Player(Tier.BRONZE);
				else players[i] = new Player(Tier.SILVER);
			}

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m1.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret1 = m1.newPlayer(players[numPlayers - 1]);
			assertThat(ret1.length, is(6));
			assertThat(ret1[0], is(players[0]));
			assertThat(ret1[1], is(players[2]));
			assertThat(ret1[2], is(players[4]));
			assertThat(ret1[3], is(players[5]));
			assertThat(ret1[4], is(players[7]));
			assertThat(ret1[5], is(players[8]));
		});
	}

	@Test
	@Score(1)
	public void test2() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m2 = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.SILVER);
			players[1] = new Player(Tier.IRON);
			players[2] = new Player(Tier.GOLD);
			players[3] = new Player(Tier.DIAMOND);
			players[4] = new Player(Tier.BRONZE);
			players[5] = new Player(Tier.BRONZE);
			players[6] = new Player(Tier.BRONZE);
			players[7] = new Player(Tier.BRONZE);
			players[8] = new Player(Tier.BRONZE);
			players[9] = new Player(Tier.BRONZE);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m2.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret2 = m2.newPlayer(players[numPlayers - 1]);
			assertThat(ret2.length, is(6));
			assertThat(ret2[0], is(players[0]));
			assertThat(ret2[1], is(players[1]));
			assertThat(ret2[2], is(players[4]));
			assertThat(ret2[3], is(players[5]));
			assertThat(ret2[4], is(players[6]));
			assertThat(ret2[5], is(players[7]));
		});
	}

	@Test
	@Score(1)
	public void test3() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m3 = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.BRONZE);
			players[1] = new Player(Tier.SILVER);
			players[2] = new Player(Tier.GOLD);
			players[3] = new Player(Tier.PLATINUM);
			players[4] = new Player(Tier.IRON);
			players[5] = new Player(Tier.IRON);
			players[6] = new Player(Tier.IRON);
			players[7] = new Player(Tier.IRON);
			players[8] = new Player(Tier.IRON);
			players[9] = new Player(Tier.IRON);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m3.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret3 = m3.newPlayer(players[numPlayers - 1]);
			assertThat(ret3.length, is(6));
			assertThat(ret3[0], is(players[0]));
			assertThat(ret3[1], is(players[4]));
			assertThat(ret3[2], is(players[5]));
			assertThat(ret3[3], is(players[6]));
			assertThat(ret3[4], is(players[7]));
			assertThat(ret3[5], is(players[8]));
		});
	}

	@Test
	@Score(1)
	public void test4() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m4 = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.GOLD);
			players[1] = new Player(Tier.SILVER);
			players[2] = new Player(Tier.GOLD);
			players[3] = new Player(Tier.DIAMOND);
			players[4] = new Player(Tier.IRON);
			players[5] = new Player(Tier.IRON);
			players[6] = new Player(Tier.IRON);
			players[7] = new Player(Tier.IRON);
			players[8] = new Player(Tier.IRON);
			players[9] = new Player(Tier.IRON);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m4.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret4 = m4.newPlayer(players[numPlayers - 1]);
			assertThat(ret4.length, is(6));
			assertThat(ret4[0], is(players[4]));
			assertThat(ret4[1], is(players[5]));
			assertThat(ret4[2], is(players[6]));
			assertThat(ret4[3], is(players[7]));
			assertThat(ret4[4], is(players[8]));
			assertThat(ret4[5], is(players[9]));
		});
	}

	@Test
	@Score(1)
	public void test5() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.BRONZE);
			players[1] = new Player(Tier.SILVER);
			players[2] = new Player(Tier.EMERALD);
			players[3] = new Player(Tier.BRONZE);
			players[4] = new Player(Tier.DIAMOND);
			players[5] = new Player(Tier.DIAMOND);
			players[6] = new Player(Tier.DIAMOND);
			players[7] = new Player(Tier.DIAMOND);
			players[8] = new Player(Tier.DIAMOND);
			players[9] = new Player(Tier.DIAMOND);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret = m.newPlayer(players[numPlayers - 1]);
			assertThat(ret.length, is(6));
			assertThat(ret[0], is(players[2]));
			assertThat(ret[1], is(players[4]));
			assertThat(ret[2], is(players[5]));
			assertThat(ret[3], is(players[6]));
			assertThat(ret[4], is(players[7]));
			assertThat(ret[5], is(players[8]));
		});
	}

	@Test
	@Score(1)
	public void test6() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.GOLD);
			players[1] = new Player(Tier.SILVER);
			players[2] = new Player(Tier.BRONZE);
			players[3] = new Player(Tier.GOLD);
			players[4] = new Player(Tier.DIAMOND);
			players[5] = new Player(Tier.DIAMOND);
			players[6] = new Player(Tier.DIAMOND);
			players[7] = new Player(Tier.DIAMOND);
			players[8] = new Player(Tier.DIAMOND);
			players[9] = new Player(Tier.DIAMOND);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret = m.newPlayer(players[numPlayers - 1]);
			assertThat(ret.length, is(6));
			assertThat(ret[0], is(players[4]));
			assertThat(ret[1], is(players[5]));
			assertThat(ret[2], is(players[6]));
			assertThat(ret[3], is(players[7]));
			assertThat(ret[4], is(players[8]));
			assertThat(ret[5], is(players[9]));
		});
	}


	@Test
	@Score(1)
	public void test7() {
		assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
			IMatchMaker m = new MatchMaker();
			int numPlayers = 10;
			Player[] players = new Player[numPlayers];
			players[0] = new Player(Tier.PLATINUM);
			players[1] = new Player(Tier.EMERALD);
			players[2] = new Player(Tier.DIAMOND);
			players[3] = new Player(Tier.SILVER);
			players[4] = new Player(Tier.GOLD);
			players[5] = new Player(Tier.DIAMOND);
			players[6] = new Player(Tier.DIAMOND);
			players[7] = new Player(Tier.DIAMOND);
			players[8] = new Player(Tier.DIAMOND);
			players[9] = new Player(Tier.DIAMOND);

			for(int i = 0; i < numPlayers - 1; i++){
				assertThat(m.newPlayer(players[i]), is(nullValue()));
			}
			Player[] ret = m.newPlayer(players[numPlayers - 1]);
			assertThat(ret.length, is(6));
			assertThat(ret[0], is(players[1]));
			assertThat(ret[1], is(players[2]));
			assertThat(ret[2], is(players[5]));
			assertThat(ret[3], is(players[6]));
			assertThat(ret[4], is(players[7]));
			assertThat(ret[5], is(players[8]));
		});
	}

}
