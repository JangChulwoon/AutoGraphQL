package org.toy.til.groovy.mocking

import spock.lang.Specification


class Publisher {
    List<Subscriber> subscribers = []
    int messageCount = 0

    void send(String message) {
        subscribers*.receive(message)
        messageCount++
    }
}

interface Subscriber {
    void receive(String message)
}

class PublisherSpec extends Specification {
    Publisher publisher = new Publisher()
}