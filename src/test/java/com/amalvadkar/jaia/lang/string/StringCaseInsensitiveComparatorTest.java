package com.amalvadkar.jaia.lang.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCaseInsensitiveComparatorTest {

    /*
        | String    | First letter | ASCII |
        | --------- | ------------ | ----- |
        | "banana"  | b            | 98    |
        | "APPLE"   | A            | 65    |
        | "cherry"  | c            | 99    |
        | "apple"   | a            | 97    |
        | "Avocado" | A            | 65    |

     */
    @Test
    void testSortFailsWithoutCaseInsensitive() {
        List<String> fruits = List.of("banana", "APPLE", "cherry", "apple", "Avocado");

        List<String> sortedFruits = fruits.stream()
//                .sorted()  // Case-sensitive!
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();

        assertThat(sortedFruits)
                .containsExactly("APPLE", "apple", "Avocado", "banana", "cherry");
    }

}
