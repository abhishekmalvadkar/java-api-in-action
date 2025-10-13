package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.Api;
import org.junit.jupiter.api.Test;

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
}
