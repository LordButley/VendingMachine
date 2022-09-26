package ui;

import java.util.Scanner;

public class UserIOImpl implements UserIO {
	
	final private Scanner myScanner = new Scanner(System.in);
	
	@Override
	public void print(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

	@Override
	public String readString(String prompt) {
		// TODO Auto-generated method stub
		System.out.println(prompt);
        return myScanner.nextLine();
	}

	@Override
	public int readInt(String prompt, int max) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		int choice = 0;
		do {
			try {
				System.out.println(prompt);
				String nextLine = myScanner.nextLine();
				choice = Integer.parseInt(nextLine);
				if (choice > 0 && choice <= max) {
					isValid = true;
				}else {
					System.out.println("You did not enter a number between 1 and "+max);
				}
			}catch(NumberFormatException e) {
				System.out.println("You did not enter a number between 1 and "+max);
			}
		}while(!isValid);
		return choice;
	}

	@Override
	public int addMoney(String prompt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
