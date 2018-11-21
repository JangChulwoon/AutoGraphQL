package org.toy.til.groovy.mocking

import spock.lang.Specification


class Publisher {
    List<Subscriber> subscribers = []
    List<String> response = []
    int messageCount = 0

    void send(String message) {
        for (Subscriber subscriber : subscribers) {
            response << subscriber.receive(message)
        }
        messageCount++
    }


}

interface Subscriber {
    String receive(String message)
}

class PublisherSpec extends Specification {
    Publisher publisher = new Publisher()
    Subscriber subscriber = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2
    }

    // 주의 mocking 과 stubbing 은 같은 인터렉션이 일어남.
    // 먼저 등록된 interaction 에 후속 interaction 이 묻힘.
    // then 절에서 먼저 interaction 이 발생하기에 아래코드의 stub은 실행되지 않는다.

    // Interactions declared in a then: block are matched against before any other interactions.
    def "should send messages to all subscribers"() {
        given:
        subscriber.receive("message1") >> "ok"

        when:
        publisher.send("message1")

        then:
        subscriber.receive("message1") >> "ok"
        1 * subscriber.receive("message1")

    }
}