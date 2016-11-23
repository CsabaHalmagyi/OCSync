package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Subject node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class SubjectNode {

	private String subjectOID;
	private List<EventNode> events;
	
	public SubjectNode() {
		this.events = new ArrayList<>();
	}

	public String getSubjectOID() {
		return subjectOID;
	}

	public void setSubjectOID(String subjectOID) {
		this.subjectOID = subjectOID;
	}

	public List<EventNode> getEvents() {
		return events;
	}

	public void setEvents(List<EventNode> events) {
		this.events = events;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjectOID == null) ? 0 : subjectOID.hashCode());
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
		SubjectNode other = (SubjectNode) obj;
		if (subjectOID == null) {
			if (other.subjectOID != null)
				return false;
		} else if (!subjectOID.equals(other.subjectOID))
			return false;
		return true;
	}

	
	public void upsert(String eventOID, String eventRepKey, String eventStatus, String formOID, 
			String formStatus, String groupOID, String groupRepKey,	String itemOID, String itemValue){
		
		
		EventNode e = new EventNode();
		e.setEventOID(eventOID);
		e.setEventRepKey(eventRepKey);
		e.setEventStatus(eventStatus);
		
		
		
		//if the event already exists
		if(this.events.contains(e)){
			this.events.get(this.events.indexOf(e)).upsert(formOID, formStatus, groupOID, groupRepKey, 
					itemOID, itemValue);
			
		}
		//if this is a new event
		else{
			this.events.add(e);
			this.events.get(this.events.indexOf(e)).upsert(formOID, formStatus, groupOID, groupRepKey, 
					itemOID, itemValue);
		}
	}
	
	public void toXML(StringBuilder sb){
		
		sb.append("<SubjectData SubjectKey=\""+this.subjectOID+"\">");
		this.events.forEach((e) -> {
			e.toXML(sb);
		});
		
		sb.append("</SubjectData>");
	}	
	
}
