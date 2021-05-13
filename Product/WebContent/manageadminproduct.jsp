<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Product"%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>GagetBadget</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="Views/bootstrap.min.css">
  	<!-- Jquery Js -->
  	<script src="Components/jquery-3.6.0.min.js" type="text/javascript"></script>
    <!-- Bootstrap JS -->
    <script src="Components/bootstrap.min.js" type="text/javascript"></script>
    <!-- Validation Product -->
    <script src="Components/product1.js"></script>
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
  <!-- Switch Style CSS -->
    <link rel="stylesheet" href="Views/Other/hover-min.css">
    <!-- ReImageGrid CSS -->
    <link rel="stylesheet" href="Views/Other/reImageGrid.css">
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
                                        
                                      
                                        <li><a href="#">Product Services</a>
                                            <ul>
                                                <li><a href="product.jsp">Add Product</a></li>
                                                <li><a href="manageadminproduct.jsp">Admin Manage Product</a></li>
                                               <li><a href="viewproductbuyers.jsp">Display Product Users</a></li>
                                            
                                            </ul>
                                        </li>
                                       <li><a href="../Login/home.jsp">Back</a></li>
                                        
                                       
                                        </ul>
                                </nav>
                            </div>
                            <div class="col-lg-2 col-md-2 hidden-sm">
                                <div class="apply-btn-area">
                                    <a href="../Login/login.jsp" class="apply-now-btn">Login</a>
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
                                
                                   
                                    <ul>
                                               <li class="active"><a href="../Login/home.jsp">Home</a>
                                        
                                      
                                        <li><a href="#">Product Services</a>
                                            <ul>
                                                <li><a href="product.jsp">Add Product</a></li>
                                                <li><a href="manageadminproduct.jsp">Admin Manage Product</a></li>
                                               <li><a href="viewproductbuyers.jsp">Display Product Users</a></li>
                                            
                                            </ul>
                                        </li>
                                       <li><a href="../Login/home.jsp">Back</a></li>
                                        
                                       
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
                <h2 class="sidebar-title">Manage Product </h2>
                <div class="registration-details-area inner-page-padding">
                         <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">   
                                                       
         <form id="formProduct" name="formProduct">
					
					Product Name: <input id="productName" name="productName" type="text" class="form-control form-control-sm"> <br> 
					
					Add ItemCode:<input id="productItemcode" name="productItemcode" type="text" class="form-control form-control-sm"> <br> 		
					Price:<input id="productPrice" name="productPrice" type="text" class="form-control form-control-sm"> <br> 		
					Stock:<input id="productStock" name="productStock" type="text" class="form-control form-control-sm"> <br> 		
					Product Description:<textarea id="productDescription" name="productDescription" class="form-control form-control-sm" rows="4" cols="50"></textarea> <br>
					Your Registration Id*:<input id="researcherID" name="researcherID" type="text" class="form-control form-control-sm"> <br> 		
					Credit/debit embled:<textarea id="embledCode1" name="embledCode1" class="form-control form-control-sm" rows="4" cols="50"></textarea> <br>
					Paypal embled:<textarea id="embledCode2" name="embledCode2" class="form-control form-control-sm" rows="4" cols="50"></textarea> <br>
			        Deliver Time:<input id="delivertime" name="delivertime" type="text" class="form-control form-control-sm"> <br> 		
					<!-- Availability -->
 					<div class="input-group input-group-sm mb-3">
 					<div class="input-group-prepend">
 					<span class="input-group-text" id="lblName">Availability: </span>
 					</div>
 					&nbsp;&nbsp;Yes
					<input type="radio" id="rdoYes" name="availability" value="Yes">
					&nbsp;&nbsp;No
					<input type="radio" id="rdoNo" name="availability" value="No">
 					</div>
			    		<!-- Approval -->
 					<div class="input-group input-group-sm mb-3">
 					<div class="input-group-prepend">
 					<span class="input-group-text" id="lblName">Approval: </span>
 					</div>
 					&nbsp;&nbsp;Yes
					<input type="radio" id="rdoYes" name="approval" value="Yes">
					&nbsp;&nbsp;No
					<input type="radio" id="rdoNo" name="approval" value="No">
 					</div>	
				
				
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-secondary"> <input type="hidden" id="hidProductIDSave" name="hidProductIDSave" value="">
				</form>
					 <div id="alertSuccess"  class="alert alert-success"></div>
				 <div id="alertError" class="alert alert-danger"></div>
				
				</div>
                                  
  </div>
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">   
  <div class="row">
 <div class="scrollWrapper">
 
   <div id="divProductsGrid">
 <%
 Product productObj = new Product();
  out.print(productObj.readProduct());
 %>
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
    
    <!-- Meanmenu Js -->
    <script src="Components/Other/jquery.meanmenu.min.js" type="text/javascript"></script>

    <!-- Custom Js -->
    <script src="Components/Other/main.js" type="text/javascript"></script>
	
</body>






</html>  
           
           
