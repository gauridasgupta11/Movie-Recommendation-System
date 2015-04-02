package movierecommender

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject

class AnalyticsController {

	def sessionFactory
	
    def index() { }
	
	def ViewerByGenre = {
		
		def session = sessionFactory.getCurrentSession()
		def query = session.createSQLQuery("select COUNT(*) as viewers, genre from ( select COUNT(data.id) as viewers, movie_data.title, movie_data.genre as genre  from data join movie_data where movie_data.id =data.id  group by movieid ) d group by genre")
		List result = query.list();
		
		def resultViewersByGenre = result.toArray()
		
		JSONArray jsonArrayThriller = new JSONArray()
		for(int i = 0; i < resultViewersByGenre.length; i++ )
		{
			Map<String, String> data1 = new HashMap<String,String>();
			data1.put( "key", resultViewersByGenre[i][1]);
			data1.put( "value",resultViewersByGenre[i][0]);
			JSONObject jsonObj = new JSONObject(data1);
				
			jsonArrayThriller.put(jsonObj)
		}
		
		JSONObject finalObject = new JSONObject();
		finalObject.put("viewer_data", jsonArrayThriller);
		
		def eshan = finalObject.toString();
		println eshan
		[data:eshan]
		
		
	}
	
}
