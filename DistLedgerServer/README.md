# DistLedgerServer

## Getting started

### Prerequisites

The server uses Java 17 and Maven >= 3.8.
To confirm that you have them installed and check their versions, you can use:

```s
javac -version
mvn -version
```

### Installation

To compile and install all modules:

```s
mvn clean install
```

## Running

To run the server with Maven, use:

```s
mvn exec:java [-Dserver.port=port] [-Dserver.qual=qual] [-Ddebug] [-Dsecondary]
```

The default arguments for the port and the qualifier are 2001 and "A", respectively. When the debug option is passed,
server execution information is printed into stderr.

## Built With

* [Maven](https://maven.apache.org/) - Build and dependency management tool;
* [gRPC](https://grpc.io/) - RPC framework.