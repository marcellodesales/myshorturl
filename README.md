myshorturl
==========

A Groovy on Grails application that converts a URL into a short one.

Use
========

Just use Grails and run the app.

```
$ grails run-app
```

To create a new short URL

```
http://localhost:8080/
Enter URL in the form
```

It will give a URL with the short code. Click in the link to get redirected the URL associated with a given code.

```
http://localhost:8080/LCx92d
```

Origin
========

When short URLs were very popular. This moved from Google Code.

```
 $ svn2git http://myshorturl.googlecode.com/svn --authors users.txt 
 Initialized empty Git repository in /tmp/.git/
r1 = 1405c6a48787c3e7a4b97bcf504b04433511424d (refs/remotes/svn/trunk)
	A	grails-project/test/unit/info/marcellodesales/myshorturl/UrlTranslatorTests.groovy
	A	grails-project/test/integration/UrlTranslationIntegrationTests.groovy
	A	grails-project/grails-app/i18n/messages.properties
	A	grails-project/grails-app/i18n/messages_zh_CN.properties
	A	grails-project/grails-app/i18n/messages_da.properties
	A	grails-project/grails-app/i18n/messages_ru.properties
...
...
```

Then, git split the repository to remove the upper directory.

```
$ git subtree split -P grails-project/ -b grails
Created branch 'grails'
77e3a7c3f527d9630a84bbec71942c5e082c8ee6
```

ON a new directory, just pulled the contents from only the split branch.

```
 $ git init
Initialized empty Git repository in /home/mdesales/dev/github/marcellodesales/myshorturl/.git/
mdesales@ubuntu ~/dev/github/marcellodesales/myshorturl (master #) $ git pull /tmp/ grails
remote: Counting objects: 184, done.
remote: Compressing objects: 100% (104/104), done.
remote: Total 184 (delta 46), reused 176 (delta 46)
Receiving objects: 100% (184/184), 167.89 KiB | 0 bytes/s, done.
Resolving deltas: 100% (46/46), done.
From /tmp
 * branch            grails     -> FETCH_HEAD

```

The rest is here.
