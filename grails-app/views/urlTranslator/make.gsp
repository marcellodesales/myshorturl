
<%@ page import="info.marcellodesales.myshorturl.UrlTranslator" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'urlTranslator.label', default: 'UrlTranslator')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton">Current number of URLs served: ${totalUrlsServed}</span>
        </div>
        <div class="body">
            <h1><g:message code="default.make.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:form action="translate" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="url"><g:message code="urlTranslator.url.label" default="Url" /></label>
                                </td>
                                <td valign="top" class="value">
                                    <g:textField name="url" value="" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.make.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
