Spring Boot with JSP pages
===========================
Technologies: Spring-Boot with WEB, JPA, JAXRS, JSP and Boostrap css/js framework.

Reference:
https://github.com/spring-projects/spring-boot/tree/v1.5.8.RELEASE/spring-boot-samples/spring-boot-sample-web-jsp


Steps
-----

1. Create Spring-Boot project using Spring-Boot Initializer with

        H2, MySql, Jpa, WEB support

2. In src/main folder create webapp folder.

   a. Inside webapp create WEB-INF/jsp and static folders

   b. You can delete static and templates folders from resources folder.
   
   c. add info for jsp files prefix, suffix in application.properties

        spring.mvc.view.prefix=/WEB-INF/jsp/
        spring.mvc.view.suffix=.jsp


3. put 
   
   \<packaging>war\</packaging>
   
   and for JSP and jstl support add additional dependencies in pom.xml

        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

4. add necessary services, controllers etc.

5. Run

    mvn spring-boot:run

       - OR -

    mvn clean package

    java -jar SpringBootJSP_2.war
