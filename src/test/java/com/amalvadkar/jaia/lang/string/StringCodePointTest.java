package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.toHexString;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCodePointTest extends AbstractApiUT {
    @Test
    void test_code_point_at() {
        String data = "abd";

        assertThat(data.codePointAt(0)).isEqualTo(97);
        assertThat(data.codePointAt(1)).isEqualTo(98);
        assertThat(data.codePointAt(2)).isEqualTo(100);

        // https://en.wikipedia.org/wiki/List_of_Unicode_characters
        assertThat("U+00%s".formatted(toHexString(data.codePointAt(0)))).isEqualTo("U+0061");

        String ae = "ऐ";
        assertThat("U+%s".formatted(toHexString(ae.codePointAt(0)))).isEqualTo("U+910");

        String m = "म";
        assertThat(m).isEqualTo("म");
    }

    @Test
    void test_code_points() {
        String data = "abd";

        assertThat(data.codePoints()).containsExactly(97,98,100);
    }
}
