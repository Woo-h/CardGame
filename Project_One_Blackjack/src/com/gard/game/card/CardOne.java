package com.gard.game.card;

/**
 * 모양과 숫자를 조합(concate)하여 카드 한장을 만들어냄
 * @author BJ 특공대 (feat.전민균)
 *
 */
public class CardOne{
	
	public static final String[] SHAPE = {"♥", "◆", "♠", "♣"};
	public static final String[] NUMBER = { "A",  "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
	private String one;
	
	
	public CardOne() {
		int a = (int)(Math.random()*SHAPE.length);
		int b = (int)(Math.random()*NUMBER.length);
		one = SHAPE[a]+ NUMBER[b];
	}

	public String getOne() {
		return one;
	}

	@Override
	public String toString() {
		return one;
	}

	@Override
	public int hashCode() {
		
		return one.hashCode()+137;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isc = false;
		CardOne other = (CardOne)obj;
		if(one.equals(other.getOne())) {
			isc = true;
		}
		
		return isc;
	}
}
