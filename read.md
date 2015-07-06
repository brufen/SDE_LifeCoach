### Life Coach Application


## Description
===========
I have implemented a basic LifeCoach service. With this service you can register Users, and after login
You can set up goals you want to reach, register measures relating to your goals and track your progress.
You can get some cheering-up quotes as well if you want.

Data layer:
The measurements, goals and user data are registered in a local database,  on which a rest-based service 
is built. There you can find another rest service as well which is an adapter for an external quote api. On 
the base of these services was built a soap service which integrates the data-sources into an unified interface.

System logic layer:
The system logic layer translates the human-style commands and strings to method calls on the Data layer. There is two 
services, the "BusinessLogicServices" implements the actual work of the system, and the "ProcessCentricServices"
transfers the users' commands to their proper destination (if you ask for a quote, is it not necessary to call
the "BusinessLogicServices", this function may be called  directly)
The three layers are connected by SOAP. 
 
User interface:
The user interface is a basic console-application where you can give commands 
for the System logic layer to use the granted functions. 

## Architecture of the Application
===============================

![]({{site.baseurl}}/http://oi57.tinypic.com/33m0dxv.jpg)

## To set up service
====================
  
1. run as Java application - LocalDBHandler/src/rest/ehealth/App.java 
2. run as Java application - LocalDBHandler/src/rest/quote/App.java 
3. run as Java application - LocalDBHandler/src/endpoint/DataPublisher.java 
4. go to "SystemLogicLayer/src" - wsimport -keep http://localhost:444/ws/dataservice?wsdl
5  run as Java application - SystemLogicLayer/src/soap/BusinessLogicServicesPublisher.java 
6. run as Java application - SystemLogicLayer/src/soap/ProcessCentricServicesPublisher.java
7. go to "UserInterface/src" - wsimport -keep http://localhost:451/ws/processcentricservice?wsdl
8. run as Java application - UserInterface/src/ConsolInterface.java

## Service:
=========

**Process Centric Service (SOAP)**
The Process Centril Service connects all the other services.When registered, users can set goals, read created goals, 
create new goals and update existing goals by adding new datapoints.

The service analizes the new information added by users, if a goal is not on the right track, it tries to motivate the user by showing a motivational quote.

Open a program which allows you to write explicit HTTP POST requests with data of the type XML(text/xml) 
(such as Postman: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) 
and type http://localhost:451/ws/processcentricservice/	 in the URL field.
Content-Type: text/xml
Login user
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
        <soap:Body xmlns:m="http://processcentricservices.soap/">
                <m:login>
                        <userdata>
                                login John Doe
                        </userdata>
                </m:login>
        </soap:Body>
</soap:Envelope>

**Register user**

<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:register>
    <userdata>register user Petar Petrovic</userdata>
  </m:register>
</soap:Body>
</soap:Envelope>

**Register Goal**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:registerGoal>
    <id>1</id>
    <arg1>goal height more than 180 cm per 20 days 2015-02-08</arg1>
  </m:registerGoal>
</soap:Body>
</soap:Envelope>

**Register Measurment:**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:registerMeasurment>
    <id>1</id>
    <arg1>measurement height 175 cm 2015-06-09</arg1>
  </m:registerMeasurment>
</soap:Body>
</soap:Envelope>

**Get Progerss Information**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:getProgressInfo>
    <id>1</id>
  </m:getProgressInfo>
</soap:Body>
</soap:Envelope>

**Get Random Quote**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:getQuote>
  </m:getQuote>
</soap:Body>
</soap:Envelope>

**Read All Registered Goals**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:getGoals>
    <id>1</id>
  </m:getGoals>
</soap:Body>
</soap:Envelope>

**Read Measurements**

<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://processcentricservices.soap/">
  <m:getMeasures>
    <id>1</id>
  </m:getMeasures>
</soap:Body>
</soap:Envelope>

**Qoute**
The Motivational Phrases Service is a REST service that provides an easy interface to easily retrieve motivational quotes.

The service pulls quotes from http://www.notableandquotable.com/. The pulling is done at random.

Open a program which allows you to write explicit HTTP requests (such as Postman: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en). For each make sure you set the right HTTP method. The service has a single REST method.

Retrive a random motivational quote:
method: GET
GET http://localhost:446/QuoteAdapter/randomquote
				
How to test::
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

