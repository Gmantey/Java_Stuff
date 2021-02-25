import org.junit.Test;
import java.lang.reflect.Field;
import org.junit.Assert;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A set of public test cases for the {@code Computer} class.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Practice Exam 2</p>
 */
public class ComputerRunner{
    public static void main(String[] args) 
    {
    Result result = JUnitCore.runClasses(ComputerPublicTest.class);
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

public static class ComputerPublicTest {
    @Test(timeout = 1_000)
    public void constructorTest0() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        Class<Computer> clazz = Computer.class;
        Field nameField;
        Field operatingSystemField;
        Field priceField;
        double delta = 1E-10;

        try {
            nameField = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `Computer` declares a field named `name` that is `private`, `final`, and of type `String`!");

            return;
        } //end try catch

        try {
            operatingSystemField = clazz.getDeclaredField("operatingSystem");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `Computer` declares a field named `operatingSystem` that is `private`, `final`, and of type `OperatingSystem`!");

            return;
        } //end try catch

        try {
            priceField = clazz.getDeclaredField("price");
        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure that `Computer` declares a field named `price` that is `private`, `final`, and of type `double`!");

            return;
        } //end try catch

        nameField.setAccessible(true);

        operatingSystemField.setAccessible(true);

        priceField.setAccessible(true);

        try {
            Assert.assertEquals("Ensure that `Computer`'s constructor initializes the `name` field with the specified argument!", name, nameField.get(computer));

            Assert.assertEquals("Ensure that `Computer`'s constructor initializes the `operatingSystem` field with the specified argument!", operatingSystem, operatingSystemField.get(computer));

            Assert.assertEquals("Ensure that `Computer`'s constructor initializes the `price` field with the specified argument!", price, priceField.getDouble(computer), delta);
        } catch (IllegalAccessException e) {
            e.printStackTrace();

            Assert.fail();
        } //end try catch
    } //constructorTest0

    @Test(timeout = 1_000, expected = NullPointerException.class)
    public void constructorTest1() {
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;

        new Computer(null, operatingSystem, price);
    } //constructorTest1

    @Test(timeout = 1_000, expected = NullPointerException.class)
    public void constructorTest2() {
        String name = "MacBook Air";
        double price = 999.0;

        new Computer(name, null, price);
    } //constructorTest2

    @Test(timeout = 1_000, expected = IllegalArgumentException.class)
    public void constructorTest3() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = -999.0;

        new Computer(name, operatingSystem, price);
    } //constructorTest3

    @Test(timeout = 1_000)
    public void getNameTest() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        String returnValue;

        returnValue = computer.getName();

        Assert.assertEquals("Ensure that `Computer`'s `getName` method returns the value of the `name` field!", name, returnValue);
    } //getNameTest

    @Test(timeout = 1_000)
    public void getOperatingSystemTest() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        OperatingSystem returnValue;

        returnValue = computer.getOperatingSystem();

        Assert.assertEquals("Ensure that `Computer`'s `getOperatingSystem` method returns the value of the `operatingSystem` field!", operatingSystem, returnValue);
    } //getOperatingSystemTest

    @Test(timeout = 1_000)
    public void getPriceTest() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        double returnValue;
        double delta = 1E-10;

        returnValue = computer.getPrice();

        Assert.assertEquals("Ensure that `Computer`'s `getPrice` method returns the value of the `price` field!", price, returnValue, delta);
    } //getPriceTest

    @Test(timeout = 1_000)
    public void compareToTest0() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer0 = new Computer(name, operatingSystem, price);
        Computer computer1 = new Computer(name, operatingSystem, price);
        int returnValue;
        int expectedValue = 0;

        returnValue = computer0.compareTo(computer1);

        Assert.assertEquals("Ensure that `Computer`'s `compareTo` method returns the correct value!", expectedValue, returnValue);
    } //compareToTest0

    @Test(timeout = 1_000)
    public void compareToTest1() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price0 = 999.0;
        double price1 = 1099.0;
        Computer computer0 = new Computer(name, operatingSystem, price0);
        Computer computer1 = new Computer(name, operatingSystem, price1);
        int returnValue;
        int expectedValue = -1;

        returnValue = computer0.compareTo(computer1);

        Assert.assertEquals("Ensure that `Computer`'s `compareTo` method returns the correct value!", expectedValue, returnValue);
    } //compareToTest1

    @Test(timeout = 1_000)
    public void compareToTest2() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price0 = 1099.0;
        double price1 = 999.0;
        Computer computer0 = new Computer(name, operatingSystem, price0);
        Computer computer1 = new Computer(name, operatingSystem, price1);
        int returnValue;
        int expectedValue = 1;

        returnValue = computer0.compareTo(computer1);

        Assert.assertEquals("Ensure that `Computer`'s `compareTo` method returns the correct value!", expectedValue, returnValue);
    } //compareToTest2

    @Test(timeout = 1_000)
    public void equalsTest0() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        boolean equal;

        equal = computer.equals(computer);

        Assert.assertTrue("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest0

    @Test(timeout = 1_000)
    public void equalsTest1() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer0 = new Computer(name, operatingSystem, price);
        Computer computer1 = new Computer(name, operatingSystem, price);
        boolean equal;

        equal = computer0.equals(computer1);

        Assert.assertTrue("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest1

    @Test(timeout = 1_000)
    public void equalsTest2() {
        String name0 = "MacBook Air";
        String name1 = "MacBook Pro";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer0 = new Computer(name0, operatingSystem, price);
        Computer computer1 = new Computer(name1, operatingSystem, price);
        boolean equal;

        equal = computer0.equals(computer1);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest2

    @Test(timeout = 1_000)
    public void equalsTest3() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem0 = new Xinu(15);
        OperatingSystem operatingSystem1 = new Xinu(25);
        double price = 999.0;
        Computer computer0 = new Computer(name, operatingSystem0, price);
        Computer computer1 = new Computer(name, operatingSystem1, price);
        boolean equal;

        equal = computer0.equals(computer1);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest3

    @Test(timeout = 1_000)
    public void equalsTest4() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price0 = 999.0;
        double price1 = 1099.0;
        Computer computer0 = new Computer(name, operatingSystem, price0);
        Computer computer1 = new Computer(name, operatingSystem, price1);
        boolean equal;

        equal = computer0.equals(computer1);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest4

    @Test(timeout = 1_000)
    public void equalsTest5() {
        String name0 = "MacBook Air";
        String name1 = "MacBook Pro";
        OperatingSystem operatingSystem0 = new Xinu(15);
        OperatingSystem operatingSystem1 = new Xinu(25);
        double price0 = 999.0;
        double price1 = 1099.0;
        Computer computer0 = new Computer(name0, operatingSystem0, price0);
        Computer computer1 = new Computer(name1, operatingSystem1, price1);
        boolean equal;

        equal = computer0.equals(computer1);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest5

    @Test(timeout = 1_000)
    public void equalsTest6() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        String string = "Hello";
        boolean equal;

        equal = computer.equals(string);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest6

    @Test(timeout = 1_000)
    public void equalsTest7() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        boolean equal;

        equal = computer.equals(null);

        Assert.assertFalse("Ensure that `Computer`'s `equals` method returns the correct value!", equal);
    } //equalsTest7

    @Test(timeout = 1_000)
    public void toStringTest0() {
        String name = "MacBook Air";
        OperatingSystem operatingSystem = new Xinu(15);
        double price = 999.0;
        Computer computer = new Computer(name, operatingSystem, price);
        String string;
        String expectedValue = "Computer[MacBook Air, Xinu[15], $999.00]";

        string = computer.toString();

        Assert.assertEquals("Ensure that `Computer`'s `toString` method returns a `String` of the correct format!", expectedValue, string);
    } //toStringTest0
}
}