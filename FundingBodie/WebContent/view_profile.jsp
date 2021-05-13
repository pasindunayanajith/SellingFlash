<html class="no-js" lang="">

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
                                    <a href="#" class="apply-now-btn">Login</a>
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
                        </div>
                    </div>
                </div>
            </div>
            <!-- Mobile Menu Area End -->
        </header>

<!-- Registration Form  -->
        <div class="registration-page-area bg-secondary">
            <div class="container">
                <h2 class="sidebar-title">View Profile</h2>
                <div class="registration-details-area inner-page-padding">
                                 <img class="avater" src="images/avater.png" alt="logo" >
                 
                    <form method="POST" enctype="multipart/form-data">     
                        <div class="row">

                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="form-group">
                                    <label class="control-label" for="first-name">Company Name: </label>
                                    <input type="text" id="user-name" class="form-control" name="Title" value="" required>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="form-group">
                                    <label class="control-label" for="first-name">Address:</label>
                                    <input type="text" id="user-name" class="form-control" name="Name" value="" required>
                                </div>
                            </div>
                           
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="form-group">
                                    <label class="control-label" for="first-name">Contact Number:</label>
                                    <input type="text" id="pass" class="form-control" name="Fblink" value="" required>
                                </div>
                            </div>                   
                            
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="form-group">
                                    <label class="control-label" for="first-name">Email:</label>
  									<input type="email" class="form-control" id="email" name="email">
                                </div>
                            </div> 
                           
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="form-group">
                                    <label class="control-label">About Your Company </label>
                                    <textarea name="Shortdes" type="text" id="address-line1" class="form-control" rows="5" ></textarea>
                                </div>
                            </div>
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                               <div class="form-group">
                             
                                <label for="pwd">Password:</label><br>
                                <input id="password" name="password" type="password" class="form-control" placeholder="Password" data-ng-model="password" data-ng-maxlength="246" required>
                            </div>                    
                            </div>
                            
                           
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="form-group">
                                    <button  class="view-all-accent-btn disabled" type="submit" name="submit">Update</button>
                                </div>
                            </div>
                        </div>
                        <br>
                       
                    </form>
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
    
    <!-- jquery-->
    <script src="Components/jquery-2.2.4.min.js" type="text/javascript"></script>
    <!-- Plugins js -->
    <script src="Components/plugins.js" type="text/javascript"></script>
    <!-- Bootstrap js -->
    <script src="Components/bootstrap.min.js" type="text/javascript"></script>
    <!-- WOW JS -->
    <script src="Components/wow.min.js"></script>
    <!-- Nivo slider js -->
    <script src="Components/jquery.nivo.slider.js" type="text/javascript"></script>
    <script src="Components/home.js" type="text/javascript"></script>
    <!-- Owl Cauosel JS -->
    <script src="Components/owl.carousel.min" type="text/javascript"></script>
    <!-- Meanmenu Js -->
    <script src="Components/jquery.meanmenu.min.js" type="text/javascript"></script>
    <!-- Srollup js -->
    <script src="Components/jquery.scrollUp.min.js" type="text/javascript"></script>
    <!-- jquery.counterup js -->
    <script src="Components/jquery.counterup.min.js"></script>
    <script src="Components/waypoints.min.js"></script>
    <!-- Countdown js -->
    <script src="Components/jquery.countdown.min.js" type="text/javascript"></script>
    <!-- Isotope js -->
    <script src="Components/isotope.pkgd.min.js" type="text/javascript"></script>
    <!-- Validator js -->
    <script src="Components/validator.min.js" type="text/javascript"></script>
    <!-- Magic Popup js -->
    <script src="Components/jquery.magnific-popup.min.js" type="text/javascript"></script>
    <!-- Custom Js -->
    <script src="Components/main.js" type="text/javascript"></script>
	<!-- Silder -->
    <script src="Components/nouislider.min.js" type="text/javascript"></script>



</body>





</html>  
           
           
