package org.example;

import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        String classLocation = "C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator1\\Homework\\out\\production\\Homework\\Homework.class";
        MyClassLoader myClassLoader = new MyClassLoader();
        File path = new File(classLocation);
        if (path.exists()) {
            System.out.println("Fisierul.class exista!");
            URL url = path.toURI().toURL();
            myClassLoader.addURL(url);
        }
        String className = "org.example.ClassAtr";
        Class clasa = Class.forName(className);
        System.out.println(clasa.getName());
        System.out.println(clasa.getPackage());
       System.out.println("Metodele:");
        Method[] methods1 = clasa.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m.getName());
        }
        System.out.println(clasa.getSuperclass());

        int passed = 0, failed = 0;
        Method[] methods = clasa.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s picat: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Teste trecute: %d, Teste picate: %d%n", passed, failed);
    }
}