package org.rdcit.ocsync.models.odmnodes;

/**
 * Represents an Item node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */


public class ItemNode {

	private String itemOID;
	private String value;
	
	public ItemNode(String itemOID, String value) {
		super();
		this.itemOID = itemOID;
		this.value = value;
	}

	public String getItemOID() {
		return itemOID;
	}

	public void setItemOID(String itemOID) {
		this.itemOID = itemOID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemOID == null) ? 0 : itemOID.hashCode());
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
		ItemNode other = (ItemNode) obj;
		if (itemOID == null) {
			if (other.itemOID != null)
				return false;
		} else if (!itemOID.equals(other.itemOID))
			return false;
		return true;
	}
	
	
	public void toXML(StringBuilder sb){
		sb.append("<ItemData ItemOID=\""+this.itemOID+"\" Value=\""+this.value+"\"/>");
	}
	
}
