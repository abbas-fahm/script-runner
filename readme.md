# Build
To create the script runner, run:
mvn clean package

# Deploy
To deploy the script runner, copy the /target/scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar to the desired server

# Run
To run the script runner, use the following syntax:

java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar <PARAMETERS>

This is a valid Command:
java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar -fileName <PATH TO SCRIPT> -dbName <DATABASE> -serverName <SERVER> -userName <USER> -password <PASSWORD>

The following parameters are used:
-h
-help
-fileName
-serverName
-dbName
-userName
-password

To see the available parameters, use the following command:
java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar -h