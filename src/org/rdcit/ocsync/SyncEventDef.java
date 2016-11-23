package org.rdcit.ocsync;

import java.util.ArrayList;
import java.util.List;

public class SyncEventDef {
	
	private String eventName;
	private String eventOID;
	private List<String> formRefs;
	
	public SyncEventDef(String eventName, String eventOID) {
		super();
		this.eventName = eventName;
		this.eventOID = eventOID;
		this.formRefs = new ArrayList<String>();
	}
	
	public void insert(String formRef){
		this.formRefs.add(formRef);
	}
	

}
