package com.min.edu.player;

import java.util.Arrays;
import java.util.Random;

import com.min.edu.BlackJackImpl;
import com.min.edu.IBlackJack;

public class Dealer implements IBlackJack {

//	public Dealer(int randomNum) {
//		super(randomNum);
//	}
	
	public String[] dealer_twocard;
	
	public String Shuffle(){
		String[] str = DACK; 
		return str[(new Random()).nextInt(str.length)];
	}
	
	public String[] getTwoCard() {
		String[] str = new String[5];
		for (int i = 0; i < 2; i++) {
			str[i] = Shuffle();
		}
		return str;
	}
	
	public void Card_hide() {
		String[] str = getTwoCard();
		this.dealer_twocard = str;
		if(str[1] != null) {
			System.out.print(str[0]);
			System.out.println(", hidden card");
		}
	}
	
	public void Card_open() {
		if(this.dealer_twocard != null) {
			System.out.println("카드를 오픈합니다.");
			System.out.print(this.dealer_twocard[0]);
			System.out.println("," + this.dealer_twocard[1]);
		}
		
		int sum = 0;
		String[] str = this.dealer_twocard;
		int[] cal = new int[2];
		for (int i = 0; i < 2; i++) {
			if(Character.isDigit(str[i].charAt(1))){
				cal[i] = Character.getNumericValue(str[i].charAt(1));;
				sum += cal[i];
			}else {
				switch(str[i].charAt(1)) {
				case 'K':
					sum += 10;
					break;
				case 'Q':
					sum += 10;
					break;
				case 'J':
					sum += 10;
					break;
				case'A':
					sum += 11;
					break;
				}	
			}// else

			System.out.println(i+"번째: " + sum);
		}//for
		
//		if(sum < 17) {
//			for (int i = 2; i < cal.length; i++) {
//				str[i] = Shuffle();
//				sum += Character.getNumericValue(str[i].charAt(2));
//			}
//		}
		System.out.println(sum);
	}
	
	
	
	

}
