import info.marcellodesales.myshorturl.UrlTranslator;
import info.marcellodesales.myshorturl.algorithm.URLKeyComputation

import java.util.Random;


class UrlTranslationService {

    boolean transactional = true
    
    /**
     * @param existingUrl is a given URL
     * @return the key for an existing URL
     */
    private UrlTranslator getTranslationUrl(String existingUrl) {
        return UrlTranslator.findByUrl(existingUrl)
    }
    
    private String computeNewKeyForUrl(String newUrl) {
        String[] keyOptions = URLKeyComputation.SINGLETON.computeUrlKeys(newUrl)
        for (int i=0; i < 4; i++) {
            def trans = UrlTranslator.findByKey(keyOptions[i])
            if (trans != null) {
                continue
            } else {
                def newTranslation = new UrlTranslator(url:newUrl, key:keyOptions[i])
                newTranslation.save()
                return newTranslation.key
            }
        }
    }

    def translateUrl = { newUrl ->
        def existingTranslation = this.getTranslationUrl(newUrl)
        if (existingTranslation != null) {
            return existingTranslation.key
        } else {
            return this.computeNewKeyForUrl(newUrl)
        }
    }

    def getNumberOfUrls = {
        return UrlTranslator.count()
    }
}
