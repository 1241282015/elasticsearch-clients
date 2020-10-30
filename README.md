# ElasticSearch Clients
## Opendistro for ES(Plugin)

By introducing the plugin, es could be easily manipulated by users. Features are 
job scheduler, alerting, SQL, Performance Analyzer and so on. 

Example to see ``src/main/java/ycl/services/Opendistro.java``


##### Reference
[Opendistro officials](https://opendistro.github.io/for-elasticsearch-docs/docs/install/plugins/#plugin-compatibility) 

[Opendistro github](https://github.com/opendistro-for-elasticsearch/sql)


## Embedded Client for ES

By creating a node with the designated cluster name, communication could be 
conducted through the node. 

Drawbacks:

- as part of cluster, the node could receive request as other nodes in the es 
cluster.
- joining in and quiting from the cluster could make a fluctuation, which causes
extra overhead of cluster.

Example to see ``src/main/java/ycl/services/ElasticEmbedded.java``

Dependencies: 
- org.elasticsearch.client:transport
- org.elasticsearch.client:elasticsearch-rest-high-level-client

transport: to provide basic connection and interaction with es server. 

high-level-client: to provide full-fledged features by taking advantage of transport dependency. It 
provides more clients for user, such as index client, cluster client, task client, snapshotClient and 
so on. 

## Client(terminal) for ES

By establishing a terminal to connect ES cluster, communication between clients 
and server could be conducted afterwards. Obviously, it is C/S architecture. 

Example to see ``src/main/java/ycl/services/ElasticTerminal.java``

