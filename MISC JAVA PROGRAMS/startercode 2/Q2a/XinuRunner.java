import org.junit.Test;
import java.lang.reflect.Field;
import org.junit.Assert;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * A set of public test cases for the {@code Xinu} class.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Practice Exam 2</p>
 */
public class XinuRunner{
    public static void main(String[] args) 
    {
    Result result = JUnitCore.runClasses(XinuPublicTest.class);
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
public static class XinuPublicTest {
    @Test(timeout = 1_000)
    public void constructorTest0() {
        int version = 15;
        Xinu xinu = new Xinu(version);
        Class<OperatingSystem> clazz = OperatingSystem.class;
        Field nameField;
        Field versionField;
        String name = "Xinu";

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
            Assert.assertEquals("Ensure that `Xinu`'s constructor initializes the `name` field with `\"Xinu\"`!", name, nameField.get(xinu));

            Assert.assertEquals("Ensure that `Xinu`'s constructor initializes the `version` field with the specified argument!", version, versionField.getInt(xinu));
        } catch (IllegalAccessException e) {
            e.printStackTrace();

            Assert.fail();
        } //end try catch
    } //constructorTest0

    @Test(timeout = 1_000, expected = IllegalArgumentException.class)
    public void constructorTest1() {
        int illegalVersion = -15;

        new Xinu(illegalVersion);
    } //constructorTest1

    @Test(timeout = 1_000)
    public void equalsTest0() {
        int version = 15;
        Xinu xinu = new Xinu(version);
        boolean equal;

        equal = xinu.equals(xinu);

        Assert.assertTrue("Ensure that `Xinu`'s `equals` method returns the correct value!", equal);
    } //equalsTest0

    @Test(timeout = 1_000)
    public void equalsTest1() {
        int version = 15;
        Xinu xinu0 = new Xinu(version);
        Xinu xinu1 = new Xinu(version);
        boolean equal;

        equal = xinu0.equals(xinu1);

        Assert.assertTrue("Ensure that `Xinu`'s `equals` method returns the correct value!", equal);
    } //equalsTest1

    @Test(timeout = 1_000)
    public void equalsTest2() {
        int version0 = 15;
        int version1 = 25;
        Xinu xinu0 = new Xinu(version0);
        Xinu xinu1 = new Xinu(version1);
        boolean equal;

        equal = xinu0.equals(xinu1);

        Assert.assertFalse("Ensure that `Xinu`'s `equals` method returns the correct value!", equal);
    } //equalsTest2

    @Test(timeout = 1_000)
    public void equalsTest3() {
        int version = 15;
        Xinu xinu = new Xinu(version);
        String string = "Hello";
        boolean equal;

        equal = xinu.equals(string);

        Assert.assertFalse("Ensure that `Xinu`'s `equals` method returns the correct value!", equal);
    } //equalsTest3

    @Test(timeout = 1_000)
    public void equalsTest4() {
        int version = 15;
        Xinu xinu = new Xinu(version);
        boolean equal;

        equal = xinu.equals(null);

        Assert.assertFalse("Ensure that `Xinu`'s `equals` method returns the correct value!", equal);
    } //equalsTest4

    @Test(timeout = 1_000)
    public void toStringTest0() {
        int version = 15;
        Xinu xinu = new Xinu(version);
        String string;
        String expectedValue = "Xinu[15]";

        string = xinu.toString();

        Assert.assertEquals("Ensure that `Xinu`'s `toString` method returns a `String` of the correct format!", expectedValue, string);
    } //toStringTest0
}
}