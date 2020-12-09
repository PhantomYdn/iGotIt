package tech.igotit.model;

import org.orienteer.core.dao.DAOProvider;
import org.orienteer.core.dao.Query;

import com.google.inject.ProvidedBy;

@ProvidedBy(DAOProvider.class)
public interface IGotItDAO {

	@Query("select from HotelVisit where trip=:trip and hotelId=:hotelId")
	public IHotelVisit lookupByHotelId(ITrip trip, String hotelId);
}
