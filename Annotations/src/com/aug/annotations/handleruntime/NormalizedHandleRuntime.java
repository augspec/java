/**
 * 
 */
package com.aug.annotations.handleruntime;

import java.lang.reflect.Field;

import com.aug.annotations.Normalized;

/**
 * Xử lý runtime cho @Normalized
 * 
 * @author AUG
 *
 */
public class NormalizedHandleRuntime {

	/**
	 * Xử lý runtime cho các @Normalized trong class đại diện của tham số truyền vào hàm này.
	 * 
	 * @param obj là object có các field có sử dụng @Normalized
	 * @author AUG
	 */
	public void processing(Object obj) {
		if (obj == null)
			return;
		
		Class<?> clazz = obj.getClass();
		
		// Xử lý các fields
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Normalized.class)) {
				Normalized annotation = field.getAnnotation(Normalized.class);
				if (annotation == null)
					continue;
				
				field.setAccessible(true);
				
				try {
					field.set(obj, String.valueOf(field.get(obj)).replaceAll("[`~!@#$%^&*()_+-={}|\\/><.,;:'\"]", ""));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
