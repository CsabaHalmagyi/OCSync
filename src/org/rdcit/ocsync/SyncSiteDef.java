package org.rdcit.ocsync;

public class SyncSiteDef {

	private String uniqueProtocolId;
	private String siteOID;
	
	public SyncSiteDef(String uniqueProtocolId, String siteOID) {
		super();
		this.uniqueProtocolId = uniqueProtocolId;
		this.siteOID = siteOID;
	}

	public String getUniqueProtocolId() {
		return uniqueProtocolId;
	}

	public String getSiteOID() {
		return siteOID;
	}
	
	
	
	
}
