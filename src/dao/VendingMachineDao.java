package dao;

import java.math.BigDecimal;
import java.util.List;

import dto.VendingMachineItem;

public interface VendingMachineDao {

	void removeItem(String name) throws VendingMachineDaoException;

	List<VendingMachineItem> getAllItems() throws VendingMachineDaoException;
	
	BigDecimal checkItemPrice(String name);

	
}
