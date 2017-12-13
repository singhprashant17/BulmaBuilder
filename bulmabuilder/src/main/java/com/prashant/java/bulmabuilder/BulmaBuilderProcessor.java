package com.prashant.java.bulmabuilder;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.JavaFileObject;

/**
 * @author Prashant Singh
 */

@SupportedAnnotationTypes("com.prashant.java.bulmabuilder.BulmaBuilder")
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class BulmaBuilderProcessor extends AbstractProcessor {
    private final static String GENERATED_FILE_NAME_SUFFIX = "Builder";

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        for (Element annotatedElement :
                roundEnvironment.getElementsAnnotatedWith(BulmaBuilder.class)) {

            // check only class should be annotated
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                throw new IllegalStateException("Uh ohhhhhh .......\nOnly class can be annotated.");
            }

            // get all elements inside the class
            final List<? extends Element> enclosedElements = annotatedElement.getEnclosedElements();

            // list of those elements which are qualified to become generated builder class methods
            List<Element> setters = new ArrayList<>();

            // this loops iterates over all the child elements. it checks for those elements
            // which are methods i.e. of type ExecutableType. the method should have exactly one
            // parameter. the method name should start with "set" (general naming convention of
            // setter methods)
            for (Element enclosedElement : enclosedElements) {
                if (enclosedElement.asType() instanceof ExecutableType &&
                        ((ExecutableType) enclosedElement.asType()).getParameterTypes().size() ==
                                1 &&
                        enclosedElement.getSimpleName().toString().startsWith("set")) {
                    setters.add(enclosedElement);
                }
            }

            if (setters.isEmpty()) {
                continue;
            }

            // className of the annotated class
            final String className = ((TypeElement) annotatedElement).getQualifiedName().toString();

            // a map to hold the setter method name and its parameter type
            Map<String, String> setterMap = new HashMap<>();

            for (Element setter : setters) {
                setterMap.put(setter.getSimpleName().toString(),
                        ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString());
            }

            String packageName = null;
            int lastDot = className.lastIndexOf('.');
            if (lastDot > 0) {
                packageName = className.substring(0, lastDot);
            }


            // writing the java source file
            PrintWriter out = null;
            try {
                String builderClassName = className + GENERATED_FILE_NAME_SUFFIX;
                JavaFileObject builderFile = processingEnv.getFiler()
                        .createSourceFile(builderClassName);
                out = new PrintWriter(builderFile.openWriter());

                if (packageName != null) {
                    out.print("package ");
                    out.print(packageName);
                    out.println(";");
                    out.println();
                }

                out.print("public class ");
                String builderSimpleClassName = builderClassName.substring(lastDot + 1);
                out.print(builderSimpleClassName);
                out.println(" {");
                out.println();

                out.print("\tprivate ");
                String simpleClassName = className.substring(lastDot + 1);
                out.print(simpleClassName);
                out.print(" object = new ");
                out.print(simpleClassName);
                out.println("();");
                out.println();

                out.print("\tpublic ");
                out.print(simpleClassName);
                out.println(" build() {");
                out.println("\t\treturn object;");
                out.println("\t}");
                out.println();

                // writing the builder setter methods
                for (Map.Entry<String, String> setter : setterMap.entrySet()) {
                    String methodName = setter.getKey();
                    String argumentType = setter.getValue();

                    out.print("\tpublic ");
                    out.print(builderSimpleClassName);
                    out.print(" ");
                    out.print(methodName);
                    out.print("(");
                    out.print(argumentType);
                    out.println(" value) {");
                    out.print("\t\tobject.");
                    out.print(methodName);
                    out.println("(value);");
                    out.println("\t\treturn this;");
                    out.println("\t}");
                    out.println();
                }
                out.println("}");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
        return false;
    }
}
