package org.toy.til.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [IntervalController])
class IntervalControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc;

    def "Spring mockMvc TC"() {

        when:
        def results = mockMvc.perform(get('/event/focusLeave/1')
                .contentType(MediaType.APPLICATION_JSON_UTF8))

        then:
        results.andDo(MockMvcResultHandlers.print());

        and:
        results.andExpect(status().isOk());
        results.andExpect(content().string("remove focus of start point."))
    }
}
