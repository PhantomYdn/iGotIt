package tech.igotit.widget;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.orienteer.core.component.FAIcon;
import org.orienteer.core.component.FAIconType;
import org.orienteer.core.model.ODocumentNameModel;
import org.orienteer.core.widget.AbstractWidget;
import org.orienteer.core.widget.Widget;
import org.orienteer.vuecket.descriptor.VueFile;

import com.orientechnologies.orient.core.record.impl.ODocument;

@Widget(id="build-trip", domain="document", selector = "Trip", order=10, autoEnable=true)
@VueFile("BuildTripWidget.vue")
public class BuildTripWidget extends AbstractWidget<ODocument> {

	public BuildTripWidget(String id, IModel<ODocument> model, IModel<ODocument> widgetDocumentModel) {
		super(id, model, widgetDocumentModel);
	}

	@Override
	protected FAIcon newIcon(String id) {
		return new FAIcon(id, FAIconType.globe);
	}

	@Override
	protected IModel<String> getDefaultTitleModel() {
		return new StringResourceModel("widget.buildtip.title");
	}

}
