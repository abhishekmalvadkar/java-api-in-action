package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.SetInterface;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.amalvadkar.jaia.common.SetMethod.add;
import static com.amalvadkar.jaia.common.SetMethod.addAll;
import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
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
}
