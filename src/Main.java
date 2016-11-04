import java.util.Scanner;

import mathX.v3.Calculator;


public class Main {

	public static void main(String[] args)
	{
		
		Scanner sn = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		while (true)
		{
			System.out.print("Math> ");
			String mathRaw = sn.nextLine();
			
			if (mathRaw.equals("exit")) break;
			
			String d = calc.calculate(mathRaw);
			System.out.println(d);
		}
		
		System.out.println("bye.");
		
	}
}
