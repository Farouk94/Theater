# Theater
Middleware Project



1) Setup My SQL database
2) Ceate necessary tables.
3) Setup DataStore in eclipse and jboss.
4) Import the projects in eclipse
5) Import the necessay external jars.

1) Setup My SQL database :
 Download my sql database : https://dev.mysql.com/downloads/mysql/
 For more precision : https://www.youtube.com/watch?v=fwQyZz6cNGU 

2)Ceate necessary tables using the queries provided .
Go to mysql workbench and create database called mydb
artist_detail
artist
artist_events
user_registration
theater_booking
theater_seat
Please refer the provided sql queries to create and insert the data in different tables.

3)Setup DataStore in eclipse and jboss. 
In eclipse :
-Window ==> Show view ==> Data Source explorer
-Right click on database connexion and hit new then you can create a new connexion following the instructions


In Jboss:
-Download Jboss 7.2.1.final  : http://jbossas.jboss.org/downloads/
-Download the connector : https://dev.mysql.com/downloads/connector/j/   (we used the  5.1.40  in this project)
-Go where you saved the Jboss file . After unzipping it got to modules 
-Create file com
-Go to com and create file mysql
-Go to mysql and create file main
-Copy the connector jar file in it 
-Create an xml file called module.xml
-Copy this in it    
<?xml version="1.0" encoding="UTF-8"?>
 
<module xmlns="urn:jboss:module:1.0" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-5.1.40-bin.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
  </dependencies>
</module>
Now the module has been created, we need to make a reference to it from the main application server configuration file 
-Go where you saved the jboss file and go to Standalone/configuration/standalone.xml
-Find "drivers" element and add a new driver to it
  <driver name="mysql" module="com.mysql">
  	<driver-class>com.mysql.jdbc.Driver</driver-class>
   </driver>

-Go to bin launch add-user.bat to create a management user . folow the instructions of the script
-Now , go to the administration console
-Go to datasources , click on profil then add
-On the create DataSource window you set : 
Name : mydb
Jndi name : java:/mydb
click next : Select the mysql driver we added before 
click next : Complete your connection url: jdbc:mysql://localhost:3306/mydb
		Fill in your specific username and password
		Then hit done
-Click on your datasource and hit enable 

In case you have an issur u can go to this tutorial : https://zorq.net/b/2011/07/12/adding-a-mysql-datasource-to-jboss-as-7/

4) Import the projects in eclipse :

5)External jars : put mysql-connector-java-5.1.40-bin.jar you downloaded before on it .

6) Start the Enterprise application project:
http://localhost:8090/WebPrj/
