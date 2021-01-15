package com.example.demo.validators;

import javax.validation.Payload;

public @interface OnlyLetters {

    String message() default "Only letters required.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
