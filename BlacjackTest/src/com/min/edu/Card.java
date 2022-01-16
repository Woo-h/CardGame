package com.min.edu;
/**
 * 카드들을 만드는 클래스
 * @author 이진희
 *
 */
public class Card {

	private Suit suit;
	private Value value;
	
	//카드 생성자
	public Card(Suit suit, Value value) {
		this.value = value;
		this.suit = suit;
	}
	// 나는 카드의 포맷이 suit-value 형식으로 print out 되길 원함
	public String toString() {
		return this.suit.toString() + "-" + this.value.toString();
	}
	// Deck 클래스에서 값을 체크하기 위해 사용할 것임
	// 핸드에서 카드의 실제 값을 확인하고 점수를 결정할 수 있게.
	public Value getValue() {
		return this.value;
	}
}
