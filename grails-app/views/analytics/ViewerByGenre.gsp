<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Viewers By Genre</title>
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="<g:createLinkTo dir='js' file='amcharts.js'/>"></script>
        <script src="<g:createLinkTo dir='js' file='serial.js'/>"></script>
        <link rel="stylesheet" href="<g:createLinkTo dir='css' file='bootstrap.min.css'/>" />

        <script type="text/javascript">
            var chart;

            var chartData = [
                {
                    "Genre": "Action",
                    "Viewers": 7,
                    "color": "#FF0F00"
                },
                {
                    "Genre": "Adventure",
                    "Viewers": 17,
                    "color": "#FF6600"
                },
                {
                    "Genre": "Animation",
                    "Viewers": 2,
                    "color": "#FF9E01"
                },
                {
                    "Genre": "Children",
                    "Viewers": 23,
                    "color": "#FCD202"
                },
                {
                    "Genre": "Comedy",
                    "Viewers": 253,
                    "color": "#F8FF01"
                },
                {
                    "Genre": "Crime",
                    "Viewers": 38,
                    "color": "#B0DE09"
                },
                {
                    "Genre": "Drama",
                    "Viewers": 344,
                    "color": "#04D215"
                },
                {
                    "Genre": "Fantasy",
                    "Viewers": 44,
                    "color": "#0D8ECF"
                },
                {
                    "Genre": "Film-Noir",
                    "Viewers": 14,
                    "color": "#0D52D1"
                },
                {
                    "Genre": "Horror",
                    "Viewers": 73,
                    "color": "#2A0CD0"
                },
                {
                    "Genre": "Musical",
                    "Viewers": 27,
                    "color": "#8A0CCF"
                },
                {
                    "Genre": "Mystery",
                    "Viewers": 84,
                    "color": "#CD0D74"
                },
                {
                    "Genre": "Romance",
                    "Viewers": 196,
                    "color": "#B0DE09"
                },
                {
                    "Genre": "Sci-fi",
                    "Viewers": 133,
                    "color": "#0D8ECF"
                },
                {
                    "Genre": "Thriller",
                    "Viewers": 221,
                    "color": "#FF0F00"
                },
                {
                    "Genre": "Unknown",
                    "Viewers": 5,
                    "color": "#FCD202"
                },
                {
                    "Genre": "War",
                    "Viewers": 170,
                    "color": "#FCD202"
                },
                {
                    "Genre": "Western",
                    "Viewers": 14,
                    "color": "#B0DE09"
                }
            ];


            AmCharts.ready(function () {
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "Genre";
                chart.startDuration = 1;
                chart.depth3D = 50;
                chart.angle = 30;
                chart.marginRight = -45;

                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.gridAlpha = 0;
                categoryAxis.axisAlpha = 0;
                categoryAxis.gridPosition = "start";

                // value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.title = "Viewers";
                valueAxis.axisAlpha = 0;
                valueAxis.gridAlpha = 0;
                chart.addValueAxis(valueAxis);

                // GRAPH
                var graph = new AmCharts.AmGraph();
                graph.valueField = "Viewers";
                graph.colorField = "color";
                graph.balloonText = "<b>[[category]]: [[value]]</b>";
                graph.type = "column";
                graph.lineAlpha = 0.5;
                graph.lineColor = "#FFFFFF";
                graph.topRadius = 1;
                graph.fillAlphas = 0.9;
                chart.addGraph(graph);

                // CURSOR
                var chartCursor = new AmCharts.ChartCursor();
                chartCursor.cursorAlpha = 0;
                chartCursor.zoomable = false;
                chartCursor.categoryBalloonEnabled = false;
                chartCursor.valueLineEnabled = true;
                chartCursor.valueLineBalloonEnabled = true;
                chartCursor.valueLineAlpha = 1;
                chart.addChartCursor(chartCursor);

                chart.creditsPosition = "top-right";

                // WRITE
                chart.write("chartdiv");
            });
        </script>
        
         <style>
        		 h1
				{
					font-weight : 700 !important;
					text-shadow : none !important;
					color:#337ab7 !important;
					font-family:'Lato', sans-serif !important;
					
					
				}	
        
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
    <h1>Viewers by Genre</h1>
    <br>
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
    </body>

</html>