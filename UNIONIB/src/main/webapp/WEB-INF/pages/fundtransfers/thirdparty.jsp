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

<%-- <tiles:insertDefinition name="defaultTemplate"> --%>
<%-- 	<tiles:putAttribute name="header"> --%>
<!-- 		<h2>Third party fund transferes - Non registered</h2> -->
<%-- 	</tiles:putAttribute> --%>
<%-- 	<tiles:putAttribute name="body"> --%>
<%-- 		<form:form> --%>
<!-- 			<label>From Acoount Number</label> -->
<%-- 			<form:input type="text" path="formAccount" /> --%>
<!-- 			<label>Account Holder's Name</label> -->
<%-- 			<form:input type="text" path="beneficiaryName" /> --%>
<!-- 			<label>Select Bank</label> -->
<%-- 			<form:select path="bank" items="bank.description" --%>
<%-- 				itemValue="bank.bankCode"> --%>
<%-- 			</form:select> --%>
<!-- 			<label>Select Bank</label> -->
<%-- 			<form:option label="Registered" value="selected" /> --%>
<%-- 			<form:option label="Un-registered" value="" /> --%>
<!-- 			<label>Remarks</label> -->
<%-- 			<form:input type="text" path="remakrs" /> --%>
<%-- 		</form:form> --%>
<%-- 	</tiles:putAttribute> --%>
<%-- 	<tiles:putAttribute name="footer"> --%>
<%-- 	</tiles:putAttribute> --%>
<%-- </tiles:insertDefinition> --%>

<html>
<title>Third party fund transfers</title>
<body>
	<h2>Fund Transfer form</h2>
	<form:form action="" modelAttribute="thirdPartyForm">
		<table>
			<tbody>
				<tr>
					<td><label>From Acoount Number</label></td>
					<td><form:input type="text" path="fromAccount" /></td>
				</tr>
				<tr>
					<td><label>Account Holder's Name</label></td>
					<td><form:input type="text" path="beneficiaryName" /></td>
				</tr>
			</tbody>
		</table>



		<label>From Acoount Number</label>
		<form:input type="text" path="fromAccount" />
		<label>Account Holder's Name</label>
		<form:input type="text" path="beneficiaryName" />
		<label>Select Bank</label>

		<label>Select Bank</label>
		<label>Remarks</label>
	</form:form>
</body>
</html>