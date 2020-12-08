package tech.igotit;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.request.resource.IResource.Attributes;
import org.orienteer.rproxy.IORProxyEndPoint;
import org.orienteer.rproxy.IORProxyExtension;
import org.orienteer.rproxy.ORProxyResource;

import com.amadeus.Amadeus;
import com.amadeus.Constants;
import com.amadeus.client.AccessToken;
import com.amadeus.exceptions.ResponseException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Headers.Builder;

@Slf4j
public class AmadeusExtension implements IORProxyExtension {

	@Inject
	private AccessToken accessToken;
	
	@Override
	public void onMapHeaders(Attributes attributes, Headers.Builder builder) {
		try {
			String token = accessToken.getBearerToken();
			log.info("Token: "+token);
			builder.set(Constants.AUTHORIZATION, token);
			builder.set(Constants.CONTENT_TYPE, "application/vnd.amadeus+json");
			builder.set("Accept-Encoding", "identity");
			builder.set("Content-Encoding", "identity");
		} catch (ResponseException e) {
			throw new WicketRuntimeException(e);
		}
	}

}
