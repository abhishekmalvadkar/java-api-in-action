package com.amalvadkar.jaia.features;

import com.amalvadkar.jaia.common.AbstractFeatureUT;
import com.amalvadkar.jaia.common.Feature;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.amalvadkar.jaia.common.FeatureName.HELPFUL_NULL_POINTER_EXCEPTION;
import static com.amalvadkar.jaia.common.Version.JDK_14;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Feature(name = HELPFUL_NULL_POINTER_EXCEPTION, version = JDK_14)
public class HelpfulNullPointerExceptionsTest extends AbstractFeatureUT {

    @Test
    void should_throw_helpful_null_pointer_exception_with_message_which_will_tell_what_is_null_by_looking_at_the_message_itself_in_this_case_address_is_null() {
        List<Person> people = List.of(
                new Person(null)
        );

        assertThatThrownBy(() -> people.getFirst().address().phoneNumber().areaCode())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"com.amalvadkar.jaia.features.HelpfulNullPointerExceptionsTest$Address.phoneNumber()\" because the return value of \"com.amalvadkar.jaia.features.HelpfulNullPointerExceptionsTest$Person.address()\" is null");
    }

    @Test
    void should_throw_helpful_null_pointer_exception_with_message_which_will_tell_what_is_null_by_looking_at_the_message_itself_in_this_case_phone_number_is_null() {
        List<Person> people = List.of(
                new Person(new Address(null))
        );

        assertThatThrownBy(() -> people.getFirst().address().phoneNumber().areaCode())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"com.amalvadkar.jaia.features.HelpfulNullPointerExceptionsTest$PhoneNumber.areaCode()\" because the return value of \"com.amalvadkar.jaia.features.HelpfulNullPointerExceptionsTest$Address.phoneNumber()\" is null");
    }

    @Test
    void should_throw_helpful_null_pointer_exception_with_message_which_will_tell_what_is_null_by_looking_at_the_message_itself_in_this_case_first_value_of_list_is_null() {
        List<Person> people = new ArrayList<>();
        people.add(null);
        people.add(new Person(new Address(null)));

        assertThatThrownBy(() -> people.getFirst().address().phoneNumber().areaCode())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"com.amalvadkar.jaia.features.HelpfulNullPointerExceptionsTest$Person.address()\" because the return value of \"java.util.List.getFirst()\" is null");
    }

    public record Person(Address address){}

    public record Address(PhoneNumber phoneNumber){}

    public record PhoneNumber(int areaCode, String number){}

}
