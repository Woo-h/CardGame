package com.min.player;

import java.util.Random;

import com.min.bjgame.BlackjackImpl;

public class Dealer extends BlackjackImpl {
	String[] Deck = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	String[] Shape = {"♥","◆","♣","♠"};
	String[] TwoCard = new String[4];
	String[] dck = new String[4];
	String[] shp = new String[4];
	int sum = 0;
	
	public String Deck() {
		String[] str = Deck;
		return str[(new Random()).nextInt(str.length)];
	}
	
	public String Shape() {
		String[] str = Shape;
		return str[(new Random()).nextInt(str.length)];
	}
	
	public void Shuffle() {
		for (int i = 0; i < 4; i++) {
			this.dck[i] = Deck();
		}
		for (int i = 0; i < 4; i++) {
			this.shp[i] = Shape();
		}
		for (int i = 0; i < 2; i++) {
			this.TwoCard[i] = this.shp[i] + this.dck[i];
		}
		System.out.println(this.TwoCard[0]+", Hidden card");
		
		for (int i = 0; i < 2; i++) {
			if(this.dck[i] != null){
				switch(this.dck[i]){
				case "1":
					sum += 1;
					break;
				case "2":
					sum += 2;
					break;
				case "3":
					sum += 3;
					break;	
				case "4":
					sum += 4;
					break;
				case "5":
					sum += 5;
					break;
				case "6":
					sum += 6;
					break;
				case "7":
					sum += 7;
					break;
				case "8":
					sum += 8;
					break;
				case "9":
					sum += 9;
					break;
				case "10":
					sum += 10;
					break;
				case "J":
					sum += 10;
					break;
				case "Q":
					sum += 10;
					break;
				case "K":
					sum += 10;
					break;
				case "A":
					sum += 11;
					break;
				}//switch

			}
//			System.out.println(i+":"+sum);
			
		}//for문
		System.out.println("카드를 오픈합니다.");
		System.out.println(this.TwoCard[0]+ this.TwoCard[1]);
		if(sum<17) {
			System.out.println("카드를 한장 더 뽑습니다.");
			this.TwoCard[2] = this.shp[2] + this.dck[2];
			System.out.println(this.TwoCard[2]);
			if(this.dck[2] != null){
				switch(this.dck[2]){
				case "1":
					sum += 1;
					break;
				case "2":
					sum += 2;
					break;
				case "3":
					sum += 3;
					break;	
				case "4":
					sum += 4;
					break;
				case "5":
					sum += 5;
					break;
				case "6":
					sum += 6;
					break;
				case "7":
					sum += 7;
					break;
				case "8":
					sum += 8;
					break;
				case "9":
					sum += 9;
					break;
				case "10":
					sum += 10;
					break;
				case "J":
					sum += 10;
					break;
				case "Q":
					sum += 10;
					break;
				case "K":
					sum += 10;
					break;
				case "A":
					sum += 11;
					break;
				}//switch

			}
			System.out.println("2:"+sum);
		}
		if (sum > 21) {
			System.out.println("버스트입니다.");
		}else if(sum>16&&sum<22) {
			System.out.println("stay!");
		}else {
			System.out.println("카드를 한장 더 뽑습니다.");
			this.TwoCard[3] = this.shp[3] + this.dck[3];
			System.out.println(this.TwoCard[3]);
			if(this.dck[3] != null){
				switch(this.dck[3]){
				case "1":
					sum += 1;
					break;
				case "2":
					sum += 2;
					break;
				case "3":
					sum += 3;
					break;	
				case "4":
					sum += 4;
					break;
				case "5":
					sum += 5;
					break;
				case "6":
					sum += 6;
					break;
				case "7":
					sum += 7;
					break;
				case "8":
					sum += 8;
					break;
				case "9":
					sum += 9;
					break;
				case "10":
					sum += 10;
					break;
				case "J":
					sum += 10;
					break;
				case "Q":
					sum += 10;
					break;
				case "K":
					sum += 10;
					break;
				case "A":
					sum += 11;
					break;
				}//switch
			}
		}	
	}
}
