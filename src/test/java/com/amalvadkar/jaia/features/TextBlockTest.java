package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import static com.amalvadkar.jaia.common.FeatureName.TEXT_BLOCK;
import static com.amalvadkar.jaia.common.Version.JDK_15;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = TEXT_BLOCK, version = JDK_15)
public class TextBlockTest extends AbstractFeatureUT {

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

    @Test
    void should_not_create_new_empty_line_at_the_end() {
        String emailBody = """
                Hi abc,
                
                Thank you for registration.
                
                Thanks,
                XYZ Team""";
        assertThat(emailBody).isEqualTo("Hi abc,\n\n" +
                "Thank you for registration.\n\n" +
                "Thanks,\n" +
                "XYZ Team");
    }

    @Test
    void should_take_trailing_custom_spaces_as_per_instructed_please_note_backslash_s_itself_a_space_so_count_that_as_well_along_with_your_normal_spaces() {
        String emailBody = """
                Hi abc,  \s
                
                Thank you for registration.
                
                Thanks,\s
                XYZ Team  \s
                """;
        assertThat(emailBody).isEqualTo("Hi abc,   \n\n" +
                "Thank you for registration.\n\n" +
                "Thanks, \n" +
                "XYZ Team   \n");
    }

}
