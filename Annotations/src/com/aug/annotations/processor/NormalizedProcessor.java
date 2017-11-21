/**
 * 
 */
package com.aug.annotations.processor;

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
 * Xử lý cảnh báo sử dụng @Normalized trong quá trình code.
 * 
 * @author AUG
 *
 */
//Có tác dụng với @Normalized
@SupportedAnnotationTypes("com.aug.annotations.Normalized")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class NormalizedProcessor extends AbstractProcessor {

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
				if (element.getKind() != ElementKind.FIELD) {
					messager.printMessage(Kind.ERROR, "@Normalized chỉ sử dụng cho field", element);
				} else if (!element.asType().toString().equals("java.lang.String")) {
					messager.printMessage(Kind.ERROR, "@Normalized chỉ sử dụng cho kiểu trả về String", element);
				}
			}
		}
		
		return true;
	}

}
