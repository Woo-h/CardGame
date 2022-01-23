package com.card.game.play;

import java.util.Scanner;

import com.card.game.user.Dealer;
import com.card.game.user.Player;
import com.gard.game.card.CardCase;
/**
 * 게임을 실행시켜주는 클래스
 * @author BJ특공대
 *
 */
public class GamePlay {

	private Dealer givedealer;
	private Player player;
	private CardCase cardcase;
	private Rule rul;

	private double playerMoney = 100;
	Scanner scan = new Scanner(System.in);
	int playerBet = 0;
	
	/**
	 * 제일 처음 실행되는 메소드 (기본 생성자)
	 */
	public GamePlay() {
		cardcase = new CardCase();
		player = new Player(cardcase.getCardcase());
		playGame();
	}

	/**
	 * 보유금액이 0이 될때까지 반복하는 게임 실행메소드
	 */
	public void playGame() {

		System.out.println("블랙잭에 오신걸 환영합니다!");
		// 배팅
		while (playerMoney > playerBet || playerMoney > 0 ) {

			while (true) { // 배팅 알맞게 입력할 때까지 반복!
				System.out.println("현재 보유금액 : $" + playerMoney + "\n얼마를 배팅하시겠습니까?");
				this.playerBet = scan.nextInt();
				if (playerBet > playerMoney) {
					System.out.println("보유 금액보다 많은 금액을 배팅할 수 없습니다. 다시 배팅해주세요.");
				} else {
					System.out.printf("배팅 금액 : $%d, 게임을 시작합니다!\n", playerBet);
					System.out.println("--------------------------------------------");
					break;
				}
			}

			player.givePlayer(); // 얘가 두개짜리
			player.Player_sum();

			// 딜러 오픈
			givedealer = new Dealer(player.getCardcase());
			givedealer.giveDealer();

			// 플레이어 HIT OR STAY
			int psum = player.PlayerHitStay();

			int dsum = givedealer.dealer_total();
			rul = new Rule();
			switch (rul.Umpire(psum, dsum)) {
			case 1: // 플레이어 승리
				playerMoney += playerBet;
				break;
			case 2: // 플레이어 블랙잭으로 승리
				playerMoney += playerBet * 1.5;
				break;
			case 3: // 딜러 승리
				playerMoney -= playerBet;
				break;

			default: // 무승부
				break;
			}
		
			// 플레이어와 딜러의 손패를 초기화
			player.Clean();
			givedealer.Clean();

			
		} 
		System.out.println("보유금액 : 0원. 파산하였습니다. 안녕히 가세요~");
		

	}
}