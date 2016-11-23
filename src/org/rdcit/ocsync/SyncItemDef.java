package org.rdcit.ocsync;

public class SyncItemDef {
	
	private String itemName;
	private String itemOID;
	
	public SyncItemDef(String itemName, String itemOID) {
		super();
		this.itemName = itemName;
		this.itemOID = itemOID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
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
		SyncItemDef other = (SyncItemDef) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	

}
