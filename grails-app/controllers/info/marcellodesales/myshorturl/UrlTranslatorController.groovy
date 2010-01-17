package info.marcellodesales.myshorturl

class UrlTranslatorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [urlTranslatorInstanceList: UrlTranslator.list(params), urlTranslatorInstanceTotal: UrlTranslator.count()]
    }

    def create = {
        def urlTranslatorInstance = new UrlTranslator()
        urlTranslatorInstance.properties = params
        return [urlTranslatorInstance: urlTranslatorInstance]
    }

    def save = {
        def urlTranslatorInstance = new UrlTranslator(params)
        if (urlTranslatorInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), urlTranslatorInstance.id])}"
            redirect(action: "show", id: urlTranslatorInstance.id)
        }
        else {
            render(view: "create", model: [urlTranslatorInstance: urlTranslatorInstance])
        }
    }

    def show = {
        def urlTranslatorInstance = UrlTranslator.get(params.id)
        if (!urlTranslatorInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
            redirect(action: "list")
        }
        else {
            [urlTranslatorInstance: urlTranslatorInstance]
        }
    }

    def edit = {
        def urlTranslatorInstance = UrlTranslator.get(params.id)
        if (!urlTranslatorInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [urlTranslatorInstance: urlTranslatorInstance]
        }
    }

    def update = {
        def urlTranslatorInstance = UrlTranslator.get(params.id)
        if (urlTranslatorInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (urlTranslatorInstance.version > version) {
                    
                    urlTranslatorInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'urlTranslator.label', default: 'UrlTranslator')] as Object[], "Another user has updated this UrlTranslator while you were editing")
                    render(view: "edit", model: [urlTranslatorInstance: urlTranslatorInstance])
                    return
                }
            }
            urlTranslatorInstance.properties = params
            if (!urlTranslatorInstance.hasErrors() && urlTranslatorInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), urlTranslatorInstance.id])}"
                redirect(action: "show", id: urlTranslatorInstance.id)
            }
            else {
                render(view: "edit", model: [urlTranslatorInstance: urlTranslatorInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def urlTranslatorInstance = UrlTranslator.get(params.id)
        if (urlTranslatorInstance) {
            try {
                urlTranslatorInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'urlTranslator.label', default: 'UrlTranslator'), params.id])}"
            redirect(action: "list")
        }
    }
}
