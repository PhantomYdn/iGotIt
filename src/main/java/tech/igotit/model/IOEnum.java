package tech.igotit.model;

import java.util.Map;

import org.orienteer.core.component.visualizer.UIVisualizersRegistry;
import org.orienteer.core.dao.DAOField;
import org.orienteer.core.dao.DAOOClass;
import org.orienteer.core.dao.ODocumentWrapperProvider;

import com.google.inject.ProvidedBy;

@ProvidedBy(ODocumentWrapperProvider.class)
@DAOOClass(value = "OEnum", isAbstract = true)
public interface IOEnum {
	
	@DAOField(visualization = UIVisualizersRegistry.VISUALIZER_LOCALIZATION)
	public Map<String, String> getName();
	public void setName(Map<String, String> name);
	
	public String getAlias();
	public void setAlias(String alias);

}
