package com.min.edu;

public class BlackJackImpl implements IBlackJack {

	protected int tmp;
	
	protected String[] shuffleDack = new String[DACK.length];
	
	public BlackJackImpl(int randomNum) {
		this.tmp = randomNum;
	}
	
	public String[] getShuffleDack() {
		String[] tmp = new String[DACK.length];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = DACK[this.tmp];
		}
		this.shuffleDack = tmp;
		return tmp;
	}
	
	@Override
	public String toString(){
		String s = "[";
		int n = DACK.length;
		for (int i = 0; i < n - 1; i++) {
			s += String.format("%s,", this.shuffleDack);
		}
		s += String.format("%s]", DACK[n - 1]);
		return s;
	}
	
}
