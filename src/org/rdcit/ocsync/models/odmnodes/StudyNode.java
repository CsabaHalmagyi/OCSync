package org.rdcit.ocsync.models.odmnodes;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Study (site) node in the ODM structure	
 * 
 * @author Csaba Halmagyi
 *
 */

public class StudyNode {

	private String studyOID;
	private List<SubjectNode> subjects;
	
	public StudyNode() {
		this.subjects = new ArrayList<>();
	}

	public String getStudyOID() {
		return studyOID;
	}

	public void setStudyOID(String studyOID) {
		this.studyOID = studyOID;
	}

	public List<SubjectNode> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectNode> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((studyOID == null) ? 0 : studyOID.hashCode());
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
		StudyNode other = (StudyNode) obj;
		if (studyOID == null) {
			if (other.studyOID != null)
				return false;
		} else if (!studyOID.equals(other.studyOID))
			return false;
		return true;
	}
	
	public void upsert(String subjectOID, String eventOID, String eventRepKey, String eventStatus, String formOID, 
			String formStatus, String groupOID, String groupRepKey,	String itemOID, String itemValue){
		
		SubjectNode ss = new SubjectNode();
		ss.setSubjectOID(subjectOID);

		//if the subject already exists
		if(this.subjects.contains(ss)){
			this.subjects.get(this.subjects.indexOf(ss)).upsert(eventOID, eventRepKey, eventStatus,formOID, formStatus, groupOID, groupRepKey, 
					itemOID, itemValue);
			
		}
		//if this is a new subject
		else{
			this.subjects.add(ss);
			this.subjects.get(this.subjects.indexOf(ss)).upsert(eventOID, eventRepKey, eventStatus,formOID, formStatus, groupOID, groupRepKey, 
					itemOID, itemValue);
		}
		
		
	}
	
	public void toXML(StringBuilder sb){
		
		sb.append("<ClinicalData StudyOID=\""+this.studyOID+"\" MetaDataVersionOID=\"1\">");
		this.subjects.forEach((ss) -> {
			ss.toXML(sb);
		});
		
		sb.append("</ClinicalData>");
	}	
	
	
	
}
