package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringStripTrailingTest extends AbstractApiUT {
    @Test
    void strip_should_remove_trailing_spaces_whitespaces() {
        assertThat("   Hello     ".stripTrailing()).isEqualTo("   Hello");
    }

    @Test
    void strip_should_remove_trailing_tabs_whitespaces() {
        assertThat("    Hello   ".stripTrailing()).isEqualTo("    Hello");
    }

    @Test
    void strip_should_remove_trailing_new_lines_whitespaces() {
        assertThat("""
                
                Hello
                
                """.stripTrailing()).isEqualTo("\nHello");
    }
}
