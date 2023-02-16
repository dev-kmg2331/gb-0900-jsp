package com.example.app;

public class Calc {
	
	public Calc() {}
	
	public int caculate(String s) throws ArithmeticException, IndexOutOfBoundsException, NumberFormatException {
		String[] arr = s.split("");
		String num1 = "", num2 = "", temp = "", equation = "";
		
		for (int i = 0; i < arr.length; i++) {
			if(!Character.isDigit(arr[i].charAt(0))){
				equation = arr[i];
				num1 = temp;
				temp = "";
				continue;
			}
			
			temp += arr[i];
		}
		
		num2 = temp;
		
		switch (equation) {
		case "+": {
			return add(Integer.parseInt(num1), Integer.parseInt(num2));
		}
		case "-": {
			return sub(Integer.parseInt(num1), Integer.parseInt(num2));
		}
		case "*": {
			return multi(Integer.parseInt(num1), Integer.parseInt(num2));
		}
		case "/": {
			return (int)divide(Integer.parseInt(num1), Integer.parseInt(num2));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + equation);
		}
	}
	
	private int add(int num1, int num2) {
		return num1 + num2;
	}
	private int sub(int num1, int num2) {
		return num1 - num2;
	}
	private int multi(int num1, int num2) {
		return num1 * num2;
	}
	private double divide(int num1, int num2) throws ArithmeticException {
		return (double)num1 / num2;
	}
	
}
