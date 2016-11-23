package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents an ItemGroup node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class ItemGroupNode {

	private String itemGroupOID;
	private String itemGroupRepKey;
	private List<ItemNode> items;

	//constructor
	public ItemGroupNode() {
		this.items = new ArrayList<>();
	}
	

	public String getItemGroupOID() {
		return itemGroupOID;
	}

	public void setItemGroupOID(String itemGroupOID) {
		this.itemGroupOID = itemGroupOID;
	}

	public String getItemGroupRepKey() {
		return itemGroupRepKey;
	}

	public void setItemGroupRepKey(String itemGroupRepKey) {
		this.itemGroupRepKey = itemGroupRepKey;
	}

	public List<ItemNode> getItems() {
		return items;
	}

	public void setItems(List<ItemNode> items) {
		this.items = items;
	}

	public void upsert(String itemOID, String itemValue ){
		ItemNode item = new ItemNode(itemOID, itemValue);
		
		//if this item already exists, overwrite the value
		if(this.items.contains(item)){
			this.items.get(this.items.indexOf(item)).setValue(itemValue);
		}
		//if this is a new item, insert it
		else{
			this.items.add(item);
		}
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemGroupOID == null) ? 0 : itemGroupOID.hashCode());
		result = prime * result
				+ ((itemGroupRepKey == null) ? 0 : itemGroupRepKey.hashCode());
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
		ItemGroupNode other = (ItemGroupNode) obj;
		if (itemGroupOID == null) {
			if (other.itemGroupOID != null)
				return false;
		} else if (!itemGroupOID.equals(other.itemGroupOID))
			return false;
		if (itemGroupRepKey == null) {
			if (other.itemGroupRepKey != null)
				return false;
		} else if (!itemGroupRepKey.equals(other.itemGroupRepKey))
			return false;
		return true;
	}


	public void toXML(StringBuilder sb){
				
		sb.append("<ItemGroupData ItemGroupOID=\""+this.itemGroupOID+"\" ItemGroupRepeatKey=\""+this.itemGroupRepKey+"\">");
		this.items.forEach((i) -> {
			i.toXML(sb);
		});
		
		sb.append("</ItemGroupData>");
	}
	
	
}
