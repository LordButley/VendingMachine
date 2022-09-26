package ui;

public interface UserIO {
	
	void print(String msg);
	
	String readString (String prompt);
		
	int addMoney(String prompt);

	int readInt(String prompt, int max);
}
