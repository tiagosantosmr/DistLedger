# DistLedger

A distributed ledger system built with Java and gRPC, featuring replication, gossip protocol synchronization, and vector clock-based ordering for consistent state management across multiple server replicas.

## Overview

DistLedger is a distributed system that maintains a replicated ledger across multiple server instances. It provides account management operations (create, delete, transfer, balance queries) with strong consistency guarantees through vector clocks and a gossip-based replication protocol.

## Architecture

The system consists of several modules:

- **DistLedgerServer**: The main server that maintains the ledger state and handles replication
- **User**: Client application for user operations (balance queries, account creation/deletion, transfers)
- **Admin**: Client application for administrative operations (server activation/deactivation, manual gossip triggering, ledger state inspection)
- **NamingServer**: Service discovery and registry for server lookup
- **Contract**: gRPC protocol buffer definitions for all services
- **Utils**: Shared utility classes

## Features

- **Account Management**: Create and delete accounts
- **Transfers**: Transfer funds between accounts with balance validation
- **Balance Queries**: Query account balances with vector clock-based consistency
- **Replication**: Multi-replica support with primary/secondary server roles
- **Gossip Protocol**: Automatic synchronization of ledger state across replicas
- **Vector Clocks**: Event ordering and causality tracking for distributed operations
- **Concurrency**: Support for concurrent read operations

## Prerequisites

- Java 17 (or Java 11 - requires downgrading version in POMs)
- Maven >= 3.8 (required for Java 17)

To verify your installation:

```bash
javac -version
mvn -version
```

## Installation

To compile and install all modules:

```bash
mvn clean install
```

## Usage

### Starting the Naming Server

The naming server must be started first for service discovery:

```bash
cd NamingServer
mvn exec:java
```

### Starting a DistLedger Server

Start a server instance with a port and qualifier:

```bash
cd DistLedgerServer
mvn exec:java -Dexec.args="<port> <qualifier>" [-Ddebug] [-Dsecondary]
```

- `port`: Port number (1024-49151)
- `qualifier`: Server identifier (e.g., "A", "B", "C")
- `-Ddebug`: Enable debug logging
- `-Dsecondary`: Start as a secondary (read-only) server

Example:
```bash
mvn exec:java -Dexec.args="2001 A"
```

### Running the User Client

```bash
cd User
mvn exec:java [-Ddebug]
```

The user client supports the following operations:
- `balance <userId>`: Query account balance
- `createAccount <userId>`: Create a new account
- `deleteAccount <userId>`: Delete an account (balance must be zero)
- `transferTo <from> <to> <amount>`: Transfer funds between accounts

### Running the Admin Client

```bash
cd Admin
mvn exec:java [-Ddebug]
```

The admin client supports:
- `activate`: Activate a server
- `deactivate`: Deactivate a server
- `gossip`: Manually trigger gossip synchronization
- `getLedgerState`: Retrieve the current ledger state

## How It Works

### Replication and Consistency

Each server maintains:
- **Update Log**: Pending operations waiting to be executed
- **Ledger**: Executed operations that form the current state
- **Vector Clock**: Tracks causality and ordering of operations across replicas

The **ReplicaManager** handles:
- Processing user operations and assigning vector timestamps
- Executing operations when their dependencies are satisfied
- Gossip protocol for synchronizing state with other replicas

### Gossip Protocol

Servers periodically exchange their update logs and vector timestamps through the gossip protocol. When a server receives gossip:
1. It merges incoming operations into its update log
2. Sorts operations based on vector clock ordering
3. Executes operations whose dependencies are satisfied
4. Updates its vector timestamp

## Built With

- [Maven](https://maven.apache.org/) - Build and dependency management
- [gRPC](https://grpc.io/) - RPC framework for inter-service communication
- [Protocol Buffers](https://protobuf.dev/) - Interface definition and serialization

## Contributors

- [Yassir Yassin](https://github.com/yassirscreed)
- [Tiago Santos](https://github.com/xDraGonGamer)
- [Javier Muller](https://github.com/JaviMuller)

## License

This project is open source and available for use and modification.
