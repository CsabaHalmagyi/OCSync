package org.rdcit.ocsync;

import java.util.ArrayList;
import java.util.List;

public class SyncFormDef {

		private String formName;
		private String formOID;
		private List<String> itemGroupRefs;
		
		public SyncFormDef(String formName, String formOID) {
			super();
			this.formName = formName;
			this.formOID = formOID;
			this.itemGroupRefs = new ArrayList<>();
		}
		
		public void insert(String itemGroupRef){
			this.itemGroupRefs.add(itemGroupRef);
		}
		
	
	
}
