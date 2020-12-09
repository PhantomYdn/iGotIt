<script>
module.exports = {
	data: function() {
		return {
					cityCode : "",
					zoom : 13,
					center : L.latLng(39.7475, -104.9425),
					bounds: null,
					url : 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
					attribution :
							'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
					mapOptions: {
									zoomSnap: 0.5
								},
					hotelsMap: {},
					hotels: [],
					selectedHotels: []
				};
		},
	methods: {
		lookupHotels : function() {
			axios
				.get('/amadeus/shopping/hotel-offers?includeClosed=true&cityCode='+this.cityCode)
				.then(response => {
					var pointsToRecenter = [];
					response.data.data.forEach(hotel => {
						hotel.coordinates = L.latLng(hotel.hotel.latitude, hotel.hotel.longitude);
						pointsToRecenter.push(hotel.coordinates);
						this.hotelsMap[hotel.hotel.hotelId] = hotel;
					});
					this.hotels = Object.values(this.hotelsMap);
					this.bounds = new L.LatLngBounds(pointsToRecenter);
				})
				.catch(error => alert(error));
		},
		addToTrip : function(hotel) {
			this.selectedHotels.push(hotel);
		},
		removeFromTrip : function(hotel) {
			this.selectedHotels.splice(this.selectedHotels.indexOf(hotel),1);
		}
	}
}
</script>