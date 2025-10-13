package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.Api;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.amalvadkar.jaia.common.methods.ObjectsMethod.nonNull;
import static org.assertj.core.api.Assertions.assertThat;

public class ObjectsTest extends AbstractApiUT {

    @Test
    @Api(type = Objects.class, method = nonNull)
    void should_return_true_if_patient_id_is_not_null() {
        Long patientId = 1L;

        assertThat(Objects.nonNull(patientId)).isTrue();
    }

    @Test
    @Api(type = Objects.class, method = nonNull)
    void non_null_method_introduced_in_jdk_8_to_be_used_as_predicate_to_take_advantage_of_method_reference_in_filter_method_like_below() {
        List<Long> patientIds = Arrays.asList(1L, 2L, 3L, null, 4L, null);

        List<Long> nonNullPatientIds = patientIds.stream()
                /* .filter(patientId -> patientId != null) */
                .filter(Objects::nonNull)
                .toList();

        assertThat(nonNullPatientIds).hasSize(4);
    }
}
