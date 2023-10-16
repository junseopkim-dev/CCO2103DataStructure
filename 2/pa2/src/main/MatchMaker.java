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
	private Queue<PlayerInfo>[] tiers;

	private int count;

	private class PlayerInfo { //들어오는 순서 order 저장하는 새로운 클래스 PlayerInfo
		Player player;
		int order;

		PlayerInfo(Player player, int order) {
			this.player = player;
			this.order = order;
		}
	}


	public MatchMaker(){
		// constructor
		tiers = new Queue[7]; //'이웃'한 티어를 구현하기 편하도록 array로 정의
		count = 0;

		for (int i = 0; i<7;i++){
			tiers[i] = new Queue<PlayerInfo>();
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

		PlayerInfo pi = new PlayerInfo(player,count);
		Tier playerTier = player.getTier();
		int tind = playerTier.ordinal(); //티어에 해당하는 index 숫자
		tiers[tind].enqueue(pi);
		count ++;

		if(tiers[tind].getSize() >=6){ //여섯이 오리라
			Player[] warriors = new Player[6];


			if(tind == 0){  //6명이 모인 티어가 아이언이라, 이웃한 하위 티어가 없는 경우
				if (tiers[tind + 1].getSize() > 0 && tiers[tind+1].peek().order < tiers[tind].peek().order){
					warriors[0] = tiers[tind+1].dequeue().player;
				}
				else{
					warriors[0] = tiers[tind].dequeue().player;
				}

				warriors[1] = tiers[tind].dequeue().player;
			}
			else if(tind == 6){ //6명이 모인 티어가 다이아라, 이웃한 상위 티어가 없는 경우
				if (tiers[tind - 1].getSize() > 0 && tiers[tind-1].peek().order < tiers[tind].peek().order){
					warriors[0] = tiers[tind-1].dequeue().player;
				}
				else{
					warriors[0] = tiers[tind].dequeue().player;
				}

				warriors[1] = tiers[tind].dequeue().player;
			}
			else{ //그 외 일반적인 상황
				if (tiers[tind + 1].getSize() > 0 &&tiers[tind - 1].getSize() > 0 &&tiers[tind+1].peek().order < tiers[tind].peek().order && tiers[tind+1].peek().order < tiers[tind-1].peek().order){
					warriors[0] = tiers[tind+1].dequeue().player;
					if(tiers[tind - 1].getSize() > 0 &&tiers[tind-1].peek().order < tiers[tind].peek().order){
						warriors[1] = tiers[tind-1].dequeue().player;
					}
					else{
						warriors[1] = tiers[tind].dequeue().player;
					}
				}
				else if (tiers[tind + 1].getSize() > 0 &&tiers[tind - 1].getSize() > 0 &&tiers[tind-1].peek().order < tiers[tind].peek().order && tiers[tind-1].peek().order < tiers[tind+1].peek().order){
					warriors[0] = tiers[tind-1].dequeue().player;
					if(tiers[tind + 1].getSize() > 0 &&tiers[tind+1].peek().order < tiers[tind].peek().order){
						warriors[1] = tiers[tind+1].dequeue().player;
					}
					else{
						warriors[1] = tiers[tind].dequeue().player;
					}
				}

				else{
					warriors[0] = tiers[tind].dequeue().player;
				}
			}

			warriors[2] = tiers[tind].dequeue().player;
			warriors[3] = tiers[tind].dequeue().player;
			warriors[4] = tiers[tind].dequeue().player;
			warriors[5] = tiers[tind].dequeue().player;

			return warriors;
		}
		return null;
		

	}
}