package tech.igotit.model;

import org.orienteer.core.component.visualizer.UIVisualizersRegistry;
import org.orienteer.core.dao.DAOField;
import org.orienteer.core.dao.DAOOClass;
import org.orienteer.core.dao.ODocumentWrapperProvider;

import com.amadeus.resources.HotelOffer.RoomDetails;
import com.google.inject.ProvidedBy;

@ProvidedBy(ODocumentWrapperProvider.class)
@DAOOClass(value = "Room", nameProperty = "title", parentProperty = "hotel")
public interface IRoom {

	public String getTitle();
	public void setTitle(String value);
	
	@DAOField(inverse = "rooms")
	public IHotelVisit getHotel();
	public void setHotel(IHotelVisit value);
	
	
	public String getDescription();
	public void setDescription(String value);
	
	public String getCategory();
	public void setCategory(String value);
	
	public Integer getBeds();
	public void setBeds(Integer value);
	
	public String getBedType();
	public void setBedType(String value);
	
	@DAOField(visualization = UIVisualizersRegistry.VISUALIZER_TEXTAREA, tab = "questionnaire")
	public Double getArea();
	public void setArea(Double value);
	
	@DAOField(visualization = UIVisualizersRegistry.VISUALIZER_TEXTAREA, tab = "questionnaire")
	public String getFurniture();
	public void setFurniture(String value);
	
	@DAOField(visualization = UIVisualizersRegistry.VISUALIZER_TEXTAREA, tab = "questionnaire")
	public String getBathroom();
	public void setBathroom(String value);
	
	@DAOField(visualization = UIVisualizersRegistry.VISUALIZER_TEXTAREA, tab = "questionnaire")
	public String getComments();
	public void setComments(String value);
	
	public default void propogateFrom(RoomDetails roomDetails) {
		setTitle(roomDetails.getType());
		if(roomDetails.getDescription()!=null)
			setDescription(roomDetails.getDescription().getText());
		if(roomDetails.getTypeEstimated()!=null) {
			setCategory(roomDetails.getTypeEstimated().getCategory());
			setBeds(roomDetails.getTypeEstimated().getBeds());
			setBedType(roomDetails.getTypeEstimated().getBedType());
		}
	}
	
}
