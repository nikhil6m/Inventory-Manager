package code;

public class Item implements Comparable<Item>{
	private String name;
	private float costPrice;
	private float sellingPrice;
	private int quantity;

	public Item(String name, float costPrice, float sellingPrice,int quantity,float currentProfit) {
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Item o) {
		return this.getName().compareTo(o.getName());
	}
}
