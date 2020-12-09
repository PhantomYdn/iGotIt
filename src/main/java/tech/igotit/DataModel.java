package tech.igotit;

import org.orienteer.core.OrienteerWebApplication;
import org.orienteer.core.dao.DAO;
import org.orienteer.core.module.AbstractOrienteerModule;
import org.orienteer.core.util.OSchemaHelper;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.record.impl.ODocument;

import tech.igotit.model.IHotelVisit;
import tech.igotit.model.IOEnum;
import tech.igotit.model.ITrip;

import com.orientechnologies.orient.core.metadata.schema.OType;

public class DataModel extends AbstractOrienteerModule{

	protected DataModel() {
		super("iGotIt", 4);
	}
	
	@Override
	public ODocument onInstall(OrienteerWebApplication app, ODatabaseSession db) {
		super.onInstall(app, db);
		OSchemaHelper helper = OSchemaHelper.bind(db);
		DAO.describe(helper, IOEnum.class, ITrip.class, IHotelVisit.class);
		
		helper.oClass("ORProxyEndPoint")
				.oDocument("name", "Amadeus")
					.field("mountPath", "/amadeus")
					.field("baseUrl", "https://test.api.amadeus.com/v2")
					.field("extensionClassName", AmadeusExtension.class.getName())
					.saveDocument();
		return null;
	}
	
	@Override
	public void onUpdate(OrienteerWebApplication app, ODatabaseSession db, int oldVersion, int newVersion) {
		onInstall(app, db);
	}
	
}
