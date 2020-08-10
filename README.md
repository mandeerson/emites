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
- The responsible for decode String is `StringDecoder` class
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

```java
public class StringDecoder extends CumulativeProtocolDecoder {
    public static final Logger LOGGER = LoggerFactory.getLogger(StringDecoder.class);

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        final int limit = in.limit();
        if (limit > 0) {
            int initPosition = in.position();
            int remaining = limit - initPosition;
            final byte[] buffer = new byte[remaining];
            in.get(buffer, 0, remaining);

            int sizeLength = 1;
            for (int i = 0; i < buffer.length; i++) {
                byte buff = buffer[i];
                if (buff == (byte) 58) {
                    sizeLength = i;
                    break;
                }
            }
            byte[] sizeBytes = Arrays.copyOfRange(buffer, 0, sizeLength);
            int size = Integer.parseInt(new String(sizeBytes));
            if (size > remaining - sizeBytes.length - 1) {
                // Need more data
                in.position(0);
                return false;
            }

            if (size <= remaining - 2) {
                // One or more queries
                int difference = buffer.length - size - sizeBytes.length - 1;
                int startQuery = buffer.length - difference - size;
                int endQuery = buffer.length - difference;

                byte[] data = Arrays.copyOfRange(buffer, startQuery, endQuery);

                LOGGER.info("{}: << {}", session.getAttribute(Constants.LOGGER), Arrays.toString(data));

                out.write(new Search(new String(data)));
                in.position(initPosition + endQuery);
                // If has remaining bytes, process again
                return in.position() != limit;
            }
        }
        // Need more data
        return false;
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
12:Interstellar
```

- The expected output follow this pattern
```sh
32:Avengers\nAvengers: Infinity war\n
14:The Cube\nCube\n
```

## Features
- Java TCP server for handle incoming messages
- Java Http server for dashboard information
- A Scraper to request some movies from IMDB

## Images

![Dashboard](/dashboard.png?raw=true "Dashboard")