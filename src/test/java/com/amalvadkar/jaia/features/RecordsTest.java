package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

import static com.amalvadkar.jaia.common.FeatureName.RECORDS;
import static com.amalvadkar.jaia.common.Version.JDK_16;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Feature(name = RECORDS, version = JDK_16)
public class RecordsTest {

    @Test
    void should_give_to_string_method_automatically_by_record() {
        Patient xyzPatient = new Patient(1L, "XYZ");
        assertThat(xyzPatient.toString()).isEqualTo("Patient[id=1, name=XYZ]");
    }

    @Test
    void should_give_equals_and_hash_code_methods_automatically_by_record() {
        Patient xyzPatient = new Patient(1L, "XYZ");
        Patient anotherXyzPatient = new Patient(1L, "XYZ");
        Set<Patient> uniqueXyzPatients = new HashSet<>();
        uniqueXyzPatients.add(xyzPatient);
        uniqueXyzPatients.add(anotherXyzPatient);
        assertThat(uniqueXyzPatients).hasSize(1);
    }

    @Test
    void should_record_provide_getter_methods_without_traditional_get_prefix_and_we_will_call_them_accessors_instead_of_getter() {
        Patient xyzPatient = new Patient(1L, "XYZ");
        assertThat(xyzPatient.id()).isEqualTo(1);
        assertThat(xyzPatient.name()).isEqualTo("XYZ");
    }

    @Test
    void should_record_provide_canonical_constructor_means_all_argument_constructor() throws NoSuchMethodException {
        Patient xyzPatient = new Patient(1L, "XYZ");
        Constructor<?>[] declaredConstructors = xyzPatient.getClass().getDeclaredConstructors();
        assertThat(declaredConstructors).hasSize(1);
        assertThat(declaredConstructors[0].getParameterCount()).isEqualTo(2);
        assertThat(declaredConstructors[0].getParameterTypes()).containsOnly(Long.class, String.class);
    }

    @Test
    void should_record_use_compact_constructor_for_any_kind_of_pre_validation_or_transaformation_on_incoming_contrsuctor_parameter_you_cannot_use_instance_variables_in_compact_constructor_only_parameters() {
        assertThatThrownBy(() -> new Patient(0L, "XYZ"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("patient id should be greater then zro");
    }

    @Test
    void should_use_compact_constructor_for_transformation_of_incoming_constructor_parameter() {
        Patient xyzAbcPatient = new Patient(1L, "xyz abc");
        assertThat(xyzAbcPatient.name()).isEqualTo("Xyz abc");
    }

}

record Patient(Long id, String name){
    Patient {
        if (id == 0) {
            throw new RuntimeException("patient id should be greater then zro");
        }
        name = StringUtils.capitalize(name);
    }
}
