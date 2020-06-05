# Spring Boot Kafka POC Getting Started

   ## Set up Kafka locally
>  ### Download Kafka binaries
>   - Create a directory named Apache under C:\FAST and extract contents of the above zip file.
> 
>   ### Setup environment variables
>    - Ensure JAVA_HOME is configured with JDK 1.8+ and the PATH variable is updated. 

   ## Start Zookeeper
>   Kafka uses ZooKeeper to manage the cluster. ZooKeeper is used to coordinate the brokers/cluster topology.
>     
>   Open Command Prompt:    
>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>   - Run  `bin\windows\zookeeper-server-start.bat config\zookeeper.properties` to start the Zookeeper.

   ## Start Kafka Server
>   
>   Open a second Command Prompt:
>   
>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>   - Run `bin\windows\kafka-server-start.bat config\server.properties` to start the Kafka Server.

   ## Create Kafka Topic
>   A Topic is a category/feed name to which messages are stored and published. Messages are byte arrays that can store any object in any format. All Kafka messages are organized into topics
>
>   Open a third Command Prompt:
>   
>    ### Creating a topic for String Message's
>>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>>   - Run `bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test` which will create 'test' topic.
>>    ![Kafka Topic Creation](image/Kafka_topic_creation.JPG)
>
>    ### Creating second topic for User type message (JSON)
>>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>>   - Run `bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic jsontest` which will create 'jsontest' topic.
>>    ![Kafka Topic Creation](image/Kafka_topic_creation.JPG)
>
>
>   We can now see that topic if we run the list topic command:
>   
>   - Run `bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092`
>       - test
>       - jsontest

   ## Publish messages to the Kafka Topic

>   Publish messages "hello" and "hi" under topic 'test'
>
>   In third Command Prompt:
>
>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>   - Run `kafka-console-producer.bat --broker-list localhost:9092 --topic test`. This will connect to 'test' topic. 
>   - Type 'Hello' and hit Return/Enter. You have published a message to Kafka! 
>   - Type 'Hi' and hit Return/Enter. You have published a message to Kafka! 
>   - Try publishing another message...

   ## Consume messages from the Kafka Topic
   
>   Start consumer to receive message from topic.
> 
>   In fourth Command Prompt: 
>   - Run `cd D:\Apache\kafka_2.12-2.5.0` to go to the Kafka scripts directory
>   - Run `set classpath=.` This will add the Kafka java libraries in class path.
>   - Run `kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning`


## API's

| Method | Endpoint | Example Request                                                                                                                                                                  | Consumer Message                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|--------|----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | /send    | `message=This is Neeraj`                                                                                                                                                           | Consumed kafka record: ConsumerRecord(topic = test, partition = 0, leaderEpoch = 0, offset = 3, CreateTime = 1591373596067, serialized key size = -1, serialized value size = 46, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = 2020-06-05T12:13:16.019 Server :This is neeraj)<br><br><br>Consumed String message: 2020-06-05T12:13:16.019 Server :This is neeraj                                                                                                                                                                                                                                                                                                                                                                  |
| POST   | /send    | `{"address":{"line1":"Line One","line2":"Line One","city":"Tampa","state":"Florida","country":"US"},"fname":"Neeraj","lname":"Singh"}` | Consumed kafka record: ConsumerRecord(topic = jsontest, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1591374740486, serialized key size = -1, serialized value size = 128, headers = RecordHeaders(headers = [RecordHeader(key = __TypeId__, value = [99, 111, 109, 46, 110, 101, 101, 114, 97, 106, 46, 112, 111, 99, 46, 107, 97, 102, 107, 97, 46, 109, 111, 100, 101, 108, 46, 85, 115, 101, 114])], isReadOnly = false), key = null, value = {"address":{"line1":"Line 1","line2":"Line 2","city":"Tampa","state":"Florida","country":"US"},"fname":"Neeraj","lname":"Singh"})<br><br><br>Consumed User message: {"address":{"line1":"Line 1","line2":"Line 2","city":"Tampa","state":"Florida","country":"US"},"fname":"Neeraj","lname":"Singh"} |
