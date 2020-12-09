package tech.igotit.widget;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;
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
	
	public static final UrlResourceReference LEAFLET_CSS = new UrlResourceReference(Url.parse("/cdn/leaflet@1.7.1/dist/leaflet.css"));
	public static final UrlResourceReference LEAFLET_JS = new UrlResourceReference(Url.parse("/cdn/leaflet@1.7.1/dist/leaflet.js"));
	public static final UrlResourceReference VUE2_LEAFLET_JS = new UrlResourceReference(Url.parse("/cdn/vue2-leaflet@2.6.0/dist/vue2-leaflet.min.js"));
	public static final UrlResourceReference AXIOS_JS = new UrlResourceReference(Url.parse("/cdn/axios@0.21.0/dist/axios.js"));
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
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(LEAFLET_CSS));
		response.render(JavaScriptHeaderItem.forReference(LEAFLET_JS, "leaflet.js"));
		response.render(JavaScriptHeaderItem.forReference(VUE2_LEAFLET_JS, "vue2-leaflet"));
		response.render(JavaScriptHeaderItem.forReference(AXIOS_JS, "axios"));
		response.render(OnDomReadyHeaderItem.forScript("Vue.component('l-map', window.Vue2Leaflet.LMap);\r\n" + 
				"        Vue.component('l-tile-layer', window.Vue2Leaflet.LTileLayer);\r\n" + 
				"        Vue.component('l-marker', window.Vue2Leaflet.LMarker);\r\n" + 
				"        Vue.component('l-popup', window.Vue2Leaflet.LPopup);\r\n" + 
				"        Vue.component('l-tooltip', window.Vue2Leaflet.LTooltip);"));
	}

}
