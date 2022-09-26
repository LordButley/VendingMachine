package service;

import java.math.BigDecimal;
import java.util.List;

import dao.VendingMachineDaoException;
import dto.VendingMachineItem;

public interface VendingMachineServiceLayer {

	void removeItem(String name) throws VendingMachineDaoException;
	
	List<VendingMachineItem> getItems() throws VendingMachineDaoException;

	List<VendingMachineItem> inStockItems() throws VendingMachineDaoException;

	boolean sufficientFunds(BigDecimal balance, String keyChoice);
	
	BigDecimal checkItemPrice(String name);

}
