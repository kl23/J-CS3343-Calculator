import java.util.Scanner;

import mathX.v1.Calculator;


public class Main {

	public static void main(String[] args)
	{
		
		Scanner sn = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		System.out.print("Math> ");
		String mathRaw = sn.nextLine();
		
		double d = calc.calculate(mathRaw);
		System.out.println(d);
		
	}
}
