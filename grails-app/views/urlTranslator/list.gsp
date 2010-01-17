
<%@ page import="info.marcellodesales.myshorturl.UrlTranslator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'urlTranslator.label', default: 'UrlTranslator')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'urlTranslator.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="url" title="${message(code: 'urlTranslator.url.label', default: 'Url')}" />
                        
                            <g:sortableColumn property="key" title="${message(code: 'urlTranslator.key.label', default: 'Key')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${urlTranslatorInstanceList}" status="i" var="urlTranslatorInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${urlTranslatorInstance.id}">${fieldValue(bean: urlTranslatorInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: urlTranslatorInstance, field: "url")}</td>
                        
                            <td>${fieldValue(bean: urlTranslatorInstance, field: "key")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${urlTranslatorInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
