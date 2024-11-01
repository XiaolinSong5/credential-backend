This is backend app with database Dynamodb

Start docker-compose first:
at root level: docker-compose up -d

IntelliJ run config
Choose type Application

Environment variables:
#DYNAMO_ENDPOINT=dynamodb.eu-central-1.amazonaws.com;#PT_HOST=pt.ptc402.jifeline.cloud;#PT_SECURE_WSNAME=PassthroughAPI402;AWS_ACCESS_KEY_ID=localstack;AWS_REGION=eu-central-1;AWS_SECRET_ACCESS_KEY=localstack;AWS_SNS_CONNECTION_ENDPOINT=arn:aws:sns:eu-central-1:736364145277:factorit-sns-example;AWS_SNS_CONNECTOR_ENDPOINT=arn:aws:sns:eu-central-1:736364145277:Test1;AWS_SQS_CONNECTION_ENDPOINT=https://sqs.eu-central-1.amazonaws.com/736364145277/test-queue-joe;AWS_SQS_CONNECTOR_ENDPOINT=https://sqs.eu-central-1.amazonaws.com/736364145277/MyAWSPlanetSQS-1650368277022;DYNAMO_ENDPOINT=http://localhost:4566;LOG_OUTPUT_LEVEL=info;LOGGING_LEVEL_COM_JIFELINE_PT_HARVESTER=debug;PT_HOST=pt.ptc101.jifeline.cloud;PT_PORT=9090;PT_SECURE_ENABLED=true;PT_SECURE_WSNAME=PassthroughAPI101;REDIS_HOST=127.0.0.1;REDIS_PORT=6380;TABLE_NAME_SUFFIX=501

Test application:
health: http://localhost:8080/actuator
Call functionality:
http://localhost:8080/calculations
Dynamodb viewer:
http://localhost:8001/

