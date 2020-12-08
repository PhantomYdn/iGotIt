package tech.igotit;

import org.orienteer.core.OrienteerWebApplication;
import org.orienteer.core.module.PerspectivesModule;

public class IGotItWebApplication extends OrienteerWebApplication
{
	@Override
	public void init()
	{
		super.init();
		mountPackage("tech.igotit.web");
		registerWidgets("tech.igotit.widget");
		registerModule(DataModel.class);
	}
	
}
