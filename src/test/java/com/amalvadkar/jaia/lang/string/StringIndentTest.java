package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringIndentTest extends AbstractApiUT {

    /*
        Heading
        List<String> subTopics

        Spring Boot Information
        =======================
        1) Introduction
        2) Actuator
        3) Configuration Properties
        4) Wrap up


     */
    @Test
    void test_indent() {
        String jsonElement = """
                "id" : 1,
                "name" : "xyz\"""";
        String json = """
                {
                %s
                }""".formatted(jsonElement.indent(5).stripTrailing());
        assertThat(json).isEqualTo("""
                {
                     "id" : 1,
                     "name" : "xyz"
                }""");
    }
}
