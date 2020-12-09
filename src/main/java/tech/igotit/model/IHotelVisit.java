package tech.igotit.model;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.util.string.Strings;
import org.orienteer.core.dao.DAOField;
import org.orienteer.core.dao.DAOOClass;
import org.orienteer.core.dao.ODocumentWrapperProvider;

import com.amadeus.resources.HotelOffer;
import com.amadeus.resources.HotelOffer.AddressType;
import com.amadeus.resources.HotelOffer.Hotel;
import com.amadeus.resources.HotelOffer.HotelContact;
import com.amadeus.resources.HotelOffer.Offer;
import com.google.inject.ProvidedBy;

@ProvidedBy(ODocumentWrapperProvider.class)
@DAOOClass(value = "HotelVisit", displayable = {"name", "rating", "address", "city", "state", "phone", "fax"})
public interface IHotelVisit {

	public String getName();
	public void setName(String name);
	
	@DAOField(inverse = "hotels")
	public ITrip getTrip();
	public void setTrip(ITrip value);
	
	
	public String getHotelId();
	public void setHotelId(String hotelId);
	
	public Integer getRating();
	public void setRating(Integer value);
	
	public String getDescription();
	public void setDescription(String description);
	
	public String getAddress();
	public void setAddress(String address);
	
	public String getCity();
	public void setCity(String city);
	
	public String getState();
	public void setState(String state);
	
	public String getPhone();
	public void setPhone(String phone);
	
	public String getFax();
	public void setFax(String value);
	
	public String getEmail();
	public void setEmail(String value);
	
	
	public Double getLatitude();
	public void setLatitude(Double value);
	
	public Double getLongitude();
	public void setLongitude(Double value);
	
	public List<String> getAmenities();
	public void setAmenities(List<String> value);
	
	public default void populateFrom(HotelOffer hotelOffer) {
		Hotel hotel = hotelOffer.getHotel();
		setName(hotel.getName());
		setHotelId(hotel.getHotelId());
		setRating(hotel.getRating());
		if(hotel.getDescription()!=null) setDescription(hotel.getDescription().getText());
		AddressType address = hotel.getAddress();
		if(address!=null) {
			String[] lines = address.getLines();
			if(lines!=null) setAddress(Strings.join(", ", lines));
			setCity(address.getCityName());
			setState(address.getStateCode());
		}
		HotelContact contact = hotel.getContact();
		if(contact!=null) {
			setPhone(contact.getPhone());
			setFax(contact.getFax());
			//setEmail(contact.getEmail()); NO SUCH method in Amadeus
		}
		setLatitude(hotel.getLatitude());
		setLongitude(hotel.getLongitude());
		String[] amenities = hotel.getAmenities();
		setAmenities(Arrays.asList(amenities));
		
		Offer[] offers = hotelOffer.getOffers();
	}
}
