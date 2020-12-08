package tech.igotit.service;

import org.joor.Reflect;

import com.amadeus.Amadeus;
import com.amadeus.client.AccessToken;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

public class AmadeusModule extends AbstractModule{

	@Provides
	@Singleton
	public Amadeus provideAmadeus(@Named("amadeus.key") String key, @Named("amadeus.secret") String secret) {
		//Default is test - it's ok for now
		return Amadeus.builder(key, secret).build();
	}
	
	@Provides
	public AccessToken provideAccessToken(Amadeus amadeus) {
		return Reflect.on(amadeus).get("accessToken");
	}
}
