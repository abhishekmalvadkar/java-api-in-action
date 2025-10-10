package com.amalvadkar.jaia.util.stream;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.Api;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.amalvadkar.jaia.common.methods.CollectorsMethod.joining;
import static com.amalvadkar.jaia.common.methods.CollectorsMethod.toSet;
import static com.amalvadkar.jaia.common.methods.CollectorsMethod.toUnmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CollectorsTest extends AbstractApiUT {

    @Test
    @Api(type = Collectors.class, method = toSet)
    void should_not_take_duplicate_Long_type_of_values_when_collecting_elements_as_set() {
        List<Long> patientIds = List.of(1L, 2L, 1L);

        Set<Long> uniquePatientIds = patientIds.stream()
                .collect(Collectors.toSet());

        assertThat(uniquePatientIds).hasSize(2);
    }

    @Test
    @Api(type = Collectors.class, method = toUnmodifiableList)
    void should_return_immutable_list_and_throw_exception_if_try_to_change_it() {
        List<Long> mutablePatientIds = new ArrayList<>(List.of(1L, 2L, 3L));
        mutablePatientIds.add(4L);

        List<Long> immutablePatientIds = mutablePatientIds.stream()
                .collect(Collectors.toUnmodifiableList());

        assertThat(immutablePatientIds).hasSize(4);
        assertThatThrownBy(() -> immutablePatientIds.add(5L))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Api(type = Collectors.class, method = joining)
    void should_join_all_email_ids_from_list_without_any_separator_and_return_as_string() {
        List<String> emailsIds = List.of("abc@xyz.com", "def@xyz.com", "ghi@xyz.com");

        String joinedEmaileIdsAsString = emailsIds.stream()
                .collect(Collectors.joining());

        assertThat(joinedEmaileIdsAsString).isEqualTo("abc@xyz.comdef@xyz.comghi@xyz.com");
    }

}
