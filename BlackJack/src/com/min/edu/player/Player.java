//package com.min.edu.player;
//
//import com.min.edu.BlackJackImpl;
//
////"������ �� ��" ��� "�÷��̾�"�� "����"��	 �� ���� ī�带 �޽��ϴ�.
//
///**
// * �÷��̾� Ŭ����
// * 
// * @author rladn
// *
// */
//public class Player extends BlackJackImpl {
//
//	private String[] shuffle = new String[DACK.length];
//
//	public Player() {
//		this.shuffle = getShuffleDack();
//	}
//
//	public String[] getShuffleDack() {
//		String[] tmp = new String[DACK.length];
//		for (int i = 0; i < tmp.length; i++) {
////			if(isCheck()) {
//			tmp[i] = DACK[randomIndexNum()];
////			}
//		}
//		return tmp;
//	}
//
////	public void getShuffleDack() {
////		int idx = 0;
////		int n = DACK.length;
////		System.out.println("1");
////		while (idx != n) {
////			int ranNum = randomIndexNum();
////			String rval = DACK[ranNum];
////			if (!isCheck(rval)) {
////				this.shuffle[idx++] = DACK[ranNum];
////			}
////		}
////	}
//
//	public void play() {
//		System.out.println(toString());
//	}
//
//	public int randomIndexNum() {
//		int num = 0;
//		num = (int) (Math.random() * DACK.length);
//		return num;
//	}
//
//	public boolean isCheck(String n) {
//		boolean ics = false;
//		for (int i = 0; i < DACK.length; i++) {
//			if (DACK[i].compareTo(n) == 0) {
//				ics = true;
//				System.out.println(ics);
//				break;
//			}
//		}
//
//		return ics;
//	}
//
//	@Override
//	public String toString() {
//		System.out.println(shuffle[3]);
//		String s = "[";
//		int n = DACK.length;
//		for (int i = 0; i < n - 1; i++) {
//			s += String.format("%s,", shuffle[i]);
//		}
//		s += String.format("%s]", shuffle[n - 1]);
//		return s;
//	}
//
//}
