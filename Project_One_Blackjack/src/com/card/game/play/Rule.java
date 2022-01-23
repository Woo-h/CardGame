package com.card.game.play;

/**
 * 승패를 결정해주는 클래스
 * 
 * @author BJ 특공대
 *
 */
public class Rule {

	private int total;

	public Rule() {
	}

	public Rule(int total) {
		this.total = total;
	}

	public void Bust() {
		if (total > 21) {
			System.out.println();
		}
	}

	/**
	 * 승패를 판단하는 메소드
	 * 
	 * @param n 플레이어 점수
	 * @param m 딜러 점수
	 * @return result 승패결과
	 */
	public int Umpire(int n, int m) {
		System.out.println("==========================================");
		int pnum = n; // 플레이어
		int dnum = m; // 딜러
		int result = 0;
		if (pnum == 21 && dnum == 21) {
			System.out.println("♨♨모두 블랙잭 무승부 입니다♨♨");
		} else if (pnum == 21) {
			System.out.println(" ★☆★☆플레이어 블랙잭 플레이어 승리 !!★☆★☆");
			result = 2;
		} else if (dnum == 21) {
			System.out.println("♧♠♧♠ 딜러의 블랙잭 입니다 플레이어의 패배 ♧♠♧♠");
			result = 3;
		} else if (pnum > 21 || dnum > 21) {
			if (pnum > 21 && dnum < 22) {
				System.out.println("♧♠♧♠플레이어의 버스트. 딜러의 승리♧♠♧♠");
				result = 3;
			} else if (pnum < 22 && dnum > 21) {
				System.out.println("★☆★☆딜러의 버스트. 플레이어의 승리★☆★☆");
				result = 1;

			}
		} else if (pnum > dnum && pnum != dnum && pnum < 22) {
			System.out.println("★☆★☆플레이어의 승리★☆★☆");
			result = 1;
		} else if (pnum < dnum && pnum != dnum && dnum < 22) {
			System.out.println("♧♠♧♠딜러의 승리입니다 플레이어의 패배♧♠♧♠");
			result = 3;
		} else {
			System.out.println("♨♨무승부 입니다♨♨");
		}
		return result;
	}
}

/*
 * if(pnum > dnum) { System.out.println("플레이어의 승리!"); } else if(pnum < dnum) {
 * System.out.println("딜러의 승리!"); }else { System.out.println("무승부!"); }
 */
