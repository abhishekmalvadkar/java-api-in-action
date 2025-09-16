package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import static com.amalvadkar.jaia.common.FeatureName.textBlock;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = textBlock)
public class TextBlockTest {

    @Test
    void should_create_email_body_with_multi_line_string_content() {
        String emailBody = """
                Hi abc,
                
                Thank you for registration.
                
                Thanks,
                XYZ Team
                """;
        assertThat(emailBody).isEqualTo("Hi abc,\n\n" +
                "Thank you for registration.\n\n" +
                "Thanks,\n" +
                "XYZ Team\n");
    }

    @Test
    void should_take_leading_space_from_the_position_of_ending_triple_double_quotes() {
        String emailBody = """
                   Hi abc,
                
                Thank you for registration.
                
                 Thanks,
                   XYZ Team
                """;
        assertThat(emailBody).isEqualTo("   Hi abc,\n\n" +
                "Thank you for registration.\n\n" +
                " Thanks,\n" +
                "   XYZ Team\n");
    }

}
