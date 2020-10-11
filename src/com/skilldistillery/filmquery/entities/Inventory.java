package com.skilldistillery.filmquery.entities;

public class Inventory {

	private String itemName;
	private Integer inventoryId;
	private String itemCondition;
	
	public Inventory() {}
	
	public Inventory(String itemName, Integer inventoryId, String itemCondition) {
		super();
		this.itemName = itemName;
		this.inventoryId = inventoryId;
		this.itemCondition = itemCondition;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
		result = prime * result + ((itemCondition == null) ? 0 : itemCondition.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (inventoryId == null) {
			if (other.inventoryId != null)
				return false;
		} else if (!inventoryId.equals(other.inventoryId))
			return false;
		if (itemCondition == null) {
			if (other.itemCondition != null)
				return false;
		} else if (!itemCondition.equals(other.itemCondition))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item: " + itemName + " Inventory Id #: " + inventoryId + ", Condition: " + itemCondition;
	}
	
	
	
}
