import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * A set of public test cases for the {@code StockManipulator} class.
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- Practice Exam 2</p>
 */
public class StockManipulatorRunner{
    public static void main(String[] args) 
    {
    Result result = JUnitCore.runClasses(StockManipulatorPublicTest.class);
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

public static class StockManipulatorPublicTest {

    
    @Test(timeout = 1000)
    public void testArray1_readStocksFromFile() {
        try {
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42"};

            String[] readStocks = StockManipulator.readStocksFromFile("stocks1.txt"); // store their saved lines
            assertTrue("The return array was null despite the file being valid.", readStocks != null); // the file's valid, so return value should be non-null

            int count = 0;
            for (; count <= readStocks.length - 1 && readStocks[count] != null; count++); // finds the 'true length' of the array by incrementing until the first null index
            assertEquals("Your readStocksFromFile method improperly reads all of the lines. There is an incorrect line count.", expected.length, count); // file only contains 3 lines

            for (int i = 0; i < expected.length; i++) { // iterate through the necessary indices
                if (!expected[i].equals(readStocks[i])) { // if they differ, fail the test.
                    fail(String.format("\nExpected: %s\nActual:   %s\nThis difference occurred at index: %d\n",
                            expected[i], readStocks[i], i));
                }
            }
        } catch (UnsupportedFileException ufe) {
            fail("This test should not have thrown an UnsupportedFileException!");
        }

    }

    @Test(timeout = 1000)
    public void testArray2_readStocksFromFile() {
        try {
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42",
                    "vers 2190.12",
                    "Chiv 210.21",
                    "dank 1004.22",
                    "nfil 830.85"};

            String[] readStocks = StockManipulator.readStocksFromFile("stocks2.txt"); // store their saved lines
            assertTrue("The return array was null despite the file being valid.", readStocks != null); // the file's valid, so return value should be non-null

            int count = 0;
            for (; count <= readStocks.length - 1 && readStocks[count] != null; count++); // finds the 'true length' of the array by incrementing until the first null index
            assertEquals("Your readStocksFromFile method improperly reads all of the lines. There is an incorrect line count.", expected.length, count); // file only contains 3 lines

            for (int i = 0; i < expected.length; i++) { // iterate through the necessary indices
                if (!expected[i].equals(readStocks[i])) { // if they differ, fail the test.
                    fail(String.format("\nExpected: %s\nActual:   %s\nThis difference occurred at index: %d\n",
                            expected[i], readStocks[i], i));
                }
            }
        } catch (UnsupportedFileException ufe) {
            fail("This test should not have thrown an UnsupportedFileException!");
        }


    }

    @Test(timeout = 1000)
    public void testArray3_readStocksFromFile() {
        try {
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42",
                    "vers 2190.12",
                    "Chiv 210.21",
                    "dank 1004.22",
                    "nfil 830.85",
                    "ana 3002.64",
                    "him 33.32",
                    "dun 104.44",
                    "him 44.21",
                    "him 3.32"};

            String[] readStocks = StockManipulator.readStocksFromFile("stocks3.txt"); // store their saved lines
            assertTrue("The return array was null despite the file being valid.", readStocks != null); // the file's valid, so return value should be non-null

            int count = 0;
            for (; count <= readStocks.length - 1 && readStocks[count] != null; count++); // finds the 'true length' of the array by incrementing until the first null index
            assertEquals("Your readStocksFromFile method improperly reads all of the lines. There is an incorrect line count.", expected.length, count); // file only contains 3 lines

            for (int i = 0; i < expected.length; i++) { // iterate through the necessary indices
                if (!expected[i].equals(readStocks[i])) { // if they differ, fail the test.
                    fail(String.format("\nExpected: %s\nActual:   %s\nThis difference occurred at index: %d\n",
                            expected[i], readStocks[i], i));
                }
            }
        } catch (UnsupportedFileException ufe) {
            fail("This test should not have thrown an UnsupportedFileException!");
        }


    }

    @Test(timeout = 1000)
    public void testArray4_fixReadStocks() {
        // Note that this test will fail if the read-from-file tests are failing.
        try {
            String[] expected = {"jank 3901.12", // the expected result
                    "hank 90.03",
                    "dun 20.22"};

            String[] readStocks = StockManipulator.readStocksFromFile("stocks4.txt"); // store their saved lines
            assertTrue("The return array was null despite the file being valid.", readStocks != null); // the file's valid, so return value should be non-null
            String[] fixedReadStocks = StockManipulator.fixReadStocks(readStocks);

            for (int i = 0; i < expected.length; i++) { // iterate through the necessary indices
                if (!expected[i].equals(fixedReadStocks[i])) { // if they differ, fail the test.
                    fail(String.format("\nExpected: %s\nActual:   %s\nThis difference occurred at index: %d\n",
                            expected[i], fixedReadStocks[i], i));
                }
            }

        } catch (UnsupportedFileException ufe) {
            fail("This test should not have thrown an UnsupportedFileException!");
        }


    }

    @Test(timeout = 1000)
    public void testArray5_fixReadStocks() {
        // Note that this test will fail if the read-from-file tests are failing.
        try {
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42",
                    "vers 2190.12",
                    "Chiv 210.21",
                    "dank 1004.22",
                    "nfil 830.85",
                    "ana 3002.64",
                    "him 80.85",
                    "dun 104.44"};

            String[] readStocks = StockManipulator.readStocksFromFile("stocks3.txt"); // store their saved lines
            assertTrue("The return array was null despite the file being valid.", readStocks != null); // the file's valid, so return value should be non-null
            String[] fixedReadStocks = StockManipulator.fixReadStocks(readStocks);

            for (int i = 0; i < expected.length; i++) { // iterate through the necessary indices
                if (!expected[i].equals(fixedReadStocks[i])) { // if they differ, fail the test.
                    fail(String.format("\nExpected: %s\nActual:   %s\nThis difference occurred at index: %d\n",
                            expected[i], fixedReadStocks[i], i));
                }
            }

        } catch (UnsupportedFileException ufe) {
            Assert.fail("This test should not have thrown an UnsupportedFileException!");
        }

    }
    
    @Test(timeout = 1000)
    public void test_Exception1() {
        try {
            String stockFile = "dooby";
            StockManipulator.readStocksFromFile(stockFile);
            fail("This test should have thrown an UnsupportedFileException because the file contains zero lines!");
        } catch (UnsupportedFileException ufe) {
            assertEquals("The wrong argument was passed to the UnsupportedFileException constructor!", "No lines in File", ufe.getMessage());
        }
        
    }

    @Test(timeout = 1000)
    public void test_Exception2() {
        try {
            String stockFile = "stocks5.txt";
            StockManipulator.readStocksFromFile(stockFile);
            fail("This test should have thrown an UnsupportedFileException because a line in the file contains more than just two words!");
        } catch (UnsupportedFileException ufe) {
            assertEquals("The wrong argument was passed to the UnsupportedFileException constructor!", "Too Many Words", ufe.getMessage());
        }
        
    }

    @Test(timeout = 1000)
    public void test_Exception3() {
        try {
            String stockFile = "stocks1.txt";
            StockManipulator.readStocksFromFile(stockFile);
        } catch (UnsupportedFileException ufe) {
            fail("This test shouldn't have thrown an UnsupportedFileException because the file is valid.");
        }
        
    }

    @Test(timeout = 1000)
    public void test_Exception4() {
        try {
            String stockFile = "stocks2.txt";
            StockManipulator.readStocksFromFile(stockFile);
        } catch (UnsupportedFileException ufe) {
            fail("This test shouldn't have thrown an UnsupportedFileException because the file is valid.");
        }
        
    }

    @Test(timeout = 1000)
    public void test_Exception5() {
        try {
            String stockFile = "stocks3.txt";
            StockManipulator.readStocksFromFile(stockFile);
        } catch (UnsupportedFileException ufe) {
            fail("This test shouldn't have thrown an UnsupportedFileException because the file is valid.");
        }
        
    }
    
    @Test(timeout = 1000)
    public void test_fileIO1() {
        try {
            String toWriteFile = "fixed1.txt";
            String solnFileString = "fixed1_soln.txt"; // the solution to be checked against
            File solnFile = new File(solnFileString);
            String[] expected = {"abc 2020.12", // the expected result
                    "de 104.13",
                    "man 94130.31"};

            String solution = "";
            for (int i = 0; i < expected.length; i++) {
                solution += expected[i] + "\n";
            }
            solution = solution.trim();

            File writtenFile = new File(toWriteFile);
            if (writtenFile.exists()) { // if the file is pre-existing, delete it (force code to re-create file)
                writtenFile.delete();
            }


            StockManipulator.writeFixedStocks(expected, toWriteFile); // write the fixed stocks
            if (!writtenFile.exists()) {
                fail("The file was not created when it didn't exist (even though it should have been.)");
            }

            byte[] studentFile = Files.readAllBytes(writtenFile.toPath());
            String studentString = new String(studentFile).replace("\r\n", "\n").trim();
            if (!studentString.equals(solution)) {
                fail("Your written file did not match the solution file. Please manually check them to view the difference.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
    }

    @Test(timeout = 1000)
    public void test_fileIO2() {
        try {
            String toWriteFile = "fixed2.txt";
            String solnFileString = "fixed2_soln.txt"; // the solution to be checked against
            File solnFile = new File(solnFileString);
            String[] expected = {"him 1290.12", // the expected result
                    "fan 2828.73",
                    "vin 290.12"};

            String solution = "";
            for (int i = 0; i < expected.length; i++) {
                solution += expected[i] + "\n";
            }
            solution = solution.trim();

            File writtenFile = new File(toWriteFile);
            if (writtenFile.exists()) { // if the file is pre-existing, delete it (force code to re-create file)
                writtenFile.delete();
            }


            StockManipulator.writeFixedStocks(expected, toWriteFile); // write the fixed stocks
            if (!writtenFile.exists()) {
                fail("The file was not created when it didn't exist (even though it should have been.)");
            }

            byte[] studentFile = Files.readAllBytes(writtenFile.toPath());
            String studentString = new String(studentFile).replace("\r\n", "\n").trim();
            if (!studentString.equals(solution)) {
                fail("Your written file did not match the solution file. Please manually check them to view the difference.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @Test(timeout = 1000)
    public void test_fileIO3() {
        try {
            String toWriteFile = "fixed3.txt";
            String solnFileString = "fixed3_soln.txt"; // the solution to be checked against
            File solnFile = new File(solnFileString);
            String[] expected = {"hank 129.12", // the expected result
                    "tub 190.34",
                    "fang 290.12",
                    "junk 1.63",
                    "xai 305.65",
                    "dunk 39.23",
                    "run 75.94"};

            String solution = "";
            for (int i = 0; i < expected.length; i++) {
                solution += expected[i] + "\n";
            }
            solution = solution.trim();

            File writtenFile = new File(toWriteFile);
            if (writtenFile.exists()) { // if the file is pre-existing, delete it (force code to re-create file)
                writtenFile.delete();
            }


            StockManipulator.writeFixedStocks(expected, toWriteFile); // write the fixed stocks
            if (!writtenFile.exists()) {
                fail("The file was not created when it didn't exist (even though it should have been.)");
            }

            byte[] studentFile = Files.readAllBytes(writtenFile.toPath());
            String studentString = new String(studentFile).replace("\r\n", "\n").trim();
            if (!studentString.equals(solution)) {
                fail("Your written file did not match the solution file. Please manually check them to view the difference.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @Test(timeout = 1000)
    public void test_fileIO4() {
        try {
            String toWriteFile = "fixed4.txt";
            String solnFileString = "fixed4_soln.txt"; // the solution to be checked against
            File solnFile = new File(solnFileString);
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42",
                    "vers 2190.12",
                    "Chiv 210.21",
                    "dank 1004.22",
                    "nfil 830.85",
                    "ana 3002.64",
                    "him 33.32",
                    "dun 104.44",
                    "him 44.21",
                    "him 3.32"};

            String solution = "";
            for (int i = 0; i < expected.length; i++) {
                solution += expected[i] + "\n";
            }
            solution = solution.trim();

            File writtenFile = new File(toWriteFile);
            if (writtenFile.exists()) { // if the file is pre-existing, delete it (force code to re-create file)
                writtenFile.delete();
            }


            StockManipulator.writeFixedStocks(expected, toWriteFile); // write the fixed stocks
            if (!writtenFile.exists()) {
                fail("The file was not created when it didn't exist (even though it should have been.)");
            }

            byte[] studentFile = Files.readAllBytes(writtenFile.toPath());
            String studentString = new String(studentFile).replace("\r\n", "\n").trim();
            if (!studentString.equals(solution)) {
                fail("Your written file did not match the solution file. Please manually check them to view the difference.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
      
    }

    @Test(timeout = 1000)
    public void test_fileIO5() {
        try {
            String toWriteFile = "fixed5.txt";
            String solnFileString = "fixed5_soln.txt"; // the solution to be checked against
            File solnFile = new File(solnFileString);
            String[] expected = {"abc 200.12", // the expected result
                    "def 2189.33",
                    "jank 102.42",
                    "vers 2190.12",
                    "Chiv 210.21",
                    "dank 1004.22",
                    "nfil 830.85",
                    "ana 3002.64",
                    "him 80.85",
                    "dun 104.44"};

            String solution = "";
            for (int i = 0; i < expected.length; i++) {
                solution += expected[i] + "\n";
            }
            solution = solution.trim();

            File writtenFile = new File(toWriteFile);
            if (writtenFile.exists()) { // if the file is pre-existing, delete it (force code to re-create file)
                writtenFile.delete();
            }


            StockManipulator.writeFixedStocks(expected, toWriteFile); // write the fixed stocks
            if (!writtenFile.exists()) {
                fail("The file was not created when it didn't exist (even though it should have been.)");
            }

            byte[] studentFile = Files.readAllBytes(writtenFile.toPath());
            String studentString = new String(studentFile).replace("\r\n", "\n").trim();
            if (!studentString.equals(solution)) {
                fail("Your written file did not match the solution file. Please manually check them to view the difference.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}
}
