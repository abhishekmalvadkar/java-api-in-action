package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class StringBytesTest extends AbstractApiUT {
    @Test
    void testBytes() {
        String a = "ab";
        assertThat(a.getBytes(UTF_8)).containsExactly(97, 98);

        byte[] ab = {97, 98};
        assertThat(new String(ab)).isEqualTo("ab");

        assertThat(Charset.defaultCharset()).isEqualTo(UTF_8);
        String json = """
                {
                    "id" : 1
                }
                """;
        assertThat(json.getBytes()).containsExactly(123, 10, 32, 32, 32, 32, 34, 105, 100, 34, 32, 58, 32, 49, 10, 125, 10);

        byte[] jsonBytes = {123, 10, 32, 32, 32, 32, 34, 105, 100, 34, 32, 58, 32, 49, 10, 125, 10};
        assertThat(new String(jsonBytes)).isEqualTo("""
                {
                    "id" : 1
                }
                """);
    }
}
