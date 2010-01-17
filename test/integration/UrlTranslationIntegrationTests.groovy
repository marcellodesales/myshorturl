import info.marcellodesales.myshorturl.UrlTranslator;
import grails.test.*

class UrlTranslationIntegrationTests extends GrailsUnitTestCase {

    def urlTranslationService

    def url = "http://www.marcellodesales.com"
    def key
    
    protected void setUp() {
        this.url = "http://www.marcellodesales.com"
        this.key = urlTranslationService.translateUrl(this.url)
    }
    
    protected void tearDown() {
        UrlTranslator.executeUpdate("delete from UrlTranslator")
    }
    
    void testKeyCreation() {
        def saved = UrlTranslator.findByUrl(this.url)
        assertEquals("The given URL should have been saved", this.url, saved.url)
        assertEquals("The saved key is different than the one persisted", this.key, saved.key)
        assertEquals("The number of URLS should be 1", 1, urlTranslationService.getNumberOfUrls())
    }
    
    void testRepeatedKeyCreation() {
        def sameUrl1 = "http://www.marcellodesales.com"
        def sameKey1 = urlTranslationService.translateUrl(this.url)
        
        assertEquals("The same key should have been returned for the same translation", this.key, sameKey1)
        assertEquals("The number of URLS should still be 1", 1, urlTranslationService.getNumberOfUrls())
    }
    
    void testNewCreation() {
        def differentUrl1 = "http://www.marcellodesales2.com"
        def differentKey1 = urlTranslationService.translateUrl(differentUrl1)
        def saved = UrlTranslator.findByUrl(differentUrl1)
        assertEquals("The keys persisted must be the same for new translation", differentKey1, saved.key)
        assertEquals("The number of URLS should be incremented 2", 2, urlTranslationService.getNumberOfUrls())
    }
}
