package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;

import dto.VendingMachineItem;

public class VendingMachineDaoImpl implements VendingMachineDao {
	
	public static final String INVENTORY_FILE = "vendingmachine.txt";
	public static final String DELIMITER = "::";
	private Map<String, VendingMachineItem> items = new HashMap<>();
	
	@Override
	public void removeItem(String name) throws VendingMachineDaoException {
		// TODO Auto-generated method stub
		loadInventory();
		VendingMachineItem boughtItem = items.get(name);
		boughtItem.setQuantity(boughtItem.getQuantity()-1);
		items.put(name, boughtItem);
		writeInventory();
	}
	
	@Override
	public List<VendingMachineItem> getAllItems() throws VendingMachineDaoException{
		// TODO Auto-generated method stub
		loadInventory();
		return new ArrayList<VendingMachineItem>(items.values());
	}
	
	@Override
	public BigDecimal checkItemPrice(String name) {
		return items.get(name).getPrice();
	}
	
	private void loadInventory() throws VendingMachineDaoException {
	    Scanner scanner;

	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(INVENTORY_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new VendingMachineDaoException(
	                "-_- Could not load DVD data into memory.", e);
	    }
	    String currentLine;
	    VendingMachineItem currentItem;

	    while (scanner.hasNextLine()) {
	        currentLine = scanner.nextLine();
	        currentItem = unmarshallVendingMachine(currentLine);
	        items.put(currentItem.getName(), currentItem);
	    }
	    // close scanner
	    scanner.close();
	}
	
	private VendingMachineItem unmarshallVendingMachine(String itemAsText){

	    String[] itemTokens = itemAsText.split(DELIMITER);

	    String name = itemTokens[0];

	    VendingMachineItem itemFromFile = new VendingMachineItem(name);

	    itemFromFile.setPrice(new BigDecimal(itemTokens[1]));
	    itemFromFile.setQuantity(Integer.parseInt(itemTokens[2]));
	  
	    return itemFromFile;
	}
	

	private String marshallVendingMachine(VendingMachineItem itemToFile) {
		
		String itemAsText = itemToFile.getName() + DELIMITER;

		itemAsText += itemToFile.getPrice().toString() + DELIMITER;
			
		itemAsText += itemToFile.getQuantity();

	    return itemAsText;
		
	}
	
	private void writeInventory() throws VendingMachineDaoException {
	 
	    PrintWriter out;

	    try {
	        out = new PrintWriter(new FileWriter(INVENTORY_FILE));
	    } catch (IOException e) {
	        throw new VendingMachineDaoException(
	                "Could not save Inventory data.", e);
	    }
	    
	    String itemAsText;
	    List<VendingMachineItem> inventory = this.getAllItems();
	    for (VendingMachineItem item : inventory) {
	        itemAsText = marshallVendingMachine(item);
	        out.println(itemAsText);
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}



}


