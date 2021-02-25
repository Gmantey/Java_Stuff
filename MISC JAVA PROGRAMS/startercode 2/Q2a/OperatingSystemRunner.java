import org.junit.Test;
import java.lang.reflect.Field;
import org.junit.Assert;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A set of public test cases for the {@code OperatingSystem} class.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Practice Exam 2</p>
 */
public class OperatingSystemRunner{
    public static void main(String[] args) 
    {
    Result result = JUnitCore.runClasses(OperatingSystemPublicTest.class);
        if (result.wasSuccessful())
        {
            System.out.println("Excellent - all tests ran successfully");
        }
        else
        {
        	for (Failure failure : result.getFailures()) 
            {
            	System.out.println(failure.toString());
        	}
        }
    }

public static class OperatingSystemPublicTest {
    @Test(timeout = 1_000)
    public void constructorTest0() {
        String name = "macOS";
        int version = 15;
        OperatingSystem operatingSystem;
        Class<OperatingSystem> clazz = OperatingSystem.class;
        Field nameField;
        Field versionField;

        operatingSystem = new OperatingSystem(name, version) {
            @Override
            public boolean equals(Object object) {
                return false;
            } //equals

            @Override
            public String toString() {
                return null;
            } //toString
        };

        try {
            nameField = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `OperatingSystem` declares a field named `name` that is `private`, `final`, and of type `String`!");

            return;
        } //end try catch

        try {
            versionField = clazz.getDeclaredField("version");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `OperatingSystem` declares a field named `version` that is `private`, `final`, and of type `int`!");

            return;
        } //end try catch

        nameField.setAccessible(true);

        versionField.setAccessible(true);

        try {
            Assert.assertEquals("Ensure that `OperatingSystem`'s constructor initializes the `name` field with the specified argument!", name, nameField.get(operatingSystem));

            Assert.assertEquals("Ensure that `OperatingSystem`'s constructor initializes the `version` field with the specified argument!", version, versionField.getInt(operatingSystem));
        } catch (IllegalAccessException e) {
            e.printStackTrace();

            Assert.fail();
        } //end try catch
    } //constructorTest0

    @Test(timeout = 1_000, expected = NullPointerException.class)
    public void constructorTest1() {
        int version = 15;

        new OperatingSystem(null, version) {
            @Override
            public boolean equals(Object object) {
                return false;
            } //equals

            @Override
            public String toString() {
                return null;
            } //toString
        };
    } //constructorTest1

    @Test(timeout = 1_000, expected = IllegalArgumentException.class)
    public void constructorTest2() {
        String name = "macOS";
        int illegalVersion = -15;

        new OperatingSystem(name, illegalVersion) {
            @Override
            public boolean equals(Object object) {
                return false;
            } //equals

            @Override
            public String toString() {
                return null;
            } //toString
        };
    } //constructorTest2

    @Test(timeout = 1_000)
    public void getNameTest() {
        String name = "macOS";
        int version = 15;
        OperatingSystem operatingSystem;
        String returnValue;

        operatingSystem = new OperatingSystem(name, version) {
            @Override
            public boolean equals(Object object) {
                return false;
            } //equals

            @Override
            public String toString() {
                return null;
            } //toString
        };

        returnValue = operatingSystem.getName();

        Assert.assertEquals("Ensure that `OperatingSystem`'s `getName` method returns the value of the `name` field!", name, returnValue);
    } //getNameTest

    @Test(timeout = 1_000)
    public void getVersionTest() {
        String name = "macOS";
        int version = 15;
        OperatingSystem operatingSystem;
        int returnValue;

        operatingSystem = new OperatingSystem(name, version) {
            @Override
            public boolean equals(Object object) {
                return false;
            } //equals

            @Override
            public String toString() {
                return null;
            } //toString
        };

        returnValue = operatingSystem.getVersion();

        Assert.assertEquals("Ensure that `OperatingSystem`'s `getVersion` method returns the value of the `version` field!", version, returnValue);
    } //getVersionTest

    @Test(timeout = 1_000)
    public void equalsTest() {
        Class<OperatingSystem> clazz = OperatingSystem.class;
        Method equalsMethod;
        int modifiers;
        Class<?> returnType;

        try {
            equalsMethod = clazz.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `OperatingSystem` declares a method named `equals` that is `public`, `abstract`, has a return type of `boolean`, and has one parameter of type `Object`!");

            return;
        } //end try catch

        modifiers = equalsMethod.getModifiers();

        returnType = equalsMethod.getReturnType();

        Assert.assertTrue("Ensure that `OperatingSystem`'s `equals` method is `public`!", Modifier.isPublic(modifiers));

        Assert.assertTrue("Ensure that `OperatingSystem`'s `equals` method is `abstract`!", Modifier.isAbstract(modifiers));

        Assert.assertEquals("Ensure that `OperatingSystem`'s `equals` method has a return type of `double`!", boolean.class, returnType);
    } //equalsTest

    @Test(timeout = 1_000)
    public void toStringTest() {
        Class<OperatingSystem> clazz = OperatingSystem.class;
        Method toStringMethod;
        int modifiers;
        Class<?> returnType;

        try {
            toStringMethod = clazz.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e) {
            Assert.fail("Ensure that `OperatingSystem` declares a method named `toString` that is `public`, `abstract`, and has a return type of `String`!");

            return;
        } //end try catch

        modifiers = toStringMethod.getModifiers();

        returnType = toStringMethod.getReturnType();

        Assert.assertTrue("Ensure that `OperatingSystem`'s `toString` method is `public`!", Modifier.isPublic(modifiers));

        Assert.assertTrue("Ensure that `OperatingSystem`'s `toString` method is `abstract`!", Modifier.isAbstract(modifiers));

        Assert.assertEquals("Ensure that `OperatingSystem`'s `toString` method has a return type of `String`!", String.class, returnType);
    } //toStringTest
}
}