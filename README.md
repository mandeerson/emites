# Java TCP 
[![Build Status](https://travis-ci.com/mandeerson/emites.svg?branch=master)](https://travis-ci.com/mandeerson/emites)

> A simple Java TCP message processing built on top of Apache Mina Framework (https://mina.apache.org/).

## Installation

```shell
$ git clone https://github.com/mandeerson/emites.git
$ cd emites
$ mvn install
```

## Application Lifecicle

- On first run, Java will setup our TCP server and Http server using the `Initializer` class
- The TCP server will be ready to receive connections at port `9090`
- The Http server will be ready to receive requests at port `4567`

```java
public class Initializer {

    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = Listener.create().start(9090);

        Spark.port(4567);
        Spark.staticFileLocation("/static");
        Spark.get("/", MetricsController.metrics(acceptor));
    }

}

```

## Run

- Run `Initializer` class
- If ports are in use, you can change in `Initializer` class
- Open browser and acess http://localhost:4567/
- Use some TCP client like PacketSender (https://packetsender.com/) to request movies
- You can use some those examples

```sh
8:Avengers
4:Cube
6:Marvel
```

## Features
- Java TCP server for handle incoming messages
- Java Http server for dashboard information
- A Scraper to request some movies from IMDB

## Images

![Dashboard](/dashboard.png?raw=true "Dashboard")