package info.marcellodesales.myshorturl

import info.marcellodesales.myshorturl.algorithm.URLKeyComputation;
import grails.test.*

class UrlTranslatorTests extends GrailsUnitTestCase {

    void testUrlTranslationUniqueness() {
        String url1 = "http://www.marcellodesales.com"
        String[] translation = URLKeyComputation.SINGLETON.computeUrlKeys(url1)
        
        String url2 = "http://www.marcellodesales.com"
        String[] translation2 = URLKeyComputation.SINGLETON.computeUrlKeys(url2)
        
        for (int i = 0; i < translation.length; i++) {
            assertEquals("Keys are NOT the same", translation[i], translation2[i])
        }
    }
    
    void testUrlTranslationDifferentiation() {
        String url1 = "http://www.marcellodesales.com"
        String[] translation = URLKeyComputation.SINGLETON.computeUrlKeys(url1)
        
        String url2 = "http://www.otheraddress.com"
        String[] translation2 = URLKeyComputation.SINGLETON.computeUrlKeys(url2)
        
        for (int i = 0; i < translation.length; i++) {
            assertNotSame("Keys are NOT the same", translation[i], translation2[i])
        }
    }
}
