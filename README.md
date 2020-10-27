# ElasticSearch Clients
### Opendistro for ES(Plugin)

By introducing the plugin, es could be easily manipulated by users. Features are 
job scheduler, alerting, SQL, Performance Analyzer and so on. More to see 
[details](https://opendistro.github.io/for-elasticsearch-docs/docs/install/plugins/#plugin-compatibility)      





### Embedded Client for ES
By creating a node with the designated cluster name, communication could be 
conducted through the node. 

Drawbacks:

- as part of cluster, the node could receive request as other nodes in the es 
cluster.
- joining in and quiting from the cluster could make a fluctuation, which causes
extra overhead of cluster.



### Client for ES
By establishing a terminal to connect ES cluster, communication between clients 
and server could be conducted afterwards. Obviously, it is C/S architecture. 