package com.amalvadkar.jaia.features;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {

    @Test
    void should_give_to_string_method_automatically_by_record() {
        Patient xyzPatient = new Patient(1L, "XYZ");
        assertThat(xyzPatient.toString()).isEqualTo("Patient[id=1, name=XYZ]");
    }

}

record Patient(Long id, String name){}
