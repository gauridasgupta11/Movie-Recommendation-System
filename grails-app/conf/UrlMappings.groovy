class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		"/login"(view:"/user/login")
		"/logout"(view:"/user/logout")
		"/register"(view:"/user/register")
		"/home"(view:"/movie/homepage")
		"/viewerByGenre"(view:"/analytics/ViewerByGenre")
		"/viewerByAge"(view:"/analytics/ViewerByAge")
		"/activeViewerByAge"(view:"/analytics/ActiveViewerByAge")
		"/viewerByProfession"(view:"/analytics/ViewersByProfession")
		"/activeViewerByProfession"(view:"/analytics/ActiveViewersByProfession")
		"/ViewerByLocation"(view:"/analytics/ViewersByLocation")
	}
}
