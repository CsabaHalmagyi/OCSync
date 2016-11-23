package org.rdcit.ocsync;

import java.util.ArrayList;
import java.util.List;

public class SyncItemGroupDef {
	
	private String itemGroupName;
	private String itemGroupOID;
	private List<String> itemRefs;
	
	public SyncItemGroupDef(String itemGroupName, String itemGroupOID) {
		super();
		this.itemGroupName = itemGroupName;
		this.itemGroupOID = itemGroupOID;
		this.itemRefs = new ArrayList<>();
	}
	
	public void insert(String itemRef){
		this.itemRefs.add(itemRef);
	}
	
}
