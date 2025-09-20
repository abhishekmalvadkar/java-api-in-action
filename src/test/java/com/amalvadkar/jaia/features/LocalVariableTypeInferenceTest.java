package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.amalvadkar.jaia.common.FeatureName.LOCAL_VARIABLE_TYPE_INFERENCE;
import static com.amalvadkar.jaia.common.Version.JDK_10;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = LOCAL_VARIABLE_TYPE_INFERENCE, version = JDK_10)
public class LocalVariableTypeInferenceTest extends AbstractFeatureUT {

    @Test
    void should_use_var_keyword_carefully_because_it_can_break_polymorphic_behaviour_as_it_takes_the_type_from_right_hand_side_type() {
        var names = new ArrayList<String>();
        ArrayList<String> anotherNames = names;
    }

    @Test
    void should_var_take_the_type_from_the_return_type_of_method_which_is_called() {
        var names = names();
        List<String> anotherNames = names;
    }

    public List<String> names(){
        return new ArrayList<>();
    }

    @Test
    void should_take_care_about_generic_type_when_using_var_with_generic_types_list_list() {
        var names = new ArrayList<>();
        ArrayList<Object> anotherNames = names;

        var tickets = new ArrayList<Long>();
        ArrayList<Long> anotherTickets = tickets;
    }

    @Test
    void should_follow_this_as_developer_if_you_want_to_see_which_type_var_has_so_press_ctrl_shift_i_quick_definition_on_var_of_your_variable() {
        boolean needToReadThisTestMethodName = true;
        assertThat(needToReadThisTestMethodName).isTrue();
    }


}
