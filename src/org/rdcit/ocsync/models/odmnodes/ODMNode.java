package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the ODM (root) node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class ODMNode {

	private List<StudyNode> studies;

	public ODMNode() {
		this.studies = new ArrayList<>();
	}
	
	public void upsert(String studyOID, String subjectOID, String eventOID, String eventRepKey, String eventStatus, String formOID, 
			String formStatus, String groupOID, String groupRepKey,	String itemOID, String itemValue){
		
		StudyNode s = new StudyNode();
		s.setStudyOID(studyOID);
		
		//if the study already exists
		if(this.studies.contains(s)){
			this.studies.get(this.studies.indexOf(s)).upsert(subjectOID, eventOID, eventRepKey, eventStatus, formOID, formStatus, groupOID, groupRepKey, itemOID, itemValue);
			
		}
		//if this is a new study
		else{
			this.studies.add(s);
			this.studies.get(this.studies.indexOf(s)).upsert(subjectOID, eventOID, eventRepKey, eventStatus,formOID, formStatus, groupOID, groupRepKey, 
					itemOID, itemValue);
		}
		
		
	}
	
	public String toXML(){
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("<ODM xmlns=\"http://www.cdisc.org/ns/odm/v1.3\" xmlns:OpenClinica=\"http://www.openclinica.org/ns/odm_ext_v130/v3.1\">");
		this.studies.forEach((s) -> {
			s.toXML(sb);
		});
		
		sb.append("</ODM>");
		return sb.toString();
	}	
	
	
}
