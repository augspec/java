/**
 * 
 */
package com.aug.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tạo thẻ bất kỳ Html<br/>Áp dụng cho các field khai báo trong lớp Java.
 * 
 * @author AUG
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HtmlTag {
	
	public String tagName() default "";
	
	public String style() default "";
	
	public String href() default "";
	
	public String target() default "_self";
}
