<%--
--@Author : Saminda Peramuna
--@Date Time : Mar 21, 2016 : 11:11:28 PM
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="header">
		<link href="resources/css/branchlocator/branchlocator.css"
			rel="stylesheet" />
		<script src="http://maps.googleapis.com/maps/api/js"
			type="text/javascript"></script>
		<h2>Branch locator</h2>
	</tiles:putAttribute>
	<tiles:putAttribute name="body">
		ATMs and Branches
		
		<!-- Beginning of script block -->
		<script type="text/javascript">
			var locations = [];
			var tempVar;
			<c:forEach items="${searchForm.branches}" var="branch">

			tempVar = {
				branchcode : '${branch.branchCode}',
				description : '${branch.description}',
				address : '${branch.address}',
				contactno : '${branch.contactNo}',
				email : '${branch.email}',
				opentime : '${branch.openTime}',
				closetime : '${branch.closeTime}',
				latitude : '${branch.latitude}',
				longitude : '${branch.longitude}',
				type : 'both'
			}

			// Accessed from the global scope.
			locations.push(tempVar);
			</c:forEach>
		</script>

		<!-- JS File must be attched below the above script for the locations to be initialised  -->
		<script src="resources/js/branchlocator/branchlocator.js"
			type="text/javascript"></script>
		<!-- End of script block -->

		<form class="search">
			<input id="search-input" class="search-input" type="search" name="q"
				placeholder="Search..." autocomplete="off" />
			<ul id="search-results" class="results"></ul>
		</form>
		<label>Branch</label>
		<input onclick="radioOnClick(this.value)" class="locType"
			value="branch" type="radio" name="group" />
		<label>ATM</label>
		<input onclick="radioOnClick(this.value)" class="locType" value="atm"
			type="radio" name="group" />
		<label>Both</label>
		<input onclick="radioOnClick(this.value)" class="locType" value="both"
			type="radio" name="group" />
		<label>All</label>
		<input onclick="radioOnClick(this.value)" class="locType" value="all"
			type="radio" name="group" checked />

		<div id="map-canvas"></div>
	</tiles:putAttribute>
</tiles:insertDefinition>