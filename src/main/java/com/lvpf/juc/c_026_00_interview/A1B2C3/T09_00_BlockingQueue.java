package com.lvpf.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T09_00_BlockingQueue {


	static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
	static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

	public static void main(String[] args) throws Exception{
		char[] aI = "1234567".toCharArray();
		char[] aC = "ABCDEFG".toCharArray();

		new Thread(() -> {

			for(char c : aI){
				System.out.println(c);
				try{
					q1.put("ok");
					q1.take();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		},"t1").start();

		new Thread(() -> {

			for(char c : aC){
				try{
					 q1.take();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(c);
				try{
					q2.put("ok");
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		},"t2").start();
	}
}