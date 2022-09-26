package controller;

import java.math.BigDecimal;

import dao.VendingMachineDaoException;
import service.VendingMachineServiceLayer;
import ui.VendingMachineView;


public class VendingMachineController {
	
	
	private VendingMachineView view;
	private VendingMachineServiceLayer service;
	
	public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
		this.service = service;
		this.view = view;
	}
	
	public void run() {
		
		boolean keepGoing = true;
		BigDecimal balance = new BigDecimal(view.inputCoin());
		
		try {
			while(keepGoing) {
				view.displayBalance(balance);
				String keyChoice = getMenuSelection();
				if (service.sufficientFunds(balance, keyChoice)){
					removeItem(keyChoice);
					balance = balance.subtract(service.checkItemPrice(keyChoice));
					view.displayChange(balance);
					keepGoing = false;
				} else {
					view.insufficientBalance();
				}
	        }
	        exitMessage();
		}catch(VendingMachineDaoException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}
	
	private void removeItem(String name) throws VendingMachineDaoException {
		view.displayBuyItemBanner(name);
		service.removeItem(name);
	}
	
	private String getMenuSelection() throws VendingMachineDaoException {
        return view.printMenuAndGetSelection(service.getItems());
    }
	
	private void exitMessage() {
	    view.displayExitBanner();
	}
}

