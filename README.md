# industry-app-framework

## Platform Introduction:
***This service is committed to building a set of convenient industrial Internet development infrastructure, 
integration of the current high utilization of components, basic packaging, to facilitate the use of 
subsequent developers as their own responsibility***
## The functions currently implemented are as follows:
* 1：Access to MySQL relational database;
* 2：Access Redis non-relational database;
* 3：Access the time series database InfluxDB;
* 4：Access ActiveMQ message queue;
* 5：Access MQTT protocol message EMQ;
* 6：Access SLF4J +logback log management;
* 7：Access WebSocket communication protocol;
* 8：Visualizing the RESTful interface with Swagger Framework;

## Introduction to use:
***This system is built in the way of multi-module, and all dependent components are an independent module.
   When you need to create a Web service, just introduce the module you depend on in the POM file,
   And modify the relevant address and account in the corresponding module into the correct address and account.
   You can use the corresponding component directly by calling the API interface encapsulated in the module.***
   
## System architecture diagram
<img src="http://app-framework-images.qingdao.cosmoplat.com/images1.jpg"/>

## Demo figure
<img src="http://app-framework-images.qingdao.cosmoplat.com/1594035818208.jpg"/>
<img src="http://app-framework-images.qingdao.cosmoplat.com/1594035843023.jpg"/>
