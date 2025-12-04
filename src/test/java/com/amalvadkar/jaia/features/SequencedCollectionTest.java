package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.amalvadkar.jaia.common.FeatureName.SEQUENCED_COLLECTION;
import static com.amalvadkar.jaia.common.Version.JDK_21;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Feature(name = SEQUENCED_COLLECTION, version = JDK_21)
public class SequencedCollectionTest extends AbstractFeatureUT {

    @Test
    void should_return_first_and_last_element_from_list() {
        List<Integer> employeeIds = List.of(2, 5, 7, 3);

        assertThat(employeeIds.getFirst()).isEqualTo(2);
        assertThat(employeeIds.getLast()).isEqualTo(3);
    }

    @Test
    void should_return_list_in_reverse() {
        List<Integer> employeeIds = List.of(2, 5, 7, 3);

        assertThat(employeeIds.reversed()).containsExactly(3, 7, 5, 2);
    }

    @Test
    void should_return_list_in_reverse_and_if_we_change_in_reversed_list_then_it_should_change_in_original_list() {
        List<Integer> employeeIds = new ArrayList<>(List.of(2, 5, 7, 3));

        List<Integer> reversedList = employeeIds.reversed();
        assertThat(reversedList).containsExactly(3, 7, 5, 2);

        reversedList.add(8);
        assertThat(employeeIds).containsExactly(8, 2, 5, 7, 3);
    }

    @Test
    void should_return_list_in_reverse_and_if_we_change_in_reversed_list_then_it_should_throw_exception_if_my_original_list_is_immutable() {
        List<Integer> employeeIds = List.of(2, 5, 7, 3);

        List<Integer> reversedList = employeeIds.reversed();
        assertThat(reversedList).containsExactly(3, 7, 5, 2);

        assertThatThrownBy(() -> reversedList.add(8))
                .isInstanceOf(UnsupportedOperationException.class);
    }




}
