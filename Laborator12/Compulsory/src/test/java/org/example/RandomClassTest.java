package org.example;

import org.junit.Assert;
import org.junit.Test;

class RandomClassTest {
    @Test
    public void testConstructor() {
        ClassAtr randomClass = new ClassAtr("Test Name");
        String name = randomClass.getName();
        Assert.assertEquals("Test Name", name);
    }

}