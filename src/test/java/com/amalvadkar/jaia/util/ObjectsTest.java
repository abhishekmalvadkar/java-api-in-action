package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.Api;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.amalvadkar.jaia.common.methods.ObjectsArtifacts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @Api(type = Objects.class, method = equals)
    void normal_equals_method_can_throw_NPE_if_one_of_is_null_but_objects_equals_will_return_false() {
        Long firstPatientId = null;
        Long anotherPatientId = 1L;

        assertThatThrownBy(() -> firstPatientId.equals(anotherPatientId))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"java.lang.Long.equals(Object)\" because \"firstPatientId\" is null");

        assertThat(Objects.equals(firstPatientId, anotherPatientId)).isFalse();
        assertThat(Objects.equals(anotherPatientId, firstPatientId)).isFalse();
    }

    @Test
    @Api(type = Objects.class, constructor = privateConstructor)
    void should_not_be_able_to_access_Objects_constructor_because_module_does_not_allowed_it() throws NoSuchMethodException {
        Class<Objects> objectsClass = Objects.class;
        Constructor<Objects> objectsClassNoArgsConstructor = objectsClass.getDeclaredConstructor();
        assertThatThrownBy(() ->   objectsClassNoArgsConstructor.setAccessible(true))
                .isInstanceOf(InaccessibleObjectException.class)
                .hasMessage("Unable to make private java.util.Objects() accessible: module java.base does not \"opens java.util\" to unnamed module @8efb846");
    }
}
