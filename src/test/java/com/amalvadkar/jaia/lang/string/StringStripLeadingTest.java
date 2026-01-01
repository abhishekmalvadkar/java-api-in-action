package com.amalvadkar.jaia.lang.string;

import com.amalvadkar.jaia.common.AbstractApiUT;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringStripLeadingTest extends AbstractApiUT {
    @Test
    void strip_should_remove_leading_spaces_whitespaces() {
        assertThat("   Hello     ".stripLeading()).isEqualTo("Hello     ");
    }

    @Test
    void strip_should_remove_leading_tabs_whitespaces() {
        assertThat("    Hello   ".stripLeading()).isEqualTo("Hello   ");
    }

    @Test
    void strip_should_remove_leading_new_lines_whitespaces() {
        assertThat("""
                
                Hello
                
                """.stripLeading()).isEqualTo("Hello\n\n");
    }
}
