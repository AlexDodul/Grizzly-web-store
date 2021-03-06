package com.github.grizzly.annotations;

import com.github.grizzly.validation.product.ProductNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductNameValidator.class)
@Documented
public @interface ValidProductName {

    String message() default "Invalid Product Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
