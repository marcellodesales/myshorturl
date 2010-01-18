class UrlMappings {
    static mappings = {

        "/$urlKey" (controller:"urlTranslator", action:"redirectKey")
        "/make" (controller:"urlTranslator", action:"make")

        "/$controller/$action?/$id?"{
            constraints {// apply constraints here
            }
        }

        "/" (controller: "urlTranslator", action:"make")
        "500"(view:'/error')
    }
}
