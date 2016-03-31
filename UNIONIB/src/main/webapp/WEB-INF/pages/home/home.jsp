
<%--
--@Author : Asitha Perera
--@Date Time : Mar 21, 2016 : 11:11:28 PM
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<tiles:insertDefinition name="defaultTemplate">
	
	

	<tiles:putAttribute name="body">
	    <div class="wrapper" style="background-color: #FFFFFF;">
            <!-- ###################################################### -->
            <div id="head"></div>
            <!--Content Wrapper. Contains page content--> 
            <div class="content-wrapper" style="margin-left: 0px;min-height: 550px;">
                <!--Content Header (Page header)--> 
                <!-- ###################################################### -->
                <!-- Main content -->
                <section class="content">
                    <div id="rowmenu"></div>
                    <!-- Info boxes -->

                    <!-- Your Page Content Here -->
                    <div class="row">
                        <div class="col-lg-12" style="background-color: white;margin-left: 2%;margin-right: 2%;padding-left: 0px;padding-right: 0;padding-top: 2%;width: 96%">

                            <!--style="box-shadow: 2px 2px 2px rgba(136, 136, 136, 0.43);"-->
                            <div>
                                <div class="col-lg-12 col-md-9s col-sm-6 col-xs-12" style="background-color: white;padding-left: 2%;
                                     padding-right: 2%;
                                     padding-top: 1%;">                                   


                                    <!-- Account Summary -->
                                    <div class="col-lg-4s col-md-6 col-sm-6 col-xs-12">
                                        <div class="inner">
                                            <div class="icon" style="font-size: 60px; color: cornflowerblue;">
                                                <i class="ion ion-cash"></i>
                                                <span class="tile-title">Account Summary</span>
                                            </div>
<div class="tile-back">
                                            <div class="inner mCustomScrollbar scroll-layout-200" data-mcs-theme="light-3">
                                                <div class="tile-border">
                                                    <div class="tile-heading">Savings Account</div>
                                                    <span class="tile-content-heading">Account Number :</span>
                                                    <span class="tile-content">1545757240</span>
                                                    <div>
                                                        <span class="tile-content-heading">Total Balance :</span>
                                                        <span class="tile-content">LKR. 299,999.00</span>
                                                    </div>
                                                </div>
                                                <div class="tile-border">
                                                    <div class="tile-heading">Current Account</div>
                                                    <span class="tile-content-heading">Account Number :</span>
                                                    <span class="tile-content">9518757240</span>
                                                    <div>
                                                        <span class="tile-content-heading">Total Balance :</span>
                                                        <span class="tile-content">LKR. 199,999.00</span>
                                                    </div>
                                                </div> 
                                                <div class="tile-border">
                                                    <div class="tile-heading">Current Account</div>
                                                    <span class="tile-content-heading">Account Number :</span>
                                                    <span class="tile-content">9518757246</span>
                                                    <div>
                                                        <span class="tile-content-heading">Total Balance :</span>
                                                        <span class="tile-content">LKR. 10,000.00</span>
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>
                                            </div>
                                    </div>

                                    <!-- Transaction History -->
                                    <div class="col-lg-4s col-md-6 col-sm-6 col-xs-12" >
                                        <div class="inner">
                                            <div class="icon" style="font-size: 60px;color: cornflowerblue;">
                                                <i class="ion ion-arrow-swap"></i>
                                                <span class="tile-title">Transaction History</span>
                                            </div>
                                        </div>
                                        <div class="tile-back">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th style="width: 26%">Date</th>
                                                        <th>Transaction Type</th>
                                                        <th style="text-align: ">Amount (LKR)</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                            <div class="inner mCustomScrollbar scroll-layout-120" data-mcs-theme="light-3">
                                                <table class="table">
                                                    <tbody> 
                                                        <tr class="table-row">
                                                            <td>10/03/2016</td>
                                                            <td>Fund Transfer</td>
                                                            <td style="text-align: right">5000.00</td>
                                                        </tr>
                                                        <tr class="table-row">
                                                            <td>11/03/2016</td>
                                                            <td>Fund Transfer</td>
                                                            <td style="text-align: right">500.00</td>
                                                        </tr>
                                                        <tr class="table-row">
                                                            <td>12/03/2016</td>
                                                            <td>Withdrawal</td>
                                                            <td style="text-align: right">4000.00</td>
                                                        </tr>
                                                        <tr class="table-row">
                                                            <td>13/03/2016</td>
                                                            <td>Utility Bill Payment</td>
                                                            <td style="text-align: right">2999.99</td>
                                                        </tr>
                                                        <tr class="table-row">
                                                            <td>14/03/2016</td>
                                                            <td>Withdrawal</td>
                                                            <td style="text-align: right">1000.00</td>
                                                        </tr>
                                                    </tbody>    
                                                </table>
                                            </div>
                                        </div>
                                        <br/>
                                    </div>

                                    <!-- Favorites -->
                                    <div class="col-lg-4s" style="width: 100%">
                                        <!-- small box -->
                                        <div class="inner">
                                            <div class="icon" style="font-size: 60px;color: cornflowerblue;">
                                                <i class="ion ion-heart"></i>
                                                <span class="tile-title">Favorites</span>
                                            </div>
                                        </div>

                                        <div class="favorites-container">
										
										<c:forEach items="${userFavourites}" var="item">
                                            <div class="favorites">
                                                <img onclick="removeFavorite(this)" src="resources/img/remove.png" alt="remove" class="remove-icon" />
                                                <a href="${item.key}">
                                                    <span class="favorites-content">${item.value}</span>
                                                </a>
                                            </div>
											</c:forEach>
                                           
                                            <div id="add-favorite" class="add-favorite">
                                                <select onchange="addFavorite()" id="select-fav" class="form-control">
                                                    <optgroup label="Fund Transfers">
                                                        <option>Own Registered Accounts</option>
                                                        <option>Other Accounts</option>
                                                        <option>Third Party Accounts</option>
                                                    </optgroup>
                                                    <optgroup label="Standing Orders">
                                                        <option>New Standing Order</option>
                                                        <option>Available Standing Orders</option>
                                                    </optgroup>
                                                    <optgroup label="Inquiries">
                                                        <option>Account Inquiry</option>
                                                        <option>Account History</option>
                                                        <option>Cheque Inquiry</option>
                                                        <option>Loan Inquiry</option>
                                                    </optgroup>
                                                    <optgroup label="Assets and Liabilities">
                                                    </optgroup>
                                                    <optgroup label="ATM Locator">
                                                    </optgroup>
                                                    <optgroup label="Requests">
                                                        <option>Statement Requests</option>
                                                        <option>Cheque Book Requests</option>
                                                    </optgroup>
                                                    <optgroup label="Utility Bill">
                                                        <option>Utility Bill Payments</option>
                                                    </optgroup>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="space" style="background-color: white;">&nbsp;</div>
                                    <div class="space" style="background-color: white;">&nbsp;</div>
                                </div>
                                <!-- the info boxes were here-->
                            </div>
                        </div>
                        <!--  the new info boxes -->
                    </div>
                </section>
            </div>
        </div>	
	
	</tiles:putAttribute>

</tiles:insertDefinition>