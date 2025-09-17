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

    @Test
    void should_switch_act_as_expression_instead_of_statement_so_we_will_use_early_returns_so_no_need_to_worry_about_break_which_is_possible_in_switch_expression() {
        int input = 1;
        int result = switch (input){
            case 1,2 -> 10;
            case 3   -> 20;
            default  -> 45;
        };
        assertThat(result).isEqualTo(10);
    }

}
