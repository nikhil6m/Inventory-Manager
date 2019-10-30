package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import code.Item;
import code.XInventoryServiceImpl;

public class XInventoryServiceImplTest {

	private static XInventoryServiceImpl serviceCaller = null;

	static {
		serviceCaller = new XInventoryServiceImpl();
		serviceCaller.createItem("ITEM1", (float) 12.23, (float) 35.12, 0, 0);
		serviceCaller.createItem("ITEM2", (float) 2.35, (float) 43.42, 0, 0);
		serviceCaller.createItem("ITEM3", (float) 1.30, (float) 22.52, 0, 0);
	}

	// The unit test method to test createItem and deleteItem.
	@Test
	public void testCreateItemAndDeleteItem() {
		serviceCaller.createItem("ITEM_4_TEMP", (float) 45.73, (float) 21.62, 0, 0);
		serviceCaller.createItem("ITEM_5_TEMP", (float) 56.22, (float) 66.12, 0, 0);
		serviceCaller.createItem("ITEM_6_TEMP", (float) 21.23, (float) 35.42, 0, 0);
		assertEquals(6, XInventoryServiceImpl.inventoryItems.size());
		serviceCaller.deleteItem("ITEM_4_TEMP");
		serviceCaller.deleteItem("ITEM_5_TEMP");
		serviceCaller.deleteItem("ITEM_6_TEMP");
		assertEquals(3, XInventoryServiceImpl.inventoryItems.size());
	}

	// The unit test method to test updateSell and updateSellPrice.
	@Test
	public void testUpdateSellAndUpdateSellPriceItem() {
		serviceCaller.createItem("ITEM_TEMPORARY", (float) 12.23, (float) 25.12, 0, 0);
		serviceCaller.updateBuy("ITEM_TEMPORARY", 250);
		serviceCaller.updateSell("ITEM_TEMPORARY", 25);
		for (Item item : XInventoryServiceImpl.inventoryItems) {
			if (item.getName().equals("ITEM_TEMPORARY")) {
				assertEquals(225, item.getQuantity());
				break;
			}
		}
		serviceCaller.updateSellPrice("ITEM_TEMPORARY", 25);
		for (Item item : XInventoryServiceImpl.inventoryItems) {
			if (item.getName().equals("ITEM_TEMPORARY")) {
				assertEquals(25.0, item.getSellingPrice(), 0);
				serviceCaller.deleteItem("ITEM_TEMPORARY");
				break;
			}
		}
		assertEquals(-2429.50, XInventoryServiceImpl.totalProfit, 0);
	}

}
