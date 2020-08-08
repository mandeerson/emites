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

- On first run, Java will setup our TCP server using the `Initializer` class
- The TCP server will be ready to receive connections at port `9090`

```java
public class Initializer {

    public static void main(String[] args) throws IOException {
        Listener listener = new Listener();
        IoAcceptor start = listener.start();
        while (start.isActive()) {
            // RUN
        }
    }
}

```


## Features
- Java TCP server for handle incoming messages
- A Scraper to request movies from IMDB