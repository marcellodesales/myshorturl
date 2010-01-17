class UrlMappings {
    static mappings = {

        "/$urlKey" (controller:"urlTranslator", action:"redirectKey")
        "/make" (controller:"urlTranslator", action:"make")

        "/$controller/$action?/$id?"{
            constraints {// apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
