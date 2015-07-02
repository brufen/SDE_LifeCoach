
Description
===========
I've implemented a basic LifeCoach service. With this service you can register Users, and after login
You can set up goals you want to reach, register measures relating to your goals and track your progress.
You can get some cheering-up quotes as well if you want.

Data layer:
The measurements, goals and user data are registered in a local database,  on which a rest-based service 
is built. There you can find another rest service as well which is an adapter for an external quote api. On 
the base of these services was built a soap service which integrates the data-sources into an unified interface.

System logic layer:
The system logic layer translates the human-style commands to method calls on the Data layer. There is two 
services, the "BusinessLogicServices" implements the actual work of the system, and the "ProcessCentricServices"
transfers the users' commands to their proper destination (if you ask for a quote, is it not necessary to call
the "BusinessLogicServices", this function may be called  directly)
The three layers are connected by SOAP. 
 
User interface:
The user interface is a basic console-application where you can give commands similar to human language 
for the System logic layer to use the granted functions. 



To set up service:
==================
1 - import LocalDBHandler,SystemLogicLayer and UserInterface to eclipse as web dynamic projects
2 - go to "SystemLogicLayer/src" then wsimport -keep http://localhost:444/ws/dataservice?wsdl
  - go to "UserInterface/src"   then wsimport -keep http://localhost:451/ws/processcentricservice?wsdl 
  
run as Java application 1 - LocalDBHandler/src/rest/ehealth/App.java 
						2 - LocalDBHandler/src/rest/quote/App.java 
						3 - LocalDBHandler/src/endpoint/DataPublisher.java 
						4 - SystemLogicLayer/src/soap/BusinessLogicServicesPublisher.java 
						5 - SystemLogicLayer/src/soap/ProcessCentricServicesPublisher.java
						5 - UserInterface/src/ConsolInterface.java

						
Try services:
=============
To try service type the following commands line by line (except in brackets):

(sign up)

	create user Chuck Norris


(login)

	login John Doe

(Set new goal:)

	goals
	goal height more than 180 cm per 20 days 2015-02-08
	goals

(add new measure:)

	measurements
	measurement height 175 cm 2015-02-09
	measurement height 176 cm 2015-02-10
	measurements

(check out the progress:)

	progress

(get a random quote:)

	quote
