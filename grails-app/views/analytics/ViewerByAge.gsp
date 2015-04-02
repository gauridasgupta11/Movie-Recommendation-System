<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Viewers By Age</title>
        <link rel="stylesheet" href="style.css" type="text/css">
       <script src="<g:createLinkTo dir='js' file='amcharts.js'/>"></script>
        <script src="<g:createLinkTo dir='js' file='pie.js'/>"></script>
        <link rel="stylesheet" href="<g:createLinkTo dir='css' file='bootstrap.min.css'/>" />
        <script type="text/javascript">
            var chart;
            var legend;

            var chartData = [
                {
                    "Age-Group": "1-20",
                    "Viewers": 109
                },
                {
                    "Age-Group": "20-40",
                    "Viewers": 562
                },
                {
                    "Age-Group": "Above 40",
                    "Viewers": 272
                }
            ];

            AmCharts.ready(function () {
                // PIE CHART
                chart = new AmCharts.AmPieChart();
                chart.dataProvider = chartData;
                chart.titleField = "Age-Group";
                chart.valueField = "Viewers";
                chart.outlineColor = "#FFFFFF";
                chart.outlineAlpha = 0.8;
                chart.outlineThickness = 2;
                chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]] Viewers</b> ([[percents]]%)</span>";
                // this makes the chart 3D
                chart.depth3D = 15;
                chart.angle = 30;

                // WRITE
                chart.write("chartdiv");
            });
        </script>
        <style>
        
			body {
			background : white !important;
			
			}
        </style>
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
    	h1
				{
					font-weight : 700 !important;
					text-shadow : none !important;
					color:#337ab7;
					font-family:'Lato', sans-serif !important;
					
					
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
<br><br><br><br>
    <span><h1>Viewers by Age Group</h1></span>
    <br>
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
    </body>

</html>