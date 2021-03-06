# RARDB4 Group's She Goes Tech Java Bootcamp final work - movie review website.
This is movie review website, that lets it's users read movie reviews from other users, read basic info about movies, that have been writen the 
review about. If user is a registered he/she/nb can write reviews, rate the movies, they've seen, rate other user's reviews and comment on
them, they can look at other user's profile and therefore get inspiration choosing their next movie.
This program uses [OMDB API key](http://www.omdbapi.com/apikey.aspx) to gather information about movie and store it in internal database.

### Prerequisites

This aplication needs latest maven version installed as well as Spring Thymleaf, 
Spring Web Services (JPA), MySQLServer, Spring Security, Java JDK.
To be able to launch the app, you need to make rardb4 database with query: "CREAT DATABASE rardb4"
Also you'll need to acquire OMDB API key and store it in application.properties file.


Note! There is already added datbase in main/resources/data.sql for your conveniece, that you can use. Simply uncomment and run it 
step by step. Password to already created users account = username.

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/documentation/) -  integrated development environment  for Java.
* [Eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers) -  integrated development 
  environment  for Java.
* [Java](https://java.com/en/download/faq/develop.xml) - Dependency Management.
* [MySQLServer](https://dev.mysql.com) - Open Source SQL database management system.
* [Spring Security](https://spring.io/projects/spring-security) - Spring Security is a powerful and highly customizable
  authentication and access-control framework.
* [Spring Web Services](https://spring.io/projects/spring-ws) - Spring Web Services (Spring-WS) is a product of the Spring
  community focused on creating document-driven Web services. 
* [Spring Thymeleaf](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html) - Thymeleaf is a Java template engine for
  processing and creating HTML, XML, JavaScript, CSS, and text.
* [Bootstrap](https://getbootstrap.com/) - Bootstrap is an open source toolkit for developing with HTML, CSS, and JS.
* [OMDB API](http://www.omdbapi.com/) - The OMDb API is a RESTful web service to obtain movie information, all content and images
on the site are contributed and maintained by our users.

## Versioning

We use [GitHub](https://github.com/) for versioning. For the versions available, see the
[tags on this repository](https://github.com/AnnaSam48/rardb4). 

## Authors

* **Liene Apsalone** - *Visual side of the web page*
* **Krista Bokanova** - *Security, functionality, user service and authentication, login visualization, user and admin pages, review editing functionality, SQL queries, visual side of the web page*
* **Inna Tišina (Meškauska)**  -*Movie info gathering and showing work with API and it's response,movie info page, comment and rating value input, SQL queries, visuals on website*
* **Anna Samborska** - *Review info gathering, sorting and showing, review editting functionality, review rating data gathering, storing and showing, SQL queries, visuals on website, readme file writting*

## Acknowledgments

* **Jurijs Grabovskis** - *SGT Java 1st & 2nd group teacher and mentor and major help with this project*
* **Zanda Dāme** - *SGT project coordinator at Accenture keeping team up date with all the info and makeing sure that the team had everything they needed from technical and support side*  
* **[Accenture Latvia](https://www.accenture.com/lv-en)** - *provider of the opportunity to learn how to make this project*
* **[Riga TechGirls](http://www.rigatechgirls.org/)** - *provider of the opportunity to learn how to make this project* 
