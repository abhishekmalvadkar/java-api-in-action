package com.amalvadkar.jaia.features;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {

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

}

record Patient(Long id, String name){}
