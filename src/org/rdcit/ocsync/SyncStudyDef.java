package org.rdcit.ocsync;

import java.util.ArrayList;
import java.util.List;



public class SyncStudyDef {

	private String uniqueProtocolId;
	private String studyOID;
	
	private List<SyncSiteDef> siteDefs;
	private List<SyncEventDef> eventDefs;
	private List<SyncFormDef> formDefs;
	private List<SyncItemGroupDef> itemGroupDefs;
	
	
	public SyncStudyDef() {
		super();
		this.siteDefs = new ArrayList<SyncSiteDef>();
		this.eventDefs = new ArrayList<SyncEventDef>();
		this.formDefs = new ArrayList<SyncFormDef>();
		this.itemGroupDefs = new ArrayList<SyncItemGroupDef>();
	}
	
	
	
	public String getUniqueProtocolId() {
		return uniqueProtocolId;
	}

	public void setUniqueProtocolId(String uniqueProtocolId) {
		this.uniqueProtocolId = uniqueProtocolId;
	}

	public String getStudyOID() {
		return studyOID;
	}

	public void setStudyOID(String studyOID) {
		this.studyOID = studyOID;
	}

	public List<SyncSiteDef> getSiteDefs() {
		return siteDefs;
	}

	public void setSiteDefs(List<SyncSiteDef> siteDefs) {
		this.siteDefs = siteDefs;
	}

	public List<SyncEventDef> getEventDefs() {
		return eventDefs;
	}

	public void setEventDefs(List<SyncEventDef> eventDefs) {
		this.eventDefs = eventDefs;
	}

	public List<SyncFormDef> getFormDefs() {
		return formDefs;
	}

	public void setFormDefs(List<SyncFormDef> formDefs) {
		this.formDefs = formDefs;
	}

	public List<SyncItemGroupDef> getItemGroupDefs() {
		return itemGroupDefs;
	}

	public void setItemGroupDefs(List<SyncItemGroupDef> itemGroupDefs) {
		this.itemGroupDefs = itemGroupDefs;
	}

	public void insertSiteDef(SyncSiteDef sd){
		this.siteDefs.add(sd);
	}
	
	public void insertEventDef(SyncEventDef ed){
		this.eventDefs.add(ed);
	}
	
	public void insertFormDef(SyncFormDef fd){
		this.formDefs.add(fd);
	}
	
	public void insertItemGroupDef(SyncItemGroupDef igd){
		this.itemGroupDefs.add(igd);
	}
	
}
