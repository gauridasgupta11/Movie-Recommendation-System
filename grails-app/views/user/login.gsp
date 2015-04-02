<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1"/>
<title>Movie Taste</title>
<!-- poster cards  -->
<style type="text/css">
.border {
    border: 1px solid #a1a1a1;
    padding: 10px 40px; 
    
    width: 500px;
    border-radius: 25px;
    box-shadow: 0px 10px 5px #848A86;
}
body {
			 
			padding-top: 90px;
			
			}
		.button {
    text-decoration: none; font: menu;
    display: inline-block; padding: 2px 8px;
    background: ButtonFace; color: ButtonText;
    border-style: solid; border-width: 2px;
    border-color: ButtonHighlight ButtonShadow ButtonShadow ButtonHighlight;
}
.button:active {
    border-color: ButtonShadow ButtonHighlight ButtonHighlight ButtonShadow;
}

.bs-example{
    	margin: 20px;
    }
    hr{
        margin: 60px 0;
    }
    
    img
						{
								box-shadow: 10px 10px 5px #B0B8B3;
						}
						
						h2
				{
						color:#337ab7 !important;
						font-family:Lato !important;
						padding-bottom:10px;
				}	
				
    
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="max-height:80px !important">

  <div class="container" style="float:right">
  <div class="bs-example"  style="float:right">
    <ul class="nav nav-pills dropdown-menu-right">
    <g:if test="${session.user}">
    <li class="active"><g:link controller="User" action="login">Hi,${session.user.id} </g:link></li>
    <li><g:link controller="User" action="logout">Logout</g:link></li>
     <li><g:link controller="Movie" action="userpage">My Recommendations</g:link></li>
        <li><g:link controller="Movie" action="ratingpage">Rate</g:link></li>
    </g:if>
    <g:else>
    
		<li class="active"><a href="/MovieRecommender/login">Login</a></li>
		<li><a href="/MovieRecommender/register">Register</a></li>
	 				 </g:else>
        <li><g:link controller="Movie" action="homepage">Top Movies</g:link></li>
        
        
        <li class="dropdown">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Analytics <b class="caret"></b></a>
            <ul class="dropdown-menu pull-right">
              <li><a href="/MovieRecommender/viewerByGenre">Viewers By Genre</a></li>
                <li><a href="/MovieRecommender/viewerByAge">Viewers By Age</a></li>
                <li><a href="/MovieRecommender/activeViewerByAge">Active Viewers By Age</a></li>
                <li><a href="/MovieRecommender/viewerByProfession">Viewers By Profession</a></li>
                <li><a href="/MovieRecommender/activeViewerByProfession">Active Viewers By Profession</a></li> 
            </ul>
        </li>
       
    </ul>
    
</div>
  </div>
</nav>

<div id="wrapper">
		<div id="content">
	
		
		<center>
		
		  
		
				<div class="border" style="margin-top:200px">
				<center>
						<h2>Login</h2>
				<g:form url="[action:'login',controller:'User']" method="POST">
				<fieldset>
					<font style="color:#337ab7;font-family:'Lato', sans-serif;">
					<p><b>User Id : </b><input type='text' name='userid'></input></p>
					<p><b>Password : </b><input type='password' name='password'></input></p>
					</font>
					<p><g:submitButton name="Login" value="Login" style="width:100px"/></p>
					</fieldset>
				</g:form>
				
				</center>
				</div>
		
		
		
		
		</center>
	</div>
	</div>
	
	
	
</body>
</html>