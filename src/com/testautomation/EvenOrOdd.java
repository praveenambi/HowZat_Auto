package com.testautomation;

public class EvenOrOdd {

	static int a[]= {15,22,8,13,20,30};


	public static void main(String[] args) {

		for (int i = 0; i < a.length; i++) {

			if (a[i]%2==0 && a[i+1]%2 == 0) {

				System.out.println("the previous element "+ a[i] + "the next element"+  a[i+1] + " are even numbers");


			} else {

				System.out.println("the previous element "+ a[i] + "the next element"+  a[i+1] + " are odd numbers");

			}

		}


	}

}
