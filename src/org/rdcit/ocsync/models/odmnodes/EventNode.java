package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents an Event node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class EventNode {

	private String eventOID;
	private String eventRepKey;
	private String eventStatus;
	
	private List<FormNode> forms;

	public EventNode() {

		this.forms = new ArrayList<>();
	}

	public String getEventOID() {
		return eventOID;
	}

	public void setEventOID(String eventOID) {
		this.eventOID = eventOID;
	}

	public String getEventRepKey() {
		return eventRepKey;
	}

	public void setEventRepKey(String eventRepKey) {
		this.eventRepKey = eventRepKey;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public List<FormNode> getForms() {
		return forms;
	}

	public void setForms(List<FormNode> forms) {
		this.forms = forms;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eventOID == null) ? 0 : eventOID.hashCode());
		result = prime * result
				+ ((eventRepKey == null) ? 0 : eventRepKey.hashCode());
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
		EventNode other = (EventNode) obj;
		if (eventOID == null) {
			if (other.eventOID != null)
				return false;
		} else if (!eventOID.equals(other.eventOID))
			return false;
		if (eventRepKey == null) {
			if (other.eventRepKey != null)
				return false;
		} else if (!eventRepKey.equals(other.eventRepKey))
			return false;
		return true;
	}

	public void upsert(String formOID, String formStatus, String groupOID, String groupRepKey, 
			String itemOID, String itemValue){
		
		FormNode f = new FormNode();
		f.setFormOID(formOID);
		f.setFormStatus(formStatus);
		
		
		//if the form already exists
		if(this.forms.contains(f)){
			this.forms.get(this.forms.indexOf(f)).upsert(groupOID, groupRepKey, itemOID, itemValue);
			
		}
		//if this is a new form
		else{
			this.forms.add(f);
			this.forms.get(this.forms.indexOf(f)).upsert(groupOID, groupRepKey, itemOID, itemValue);
		}
		
		
	}
	
	
	public void toXML(StringBuilder sb){
		
		sb.append("<StudyEventData StudyEventOID=\""+this.eventOID+"\" StudyEventRepeatKey=\""+this.eventRepKey+"\">");
		this.forms.forEach((f) -> {
			f.toXML(sb);
		});
		
		sb.append("</StudyEventData>");
	}
	
}
