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
	public int readInt(String prompt) {
		// TODO Auto-generated method stub
		int choice = 0;
		System.out.println(prompt);
		String nextLine = myScanner.nextLine();
		choice = Integer.parseInt(nextLine);
		return choice;
	}

}
