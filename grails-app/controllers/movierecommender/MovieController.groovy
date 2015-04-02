package movierecommender

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject
import org.hibernate.Query

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood
import org.apache.mahout.cf.taste.recommender.RecommendedItem
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender
import org.apache.mahout.cf.taste.similarity.UserSimilarity


class MovieController {

	def sessionFactory
	
	
    def index() { }
	
	def homepage = {
		
		def session = sessionFactory.getCurrentSession()
		def query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title FROM data join movie_data where data.movieid = movie_data.id group by data.movieid order by rating desc limit 7")
		List result = query.list();
		
		def resultTopMoviesArray = result.toArray()
		//println resultTopMoviesArray
		JSONArray jsonArray = new JSONArray() 
		for(int i=0;i<resultTopMoviesArray.length;i++)
		{
			 String movieName = resultTopMoviesArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArray.put(jsonObj)
		}
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='drama' group by data.movieid order by rating desc limit 7")
		List resultDrama = query.list();
		def resultTopMoviesDramaArray = resultDrama.toArray()
		JSONArray jsonArrayDrama = new JSONArray()
		for(int i=0;i<resultTopMoviesDramaArray.length;i++)
		{
			 String movieName = resultTopMoviesDramaArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayDrama.put(jsonObj)
		}
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='documentary' group by data.movieid order by rating desc limit 7")
		List resultDocumentary = query.list();
		def resultTopMoviesDocumentaryArray = resultDocumentary.toArray()
		JSONArray jsonArrayDocumentary = new JSONArray()
		for(int i=0;i<resultTopMoviesDocumentaryArray.length;i++)
		{
			 String movieName = resultTopMoviesDocumentaryArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayDocumentary.put(jsonObj)
		}
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='sci-fi' group by data.movieid order by rating desc limit 7")
		List resultScifi = query.list();
		def resultTopMoviesScifiArray = resultScifi.toArray()
		JSONArray jsonArrayScifi = new JSONArray()
		for(int i=0;i<resultTopMoviesScifiArray.length;i++)
		{
			 String movieName = resultTopMoviesScifiArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayScifi.put(jsonObj)
		}
		
		/**
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='film-noir' group by data.movieid order by rating desc limit 5")
		List resultFilmnoir = query.list();
		def resultTopMoviesFilmnoirArray = resultFilmnoir.toArray()
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='crime' group by data.movieid order by rating desc limit 5")
		List resultCrime = query.list();
		def resultTopMoviesCrimeArray = resultCrime.toArray()
		**/
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='action' group by data.movieid order by rating desc limit 7")
		List resultAction = query.list();
		def resultTopMoviesActionArray = resultAction.toArray()
		JSONArray jsonArrayAction = new JSONArray()
		for(int i=0;i<resultTopMoviesActionArray.length;i++)
		{
			 String movieName = resultTopMoviesActionArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayAction.put(jsonObj)
		}
		
		/**
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='animation' group by data.movieid order by rating desc limit 5")
		List resultAnimation = query.list();
		def resultTopMoviesAnimationArray = resultAnimation.toArray()
		JSONArray jsonArrayAnimation = new JSONArray()
		for(int i=0;i<resultTopMoviesAnimationArray.length;i++)
		{
			 String movieName = resultTopMoviesAnimationArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayAnimation.put(jsonObj)
		}
		**/
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='children' group by data.movieid order by rating desc limit 7")
		List resultChildren = query.list();
		def resultTopMoviesChildrenArray = resultChildren.toArray()
		JSONArray jsonArrayChildren = new JSONArray()
		for(int i=0;i<resultTopMoviesChildrenArray.length;i++)
		{
			 String movieName = resultTopMoviesChildrenArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayChildren.put(jsonObj)
		}
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='comedy' group by data.movieid order by rating desc limit 7")
		List resultComedy = query.list();
		def resultTopMoviesComedyArray = resultComedy.toArray()
		JSONArray jsonArrayComedy = new JSONArray()
		for(int i=0;i<resultTopMoviesComedyArray.length;i++)
		{
			 String movieName = resultTopMoviesComedyArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			jsonArrayComedy.put(jsonObj)
		}
		
		/**
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='fantasy' group by data.movieid order by rating desc limit 5")
		List resultFantasy = query.list();
		def resultTopMoviesFantasyArray = resultFantasy.toArray()
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='horror' group by data.movieid order by rating desc limit 5")
		List resultHorror = query.list();
		def resultTopMoviesHorrorArray = resultHorror.toArray()
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='musical' group by data.movieid order by rating desc limit 5")
		List resultMusical = query.list();
		def resultTopMoviesMusicalArray = resultMusical.toArray()
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='mystery' group by data.movieid order by rating desc limit 5")
		List resultMystery = query.list();
		def resultTopMoviesMysteryArray = resultMystery.toArray()
			
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='romance' group by data.movieid order by rating desc limit 5")
		List resultRomance = query.list();
		def resultTopMoviesRomanceArray = resultRomance.toArray()
		**/	
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='thriller' group by data.movieid order by rating desc limit 7")
		List resultThriller = query.list();
		def resultTopMoviesThrillerArray = resultThriller.toArray()
		JSONArray jsonArrayThriller = new JSONArray()
		for(int i=0;i<resultTopMoviesThrillerArray.length;i++)
		{
			 String movieName = resultTopMoviesThrillerArray[i][2].toString()
			movieName = movieName.replace(" ","+")
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			//println jsonObj
			
			jsonArrayThriller.put(jsonObj)
		}
		
		/**	
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='war' group by data.movieid order by rating desc limit 5")
		List resultWar = query.list();
		def resultTopMoviesWarArray = resultWar.toArray()
		
		query = session.createSQLQuery("SELECT AVG(data.rating) as rating, data.movieid, movie_data.title, movie_data.genre FROM data join movie_data where data.movieid = movie_data.id and movie_data.genre='western' group by data.movieid order by rating desc limit 5")
		List resultWestern = query.list();
		def resultTopMoviesWesternArray = resultWestern.toArray()
		**/
		
		//send the response to view page
		//render(view : "home", model:[data:jsonArray]);
		[data:jsonArray,dataDrama:jsonArrayDrama,dataDocumentary:jsonArrayDocumentary,dataScifi:jsonArrayScifi,dataAction:jsonArrayAction,dataChildren:jsonArrayChildren,dataComedy:jsonArrayComedy,dataThriller:jsonArrayThriller]
	}
	
	
	def userpage = {
		
		int uid  = session.user.id.toInteger()
		String uoccupation = session.user.occupation
		String uagegroup = session.user.age_group
		String ustate = session.user.state
		def selectedcriteria = params.criteria
		
		println "userid:"+uid
		
		JSONArray jsonArrayAgeGroup = new JSONArray()
		
		JSONArray jsonArrayOccupation = new JSONArray()
		JSONArray jsonArrayGeneral = new JSONArray()
		JSONArray jsonArrayItem = new JSONArray()
		def session = sessionFactory.getCurrentSession()
		
		def queryGetUser = session.createSQLQuery("select * from data where id="+uid)
		List resultGetUser = queryGetUser.list();
		def resultArrayGetUser = resultGetUser.toArray()
		println "user result"+resultArrayGetUser
		if(resultArrayGetUser.length>0)
		{
			println "inside reco"
			println "selected criteria :"+selectedcriteria
		if(selectedcriteria == 'Please Select' || selectedcriteria == null)
		{
			//Rating according to general criteria
			//def session = sessionFactory.getCurrentSession()
			println "inside reco tags eshan"
			def queryGeneral = session.createSQLQuery("select * from data")
			List resultGeneral = queryGeneral.list();
			def resultArrayGeneral = resultGeneral.toArray()
			
			BufferedWriter bwGeneral = new BufferedWriter(new FileWriter("data/ratingDataGeneral.csv"));
			String lineGeneral="";
			for(int i=0; i<resultArrayGeneral.length;i++)
			{
				//println resultArray[i][0]
				bwGeneral.write(resultArrayGeneral[i][0]+","+resultArrayGeneral[i][1]+","+resultArrayGeneral[i][2]+"\n");
				
			}
			bwGeneral.close();
			try {
				DataModel modelGeneral = new FileDataModel(new File("data/ratingDataGeneral.csv"));
				
				UserSimilarity similarityGeneral = new PearsonCorrelationSimilarity(modelGeneral);
			
				
			UserNeighborhood neighborhoodGeneral = new ThresholdUserNeighborhood(0.1, similarityGeneral, modelGeneral);
				//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
				
				UserBasedRecommender recommenderGeneral = new GenericUserBasedRecommender(modelGeneral, neighborhoodGeneral, similarityGeneral);
	
				int useridGeneral=uid
				List<RecommendedItem> recommendationsGeneral = recommenderGeneral.recommend(useridGeneral, 9);
				def arrayTempGeneral = recommendationsGeneral.toArray()
				JSONArray userRecommendationGeneral = new JSONArray(recommendationsGeneral)
				//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
				for(int k=0;k<userRecommendationGeneral.length();k++)
				{
				def tempGeneral = userRecommendationGeneral[k].toString()
				println tempGeneral
				tempGeneral = tempGeneral.substring(15, tempGeneral.length())
				
				tempGeneral = tempGeneral.replace('[', '{')
				tempGeneral = tempGeneral.replace(']', '}')
				JSONObject jsonObjGeneral = new JSONObject(tempGeneral)
				def findMovieGeneral = MovieData.findById(jsonObjGeneral.item)
				def movieNameGeneral = findMovieGeneral.title
				 movieNameGeneral = movieNameGeneral.replace(" ","+")
				def urlGeneral = "http://www.omdbapi.com/?t="+movieNameGeneral+"&y=&plot=short&r=json"
				URL objGeneral = new URL(urlGeneral)
				HttpURLConnection conGeneral = (HttpURLConnection) objGeneral.openConnection();
				conGeneral.setRequestMethod("GET");
				conGeneral.setRequestProperty("User-Agent", "Mozilla/5.0");
					BufferedReader brGeneral = new BufferedReader(
						new InputStreamReader(conGeneral.getInputStream()));
				String inputLineGeneral;
				StringBuffer responseGeneral = new StringBuffer();
		 
				while ((inputLineGeneral = brGeneral.readLine()) != null) {
					responseGeneral.append(inputLineGeneral);
				}
				JSONObject jsonObjNewGeneral = new JSONObject(responseGeneral.value.toString());
				jsonObjNewGeneral.put("Rating",jsonObjGeneral.value)
				
				//JSONObject newJsonObj = new JSONObject();
				//newJsonObj.put("Rating", jsonObj.value)
				
				println jsonObjNewGeneral
				
				jsonArrayGeneral.put(jsonObjNewGeneral)
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("There was an error.");
				e.printStackTrace();
			} catch (TasteException e) {
				// TODO Auto-generated catch block
				System.out.println("There was a taste error.");
				e.printStackTrace();
			}
		
			[data : jsonArrayGeneral,recommendationtypemessage : 'What people with a taste similar to you might suggest you']
		}
		else
		{
			
			if(selectedcriteria != null)
			{
				if( selectedcriteria == 'My Location')
				{
					def queryGeneral = session.createSQLQuery("select distinct data.id, data.movieid, data.rating from data join user where user.state ='"+ustate+"' and data.id = user.id")
					List resultGeneral = queryGeneral.list();
					def resultArrayGeneral = resultGeneral.toArray()
					println resultArrayGeneral
					BufferedWriter bwGeneral = new BufferedWriter(new FileWriter("data/ratingDataLocation.csv"));
					String lineGeneral="";
					for(int i=0; i<resultArrayGeneral.length;i++)
					{
						//println resultArray[i][0]
						bwGeneral.write(resultArrayGeneral[i][0]+","+resultArrayGeneral[i][1]+","+resultArrayGeneral[i][2]+"\n");
						
					}
					bwGeneral.close();
					try {
						DataModel modelGeneral = new FileDataModel(new File("data/ratingDataLocation.csv"));
						
						UserSimilarity similarityGeneral = new PearsonCorrelationSimilarity(modelGeneral);
					
						
					UserNeighborhood neighborhoodGeneral = new ThresholdUserNeighborhood(0.2, similarityGeneral, modelGeneral);
						//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
						
						UserBasedRecommender recommenderGeneral = new GenericUserBasedRecommender(modelGeneral, neighborhoodGeneral, similarityGeneral);
			
						int useridGeneral=uid
						List<RecommendedItem> recommendationsGeneral = recommenderGeneral.recommend(useridGeneral, 9);
						def arrayTempGeneral = recommendationsGeneral.toArray()
						JSONArray userRecommendationGeneral = new JSONArray(recommendationsGeneral)
						//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
						for(int k=0;k<userRecommendationGeneral.length();k++)
						{
						def tempGeneral = userRecommendationGeneral[k].toString()
						println tempGeneral
						tempGeneral = tempGeneral.substring(15, tempGeneral.length())
						
						tempGeneral = tempGeneral.replace('[', '{')
						tempGeneral = tempGeneral.replace(']', '}')
						JSONObject jsonObjGeneral = new JSONObject(tempGeneral)
						def findMovieGeneral = MovieData.findById(jsonObjGeneral.item)
						def movieNameGeneral = findMovieGeneral.title
						 movieNameGeneral = movieNameGeneral.replace(" ","+")
						def urlGeneral = "http://www.omdbapi.com/?t="+movieNameGeneral+"&y=&plot=short&r=json"
						URL objGeneral = new URL(urlGeneral)
						HttpURLConnection conGeneral = (HttpURLConnection) objGeneral.openConnection();
						conGeneral.setRequestMethod("GET");
						conGeneral.setRequestProperty("User-Agent", "Mozilla/5.0");
							BufferedReader brGeneral = new BufferedReader(
								new InputStreamReader(conGeneral.getInputStream()));
						String inputLineGeneral;
						StringBuffer responseGeneral = new StringBuffer();
				 
						while ((inputLineGeneral = brGeneral.readLine()) != null) {
							responseGeneral.append(inputLineGeneral);
						}
						JSONObject jsonObjNewGeneral = new JSONObject(responseGeneral.value.toString());
						jsonObjNewGeneral.put("Rating",jsonObjGeneral.value)
						
						//JSONObject newJsonObj = new JSONObject();
						//newJsonObj.put("Rating", jsonObj.value)
						
						println jsonObjNewGeneral
						
						jsonArrayGeneral.put(jsonObjNewGeneral)
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("There was an error.");
						e.printStackTrace();
					} catch (TasteException e) {
						// TODO Auto-generated catch block
						System.out.println("There was a taste error.");
						e.printStackTrace();
					}
					println "data to send:"+jsonArrayGeneral
					[data : jsonArrayGeneral,recommendationtypemessage : 'What your Neighbours might suggest you',RatingTotal:'5.0']
				}
				else
				{
				if(selectedcriteria =='My Age')
				{
					session = sessionFactory.getCurrentSession()
					def queryAgeGroup = session.createSQLQuery("select distinct data.id, data.movieid, data.rating from data join user where user.age_group ='"+uagegroup+"' and data.id = user.id")
					List resultAgeGroup = queryAgeGroup.list();
					def resultArrayAgeGroup = resultAgeGroup.toArray()
					println resultArrayAgeGroup
					BufferedWriter bwAgeGroup = new BufferedWriter(new FileWriter("data/ratingDataAge.csv"));
					String line="";
					for(int i=0; i<resultArrayAgeGroup.length;i++)
					{
						//println resultArray[i][0]
						bwAgeGroup.write(resultArrayAgeGroup[i][0]+","+resultArrayAgeGroup[i][1]+","+resultArrayAgeGroup[i][2]+"\n");
						
					}
					bwAgeGroup.close();
					try {
						DataModel modelAgeGroup = new FileDataModel(new File("data/ratingDataAge.csv"));
						
						UserSimilarity similarityAgeGroup = new PearsonCorrelationSimilarity(modelAgeGroup);
					
						
						UserNeighborhood neighborhoodAgeGroup = new ThresholdUserNeighborhood(0.2, similarityAgeGroup, modelAgeGroup);
						//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
						
						UserBasedRecommender recommenderAgeGroup = new GenericUserBasedRecommender(modelAgeGroup, neighborhoodAgeGroup, similarityAgeGroup);
			
						int useridAgeGroup=uid
						List<RecommendedItem> recommendationsAgeGroup = recommenderAgeGroup.recommend(useridAgeGroup, 9);
						def arrayTempAgeGroup = recommendationsAgeGroup.toArray()
						JSONArray userRecommendationAgeGroup = new JSONArray(recommendationsAgeGroup)
						//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
						//
						for(int i=0;i<userRecommendationAgeGroup.length();i++)
						{
						def tempageGroupAgeGroup = userRecommendationAgeGroup[i].toString()
						println tempageGroupAgeGroup
						tempageGroupAgeGroup = tempageGroupAgeGroup.substring(15, tempageGroupAgeGroup.length())
						
						tempageGroupAgeGroup = tempageGroupAgeGroup.replace('[', '{')
						tempageGroupAgeGroup = tempageGroupAgeGroup.replace(']', '}')
						JSONObject jsonObjAgeGroup = new JSONObject(tempageGroupAgeGroup)
						def findMovieAgeGroup = MovieData.findById(jsonObjAgeGroup.item)
						def movieNameAgeGroup = findMovieAgeGroup.title
						 movieNameAgeGroup = movieNameAgeGroup.replace(" ","+")
						def urlAgeGroup = "http://www.omdbapi.com/?t="+movieNameAgeGroup+"&y=&plot=short&r=json"
						URL objAgeGroup = new URL(urlAgeGroup)
						HttpURLConnection conAgeGroup = (HttpURLConnection) objAgeGroup.openConnection();
						conAgeGroup.setRequestMethod("GET");
						conAgeGroup.setRequestProperty("User-Agent", "Mozilla/5.0");
							BufferedReader brAgeGroup = new BufferedReader(
								new InputStreamReader(conAgeGroup.getInputStream()));
						String inputLineAgeGroup;
						StringBuffer responseAgeGroup = new StringBuffer();
				 
						while ((inputLineAgeGroup = brAgeGroup.readLine()) != null) {
							responseAgeGroup.append(inputLineAgeGroup);
						}
						JSONObject jsonObjNewAgeGroup = new JSONObject(responseAgeGroup.value.toString());
						jsonObjNewAgeGroup.put("Rating",jsonObjAgeGroup.value)
						
						//JSONObject newJsonObj = new JSONObject();
						//newJsonObj.put("Rating", jsonObj.value)
						
						println jsonObjNewAgeGroup
						//
						
						jsonArrayAgeGroup.put(jsonObjNewAgeGroup)
						}
					} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("There was an error.");
					e.printStackTrace();
				} catch (TasteException e) {
					// TODO Auto-generated catch block
					System.out.println("There was a taste error.");
					e.printStackTrace();
				}
				
				[data : jsonArrayAgeGroup,recommendationtypemessage : 'What people of your age group might suggest you',RatingTotal:'5.0']
				}
				
				else
				{
					if(selectedcriteria == 'My Occupation')
					{
						//Rating according to occupation
						//def session = sessionFactory.getCurrentSession()
						def queryOccupation = session.createSQLQuery("select distinct data.id, data.movieid, data.rating from data join user where user.occupation ='"+uoccupation+"' and data.id = user.id")
						List resultOccupation = queryOccupation.list();
						def resultArrayOccupation = resultOccupation.toArray()
						println resultArrayOccupation
						BufferedWriter bwOccupation = new BufferedWriter(new FileWriter("data/ratingDataOccupation.csv"));
						String lineOccupation="";
						for(int i=0; i<resultArrayOccupation.length;i++)
						{
							//println resultArray[i][0]
							bwOccupation.write(resultArrayOccupation[i][0]+","+resultArrayOccupation[i][1]+","+resultArrayOccupation[i][2]+"\n");
							
						}
						bwOccupation.close();
						try {
							DataModel modelOccupation = new FileDataModel(new File("data/ratingDataOccupation.csv"));
							
							UserSimilarity similarityOccupation = new PearsonCorrelationSimilarity(modelOccupation);
						
							
						UserNeighborhood neighborhoodOccupation = new ThresholdUserNeighborhood(0.2, similarityOccupation, modelOccupation);
							//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
							
							UserBasedRecommender recommenderOccupation = new GenericUserBasedRecommender(modelOccupation, neighborhoodOccupation, similarityOccupation);
							println "occupation userid"+uid
							int useridOccupation=uid
							List<RecommendedItem> recommendationsOccupation = recommenderOccupation.recommend(useridOccupation, 9);
							def arrayTempOccupation = recommendationsOccupation.toArray()
							JSONArray userRecommendationOccupation = new JSONArray(recommendationsOccupation)
							//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
							for(int j=0;j<userRecommendationOccupation.length();j++)
							{
							def tempOccupation = userRecommendationOccupation[j].toString()
							println "Moviename"+userRecommendationOccupation[j].toString()
							tempOccupation = tempOccupation.substring(15, tempOccupation.length())
							
							tempOccupation = tempOccupation.replace('[', '{')
							tempOccupation = tempOccupation.replace(']', '}')
							JSONObject jsonObjOccupation = new JSONObject(tempOccupation)
							def findMovieOccupation = MovieData.findById(jsonObjOccupation.item)
							def movieNameOccupation = findMovieOccupation.title
							 movieNameOccupation = movieNameOccupation.replace(" ","+")
							def urlOccupation = "http://www.omdbapi.com/?t="+movieNameOccupation+"&y=&plot=short&r=json"
							URL objOccupation = new URL(urlOccupation)
							HttpURLConnection conOccupation = (HttpURLConnection) objOccupation.openConnection();
							conOccupation.setRequestMethod("GET");
							conOccupation.setRequestProperty("User-Agent", "Mozilla/5.0");
								BufferedReader brOccupation = new BufferedReader(
									new InputStreamReader(conOccupation.getInputStream()));
							String inputLineOccupation;
							StringBuffer responseOccupation = new StringBuffer();
					 
							while ((inputLineOccupation = brOccupation.readLine()) != null) {
								responseOccupation.append(inputLineOccupation);
							}
							JSONObject jsonObjNewOccupation = new JSONObject(responseOccupation.value.toString());
							jsonObjNewOccupation.put("Rating",jsonObjOccupation.value)
							
							//JSONObject newJsonObj = new JSONObject();
							//newJsonObj.put("Rating", jsonObj.value)
							
							println jsonObjNewOccupation
							
							jsonArrayOccupation.put(jsonObjNewOccupation)
							}
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("There was an error.");
							e.printStackTrace();
						} catch (TasteException e) {
							// TODO Auto-generated catch block
							System.out.println("There was a taste error.");
							e.printStackTrace();
						}
					[data : jsonArrayOccupation,recommendationtypemessage : 'What your work mates  might suggest you',RatingTotal:'5.0']
					}
					else
					{
						if(selectedcriteria == 'Viewing History')
						{
							def queryMovieItem = session.createSQLQuery("select movieid from data where id="+uid+" order by RAND() limit 1")
							List resultMovieItem = queryMovieItem.list();
							def resultArrayMovieItem = resultMovieItem.toArray()
							println resultArrayMovieItem
							int movieId = resultArrayMovieItem[0].toString().toInteger();
							
							
							queryMovieItem = session.createSQLQuery("select title from movie_data where id="+movieId)
							List resultMovieNameItem = queryMovieItem.list();
							def resultArrayMovieNameItem = resultMovieNameItem.toArray()
							println resultArrayMovieNameItem
							String movieName = resultArrayMovieNameItem[0].toString();
							
							
							def queryItem = session.createSQLQuery("select * from data ")
							List resultItem = queryItem.list();
							def resultArrayItem = resultItem.toArray()
							
							
							BufferedWriter bwItem = new BufferedWriter(new FileWriter("data/ratingDataItem.csv"));
							String lineOccupation="";
							for(int i=0; i<resultArrayItem.length;i++)
							{
								//println resultArray[i][0]
								bwItem.write(resultArrayItem[i][0]+","+resultArrayItem[i][1]+","+resultArrayItem[i][2]+"\n");
								
							}
							bwItem.close();
							try {
								DataModel dm = new FileDataModel(new File("data/ratingDataItem.csv"));
								
								ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
								
								GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
								List<RecommendedItem>recommendations = recommender.mostSimilarItems(movieId, 7);
								
								JSONArray userRecommendationOccupation = new JSONArray(recommendations)
								//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
								for(int j=0;j<userRecommendationOccupation.length();j++)
								{
								def tempOccupation = userRecommendationOccupation[j].toString()
								println "Moviename"+userRecommendationOccupation[j].toString()
								tempOccupation = tempOccupation.substring(15, tempOccupation.length())
								
								tempOccupation = tempOccupation.replace('[', '{')
								tempOccupation = tempOccupation.replace(']', '}')
								JSONObject jsonObjOccupation = new JSONObject(tempOccupation)
								def findMovieOccupation = MovieData.findById(jsonObjOccupation.item)
								def movieNameOccupation = findMovieOccupation.title
								 movieNameOccupation = movieNameOccupation.replace(" ","+")
								def urlOccupation = "http://www.omdbapi.com/?t="+movieNameOccupation+"&y=&plot=short&r=json"
								URL objOccupation = new URL(urlOccupation)
								HttpURLConnection conOccupation = (HttpURLConnection) objOccupation.openConnection();
								conOccupation.setRequestMethod("GET");
								conOccupation.setRequestProperty("User-Agent", "Mozilla/5.0");
									BufferedReader brOccupation = new BufferedReader(
										new InputStreamReader(conOccupation.getInputStream()));
								String inputLineOccupation;
								StringBuffer responseOccupation = new StringBuffer();
						 
								while ((inputLineOccupation = brOccupation.readLine()) != null) {
									responseOccupation.append(inputLineOccupation);
								}
								JSONObject jsonObjNewOccupation = new JSONObject(responseOccupation.value.toString());
								jsonObjNewOccupation.put("Rating",jsonObjOccupation.value)
								
								//JSONObject newJsonObj = new JSONObject();
								//newJsonObj.put("Rating", jsonObj.value)
								
								println jsonObjNewOccupation
								
								jsonArrayItem.put(jsonObjNewOccupation)
								}
									
								} catch (IOException e) {
									System.out.println("There was an error.");
									e.printStackTrace();
								} catch (TasteException e) {
									System.out.println("There was a Taste Exception");
									e.printStackTrace();
								}
								String messagetemp = 'Since you rated '+movieName
								[data : jsonArrayItem,recommendationtypemessage : messagetemp,RatingTotal:'1.0']
						}
					}
				}
			  }	
			}
			else
			{
				[data:null,recommendationtypemessage:"Please rate some movies"]
			}
		
	}	
 }		
}		
		
		/**
		JSONArray jsonArrayAgeGroup = new JSONArray()
		
		JSONArray jsonArrayOccupation = new JSONArray()
		JSONArray jsonArrayGeneral = new JSONArray()
		JSONArray jsonArrayItem = new JSONArray()
		
		//def currentUser = session.user
		//String uid  = session.user.id
		//String uoccupation = session.user.occupation
		
		
		
		//Recommendation according to age group
		
		
		

			//Rating according to occupation
			//def session = sessionFactory.getCurrentSession()
			def queryOccupation = session.createSQLQuery("select distinct data.id, data.movieid, data.rating from data join user where user.occupation ='executive' and data.id = user.id")
			List resultOccupation = queryOccupation.list();
			def resultArrayOccupation = resultOccupation.toArray()
			
			BufferedWriter bwOccupation = new BufferedWriter(new FileWriter("data/ratingData.csv"));
			String lineOccupation="";
			for(int i=0; i<resultArrayOccupation.length;i++)
			{
				//println resultArray[i][0]
				bwOccupation.write(resultArrayOccupation[i][0]+","+resultArrayOccupation[i][1]+","+resultArrayOccupation[i][2]+"\n");
				
			}
			bwOccupation.close();
			try {
				DataModel modelOccupation = new FileDataModel(new File("data/ratingData.csv"));
				
				UserSimilarity similarityOccupation = new PearsonCorrelationSimilarity(modelOccupation);
			
				
			UserNeighborhood neighborhoodOccupation = new ThresholdUserNeighborhood(0.2, similarityOccupation, modelOccupation);
				//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
				
				UserBasedRecommender recommenderOccupation = new GenericUserBasedRecommender(modelOccupation, neighborhoodOccupation, similarityOccupation);
	
				int useridOccupation=298
				List<RecommendedItem> recommendationsOccupation = recommenderOccupation.recommend(useridOccupation, 7);
				def arrayTempOccupation = recommendationsOccupation.toArray()
				JSONArray userRecommendationOccupation = new JSONArray(recommendationsOccupation)
				//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
				for(int j=0;j<userRecommendationOccupation.length();j++)
				{
				def tempOccupation = userRecommendationOccupation[j].toString()
				println "Moviename"+userRecommendationOccupation[j].toString()
				tempOccupation = tempOccupation.substring(15, tempOccupation.length())
				
				tempOccupation = tempOccupation.replace('[', '{')
				tempOccupation = tempOccupation.replace(']', '}')
				JSONObject jsonObjOccupation = new JSONObject(tempOccupation)
				def findMovieOccupation = MovieData.findById(jsonObjOccupation.item)
				def movieNameOccupation = findMovieOccupation.title
				 movieNameOccupation = movieNameOccupation.replace(" ","+")
				def urlOccupation = "http://www.omdbapi.com/?t="+movieNameOccupation+"&y=&plot=short&r=json"
				URL objOccupation = new URL(urlOccupation)
				HttpURLConnection conOccupation = (HttpURLConnection) objOccupation.openConnection();
				conOccupation.setRequestMethod("GET");
				conOccupation.setRequestProperty("User-Agent", "Mozilla/5.0");
					BufferedReader brOccupation = new BufferedReader(
						new InputStreamReader(conOccupation.getInputStream()));
				String inputLineOccupation;
				StringBuffer responseOccupation = new StringBuffer();
		 
				while ((inputLineOccupation = brOccupation.readLine()) != null) {
					responseOccupation.append(inputLineOccupation);
				}
				JSONObject jsonObjNewOccupation = new JSONObject(responseOccupation.value.toString());
				jsonObjNewOccupation.put("Rating",jsonObjOccupation.value)
				
				//JSONObject newJsonObj = new JSONObject();
				//newJsonObj.put("Rating", jsonObj.value)
				
				println jsonObjNewOccupation
				
				jsonArrayOccupation.put(jsonObjNewOccupation)
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("There was an error.");
				e.printStackTrace();
			} catch (TasteException e) {
				// TODO Auto-generated catch block
				System.out.println("There was a taste error.");
				e.printStackTrace();
			}
		
		
		
		
			//Rating according to occupation
			//def session = sessionFactory.getCurrentSession()
			
		
		//item based recommendation
			def queryItem = session.createSQLQuery("select * from data")
			List resultItem = queryItem.list();
			def resultArrayItem = resultItem.toArray()
			
			BufferedWriter bwItem = new BufferedWriter(new FileWriter("data/ratingData.csv"));
			String lineItem="";
			for(int i=0; i<resultArrayItem.length;i++)
			{
				//println resultArray[i][0]
				bwItem.write(resultArrayItem[i][0]+","+resultArrayItem[i][1]+","+resultArrayItem[i][2]+"\n");
				
			}
			bwItem.close();
			try {
				DataModel modelItem = new FileDataModel(new File("data/ratingData.csv"));
				
				UserSimilarity similarityItem = new PearsonCorrelationSimilarity(modelItem);
			
				
			UserNeighborhood neighborhoodItem = new ThresholdUserNeighborhood(0.2, similarityItem, modelItem);
				//UserNeighborhood neighborhood = new NearestNUserNeighborhood(20, similarity, model);
				
				UserBasedRecommender recommenderItem = new GenericUserBasedRecommender(modelItem, neighborhoodItem, similarityItem);
	
				int useridItem=298
				List<RecommendedItem> recommendationsItem = recommenderItem.recommend(useridItem, 7);
				def arrayTempItem = recommendationsItem.toArray()
				JSONArray userRecommendationItem = new JSONArray(recommendationsItem)
				//JSONObject jsonObj = new JSONObject(JSON.parse(userRecommendation[0]));
				for(int j=0;j<userRecommendationItem.length();j++)
				{
				def tempItem = userRecommendationItem[j].toString()
				println "Moviename"+userRecommendationItem[j].toString()
				tempItem = tempItem.substring(15, tempItem.length())
				
				tempItem = tempItem.replace('[', '{')
				tempItem = tempItem.replace(']', '}')
				JSONObject jsonObjItem = new JSONObject(tempItem)
				def findMovieItem = MovieData.findById(jsonObjItem.item)
				def movieNameItem = findMovieItem.title
				 movieNameItem = movieNameItem.replace(" ","+")
				def urlItem = "http://www.omdbapi.com/?t="+movieNameItem+"&y=&plot=short&r=json"
				URL objItem = new URL(urlItem)
				HttpURLConnection conItem = (HttpURLConnection) objItem.openConnection();
				conItem.setRequestMethod("GET");
				conItem.setRequestProperty("User-Agent", "Mozilla/5.0");
					BufferedReader brItem = new BufferedReader(
						new InputStreamReader(conItem.getInputStream()));
				String inputLineItem;
				StringBuffer responseItem = new StringBuffer();
		 
				while ((inputLineItem = brItem.readLine()) != null) {
					responseItem.append(inputLineItem);
				}
				JSONObject jsonObjNewItem = new JSONObject(responseItem.value.toString());
				jsonObjNewItem.put("Rating",jsonObjItem.value)
				
				//JSONObject newJsonObj = new JSONObject();
				//newJsonObj.put("Rating", jsonObj.value)
				
				println jsonObjNewItem
				
				jsonArrayItem.put(jsonObjNewItem)
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("There was an error.");
				e.printStackTrace();
			} catch (TasteException e) {
				// TODO Auto-generated catch block
				System.out.println("There was a taste error.");
				e.printStackTrace();
			}
		
		
			
		
		[dataAgeGroup : jsonArrayAgeGroup, dataOccupation : jsonArrayOccupation, dataGeneral : jsonArrayGeneral,dataItem:jsonArrayItem]
	
	}
	**/	
		
	def ratingpage = {
		def session = sessionFactory.getCurrentSession()
		def query = session.createSQLQuery("select * from movie_data where id not in ( select movieid from data where id =109 group by movieid order by movieid asc) order by RAND() limit 1")
		List result = query.list();
		def resultArray = result.toArray()
		JSONArray jsonArray = new JSONArray()
		for(int i=0;i<resultArray.length;i++)
		{
			 String movieName = resultArray[i][1].toString()
			movieName = movieName.replace(" ","+")
			//println movieName
			def url = "http://www.omdbapi.com/?t="+movieName+"&y=&plot=short&r=json"
			URL obj = new URL(url)
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			JSONObject jsonObj = new JSONObject(response.value.toString());
			jsonObj.put("movieid", resultArray[i][0].toString())
			//println jsonObj
			jsonArray.put(jsonObj)
		}
		
		[data:jsonArray]
		
		
	}
	
	def addRating = {
		println params.rating
		println params.idHidden
		int userid = session.user.id.toInteger()
		def session  = sessionFactory.getCurrentSession()
		Query query = session.createSQLQuery("insert into  data values("+userid+","+params.idHidden.toInteger()+","+params.rating+")")
		int temp = query.executeUpdate()
		
		
		//def rating = new Data(id:session.user.id.toInteger(),movieid:params.idHidden,rating:params.rating)
		//rating.save(flush:true)
		forward controller: "Movie", action: "ratingpage"
	}
	
}
