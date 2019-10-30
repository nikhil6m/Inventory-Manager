package code;

import java.util.Scanner;

public class InventoryController {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		while (inputReader.hasNextLine()) {
			String inventoryOperation = inputReader.nextLine();
			if (inventoryOperation.equals("#")) {
				break;
			}
			if (isValidOperation(inventoryOperation)) {
				String[] operation = inventoryOperation.split(" ", 4);
				XInventoryServiceImpl inventoryServiceImpl = new XInventoryServiceImpl();
				switch (operation[0]) {
					case "create":
						inventoryServiceImpl.createItem(operation[1], Float.parseFloat(operation[2]),
								Float.parseFloat(operation[3]),0,0);
						break;
					case "delete":
						inventoryServiceImpl.deleteItem(operation[1]);
						break;
					case "updateBuy":
						inventoryServiceImpl.updateBuy(operation[1], Integer.parseInt(operation[2]));
						break;
					case "updateSell":
						inventoryServiceImpl.updateSell(operation[1], Integer.parseInt(operation[2]));
						break;
					case "report":
						inventoryServiceImpl.generateReport();
						break;
					case "updateSellPrice":
						inventoryServiceImpl.updateSellPrice(operation[1], Float.parseFloat(operation[2]));
						break;
					default:
						System.out.println("Please check the input command");  // Can be replaced with loggers(slf4j or log4j) 
				}
			}
		}
		inputReader.close();
	}

	private static boolean isValidOperation(String inventoryOperation) {
		String[] inputValues = inventoryOperation.split(" ");
		boolean isCommandValid = false;
		if (0 < inputValues.length && inputValues.length < 5) {
			String arg1 = inputValues[0];
			if(arg1.equals("create") || arg1.equals("updateBuy") || arg1.equals("updateSellPrice") || arg1.equals("report")
					|| arg1.equals("updateSell") || arg1.equals("delete")) {
				isCommandValid = true;
			}
			// Assumption : The rest of input string is entered in the respective data types(Number).
		}
		return isCommandValid;
	}
}
