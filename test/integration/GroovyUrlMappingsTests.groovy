class GroovyUrlMappingsTests extends grails.test.GrailsUrlMappingsTestCase {
    
    void testRedirectKeyMappings() {
        assertUrlMapping("/LR43AB", controller: "urlTranslator", action: "redirectKey") {
            urlKey = "LR43AB"
        }
    }
}