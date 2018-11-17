package org.toy.til.controller

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class IntervalControllerTest extends Specification {
    MockMvc mvc;

    def setup() {
        mvc = MockMvcBuilders.standaloneSetup(new IntervalController()).build();
    }

    def "should pass user registration details to domain component and return 'created' status"() {

        when:
        def results = mvc.perform(get('/event/focusLeave/1')
                .contentType(MediaType.APPLICATION_JSON_UTF8))

        then:
        results.andDo(MockMvcResultHandlers.print());

        and:
        results.andExpect(status().isOk());
        results.andExpect(content().string("remove focus of start point."))
    }
}
