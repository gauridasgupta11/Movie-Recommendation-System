package movierecommender

import groovy.sql.Sql
import groovy.sql.GroovyRowResult
import org.grails.datastore.mapping.query.Query
import org.hibernate.Session


 
class UserController {

	def sessionFactory
	
    def index() 
	{
		redirect (uri : '/')
	}
	
	def login = {
		println params.userid
		println params.password
		
		def findUser = User.findById(params.userid)
		
		println findUser.age_group
		println findUser.password
		if(findUser.password == params.password)
		{
			session.user = findUser
			println session.user
			println session.user.id 
			println session.user.occupation
			println session.user.age_group
			println session.user.state
			forward controller: "Movie", action: "userpage"
		}
		else
		{
			redirect(uri:'/login')
		}
	}
	
	def register ={
		
		println params.username
		println params.password
		println params.age
		println params.occupation
		println params.gender
		println params.zip
		println params.state
		
		String age_group="";
		if(params.age.toInteger()<=20)
		{
			age_group="1-20"
		}
		else
		{
			if(params.age.toInteger()>20 && params.age.toInteger()<=40)
			{
				age_group="20-40"
			}
			else
			{
				age_group="above 40"
			}
		}
		
		def newUser = new User(id:params.username.toInteger(),age:params.age.toInteger(),gender:params.gender,occupation:params.occupation,password:params.password,zip:params.zip.toInteger(),state:params.state,age_group:age_group,lat:'0',lon:'0')
		newUser.save(failOnError: true)
		if(!newUser.save())
		{
			redirect(uri:'/register')
		}
		else
		{
			redirect(uri:'/login')
		}
	
	}
	
	def logout = {
		session.invalidate()
		redirect(uri:'/logout')
	}
	
	
	
	
}
