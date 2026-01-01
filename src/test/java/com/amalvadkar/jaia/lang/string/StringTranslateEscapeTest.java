package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTranslateEscapeTest extends AbstractApiUT {
    @Test
    void test_translate_escape() {
        assertThat("Hello\\nWorld".translateEscapes()).isEqualTo("""
                Hello
                World""");
        assertThat("Hello\\nWorld".translateEscapes()).isEqualTo("Hello\nWorld");
        assertThat("Hello\\tWorld".translateEscapes()).isEqualTo("Hello\tWorld");
        assertThat("C:\\\\Users\\\\Admin".translateEscapes()).isEqualTo("C:\\Users\\Admin");
        assertThat("She said: \\\"Hello\\\"".translateEscapes()).isEqualTo("She said: \"Hello\"");
    }
}
