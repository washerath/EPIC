<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>${headerMessage}</h1>
	<h3>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>
	Language :
	<a href="?language=en">English</a>|
	<a href="?language=zh_CN">Chinese</a>
	<a href="?language=si_LK">Sinhala</a>

	<form:errors path="student1.*" />
	<br>
	<c:if test="${message.message != null}">
		<div class="msg">${message.message}</div>
	</c:if>

	<form action="/springmvc/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td>Student's Name :</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby :</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td>Student's Mobile :</td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>
			<tr>
				<td>Student's DOB :</td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>

			<tr>
				<td>Student's Skills set :</td>
				<td><select name="studentSkills" multiple>
						<option value="Java Core">Java Core</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring MVC">Spring MVC</option>
				</select>
				<td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Student's Address :</td>
			</tr>
			<tr>
				<td>country: <input type="text" name="studentAddress.country" /></td>
				<td>city: <input type="text" name="studentAddress.city" /></td>
				<td>street: <input type="text" name="studentAddress.street" /></td>
				<td>pincode:<input type="text" name="studentAddress.pincode" /></td>
			</tr>

			<tr>
				<td><input type="submit"
					value="Submit this form by clicking here" /></td>
			</tr>
		</table>

	</form>
	Current Locale : ${pageContext.response.locale}
</body>
</html>

