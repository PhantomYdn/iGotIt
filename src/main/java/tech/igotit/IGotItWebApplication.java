package tech.igotit;

import java.nio.file.Paths;

import org.orienteer.core.OrienteerWebApplication;
import org.orienteer.core.module.PerspectivesModule;
import org.orienteer.core.util.StartupPropertiesLoader;
import org.orienteer.jnpm.JNPMService;
import org.orienteer.jnpm.JNPMSettings;
import org.orienteer.jnpm.cdn.CDNWicketResource;

public class IGotItWebApplication extends OrienteerWebApplication
{
	@Override
	public void init()
	{
		super.init();
		mountPackage("tech.igotit.web");
		registerWidgets("tech.igotit.widget");
		registerModule(DataModel.class);
		if(!JNPMService.isConfigured()) 
			   JNPMService.configure(JNPMSettings.builder()
					   					.homeDirectory(Paths.get(StartupPropertiesLoader.getRuntime(), ".jnpm"))
					   					.build());
	    CDNWicketResource.mount(this, "/cdn");
	}
	
}
