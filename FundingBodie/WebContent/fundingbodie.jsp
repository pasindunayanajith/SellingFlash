
<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.FundingBodie"%>


<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>GagetBadget</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="Views/bootstrap.min.css">
  	<!-- Jquery Js -->

  	<script src="Components/jquery-1.9.1.min.js" type="text/javascript"></script>
   
    <!-- Validation Researcher -->
    <script src="Components/fundingbodie.js"></script>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="img/fav.png">
    <!-- Normalize CSS -->
    <link rel="stylesheet" href="Views/Other/normalize.css">
    <!-- Main CSS -->
    <link rel="stylesheet" href="Views/Other/main.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="Views/Other/animate.min.css">
    <!-- Font-awesome CSS-->
    <link rel="stylesheet" href="Views/Other/font-awesome.min.css">
    <!-- Owl Caousel CSS -->
    <link rel="stylesheet" href="Views/Other/owl.carousel.min.css">
    <link rel="stylesheet" href="Views/Other/owl.theme.default.min.css">
    <!-- Main Menu CSS -->
    <link rel="stylesheet" href="Views/Other/meanmenu.min.css">
    <!-- nivo slider CSS -->
    <link rel="stylesheet" href="Views/Other/nivo-slider.css">
    <link rel="stylesheet" href="Views/Other/preview.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="Views/Other/style3.css">
    <link rel="stylesheet" href="Views/Other/style1.css"> 
  ``<!-- Switch Style CSS -->
    <link rel="stylesheet" href="Views/Other/hover-min.css">
    <!-- ReImageGrid CSS -->
    <link rel="stylesheet" href="Views/Other/reImageGrid.css">
    <!-- Modernizr Js #100032 -->
    <script src="Components/Other/modernizr-2.8.3.min.js"></script>
    <link rel="stylesheet" href="Views/Other/admin.css">
   
  
</head>
<style>

</style>
<body>
    
    <div id="wrapper">
        <!-- Header Area Start Here -->
        <header>
            <div id="header1" class="header1-area">
                <div class="main-menu-area bg-primary" id="sticker">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3">
                                <div class="logo-area">
                                    <a href="index.html"><img class="img-responsive" src="images/logo1.jpg" alt="logo"></a>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-9">
                                <nav id="desktop-nav">
                                    <ul>
                                        <li class="active"><a href="../Login/home.jsp">Home</a>
                                        
                                        </li>
                                        
                                        <li><a href="#">FundingBodie Service</a>
                                            <ul>
                                                <li><a href="fundingbodie.jsp">Create FundingBoides</a></li>
                                                <li><a href="view_profile.jsp">View Profile</a></li>
                                                <li><a href="viewfundingbodieusers.jsp">Display FundingBodie Users</a></li>
                                            
                                            </ul>
                                        </li>
                                      </ul>
                                </nav>
                            </div>
                            <div class="col-lg-2 col-md-2 hidden-sm">
                                <div class="apply-btn-area">
                                    <a href="../Login/login.jsp" class="apply-now-btn">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Mobile Menu Area Start -->
            <div class="mobile-menu-area">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            
                            <div class="mobile-menu">
                                <nav id="dropdown">
                                
                                    <ul><br>
                                        <li class="active"><a href="../Login/home.jsp">Home</a>
                                        
                                        </li>
                                    
                                        <li><a href="#">FundingBoide Services</a>
                                            <ul>
                                                  <li><a href="fundingbodie.jsp">Create FundingBoides</a></li>
                                                <li><a href="view_profile.jsp">View Profile</a></li>>
                                                <li><a href="viewfundingbodieusers.jsp">Display FundingBodie Users</a></li>
                                            </ul>
                                            </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Mobile Menu Area End -->
        </header>

<!-- Registration Form  -->
        <div class="registration-page-area bg-secondary">
            <div class="container">
                <h2 class="sidebar-title">Create Funding Bodie Account</h2>
                <div class="registration-details-area inner-page-padding">
                 
          
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">   
                 
                   <form id="formFundingbodie" name="formFundingbodie">
					
					Company Name: <input id="fbName" name="fbName" type="text" class="form-control form-control-sm"> <br> 
					
					Address:<input id="fbAddress" name="fbAddress" type="text" class="form-control form-control-sm"> <br> 		
													    
				    Phone:<input id="fbPhone" name="fbPhone" type="text" class="form-control form-control-sm"> <br> 		
				
					Email:<input id="fbEmail" name="fbEmail" type="email" class="form-control form-control-sm"> <br> 		
				
					Password:<input id="fbPassword" name="fbPassword" type="password" class="form-control form-control-sm"> <br> 		
							
					Company Details:<textarea id="fbDescription" name="fbDescription" class="form-control form-control-sm" rows="4" cols="50"></textarea> <br>
				
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-secondary"><input type="hidden" id="hidFundingbodieIDSave" name="hidFundingbodieIDSave" value="">
				
				</form>
				 <div id="alertSuccess"  class="alert alert-success"></div>
				 <div id="alertError" class="alert alert-danger"></div>
				
				</div>
                                  
  </div>
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">   
  <div class="row">
 <div class="scrollWrapper">
 
   <div id="divFundingbodiesGrid">
   
 <%
 FundingBodie fundingbodieObj = new FundingBodie();
 out.print(fundingbodieObj.readFundingBodies());
 %>
 
</div>
 
 
</div>
</div>
</div>
</div> 
                           
</div>     
                        
</div>


            <!-- Footer Area Start Here -->
           
        <footer>
            
            <div class="footer-area-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                            <p>&copy; 2021 GadgetBadget All Rights Reserved. </p>
                        </div>

                    </div>
                </div>
            </div>
            
            
            
        </footer>
        <!-- Footer Area End Here -->
    </div>
    
   <!-- Bootstrap JS -->
    <script src="Components/bootstrap.min.js" type="text/javascript"></script>
    <!-- Meanmenu Js -->
    <script src="Components/Other/jquery.meanmenu.min.js" type="text/javascript"></script>

    <!-- Custom Js -->
    <script src="Components/Other/main.js" type="text/javascript"></script>
	


</body>





</html>  
           
           
