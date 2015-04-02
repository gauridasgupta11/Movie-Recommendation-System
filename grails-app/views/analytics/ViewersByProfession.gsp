<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Viewers By Profession</title>
        <link rel="stylesheet" href="style.css" type="text/css">
        <script src="<g:createLinkTo dir='js' file='amcharts.js'/>"></script>
        <script src="<g:createLinkTo dir='js' file='serial.js'/>"></script>
        <link rel="stylesheet" href="<g:createLinkTo dir='css' file='bootstrap.min.css'/>" />

        <script type="text/javascript">
            var chart;

            var chartData = [
                {
                	"Profession": "administrator",

                    "Registered Users": 79,
                    "color": "#FF0F00"
                },
                {
                	"Profession": "artist",

                    "Registered Users": 28,
                    "color": "#FF6600"
                },
                {
                	  "Profession": "doctor",

                      "Registered Users": 7,
                    "color": "#FF9E01"
                },
                {
                	"Profession": "educator",

                    "Registered Users": 95,
                    "color": "#FCD202"
                },
                {
                	 "Profession": "engineer",

                     "Registered Users": 67,
                    "color": "#F8FF01"
                },
                {
                	 "Profession": "entertainment",

                     "Registered Users": 18,
                    "color": "#B0DE09"
                },
                {
                	"Profession": "executive",

                    "Registered Users": 32,
                    "color": "#04D215"
                },
                {
                	"Profession": "healthcare",

                    "Registered Users": 16,
                    "color": "#0D8ECF"
                },
                {
                	"Profession": "homemaker",

                    "Registered Users": 7,
                    "color": "#0D52D1"
                },
                {
                	"Profession": "lawyer",

                    "Registered Users": 12,
                    "color": "#2A0CD0"
                },
                {

                    "Profession": "librarian",

                    "Registered Users": 51,
                    "color": "#8A0CCF"
                },
                {
                	 "Profession": "marketing",

                     "Registered Users": 26,
                    "color": "#CD0D74"
                },
                {
                	 "Profession": "none",

                     "Registered Users": 9,
                    "color": "#B0DE09"
                },
                {
                	"Profession": "other",

                    "Registered Users": 105,
                    "color": "#0D8ECF"
                },
                {
                	"Profession": "programmer",

                    "Registered Users": 66,

                    "color": "#FF0F00"
                },
                {
                	"Profession": "retired",

                    "Registered Users": 14,
                    "color": "#FCD202"
                },
                {
                	 "Profession": "salesman",

                     "Registered Users": 12,
                    "color": "#FCD202"
                },
                {
                	 "Profession": "scientist",

                     "Registered Users": 31,
                    "color": "#B0DE09"
                },
                {
                	 "Profession": "student",

                     "Registered Users": 196,
                    "color": "#0D8ECF"
                },
                {
                	"Profession": "technician",

                    "Registered Users": 27,
                    "color": "#04D215"
                },
                {
                	 "Profession": "writer",

                     "Registered Users": 45,
                    "color": "#FF6600"
                }
            ];


            AmCharts.ready(function () {
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "Profession";
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
                valueAxis.title = "Registered Users";
                valueAxis.axisAlpha = 0;
                valueAxis.gridAlpha = 0;
                chart.addValueAxis(valueAxis);

                // GRAPH
                var graph = new AmCharts.AmGraph();
                graph.valueField = "Registered Users";
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
    <h1>Viewers by Profession</h1>
    <br>
        <div id="chartdiv" style="width: 100%; height: 400px;"></div>
    </body>

</html>