package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Form node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class FormNode {

	private String formOID;
	private String formStatus;
	private List<ItemGroupNode> itemGroups;
	
	public FormNode() {
		this.itemGroups = new ArrayList<>();
	}

	public String getFormOID() {
		return formOID;
	}

	public void setFormOID(String formOID) {
		this.formOID = formOID;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public List<ItemGroupNode> getItemGroups() {
		return itemGroups;
	}

	public void setItemGroups(List<ItemGroupNode> itemGroups) {
		this.itemGroups = itemGroups;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formOID == null) ? 0 : formOID.hashCode());
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
		FormNode other = (FormNode) obj;
		if (formOID == null) {
			if (other.formOID != null)
				return false;
		} else if (!formOID.equals(other.formOID))
			return false;
		return true;
	}

	public void upsert(String groupOID, String groupRepKey, String itemOID, String itemValue){
		
		ItemGroupNode ig = new ItemGroupNode();
		ig.setItemGroupOID(groupOID);
		ig.setItemGroupRepKey(groupRepKey);
		
		//if the itemGroup already exists
		if(this.itemGroups.contains(ig)){
			this.itemGroups.get(this.itemGroups.indexOf(ig)).upsert(itemOID, itemValue);
		}
		//if this is a new itemGroup
		else{
			this.itemGroups.add(ig);
			this.itemGroups.get(this.itemGroups.indexOf(ig)).upsert(itemOID, itemValue);
		}
	}
	
	
	public void toXML(StringBuilder sb){
		
		sb.append("<FormData FormOID=\""+this.formOID+"\" OpenClinica:Status=\""+this.formStatus+"\">");
		this.itemGroups.forEach((ig) -> {
			ig.toXML(sb);
		});
		
		sb.append("</FormData>");
	}
}
