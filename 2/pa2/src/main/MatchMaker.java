/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class MatchMaker implements IMatchMaker {
	public MatchMaker(){
		// constructor
	}

	@Override
	public Player[] newPlayer(Player player) {
		/*
		 * Input:
		 *	- Player player: Player object containing the tier information of a new player.
		 *
		 * Output:
		 *  - an array of 6 Player objects that meet the matchmaking criteria, if any.
		 *  - if none meets the criteria, returns null.
		 *  - the returned Player array should contain the Players exactly in the order of their arrival.
		 *  - refer to the assignment specification for the exact criteria.
		 * 
		 * Does:
		 *  - keeps track of the Players that are waiting for matchmaking and their order of arrival using the queue you implemented.
		 */
		return null;
	}
}
