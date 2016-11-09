
import java.util.*;

import mathX.v3.Calculator;


public class Main {

	public static void main(String[] args)
	{
		
		Scanner sn = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		Map<String, ICommand> commandList = new HashMap<>();
		commandList.put("angle", new ICommand() {
			@Override
			public void execute(String... args) {
				calc.setAngleUnit(args[1]);
			}
		});
		commandList.put("base", new ICommand() {
			@Override
			public void execute(String... args) {
				calc.setBase(Integer.parseInt(args[1]));
			}
		});
		commandList.put("exit", new ICommand() {
			@Override
			public void execute(String... args) {
				System.out.println("bye.");
				System.exit(0);
			}
		});
		
				
		//-----------
		while (true)
		{
			System.out.print("Math> ");
			String cmdRaw = sn.nextLine();
			
			String[] cmdArgs = cmdRaw.split(" ");
			cmdArgs[0] = cmdArgs[0].toLowerCase();
			if (commandList.containsKey(cmdArgs[0])) {
				try
				{
					ICommand icmd = commandList.get(cmdArgs[0]);
					icmd.execute(cmdArgs);
				} catch (Exception ex) {
					System.err.println("Incorrect command");
				}
			} else {
				String d = calc.calculate(cmdRaw);
				System.out.println(d);	
			}
		}
	
	}
}

interface ICommand {
	void execute(String... args);
}
