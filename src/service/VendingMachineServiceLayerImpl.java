package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import dao.VendingMachineDao;
import dao.VendingMachineDaoException;
import dto.VendingMachineItem;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
	
	VendingMachineDao dao;
	
	public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
		this.dao = dao;
	}
	
	public void removeItem(String name) throws VendingMachineDaoException{
	    dao.removeItem(name);
	}
	
	public List<VendingMachineItem> getItems() throws VendingMachineDaoException{
		return dao.getAllItems();
	}
	
	public List<VendingMachineItem> inStockItems() throws VendingMachineDaoException{
		List<VendingMachineItem> currentItems = dao.getAllItems();
		List<VendingMachineItem> filteredItems = currentItems.stream().filter((item) -> item.getQuantity() > 0).collect(Collectors.toList());
		return filteredItems;
	} 
	
	public boolean sufficientFunds(BigDecimal balance, String name) {
		return (dao.checkItemPrice(name).compareTo(balance) <= 0);
	}
	
	public BigDecimal checkItemPrice(String name) {
		return dao.checkItemPrice(name);
	}
}
	