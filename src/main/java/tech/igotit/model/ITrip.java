package tech.igotit.model;

import java.util.Date;
import java.util.Set;

import org.orienteer.core.component.visualizer.UIVisualizersRegistry;
import org.orienteer.core.dao.DAOField;
import org.orienteer.core.dao.DAOOClass;

import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;

@DAOOClass("Trip")
public interface ITrip {

	public String getTitle();
	public void setTitle(String title);
	
	@DAOField(type = OType.DATE)
	public Date getStartDate();
	public void setStartDate(Date date);
	
	@DAOField(type = OType.DATE)
	public Date getFinishDate();
	public void setFinishDate(Date date);
	
	@DAOField(linkedClass = "OUser", visualization = UIVisualizersRegistry.VISUALIZER_SUGGEST)
	public Set<ODocument> getTeam();
	public void setTeam(Set<ODocument> team);
}
