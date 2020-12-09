<script>
module.exports = {
 data: function() {
			return {
						cityCode : "",
						zoom : 13,
						center : L.latLng(39.7475, -104.9425),
						url : 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
						attribution :
								'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
						mapOptions: {
										zoomSnap: 0.5
									}
					};
			}
}
</script>