<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script type='text/javascript' src='https://www.google.com/jsapi'></script>
<script>
function drawStatesMap() {
        var options = {region: 'US', resolution: 'provinces'};
        var dimension = "viewers";
        $.ajax({
          url: "file:///Users/eshan/Desktop/states.json",
          dataType: "JSON"
        }).done(function(data) {
                var statesArray = [["State",dimension]];
                $.each(data.states, function() {
                    var stateitem = [this.abbrev, this[dimension]];
                    statesArray.push(stateitem);
                });
          var statesData = google.visualization.arrayToDataTable(statesArray);
          var chart = new google.visualization.GeoChart(document.getElementById('chart_div'));
          chart.draw(statesData, options);
          $("h3").append(" Sorted by  "+dimension);
        });
}
google.load('visualization', '1', {'packages': ['geochart']});
google.setOnLoadCallback(drawStatesMap);
</script>


<div id="chart_div" style="width: 900px; height: 500px;"></div>
</html>
