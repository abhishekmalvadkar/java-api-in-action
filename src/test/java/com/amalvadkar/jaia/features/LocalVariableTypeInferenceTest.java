package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.amalvadkar.jaia.common.FeatureName.LOCAL_VARIABLE_TYPE_INFERENCE;
import static com.amalvadkar.jaia.common.Version.JDK_10;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = LOCAL_VARIABLE_TYPE_INFERENCE, version = JDK_10)
public class LocalVariableTypeInferenceTest extends AbstractFeatureUT {

    @Test
    void should_use_var_keyword_carefully_because_it_can_break_polymorphic_behaviour_as_it_takes_the_type_from_right_hand_side_type() {
        var names = new ArrayList<String>();
        assertThat(names.getClass()).isEqualTo(ArrayList.class);
    }

}
