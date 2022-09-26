package vendingmachineapp;

import controller.VendingMachineController;
import dao.VendingMachineAuditDao;
import dao.VendingMachineAuditDaoImpl;
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
	    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
		VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, auditDao);
		VendingMachineController controller = new VendingMachineController(service, view);
		controller.run();
	}

}
