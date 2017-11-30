/**
 * 
 */
package com.aug.annotations.hibernate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Đánh dấu tên cột trong DB MySQL
 * 
 * @author AUG
 *
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	public String name() default "";
	public boolean allowNull() default true;
}
