package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.SetInterface;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.amalvadkar.jaia.common.SetMethod.add;
import static com.amalvadkar.jaia.common.SetMethod.addAll;
import static org.assertj.core.api.Assertions.assertThat;

public class SetTest extends AbstractApiUT {
    @Test
    @SetInterface(method = add)
    void should_not_take_duplicate_long_type_of_values_when_adding_one_by_one() {
        Set<Long> patientIds = new HashSet<>();
        patientIds.add(1L);
        patientIds.add(2L);
        patientIds.add(3L);
        patientIds.add(1L);
        assertThat(patientIds).hasSize(3);
    }

    @Test
    @SetInterface(method = addAll)
    void should_not_take_duplicate_long_type_of_values_when_adding_in_bulk() {
        Set<Long> patientIdsWhoAreReadyToDischarge = new HashSet<>(Set.of(1L, 2L, 3L));
        Set<Long> patientIdsWhoParticipatedInGame = new HashSet<>(Set.of(1L, 4L, 3L));
        patientIdsWhoAreReadyToDischarge.addAll(patientIdsWhoParticipatedInGame);
        assertThat(patientIdsWhoAreReadyToDischarge).hasSize(4);
    }

    @Test
    @SetInterface(method = add)
    void should_take_only_one_null_if_trying_to_multiple_null_values_in_set_because_set_cannot_have_duplicate_values() {
        Set<Long> patientIds = new HashSet<>();
        patientIds.add(1L);
        patientIds.add(2L);
        patientIds.add(null);
        patientIds.add(3L);
        patientIds.add(null);
        assertThat(patientIds).hasSize(4);
    }

    @Test
    @SetInterface(method = add)
    void should_not_take_duplicate_object_type_of_values_when_adding_one_by_one_if_override_equals_and_hashcode_based_on_content() {
        Patient abcPatient = Patient.of(1L, "abc");
        Patient cdePatient = Patient.of(2L, "cde");
        Patient duplicateAbcPatient = Patient.of(1L, "abc");

        Set<Patient> gameWinnerPatients = new HashSet<>();
        gameWinnerPatients.add(abcPatient);
        gameWinnerPatients.add(cdePatient);
        gameWinnerPatients.add(duplicateAbcPatient);

        assertThat(gameWinnerPatients).hasSize(2);
    }

    @Test
    @SetInterface(method = add)
    void should_take_duplicate_object_type_of_values_when_adding_one_by_one_if_does_not_override_equals_and_hashcode_based_on_content() {
        Hospital abcHospital = Hospital.of(1L, "abc");
        Hospital cdeHospital = Hospital.of(2L, "cde");
        Hospital duplicateAbcHospital = Hospital.of(1L, "abc");

        Set<Hospital> gameWinnerHospitals = new HashSet<>();
        gameWinnerHospitals.add(abcHospital);
        gameWinnerHospitals.add(cdeHospital);
        gameWinnerHospitals.add(duplicateAbcHospital);

        assertThat(gameWinnerHospitals).hasSize(3);
        
    }

}
record Patient(Long id, String name){
    public static Patient of(Long id, String name){
        return new Patient(id, name);
    }
}

@RequiredArgsConstructor
class Hospital{
    private final Long id;
    private final String name;
    
    public static Hospital of(Long id, String name){
        return new Hospital(id,name);
    }
}
