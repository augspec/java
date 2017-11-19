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
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

//Có tác dụng với @PublicFinal
@SupportedAnnotationTypes("com.aug.annotations.HtmlTag")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class HtmlTagProcessor extends AbstractProcessor {

	private Messager messager;
	
	@Override
	public void init(ProcessingEnvironment processingEnv) {
		messager = processingEnv.getMessager();
	}

	// annotations - là các Annotation chịu tác dụng của Processor này.
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		
		for (TypeElement annotation : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
			
			for (Element element : elements) {
				
				if (element.getKind() != ElementKind.FIELD) {
					messager.printMessage(Kind.ERROR, "@HtmlTag chỉ sử dụng cho field", element);
				} else {
					Set<Modifier> modifiers = element.getModifiers();
					
					if (!modifiers.contains(Modifier.PRIVATE)) {
						messager.printMessage(Kind.ERROR, "@HtmlTag chỉ sử dụng cho field private", element);
					}
				}
			}
		}
		
		return true;
	}

}
