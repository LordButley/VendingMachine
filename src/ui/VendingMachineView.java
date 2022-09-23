package ui;

public class VendingMachineView {
	
	UserIO io = new UserIOImpl();
	
	public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("£0.50p - KitKat");
        io.print("£0.60p - Boost");
        io.print("£0.80p - Coca-Cola");
        io.print("£1.00p - Lucazade Sport");
        io.print("£1.50p - Natural Bar");
        io.print("£2.00p - Salted Peanuts");
        io.print("Exit");

        return io.readInt("Please select from the above choices.");
    }
}
