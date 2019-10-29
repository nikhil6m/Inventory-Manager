package code;

interface XInventoryService {
	
	void createItem(String itemName, float costPrice, float sellingPrice, int quantity,float currentProfit);

	void deleteItem(String itemName);

	void updateBuy(String itemName, int quantity);

	void updateSell(String itemName, int quantity);

	void generateReport();

	void updateSellPrice(String string, float parseFloat);
}
