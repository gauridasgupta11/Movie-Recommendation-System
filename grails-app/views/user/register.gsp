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
    
		<li><a href="/MovieRecommender/login">Login</a></li>
		<li class="active"><a href="/MovieRecommender/register">Register</a></li>
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
		
		  
		
				<div class="border" style="margin-top:100px">
				<center>
						<h2>Register</h2>
				<g:form url="[action:'register',controller:'User']">
				
					<font style="color:#337ab7;font-family:'Lato', sans-serif;">
					<p><b>User Id : </b><input type='text' name='username'></input></p>
					<p><b>Password : </b><input type='password' name='password'></input></p>
					<p><b>Age: </b><input type='text' name='age'></input></p>
					<p><b>Occupation : </b><g:select name="occupation" from="${['administrator','artist','doctor','educator','engineer','entertainment','executive','healthcare','homemaker','lawyer','librarian','marketing','none','other','programmer','retired','salesman','scientist','student','technician','writer']}" valueMessagePrefix="occupation" /></p>
					<p><b>Gender : </b><g:select name="gender" from="${['M','F']}" valueMessagePrefix="gender" /></p>
					<p><b>Zip : </b><input type='text' name='zip'></input></p>
					<p><b>State : </b><g:select name="state" from="${['AZ','CA','FL','OH','PA','WA','VT','MA','GA','CT','SC','MN','OR','NY','TN','KY','MI','MD','TX','NC','WI','CO','IN','IA','NJ','UT','IL','VA','OK','NH','DC','NV','NE','LA','MO','KS','AK','AL','ID','ND','MS','AR','MT','NM','RI','HI','WV','ME','DE','WY','AP','SD','AE']}" valueMessagePrefix="state" /></p>
					</font>
					<g:submitButton name="Register" value="Register" style="width:100px"/>
					
				</g:form>
				
				</center>
				</div>
		
		
		
		
		</center>
	</div>
	</div>
	
	
	
</body>
</html>