package com.miin.edu.rule;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GameRule {
	Scanner scan = new Scanner(System.in);
	public int total = 0;

	public void makeTotal() {
		bustRule();
		System.out.println("카드를 골라주세요");
		String choicecard = scan.next();
		System.out.println("당신이 고른 카드 : " + choicecard);
		String numpattern = "^[1-9]*$";
		String jqkpattern = "^[jqk]*$";
		String apattern = "[a]";
		String totalpattern = "^[1-9jqka]*$";
		while (choicecard.trim().equals("") || choicecard.trim().length() != 1 || !Pattern.matches(totalpattern, choicecard)) {
			System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요");
			choicecard = scan.next();
		}
		while(total < 22) {
			if(Pattern.matches(numpattern, choicecard)){
				total += Integer.parseInt(choicecard);
				System.out.println(total);
				makeTotal();
			} else if(Pattern.matches(jqkpattern, choicecard)) {
				total += 10;
				System.out.println(total);
				makeTotal();
			} else {
				if(total>11) {
					total += 1;
					System.out.println(total);
					makeTotal();
				} else if(total <= 10) {
					total += 11;
					System.out.println(total);
					makeTotal();
				}
			}
		}
	}

	public void bustRule() {
		if (total > 21) {
			System.out.println("21을 초과하였습니다. 패배");
		}
	}


}
