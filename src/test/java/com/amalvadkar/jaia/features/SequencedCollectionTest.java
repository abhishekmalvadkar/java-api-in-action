package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amalvadkar.jaia.common.FeatureName.SEQUENCED_COLLECTION;
import static com.amalvadkar.jaia.common.Version.JDK_21;
import static org.assertj.core.api.Assertions.assertThat;

@Feature(name = SEQUENCED_COLLECTION, version = JDK_21)
public class SequencedCollectionTest extends AbstractFeatureUT {

    @Test
    void should_return_first_and_last_element_from_list() {
        List<Integer> employeeIds = List.of(2, 5, 7, 3);

        assertThat(employeeIds.getFirst()).isEqualTo(2);
        assertThat(employeeIds.getLast()).isEqualTo(3);
    }
}
