
<%@page import="com.epic.ib.bean.session.SessionBean"%>
<%
	SessionBean sessBean = (SessionBean) pageContext.getSession().getAttribute("scopedTarget.sessionBean");
%>

<link href="resources/bootstrap/css/ionicons.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/rowmenu/rowmenu.css" type="text/css"
	rel="stylesheet" />


<div class="row" style="padding: 0px;">

	<div
		class="clearfix visible-sm-block visible-md-block visible-lg-block"
		style="margin-bottom: 15px; background-color: white; box-shadow: 2px 2px 2px rgba(136, 136, 136, 0.31);">

		<div class="space"></div>
		<div class="col-lg-3 col-md-4">
			<div class="info-box-icon" style="background-color: white;">
				<img src="resources/img/bank_logo_old.png" class="" alt="User Image"
					width="80" height="80" />
			</div>

			<div class="info-box-text"
				style="margin-left: 100px; overflow: visible">
				<h3 style="color: #205499;"><%out.println(sessBean.getIbmobuser().getFirstname()+" "+sessBean.getIbmobuser().getLastname()); %></h3>
				<h5 style="color: #205499;">Last login: 10/03/2016</h5>
			</div>
		</div>
	</div>
</div>
<div class="fixed-side-social-container">
	<a class="fa fa-exchange" title="Exchange Rates"
		style="font-size: xx-large;" href="../sidebar/exchangerates.html"></a>
	<a class="fa fa-percent" title="Interest Rates"
		style="font-size: xx-large;" href="../sidebar/interestrates.html"></a>
	<a class="fa fa-calculator" title="Calculator"
		style="font-size: xx-large;" href="../sidebar/loancalculator.html"></a>
	<a class="fa fa-bullhorn" title="Promotions"
		style="font-size: xx-large;" href="../promotions/promotions.html"></a>

</div>
