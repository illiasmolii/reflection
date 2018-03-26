package ua.smolii;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class Classes {

    public static void main(String[] args) throws Exception {
        String className = args[0];
        Class<?> clazz = Class.forName(className);

        printClassName(clazz);
        printModifiers(clazz);
        printTypeParams(clazz);
        printImplementedInterfaces(clazz);
        printAnnotations(clazz);
        printInheritancePath(clazz);
    }

    private static void printClassName(Class<?> clazz) {
        System.out.println(clazz.getCanonicalName());
    }

    private static void printModifiers(Class<?> clazz) {
        System.out.println("\nModifiers:");
        System.out.println(
                Modifier.toString(clazz.getModifiers())
        );
    }

    private static void printTypeParams(Class<?> clazz) {
        System.out.println("\nType parameters:");
        Arrays.stream(clazz.getTypeParameters())
                .map(TypeVariable::getName)
                .forEach(System.out::println);
    }

    private static void printImplementedInterfaces(Class<?> clazz) {
        System.out.println("\nInterfaces:");
        Arrays.stream(clazz.getGenericInterfaces()).forEach(System.out::println);
    }

    private static void printAnnotations(Class<?> clazz) {
        System.out.println("\nAnnotastions:");
        Arrays.stream(clazz.getAnnotations()).forEach(System.out::println);
    }

    private static void printInheritancePath(Class<?> clazz) {
        System.out.println("\nInheritance path:");
        printAncestors(clazz);
    }

    private static void printAncestors(Class<?> clazz) {
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            printAncestors(superclass);
        }
        System.out.println(clazz.getCanonicalName());
    }
}
