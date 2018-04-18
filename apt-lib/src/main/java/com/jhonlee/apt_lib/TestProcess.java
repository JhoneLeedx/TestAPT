package com.jhonlee.apt_lib;

import com.google.auto.service.AutoService;
import com.jhonlee.aptlib.HellowWord;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * @author dengxin
 * @Description TODO
 * @date 2018/4/17
 */
@AutoService(Processor.class)
public class TestProcess extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.jhonlee.apt-lib", helloWorld)
                .build();

        try {
            javaFile.writeTo( processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(HellowWord.class.getCanonicalName());
    }
}
