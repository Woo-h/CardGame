package com.card.game.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.gard.game.card.CardOne;
import com.gard.game.card.TotalCard;

public class Player {

	private int sum = 0;
	private List<CardOne> cardcase;
	private List<String> player = new ArrayList<String>();

	/**
	 * @param 생성자를 통해서 모든 카드 케이스를 받아온다
	 */
	public Player(List<CardOne> cardcase) {
		this.cardcase = cardcase;
	}

	/**
	 * @param get을 통해 Cardcase값을 가져오는 메소드를 만들었다
	 */
	public List<CardOne> getCardcase() {
		return cardcase;
	}

	/**
	 * 카드케이스에서 받은 값을 플레이어에게 추가해준다
	 * 
	 * @return 추가된 값을 가진 플레이어
	 */
	public List<String> givePlayer() {
		this.player.add(cardcase.get(0).toString());
		cardcase.remove(0);
		return player;
	}

	/**
	 * giveplayer의 값을 totalCard를 넣어준다
	 * 
	 * @return 플레이어의 총합
	 */

	public int Player_sum() {
		sum = new TotalCard(givePlayer()).totalCard();
		System.out.println("플레이어의 카드 : " + this.player);
		System.out.println("플레이어의 총합 : " + sum);
		return sum;
	}

	/**
	 * PlayerHitStay 를 판단하는 메소드
	 * 
	 * @return 새로운 카드를 오픈한 플레이어의 총합
	 */
	public int PlayerHitStay() {

		while (this.sum < 21) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------");

			System.out.println("HIT 하시겠습니까? STAY 하시겠습니까? 0=HIT || 1=STAY");

			String result = sc.next();
			String pattern = "^[0-1]*$";
			while (!Pattern.matches(pattern, result)) {
				System.out.println("다시 입력해 주세요");
				result = sc.next();
			}
			if (result.compareTo("0") == 0) {
				System.out.println("플레이어가 HIT를 선택했습니다.");
				System.out.println("새로운 카드 오픈.");
				givePlayer();
				System.out.println(player);
				this.sum = new TotalCard(this.player).totalCard();
				System.out.println("플레이어의 합 : " + sum);
				if (sum > 21) {
					System.out.println("플레이어의 버스트!");
					break;
				}
			} else if (result.compareTo("1") == 0) {
				System.out.println("플레이어가 STAY를 선택했습니다.");
				break;
			}
		}
		System.out.println("-------------------------------------------");
		return sum;

	}
	/**
	 * 플레이어의 손패를 초기화 시켜주는 메소드
	 */
	public void Clean() {
		int idx = 0;
		while (player.size() != 0) {
			player.remove(idx);
		}
//		System.out.println(player);
	}
}
