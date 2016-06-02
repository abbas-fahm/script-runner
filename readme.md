# Build
To create the script runner, run:
<code>mvn clean package</code>

# Deploy
To deploy the script runner, copy the /target/scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar to the desired server

# Run
To run the script runner, use the following syntax:

<code>
java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar \<PARAMETERS\>
</code>

This is a valid Command:

<code>
java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar -fileName \<PATH TO SCRIPT\> -dbName \<DATABASE\> -serverName \<SERVER\> -userName \<USER\> -password \<PASSWORD\>
</code>

The following parameters are used:
-h
-help
-fileName
-serverName
-dbName
-userName
-password

To see the available parameters, use the following command:

<code>
java -jar scriptrunner-1.0-SNAPSHOT-jar-with-dependencies.jar -help
</code>