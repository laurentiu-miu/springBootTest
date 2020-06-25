# Description
# I have a service MyServiceImpl that listen to the ApplicationReadyEvent
# In the method doStuff I run a while(true) - run forever 
# (In the original app I run a (infinite) sink that is getting data from a rest endpoint and publish it to kafka)  
# In spring boot 3.0.0 the actuator endpoint status for readiness is OUT_OF_SERVICE because the listener doesn't finish
# In spring boot 2.2.8 the actuator endpoint status for readiness is UP    

#1. Start the app with spring boot 3.0.0
mvn spring-but:run
#access the endpoint for readiness 
http://localhost:8080/.mystatus/ready
#The health is "status": "OUT_OF_SERVICE"

#2. Start the app with spring boot 2.2.8
mvn spring-but:run
#access the endpoint for readiness 
http://localhost:8080/.mystatus/ready
#The health is "status": "UP"