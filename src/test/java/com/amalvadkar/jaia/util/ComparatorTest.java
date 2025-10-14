package com.amalvadkar.jaia.util;

import com.amalvadkar.jaia.common.AbstractApiUT;
import com.amalvadkar.jaia.common.Api;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static com.amalvadkar.jaia.common.methods.ComparatorMethod.compare;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest extends AbstractApiUT {

    public static final Comparator<Long> LONG_NATURAL_ORDER_COMPARATOR = Comparator.naturalOrder();

    @Test
    @Api(type = Comparator.class, method = compare)
    void compare_method_we_can_use_to_check_two_elements_are_same_or_not_if_it_returns_zero_to_check_this_you_can_take_any_type_of_comparator() {
        int compare = LONG_NATURAL_ORDER_COMPARATOR.compare(1L, 1L);
        assertThat(compare).isZero();
    }
}
