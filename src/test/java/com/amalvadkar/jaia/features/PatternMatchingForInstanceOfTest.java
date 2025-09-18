package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import static com.amalvadkar.jaia.common.FeatureName.PATTERN_MATCHING_FOR_INSTANCE_OF;
import static com.amalvadkar.jaia.common.Version.JDK_16;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = PATTERN_MATCHING_FOR_INSTANCE_OF, version = JDK_16)
public class PatternMatchingForInstanceOfTest extends AbstractFeatureUT {

    @Test
    void should_represent_the_explicit_type_casting_problem_from_traditional_way_of_pattern_matching_with_instance_of_operator() {
        Object value = 12;
        String result;

        if (value instanceof Integer) {
            Integer intValue = (Integer) value;
            result = "%s value is integer".formatted(intValue);
        } else {
            result = "%s value is other then integer type".formatted(value);
        }

        assertThat(result).isEqualTo("12 value is integer");
    }

    @Test
    void should_represent_better_pattern_matching_with_instance_of_feature_so_explicit_casting_is_not_required_and_implicit_casting_will_happen() {
        Object value = 12;
        String result;

        if (value instanceof Integer intValue) {
            result = "%s value is integer".formatted(intValue);
        } else {
            result = "%s value is other then integer type".formatted(value);
        }

        assertThat(result).isEqualTo("12 value is integer");
    }

}
