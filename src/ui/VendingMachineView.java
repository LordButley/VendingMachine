package ui;

import java.math.BigDecimal;
import java.util.List;
import dto.VendingMachineItem;

public class VendingMachineView {
	
	private UserIO io;
	
	public VendingMachineView(UserIO io) {
		this.io = io;
	}
	
	public String printMenuAndGetSelection(List<VendingMachineItem> stock) {
        io.print("Main Menu");
        int i = 1;
        for(VendingMachineItem item:stock) {
        	io.print(i+" $"+item.getPrice()+"p - "+item.getName());
        	i++;
        }
        int choice = io.readInt("Please select from the above choices.", i-1);
        return stock.get(choice - 1).getName();
    }
	
	public void displayBuyItemBanner(String name) {
		io.print("Enjoy your "+name);
	}

	public void displayErrorMessage(String message) {
		// TODO Auto-generated method stub
		io.print("error");
	}

	public void displayExitBanner() {
		io.print("Goodbye");
	}
	
	public void displayBalance(BigDecimal balance) {
		io.print("$"+balance.toString());
	}
	
	public void insufficientBalance() {
		io.print("Sorry, you have insufficient balance. Please choose something else");
	}
	
	public String inputCoin() {
		BigDecimal funds = new BigDecimal("0");
		boolean keepAdding = true;
		while (keepAdding) {
			io.print("Balance: $"+funds);
			io.print("Add coins?");
		      io.print("1 - Penny");
		      io.print("2 - Nickel");
		      io.print("3 - Dime");
		      io.print("4 - Quarter");
		      io.print("5 - Done?");
		      int input = io.readInt("Please select a number from the above choices.", 5);
			switch (input) {
          		case 1:
          			io.print("Penny added");
          			io.print("");
          			funds = funds.add(new BigDecimal("0.01"));
          			break;
          		case 2:
          			io.print("Nickel added");
          			io.print("");
          			funds = funds.add(new BigDecimal("0.05"));
                  break;
          		case 3:
          			io.print("Dime added");
          			io.print("");
          			funds = funds.add(new BigDecimal("0.10"));
                  break;
          		case 4:
          			io.print("Quarter added");
          			io.print("");
          			funds = funds.add(new BigDecimal("0.25"));
                  break;
          		default:
          			if(funds.compareTo(new BigDecimal("0.5")) >= 0) {
                      	keepAdding = false;  	             

          			}else {
          				io.print("Add more money");
          			}
          			
          		}
		}

		return funds + "";
      
      
	}
	
	public void displayChange(BigDecimal balance) {
		io.print("Your change is: $"+balance.toString());
		BigDecimal quarterValue = new BigDecimal("0.25");
		int quarterNumber = 0;
		BigDecimal dimeValue = new BigDecimal("0.10");
		int dimeNumber = 0;
		BigDecimal nickelValue = new BigDecimal("0.05");
		int nickelNumber = 0;
		BigDecimal pennyValue = new BigDecimal("0.01");
		int pennyNumber = 0;
		
		while (balance.compareTo(quarterValue)>= 0){
			balance = balance.subtract(quarterValue);
			quarterNumber ++;
		}
		while (balance.compareTo(dimeValue)>= 0){
			balance = balance.subtract(dimeValue);
			dimeNumber ++;
		}
		while (balance.compareTo(nickelValue)>= 0){
			balance = balance.subtract(nickelValue);
			nickelNumber ++;
		}
		while (balance.compareTo(pennyValue)>= 0){
			balance = balance.subtract(pennyValue);
			pennyNumber ++;
		}
		
		io.print("Quarters: "+quarterNumber);
		io.print("Dimes: "+dimeNumber);
		io.print("Nickels: "+nickelNumber);
		io.print("Pennys: "+pennyNumber);

	}

}
