package com.gard.game.card;

import java.util.List;
/**
 * 핸드에 있는 카드의 총합을 계산하는 클래스
 * @author BJ 특공대 
 *
 */
public class TotalCard{
	
	private List<String> choicecard;
	
	public TotalCard(List<String> choicecard) {
		this.choicecard = choicecard;
		totalCard();
	}

	/**
	 * 가지고 온 손패를 split으로 나누어 뒤의 숫자만으로 값을 계산하는 메소드
	 * @return total 값의 총합
	 */
	public int totalCard() {
		int total = 0;
		int acount = 0;
		int idx = 0;
		while (choicecard.size() != idx) {
			String card0 = choicecard.get(idx++).toString();
			String[] cardSplit = card0.split("");
			switch (cardSplit[1]) {
			case "A":
				acount += 1;
				break;
			case "2":
				total += 2;
				break;
			case "3":
				total += 3;
				break;
			case "4":
				total += 4;
				break;
			case "5":
				total += 5;
				break;
			case "6":
				total += 6;
				break;
			case "7":
				total += 7;
				break;
			case "8":
				total += 8;
				break;
			case "9":
				total += 9;
				break;
			case "1":
				total += 10;
				break;
			case "J":
				total += 10;
				break;
			case "Q":
				total += 10;
				break;
			case "K":
				total += 10;
				break;
			}
				if (total > 21) {
					break;
				}
			}

			for (int i = 0; i < acount; i++) {
				if (total > 10) {
					total += 1;
				} else {
					total += 11;
				}
			}
//			System.out.println("총합은 : " + total);
			return total;
	}

	
}
