<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />

		<title>Movie Taste</title>	
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

		<!-- bootstrap style sheet -->
		<link rel="stylesheet" href="<g:createLinkTo dir='css' file='bootstrap.min.css'/>" />
		
		<!-- profile flip cards  -->
		<link rel="stylesheet" href="<g:createLinkTo dir='css' file='style.css'/>" />
		
		<!-- Base MasterSlider style sheet -->
		<link rel="stylesheet" href="<g:createLinkTo dir='css' file='masterslider.css'/>" />
		 
		<!-- MasterSlider Template Style -->
		<link href="<g:createLinkTo dir='css' file='ms-staff-style.css'/>" rel='stylesheet' type='text/css'>
		
		<!-- google font Lato -->
		<link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
		
		<!-- jQuery -->
		<script src="<g:createLinkTo dir='js' file='jquery-1.10.2.min.js'/>"></script>
		
		<script src="<g:createLinkTo dir='js' file='jquery.easing.min.js'/>"></script>
		
		<!-- jQuery for profile flip cards-->
		<script src="<g:createLinkTo dir='js' file='prefixfree.min.js'/>"></script>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
	.bs-example{
    	margin: 20px;
    }
    hr{
        margin: 60px 0;
    }
    
			
    
</style>
		
		<!-- Master Slider -->
		<script src="<g:createLinkTo dir='js' file='masterslider.min.js'/>"></script>
		
		<!-- Template js -->
		<script src="<g:createLinkTo dir='js' file='masterslider.staff.carousel.js'/>"></script>


		<style type="text/css">
	
		.ms-staff-carousel .ms-staff-info{
			min-height: 200px;
		}
		
		
			body {
			 
			padding-top: 70px;
			
			background : white !important;
			}

				h1
				{
					font-weight : 700 !important;
					text-shadow : none !important;
					color:#337ab7;
					font-family:'Lato', sans-serif !important;
					
					
				}					
				
				h2
				{
						color:#337ab7;
						font-family:Lato !important;
						padding-bottom:10px;
				}	
				
				.ulborder
				{
					border: dotted 1.5px #337ab7;padding-top:15px;padding-bottom:15px;
				}	
						img
						{
								box-shadow: 10px 10px 5px #B0B8B3;
						}
													
		</style>
		
	</head>

	<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="max-height:80px !important">

  <div class="container" style="float:right">
  <div class="bs-example"  style="float:right">
    <ul class="nav nav-pills dropdown-menu-right">
    <g:if test="${session.user}">
    <li><g:link controller="User" action="login">Hi,${session.user.id} </g:link></li>
    <li><g:link controller="User" action="logout">Logout</g:link></li>
     <li><g:link controller="Movie" action="userpage">My Recommendations</g:link></li>
        <li><g:link controller="Movie" action="ratingpage">Rate</g:link></li>
    </g:if>
    <g:else>
    
		<li><a href="/MovieRecommender/login">Login</a></li>
	 				 </g:else>
        <li class="active"><g:link controller="Movie" action="homepage">Top Movies</g:link></li>
        
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


		<h1 style="margin-left:1%;padding-top:20px;">Top Rated Movies</h1>

		<!-- template -->
		<div class="ms-staff-carousel">
			<!-- masterslider -->
			
			<div class="master-slider" id="masterslider">
			
			<g:each var="d" in="${data}">
			    <div class="ms-slide">
			        <img src=${d.Poster}  alt="lorem ipsum dolor sit" />  
			        <div class="ms-info">
			        	<h3>Title : ${d.Title}</h3>
			        	<h4>Release Date : ${d.Released}</h4>
			        	<p class="email">Cast : ${d.Actors}</p>
			        	<p>Plot : ${d.Plot}</p>
			        	
			        </div>     
			    </div>
			</g:each>
			 </div>
			<!-- end of masterslider -->
			<div class="ms-staff-info" id="staff-info"> </div>
		</div>
		<h1 style="margin-left:1%">Top Rated Movies By Genres</h1>
		<!-- end of template -->
		
		<div id="wrapper">
    
    <div id="content">
    <h2>Drama</h2>
    
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataDrama}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
	        
    <br>
    <h2>Documentary</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataDocumentary}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    
    <h2>Scifi</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataScifi}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    <h2>Action</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataAction}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    <h2>Children</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataChildren}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    <h2>Comedy</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataComedy}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    <h2>Thriller</h2>
	     <ul id="push" class="profiles cf ulborder" style="padding-left:8px" !important;">
	     
	            <g:each var="d" in="${dataThriller}">
	            <li>
	                <img class="pic" src="${d.Poster}" alt="Image Unavailable" />
	                <ul class="info">
	                    <li><center>Title:<br> ${d.Title}</center></li>
	                  <li><center>Release Date:<br> ${d.Released}</center></li>
	                    <li><center>Director:<br> ${d.Director}</center></li>
	                </ul>
	            </li>
	           </g:each>
	        </ul>
    <br>
    	</div>
    </div>
		
			<br>
			<br>
			
	</body>
	
	<script type="text/javascript">	
function mouse(x)
{
	var element =document.getElementById(x);
	 
	element.style.display="block";
	}

function mouseout(x)
{
	var element =document.getElementById(x);
	   
	element.style.display="none";
	}
	
	
		var slider = new MasterSlider();
		slider.setup('masterslider' , {
			loop:true,
			width:280,
			height:280,
			speed:20,
			view:'flow',
			preload:0,
			space:0,
			wheel:true
		});
		slider.control('arrows');
		slider.control('slideinfo',{insertTo:'#staff-info'});

		$('#myTab a').click(function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});

		SyntaxHighlighter.all();
		
	</script>
</html>
