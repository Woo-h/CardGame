package com.gard.game.card;

import java.util.ArrayList;
import java.util.List;

/**
 * 카드 한 댁을 만들어내는 클래스
 * @author BJ 특공대 (feat.전민균)
 *
 */
public class CardCase{
	
	private List<CardOne> cardcase;
	
	public List<CardOne> getCardcase() {
		return cardcase;
	}
	
	public CardCase() {
		cardcase = new ArrayList<CardOne>();
		make();
	}
	
	private void make() {
		int cnt =0; // 종료조건
		while (true) {
			CardOne num = new CardOne();
			if(!cardcase.contains(num)) {
				cardcase.add(num);
				cnt++;
			}
			if(cnt == CardOne.SHAPE.length*CardOne.NUMBER.length) {
				break;
			}
		}
	}
}
