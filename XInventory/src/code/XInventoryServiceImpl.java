package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XInventoryServiceImpl implements XInventoryService {

	public static List<Item> inventoryItems = new ArrayList<Item>();
	public static float totalProfit = 0;

	@Override
	public void createItem(String itemName, float costPrice, float sellingPrice, int quantity, float currentProfit) {
		if (itemDoesNotExistInInventory(itemName)) {
			Item newInventoryItem = new Item(itemName, costPrice, sellingPrice, quantity, currentProfit);
			inventoryItems.add(newInventoryItem);
		}
	}

	private boolean itemDoesNotExistInInventory(String itemName) {
		for (Item item : inventoryItems) {
			if (item.getName().equals(itemName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void deleteItem(String itemName) {
		for (Item itemToDelete : inventoryItems) {
			if (itemToDelete.getName().equals(itemName)) {
				totalProfit -= itemToDelete.getQuantity() * itemToDelete.getCostPrice();
				inventoryItems.remove(itemToDelete);
				break;
			}
		}
	}

	@Override
	public void updateBuy(String itemName, int quantity) {
		for (Item itemToUpdate : inventoryItems) {
			if (itemToUpdate.getName().equals(itemName)) {
				itemToUpdate.setQuantity(quantity);
				break;
			}
		}
	}

	@Override
	public void updateSell(String itemName, int quantity) {
		for (Item itemToSell : inventoryItems) {
			if (itemToSell.getName().equals(itemName)) {
				totalProfit += (itemToSell.getSellingPrice() - itemToSell.getCostPrice()) * quantity;
				itemToSell.setQuantity(itemToSell.getQuantity() - quantity);
				break;
			}
		}
	}

	@Override
	public void generateReport() {
		System.out.println("                             INVENTORY REPORT                              ");
		System.out.println("Item Name   \t Bought At \t Sold At \t AvailableQty \t   Value");
		System.out.println("-------------------------------------------------------------------------- ");
		float totalValue = 0;
		String format = "%-18s%-15s%-20s%-15s%s%n";
		Collections.sort(inventoryItems);
		for (Item item : inventoryItems) {
			System.out.printf(format, item.getName(), item.getCostPrice(), item.getSellingPrice(), item.getQuantity(),
					item.getCostPrice() * item.getQuantity());
			totalValue += item.getCostPrice() * item.getQuantity();
		}
		System.out.println("-------------------------------------------------------------------------- ");
		System.out.println("Total Value 							   " + String.format("%.2f", totalValue));
		System.out.println("Profit since previous report 			   		   " + String.format("%.2f", totalProfit));
		totalProfit = 0;
	}

	@Override
	public void updateSellPrice(String itemName, float sellingPrice) {
		for (Item itemSellToUpdate : inventoryItems) {
			if (itemSellToUpdate.getName().equals(itemName)) {
				itemSellToUpdate.setSellingPrice(sellingPrice);
				break;
			}
		}
	}

}
