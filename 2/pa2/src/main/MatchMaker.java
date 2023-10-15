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
	private Queue<Player>[] tiers;
	public MatchMaker(){
		// constructor
		tiers = new Queue[7]; //'이웃'한 티어를 구현하기 편하도록 array로 정의
		for (int i = 0; i<7;i++){
			tiers[i] = new Queue<>();
		}
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
		Tier playerTier = player.getTier();
		int tind = playerTier.ordinal();
		tiers[tind].enqueue(player);

		if(tiers[tind].getSize() >=6){ // 같은 티어에 6명 이상이 대기중일 경우
			Player[] warriors = new Player[6];

			for(int i = 0; i<6; i++) { //그 티어의 선착순 6명을 뽑아 매치인원(warriors)에 저장
				warriors[i] = tiers[tind].dequeue();
			}

			//이웃한 티어의 대기순서 비교,현재티어 = tind, 하위 티어 = tind - 1, 상위 티어 = tind + 1
			for (int i = -1; i <= 1; i +=2){
				if (tind + i < 0 || tind + i > 6){ //아이언, 다이아라 하위 혹은 상위 티어가 없는 경우는 생략
					continue;
				}

				if(!tiers[tind + i].isEmpty()){ //이웃 티어의 인원이 비어있지 않다면
					Player neighbor = tiers[tind + i].peek();


					if(neighbor.equals(warriors[5]) || neighbor.equals(warriors[4])){
						continue;
					}

					if(tiers[tind].getSize() < 6 || neighbor.getPlayerID() < warriors[5].getPlayerID()){
						warriors[5] = tiers[tind + i].dequeue();
					}
					else if (neighbor.getPlayerID() < warriors[4].getPlayerID()){
						warriors[4] = tiers[tind + i].dequeue();
					}
				}
			}
			return warriors;
		}



		return null;
	}
}
