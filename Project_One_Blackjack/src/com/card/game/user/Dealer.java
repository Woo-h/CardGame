package com.card.game.user;

import java.util.ArrayList;
import java.util.List;

import com.gard.game.card.CardOne;
import com.gard.game.card.TotalCard;

public class Dealer {
	private List<CardOne> cardcase;
	private List<String> dealer = new ArrayList<String>();
	private int sum = 0;

	/**
	 * @param 플레이어가 쓰고 남은 카드를 받아온다
	 */
	public Dealer(List<CardOne> cardcase) {
		this.cardcase = cardcase;
	}

	/**
	 * 딜러의 카드를 하나만 프린트하는 메서드
	 * 
	 * @return 카드가 한 개만 add된 dealer를 반환
	 */
	public List<String> giveDealer() {
		this.dealer.add(cardcase.get(0).toString());
		cardcase.remove(0);
		System.out.println("딜러의 카드 : [" + dealer.get(0) + ", UnOpened Card]");
		return dealer;
	}

	/**
	 * 딜러가 추가로 카드를 한개 더 받고 딜러의 합을 보여주는 메서드
	 * 
	 * @return 카드가 두 개 add된 dealer를 반환
	 */
	public List<String> open_HiddenCard() {
		System.out.println("딜러의 남은 카드 오픈!");
		this.dealer.add(cardcase.get(0).toString());
		cardcase.remove(0);
		this.sum = new TotalCard(this.dealer).totalCard();
		System.out.println("딜러의 합 : " + sum);
		return this.dealer;
	}

	/**
	 * 17미만인 경우일때 딜러가 추가로 카드를 받는 메서드
	 * 
	 * @return 카드를 +1개된 dealer를 반환
	 */
	public List<String> moreCard() {
		this.dealer.add(cardcase.get(0).toString());
		cardcase.remove(0);
		System.out.println("딜러가 추가로 한장을 오픈했습니다." + dealer);
		return dealer;
	}

	/**
	 * 딜러의 합을 판단하는 메서드
	 * 
	 * @return 딜러의 총합
	 */
	public int dealer_total() {
		int temp = 0;
		while (sum < 17) {
			temp = new TotalCard(moreCard()).totalCard();
			if (temp > 16 && temp < 22) {
				System.out.println("딜러의 합 : " + temp);
				System.out.println("지금부터 모두 STAY");
				break;
			} else if (temp > 21) {
				System.out.println("딜러의 합 : " + temp);
				System.out.println("딜러의 버스트!");
				break;
			}
		}
		return temp;

	}

	public void Clean() {
		int idx = 0;
		while (dealer.size() != 0) {
			dealer.remove(idx);
		}
//		System.out.println(dealer);
	}
}