package org.example;

import org.testng.annotations.Test;

public class ClassAtr {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ClassAtr(String name) {
        this.name = name;
    }
    @Test public static void test_method() { }
}
