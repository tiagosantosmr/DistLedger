# AdminClient

## Getting started

### Prerequisites

The client uses Java 17 and Maven >= 3.8.
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

To run the client with Maven, use:

```s
mvn exec:java [-Ddebug]
```

When the debug option is passed, client execution information is printed into stderr.

## Built With

* [Maven](https://maven.apache.org/) - Build and dependency management tool;
* [gRPC](https://grpc.io/) - RPC framework.
