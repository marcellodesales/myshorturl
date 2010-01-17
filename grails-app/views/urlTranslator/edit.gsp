
<%@ page import="info.marcellodesales.myshorturl.UrlTranslator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'urlTranslator.label', default: 'UrlTranslator')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${urlTranslatorInstance}">
            <div class="errors">
                <g:renderErrors bean="${urlTranslatorInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${urlTranslatorInstance?.id}" />
                <g:hiddenField name="version" value="${urlTranslatorInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="url"><g:message code="urlTranslator.url.label" default="Url" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: urlTranslatorInstance, field: 'url', 'errors')}">
                                    <g:textField name="url" value="${urlTranslatorInstance?.url}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="key"><g:message code="urlTranslator.key.label" default="Key" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: urlTranslatorInstance, field: 'key', 'errors')}">
                                    <g:textField name="key" value="${urlTranslatorInstance?.key}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
