package it.reference.website.annotations;


import it.reference.website.annotations.validators.ValuesMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValuesMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldsMatch
{
	String[] value() default {};

	String message() default "Values do not match";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface List
	{
		FieldsMatch[] value();
	}
}
