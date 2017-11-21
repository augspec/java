/**
 * 
 */
package com.aug.annotations.hibernate.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

/**
 * Chỉ dẫn trình biên dịch khi sử dụng @Table
 * 
 * @author AUG
 *
 */
@SupportedAnnotationTypes("com.aug.annotations.hibernate.Table")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class TableProcessor extends AbstractProcessor {

private Messager messager;
	
	@Override
	public void init(ProcessingEnvironment processingEnv) {
		messager = processingEnv.getMessager();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {

		for (TypeElement ann : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(ann);
			
			for (Element element : elements) {
				if (element.getKind() != ElementKind.CLASS) {
					messager.printMessage(Kind.ERROR, "@Table chỉ sử dụng cho class", element);
				}
			}
		}
		
		return true;
	}
}
