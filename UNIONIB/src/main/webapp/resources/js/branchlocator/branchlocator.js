/** 
 * @Author : Saminda Peramuna
 * @Date Time : Mar 21, 2016 : 11:11:28 PM
 * 
 * This JavaScript file contains the google map api functions 
 * for processing the branch locations.
 */

/**
 * Document-wide variables.
 */

// Google map co-ordinates.
var centerCoords = new google.maps.LatLng(7.8578, 80.6525);

// Default location.
defaultLocation = locations[0];
/**
 * End of document-wide variables.
 */

/**
 * Insertion point.
 */
$(document).click(function() {

});

/**
 * Display all the locations.
 */
function initializeLocations(loc) {
	var mapZoom;
	var mapCenter;

	if (loc.length == 1) {
		mapZoom = 15;
		mapCenter = new google.maps.LatLng(loc[0].latitude, loc[0].longitude);
	} else {
		mapZoom = 8;
		mapCenter = centerCoords;
	}

	var mapProp = {
		center : mapCenter,
		zoom : mapZoom,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};

	var map = new google.maps.Map(document.getElementById('map-canvas'),
			mapProp);
	var infoWindow = new google.maps.InfoWindow();
	var marker;

	for (var i = 0; i < loc.length; i++) {
		var mapIcon;
		if (loc[i].type == "atm") {
			mapIcon = 'resources/img/atm.png';
		} else if (loc[i].type == "branch") {
			mapIcon = 'resources/img/branch.png';
		} else {
			mapIcon = 'resources/img/both.png';
		}

		marker = new google.maps.Marker({
			position : new google.maps.LatLng(loc[i].latitude, loc[i].longitude),
			animation : google.maps.Animation.DROP,
			icon : mapIcon
		});

		var htmlInfo = '<div class="info_content">' + '<h4>' + loc[i].description
				+ '</h4>' + '<p>' + loc[i].address + '</p>'
				+ '<p> Telephone : ' + loc[i].contactno + '</p>'
				+ '<p> Email : ' + loc[i].email + '</p>' + '</div>';

		google.maps.event.addListener(marker, 'click', (function(marker,
				htmlInfo, infoWindow) {
			return function() {
				infoWindow.setContent(htmlInfo);
				infoWindow.open(map, marker);
			};
		})(marker, htmlInfo, infoWindow));

		marker.setMap(map);
	}
}

/**
 * Invoke Google Map API
 */
$(document).ready(function() {

	// Search function.
	$("#search-input").on("keyup",function() {
		var searchFor = $("#search-input").val().toLowerCase();
		var locationType = $("input[type='radio'][class='locType']:checked").val();
		var results = [];

		for (var i = 0; i < locations.length; i++) {
			if (locations[i].description.toLowerCase().indexOf(searchFor) > -1) {
				var location = locations[i];
				if (((searchFor != "") && (location.type == locationType)) || ((searchFor != "") && (locationType == "all"))) {
					results.push("<li><a id='"
						+ location.description
						+ "' href='#' onclick='selectSearchItem(this.id)'>"
						+ location.description
						+ "</a></li>");
				}
			}
		}
        if (results.length == 0) {
            $("#search-results").html("");
            $("#search-results").css("display", "none");
        } else {
            $("#search-results").html(results.join(""));
            $("#search-results").css("display", "block");
        }
	});

	google.maps.event.addDomListener(window, 'load',initializeLocations(locations));
});

/**
 * Search event handler.
 */
function selectSearchItem(key) {
	for (var i = 0; i < locations.length; i++) {
		var location = [];
		location[0] = locations[i];
		if (location[0].description == key) {
			google.maps.event.addDomListener(window, 'load',
					initializeLocations(location));
		}
	}
	$("#search-input").val("");
	$("#search-input").keyup();
}

/*
 * Radio Array event handler.
 */
function radioOnClick(e) {
	var tempLoc = [];

	for (var i = 0; i < locations.length; i++) {
		if (locations[i].type == e.toLowerCase()) {
			tempLoc.push(locations[i]);
		}
	}

	if (e.toLowerCase() == "all") {
		tempLoc = locations;
	}

	google.maps.event.addDomListener(window, 'load',
			initializeLocations(tempLoc));
}