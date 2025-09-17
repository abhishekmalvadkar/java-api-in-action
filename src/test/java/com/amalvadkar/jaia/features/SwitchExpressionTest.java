package com.amalvadkar.jaia.features;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwitchExpressionTest {

    @Test
    void should_give_wrong_output_as_bug_if_we_use_traditional_switch_statement_without_break() {
        int result;
        int input = 1;
        switch (input){
            case 1,2 :
                result = 10;
            case 3 :
                result = 20;
            default :
                result = 45;
        }
        assertThat(result).isEqualTo(45);
    }

}
