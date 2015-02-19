/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.validators;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Size(min=9,max=9)
@Constraint(validatedBy = CEPValidator.class)
@Documented
@Target({ANNOTATION_TYPE,FIELD, METHOD})
@Retention(RUNTIME)

public @interface CEP {
       String message() default "CEP inválido";
       String[] groups() default {};    
}


    