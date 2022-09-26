package vendingmachineapp;

import controller.VendingMachineController;
import dao.VendingMachineDao;
import dao.VendingMachineDaoImpl;
import service.VendingMachineServiceLayer;
import service.VendingMachineServiceLayerImpl;
import ui.UserIO;
import ui.UserIOImpl;
import ui.VendingMachineView;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserIO io = new UserIOImpl();
		VendingMachineView view = new VendingMachineView(io);
		VendingMachineDao dao = new VendingMachineDaoImpl();
		VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);
		VendingMachineController controller = new VendingMachineController(service, view);
		controller.run();
	}

}
