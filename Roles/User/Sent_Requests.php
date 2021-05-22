<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="../../Css/mainPagesStyle.css">
        <link rel="stylesheet" href="../../Css/Header&Footer.css">
				<link rel="stylesheet" href="../../Css/User_Style/Sent_Requests.css">

        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/all.css">
        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/brands.css">
        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/fontawesome.css">
        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/regular.css">
        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/solid.css">
        <link rel="stylesheet" href="../../Css/fontawesome-free-5.14.0-web/css/v4-shims.css">

    </head>
    <body>
        <!--Start Header-->
        
        <div class="header">
            <div class="navbar">
                <div class="container">
                    <a href="My_Profile.php" target="_parent"><h1 class="fl-left">Population Census System</h1></a>
                    <ul>
						<li><a href="My_Profile.php" target="_parent">My Profile</a></li>
                        <li><a href="My_Family.php" target="_parent">My Family</a></li>
                        <li><a href="Add_new_member.php" target="_parent">Add New Member</a></li>
						<li><a href="Update_Member.php" target="_parent">Update Member</a></li>
						<li><a href="Sent_Requests.php" target="_parent">Sent Requests</a></li>

                    </ul>
                </div>
            </div>
            <div class="sign-bar">
                <div class="container">
                    <ul>
                        <li class="fl-left" >
							<a href="../../Login.php"><strong  id="login">Logout</strong></a>
							<a href="My_Profile.php" id="hi" target="_parent"><strong id="logout"><? /* php if(isset($_SESSION['username'])){echo 'Hi_' . $_SESSION['username'];}*/?>Hi_UserName </strong></a>
						</li>
                    </ul>
                </div>
            </div>
        </div>
        <!--End Header-->






 
        <!--Start Footer-->
        
        <div class="footer">
                <div class="container">
                    <span>Copyright &copy; 2021 OUR-TEAM Inc.</span>
                </div>
        </div>
        
        <!--End Footer-->
        
    </body>

</html>
