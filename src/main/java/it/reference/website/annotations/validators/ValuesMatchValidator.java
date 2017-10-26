package it.reference.website.annotations.validators;

import it.reference.website.annotations.FieldsMatch;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValuesMatchValidator implements ConstraintValidator<FieldsMatch, Object>
{
   private String[] fields;
   private String errorMessage;
   
   @Override
   public void initialize(final FieldsMatch constraintAnnotation) {
      fields = constraintAnnotation.value();
      errorMessage = constraintAnnotation.message();
   }
   
   @Override
   public boolean isValid(final Object value, final ConstraintValidatorContext context) {
      if (fields.length > 0) {
         final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);
         final Object comparisonValue = beanWrapper.getPropertyValue(fields[0]);
         
         for (int i = 1; i < fields.length; i++) {
            if (!comparisonValue.equals(beanWrapper.getPropertyValue(fields[i]))) {
               context.disableDefaultConstraintViolation();
               context.buildConstraintViolationWithTemplate(errorMessage)
                      .addPropertyNode(fields[0])
                      .addConstraintViolation();
               return false;
            }
         }
      }
      
      return true;
   }
}
