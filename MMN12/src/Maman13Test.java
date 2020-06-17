//To download this: press "raw" button -> save as Maman13Test.java.
//Place in same package where Stock, Matrix, Date and FoodItem classes are located and run.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Fully automated tests for maman 13 (OUI).
 * This class will test your Stock and Matrix classes and generate a
 * report about methods working properly and failures.
 * <p>
 * -------------------------------------------------------------
 * NOTE: THESE TESTS ARE WRITTEN BY A STUDENT, NOT BY A TEACHER!
 * RELY ON THE RESULTS AT YOUR OWN RISK!
 * OFFICIAL TESTS CAN BE FOUND ON FORUM.
 * --------------------------------------------------------------
 * <p>
 * If you want to update these tests on pastebin.com,
 * send an email to skorn.ilya AT gmail DOT com containing a copy of this file with your changes.
 * Your experience and issues: https://vk.cc/aa5jH8
 * <p>
 * Thanks for everyone who leaves a feedback! =)
 * <p>
 *
 * @author Ilya Skornyakov
 * @version 1.0.8
 * @since JDK 8
 * <p>
 * Updates: https://pastebin.com/sV4zVKCQ
 */

public class Maman13Test {
    private static final boolean VERBOSE = false;
    private static final String VERSION = "1.0.8";

    private static final ClassTest stockTests = new ClassTest("Stock", new Test[]{
            new Test("addItem() and getNumOfItems()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                Date date3 = new Date(1, 3, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1000, 1, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 1, date1, date2, 1, 10, 5);
                FoodItem fi3 = new FoodItem("Name2", 1002, 1, date1, date3, 1, 10, 5);
                FoodItem fi4 = new FoodItem("Name3", 1003, 1, date1, date2, 1, 10, 5);
                FoodItem fi5 = new FoodItem("Name1", 1000, 1, date1, date2, 1, 10, 5);
                FoodItem fi6 = new FoodItem("Name4", 1001, 1, date1, date2, 1, 10, 5);
                Stock actual = new Stock();
                actual.addItem(fi1);
                actual.addItem(fi2);
                actual.addItem(fi3);
                actual.addItem(fi4);
                actual.addItem(fi5);
                actual.addItem(fi6);

                FoodItem fi1_2 = new FoodItem("Name1", 1000, 2, date1, date2, 1, 10, 5);

                assertEquals(actual, new FoodItem[]{fi1_2, fi6, fi3, fi2, fi4});

                assertEquals(actual.getNumOfItems(), 5);

                Stock actual2 = new Stock();

                //adding 100 different elements
                for (int i = 0; i < 100; i++) {
                    assertTrue(actual2.addItem(new FoodItem("Name" + i, 1000 + i, 10, date1, date2, 1, 10, 5)));
                }

                //101th element
                assertFalse(actual2.addItem(new FoodItem("NameX", 9999, 10, date1, date2, 1, 10, 5)));

                //Not adding, but changing quantity!
                assertTrue(actual2.addItem(new FoodItem("Name0", 1000, 10, date1, date2, 1, 10, 5)));

                assertEquals(actual2.getNumOfItems(), 100);
            }),

            new Test("howMany()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 1, date1, date2, 5, 10, 5);
                FoodItem fi3 = new FoodItem("Name3", 1003, 3, date1, date2, 1, 10, 5);

                Stock stock = new Stock();

                assertEquals(stock.howMany(2), 0);

                stock.addItem(fi1);
                stock.addItem(fi2);
                stock.addItem(fi3);

                assertEquals(stock.howMany(2), 4);
            }),

            new Test("Aliasing", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 10, 5);

                Stock stock = new Stock();
                stock.addItem(fi1);
                String snapshot1 = stock.toString();

                fi1.setExpiryDate(date1.tomorrow());
                fi1.setProductionDate(date2.tomorrow());
                fi1.setQuantity(9);

                String snapshot2 = stock.toString();

                assertEquals(snapshot1, snapshot2);

                FoodItem fi2 = stock.mostExpensive();

                fi2.setExpiryDate(date1.tomorrow().tomorrow());
                fi1.setProductionDate(date2.tomorrow().tomorrow());
                fi2.setQuantity(99);

                String snapshot3 = stock.toString();

                assertEquals(snapshot1, snapshot3);
            }),

            new Test("removeAfterDate()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                Date date3 = new Date(1, 3, 2000);
                Date date4 = new Date(1, 4, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 10, 5);
                FoodItem fi2_fresh = new FoodItem("Name2", 1002, 1, date1, date4, 5, 10, 5);
                FoodItem fi3 = new FoodItem("Name3", 1003, 1, date1, date2, 1, 10, 5);
                FoodItem fi4 = new FoodItem("Name4", 1004, 1, date1, date2, 1, 10, 5);

                Stock actual = new Stock();

                actual.addItem(fi1);
                actual.addItem(fi2_fresh);
                actual.addItem(fi3);
                actual.addItem(fi4);

                actual.removeAfterDate(date3);

                assertEquals(actual, new FoodItem[]{fi2_fresh});

                assertEquals(actual.getNumOfItems(), 1);
            }),

            new Test("mostExpensive()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 1, date1, date2, 5, 10, 6);
                FoodItem fi3_mostExpensive = new FoodItem("Name3", 1003, 1, date1, date2, 1, 10, 7);
                FoodItem fi4 = new FoodItem("Name4", 1005, 1, date1, date2, 1, 10, 7);
                FoodItem fi5 = new FoodItem("Name5", 1006, 1, date1, date2, 1, 10, 6);


                Stock stock = new Stock();

                assertTrue(stock.mostExpensive() == null);

                stock.addItem(fi1);
                stock.addItem(fi2);
                stock.addItem(fi3_mostExpensive);
                stock.addItem(fi4);
                stock.addItem(fi5);

                assertEquals(stock.mostExpensive(), fi3_mostExpensive);
            }),

            new Test("howManyPieces()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 0, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 1, date1, date2, 5, 10, 6);
                FoodItem fi3 = new FoodItem("Name3", 1003, 3, date1, date2, 1, 10, 7);
                FoodItem fi4 = new FoodItem("Name4", 1005, 7, date1, date2, 1, 10, 6);

                Stock stock = new Stock();

                assertEquals(stock.howManyPieces(), 0);

                stock.addItem(fi1);
                stock.addItem(fi2);
                stock.addItem(fi3);
                stock.addItem(fi4);

                assertEquals(stock.howManyPieces(), 11);
            }),

            new Test("toString()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 2, date1, date2, 5, 10, 6);

                Stock stock = new Stock();

                assertEquals(stock.toString(), "");

                stock.addItem(fi1);
                stock.addItem(fi2);

                String toStringExpected = "FoodItem: Name1\tCatalogueNumber: 1001\tProductionDate: 01/01/2000\tExpiryDate: 01/02/2000\tQuantity: 1\n" +
                        "FoodItem: Name2\tCatalogueNumber: 1002\tProductionDate: 01/01/2000\tExpiryDate: 01/02/2000\tQuantity: 2";
                assertTrue(stock.toString().equals(toStringExpected) || stock.toString().equals(toStringExpected + "\n"));
            }),

            new Test("order()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                Date date3 = new Date(1, 3, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1000, 4, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 2, date1, date2, 1, 10, 5);
                FoodItem fi3 = new FoodItem("Name2", 1002, 2, date1, date3, 1, 10, 10);
                FoodItem fi4 = new FoodItem("Name3", 1004, 1, date1, date2, 1, 10, 5);
                FoodItem fi5 = new FoodItem("Name3", 1004, 1, date1, date2, 1, 10, 5);
                FoodItem fi6 = new FoodItem("Name4", 1005, 2, date1, date2, 1, 10, 5);
                FoodItem fi7 = new FoodItem("Name5", 1006, 1, date1, date2, 1, 10, 5);
                FoodItem fi8 = new FoodItem("Name5", 1006, 1, date2, date3, 1, 10, 6);
                FoodItem fi9 = new FoodItem("Name5", 1006, 1, date1, date2, 1, 10, 7);
                FoodItem fi10 = new FoodItem("Name6", 1007, 3, date1, date2, 1, 10, 5);
                FoodItem fi11 = new FoodItem("Name7", 1008, 2, date1, date2, 1, 10, 5);
                Stock stock = new Stock();

                assertEquals(stock.order(1), "");

                stock.addItem(fi1);
                stock.addItem(fi2);
                stock.addItem(fi3);
                stock.addItem(fi4);
                stock.addItem(fi5);
                stock.addItem(fi6);
                stock.addItem(fi7);
                stock.addItem(fi8);
                stock.addItem(fi9);
                stock.addItem(fi10);
                stock.addItem(fi11);

                assertEquals(stock.order(3), "Name3, Name4, Name7");
            }),

            new Test("updateStock()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                Date date3 = new Date(1, 3, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1000, 1, date1, date2, 1, 10, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 2, date1, date2, 1, 10, 5);
                FoodItem fi3 = new FoodItem("Name2", 1002, 2, date1, date3, 1, 10, 10);
                FoodItem fi4 = new FoodItem("Name3", 1003, 2, date1, date2, 1, 10, 5);
                FoodItem fi5 = new FoodItem("Name3", 1004, 2, date1, date2, 1, 10, 5);
                FoodItem fi6 = new FoodItem("Name4", 1005, 2, date1, date2, 1, 10, 5);
                FoodItem fi7 = new FoodItem("Name5", 1006, 1, date1, date2, 1, 10, 5);
                FoodItem fi8 = new FoodItem("Name5", 1006, 1, date2, date3, 1, 10, 5);
                FoodItem fi9 = new FoodItem("Name5", 1006, 1, date1, date3, 1, 10, 5);
                FoodItem fi10 = new FoodItem("Name6", 1007, 3, date1, date2, 1, 10, 5);
                FoodItem fi11 = new FoodItem("Name7", 1008, 2, date1, date2, 1, 10, 5);
                Stock actual = new Stock();

                actual.addItem(fi1);

                actual.updateStock(new String[]{"Name1"});

                assertEquals(actual, new FoodItem[]{});

                actual.addItem(fi1);
                actual.addItem(fi2);
                actual.addItem(fi3);
                actual.addItem(fi4);
                actual.addItem(fi5);
                actual.addItem(fi6);
                actual.addItem(fi7);
                actual.addItem(fi8);
                actual.addItem(fi9);
                actual.addItem(fi10);
                actual.addItem(fi11);

                actual.updateStock(new String[]{"Name6", "Name1", "Name2", "Name3", "Name7", "Name6", "Name3", "Name3", "Name3", "Name6", "Name5"});

                //order of adding items is also taken into consideration
                FoodItem fi_1 = new FoodItem("Name2", 1002, 1, date1, date3, 1, 10, 10);
                FoodItem fi_2 = new FoodItem("Name2", 1002, 2, date1, date2, 1, 10, 5);
                FoodItem fi_3 = new FoodItem("Name4", 1005, 2, date1, date2, 1, 10, 5);
                FoodItem fi_4 = new FoodItem("Name5", 1006, 1, date2, date3, 1, 10, 5);
                FoodItem fi_5 = new FoodItem("Name5", 1006, 1, date1, date2, 1, 10, 5);
                FoodItem fi_6 = new FoodItem("Name7", 1008, 1, date1, date2, 1, 10, 5);

                assertEquals(actual, new FoodItem[]{fi_1, fi_2, fi_3, fi_4, fi_5, fi_6});

                assertEquals(actual.getNumOfItems(), 6);
            }),

            new Test("getTempOfStock()", () -> {
                Date date1 = new Date(1, 1, 2000);
                Date date2 = new Date(1, 2, 2000);
                FoodItem fi1 = new FoodItem("Name1", 1001, 1, date1, date2, 1, 15, 5);
                FoodItem fi2 = new FoodItem("Name2", 1002, 1, date1, date2, 5, 8, 6);
                FoodItem fi3 = new FoodItem("Name3", 1003, 1, date1, date2, 6, 12, 7);
                FoodItem fi4 = new FoodItem("Name5", 1005, 1, date1, date2, 8, 13, 6);
                FoodItem fi5 = new FoodItem("Name6", 1006, 1, date1, date2, 9, 14, 6);

                Stock stock = new Stock();

                assertEquals(stock.getTempOfStock(), Integer.MAX_VALUE);

                stock.addItem(fi1);
                stock.addItem(fi2);
                stock.addItem(fi3);

                assertEquals(stock.getTempOfStock(), 6);

                stock.addItem(fi4);

                assertEquals(stock.getTempOfStock(), 8);

                stock.addItem(fi5);

                assertEquals(stock.getTempOfStock(), Integer.MAX_VALUE);
            }),
    });
    //Matrix tests
    private static final ClassTest matrixTests = new ClassTest("Matrix", new Test[]{
            new Test("toString() and Aliasing", () -> {
                Matrix m1 = new Matrix(2, 3);
                int[][] arr1 = new int[][]{{101, 102, 200}, {0, 10, 255}};
                Matrix m2 = new Matrix(arr1);

                assertEquals(m1.toString(), "0\t0\t0\n0\t0\t0\n");
                assertEquals(m2.toString(), "101\t102\t200\n0\t10\t255\n");

                String snapshot1 = m2.toString();
                arr1[0][0] = 99;
                String snapshot2 = m2.toString();

                assertEquals(snapshot1, snapshot2);
            }),
            new Test("imageFilterAverage()", () -> {
                Matrix matrix = new Matrix(new int[][]{
                        {19, 124, 28, 35, 38},
                        {115, 22, 25, 230, 31},
                        {9, 21, 22, 249, 230},
                        {0, 6, 9, 232, 255},
                        {2, 5, 10, 116, 129}});

                Matrix expected = new Matrix(new int[][]{
                        {70, 55, 77, 64, 83},
                        {51, 42, 84, 98, 135},
                        {28, 25, 90, 142, 204},
                        {7, 9, 74, 139, 201},
                        {3, 5, 63, 125, 183}});

                Matrix actual = matrix.imageFilterAverage();

                assertEquals(actual, expected);
            }),

            new Test("rotateClockwise()", () -> {
                Matrix matrix = new Matrix(new int[][]{
                        {19, 124, 28, 35},
                        {115, 22, 25, 230},
                        {19, 21, 22, 249},
                        {0, 16, 9, 232},
                        {62, 35, 10, 116}});

                Matrix expected = new Matrix(new int[][]{
                        {62, 0, 19, 115, 19},
                        {35, 16, 21, 22, 124},
                        {10, 9, 22, 25, 28},
                        {116, 232, 249, 230, 35}});

                Matrix actual = matrix.rotateClockwise();

                assertEquals(actual, expected);

                actual = actual.rotateClockwise();
                actual = actual.rotateClockwise();
                actual = actual.rotateClockwise();

                assertEquals(actual, matrix);
            }),

            new Test("rotateCounterClockwise()", () -> {
                Matrix matrix = new Matrix(new int[][]{
                        {62, 0, 19, 115, 19},
                        {35, 16, 21, 22, 124},
                        {10, 9, 22, 25, 28},
                        {116, 232, 249, 230, 35}});

                Matrix expected = new Matrix(new int[][]{
                        {19, 124, 28, 35},
                        {115, 22, 25, 230},
                        {19, 21, 22, 249},
                        {0, 16, 9, 232},
                        {62, 35, 10, 116}});

                Matrix actual = matrix.rotateCounterClockwise();

                assertEquals(actual, expected);

                actual = actual.rotateCounterClockwise();
                actual = actual.rotateCounterClockwise();
                actual = actual.rotateCounterClockwise();

                assertEquals(actual, matrix);
            }),

            new Test("makeNegative()", () -> {
                Matrix matrix = new Matrix(new int[][]{
                        {19, 124, 28, 35, 38},
                        {115, 22, 25, 230, 31},
                        {9, 21, 22, 249, 230},
                        {0, 6, 9, 232, 255},
                        {2, 5, 10, 116, 129}});

                Matrix expected = new Matrix(new int[][]{
                        {236, 131, 227, 220, 217},
                        {140, 233, 230, 25, 224},
                        {246, 234, 233, 6, 25},
                        {255, 249, 246, 23, 0},
                        {253, 250, 245, 139, 126}});

                Matrix actual = matrix.makeNegative();

                assertEquals(actual, expected);

                actual = actual.makeNegative();

                assertEquals(actual, matrix);
            }),
    });

    private static final String UPDATES_LINK = "https://pastebin.com/sV4zVKCQ";
    private static int errorsCurrent = 0;
    private static int errors = 0;
    private static Map<String, Map<String, Integer>> methodErrorsCount = new HashMap<>();
    private static Map<String, Map<String, ArrayList<String>>> methodErrorsMessages = new HashMap<>();
    private static Map<String, Integer> totalErrors = new HashMap<>();
    private static String cClass = "";
    private static String cMethod = "";

    public static void main(String[] args) {
        doTests(stockTests);
        doTests(matrixTests);
        report();
    }


    private static int doTests(ClassTest tests) {
        String className = tests.getClassName();
        cClass = className;
        if (VERBOSE)
            vPrint("=========================================\n" +
                    "\t\t\tTesting now: %s\n" +
                    "-----------------------------------------\n", className);
        else
            vPrint("\nTesting now: %s\n", className.toUpperCase());

        methodErrorsCount.put(className, new HashMap<>());
        methodErrorsMessages.put(className, new HashMap<>());
        errorsCurrent = 0;
        for (Test t : tests.getTests()) {
            cMethod = t.getName();

            if (VERBOSE) vPrint("----= %s =----\n", t.getName());

            int c = errorsCurrent;

            try {
                t.getTest().run();
            } catch (Exception e) {
                StringWriter writer = new StringWriter();
                e.printStackTrace(new PrintWriter(writer));
                failedAssert("Exception: " + writer.toString());
            }

            c = errorsCurrent - c;
            reportMethodErrors(t.getName(), c);
            cMethod = "";
            methodErrorsCount.get(className).put(t.getName(), c);
        }
        totalErrors.put(className, errorsCurrent);
        cClass = "";
        int e = errorsCurrent;
        errorsCurrent = 0;
        return e;
    }

    private static void assertEquals(Matrix m1, Matrix m2) {
        if (m1.toString().equals(m2.toString()))
            succeedAssert(String.format("%s and %s are equal", m1.toString(), m2.toString()));
        else
            failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s]\n", m2.toString(), m1.toString()));
    }

    private static void assertEquals(Stock actual, Stock expected) {
        if (actual.toString().equals(expected.toString()))
            succeedAssert(String.format("%s and %s are equal", actual.toString(), expected.toString()));
        else
            failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s]\n", expected.toString(), actual.toString()));
    }


    private static void assertEquals(String a, String b) {
        if (a.equals(b))
            succeedAssert(String.format("%s and %s are equal", a, b));
        else
            failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s]\n", b, a));
    }

    private static void assertEquals(int a, int b) {
        assertEquals(a, b, "");
    }

    private static void assertEquals(int a, int b, String failMsg) {
        if (a == b)
            succeedAssert(String.format("%s and %s are equal", a, b));
        else if (failMsg.isEmpty())
            failedAssert(String.format("Expected %s but got %s", b, a));
        else
            failedAssert(String.format("Expected %s but got %s (%s)", b, a, failMsg));
    }

    private static void assertEquals(FoodItem d1, FoodItem d2) {
        if (d1.equals(d2))
            succeedAssert(String.format("%s and %s are equal", d1.toString(), d2.toString()));
        else
            failedAssert(String.format("Expected %s but got %s", d2.toString(), d1.toString()));
    }

    private static void assertEquals(Stock actual, FoodItem[] expected) {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder actualString = new StringBuilder(actual.toString());
        if (actualString.lastIndexOf("\n") != actualString.length() - 1)
            actualString.append("\n");

        for (FoodItem foodItem : expected) {
            expectedString.append(foodItem.toString() + "\n");
        }

        assertEquals(actualString.toString(), expectedString.toString());
    }

    private static void assertTrue(boolean b) {
        assertTrue(b, "");
    }

    private static void assertTrue(boolean b, String failMsg) {
        if (b)
            succeedAssert("True");
        else if (failMsg.isEmpty())
            failedAssert("Expected true, but got FALSE");
        else
            failedAssert(String.format("Expected true, but got FALSE (%s)", failMsg));
    }


    private static void assertFalse(boolean b) {
        if (!b)
            succeedAssert("False");
        else
            failedAssert("Expected false, but got TRUE");
    }

    private static void failedAssert(String message) {
        int lineOfCode = -1;

        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (e.getMethodName().startsWith("lambda$")) {
                lineOfCode = e.getLineNumber();
                break;
            }
        }

        if (lineOfCode != -1) {
            vPrint(false, message + "\t-> FAIL (line: %d)\n", lineOfCode);
            message = String.format("At line %d: %s", lineOfCode, message);
        } else
            vPrint(false, message + "\t-> FAIL\n");

        ArrayList<String> msgs = methodErrorsMessages.get(cClass).getOrDefault(cMethod, new ArrayList<>());
        msgs.add(message);
        methodErrorsMessages.get(cClass).put(cMethod, msgs);
        methodErrorsCount.get(cClass).compute(cMethod, (k, c) -> c == null ? 0 : c + 1);
        errors++;
        errorsCurrent++;
    }

    private static void succeedAssert(String message) {
        vPrintln(false, message + "\t-> ok");
    }


    private static void vPrintln(String s) {
        vPrintln(true, s);
    }

    private static void vPrintln(Boolean v, String s) {
        vPrint(v, s + "\n");
    }

    private static void vPrint(String s, Object... o) {
        vPrint(true, s, o);
    }

    private static void vPrint(Boolean v, String s, Object... o) {
        if (v || VERBOSE)
            System.out.printf(s, o);
    }

    private static void report() {
        vPrintln("\n~~ Test is finished! ~~\n");
        vPrintln("===============================================\n" +
                "\t\t\t\tTESTS RESULTS\n" +
                "-----------------------------------------------");

        totalErrors.forEach((className, totalErrors) -> {
            vPrintln("-----------------------------------------------");
            vPrint("[%s] --> ", className.toUpperCase());
            if (totalErrors > 0) {
                vPrint("Tests revealed %d errors\n", totalErrors);
                methodErrorsCount.get(className).forEach((methodName, count) -> {
                    if (count > 0) {
                        vPrint("\t%s: %d errors\n", methodName, count);
                        methodErrorsMessages.get(className).get(methodName).forEach((msg) -> vPrintln("\t\t" + msg));
                        vPrintln("");
                    }
                });
            } else
                vPrintln(" Tests are passed with no errors");
        });

        vPrintln("-----------------------------------------------");

        if (errors > 0)
            vPrint("\t\t\tTotal errors: %d\n", errors);
        else
            vPrint("All classes passed tests with no errors\n");

        vPrintln("===============================================\n\n\n");
        vPrintln("What was your experience? Let me know: https://vk.cc/aa5jH8 Thanks for your warm words!\n" +
                "Before reporting an issue make sure you use the latest verison.");
        vPrint("Current version: %s, updates: %s\n\n", VERSION, UPDATES_LINK);
        vPrintln("~~ Please check your classes with official tester on forum ~~");
    }

    private static void reportMethodErrors(String methodName, int errorsCount) {
        String t = methodName.length() >= 25 ? "\t" : "";

        if (errorsCount == 0) {
            if (VERBOSE)
                vPrint("| OK\n\n", methodName);
            else
                vPrint("\t%-24s%s %-15s\n", methodName, t, "Ok");
        } else {
            if (VERBOSE)
                vPrint("| Errors: %d\n\n", errorsCount);
            else
                vPrint("\t%-24s%s Errors: %-15d\n", methodName, t, errorsCount);

        }
    }
}


class ClassTest {
    private String className;
    private Test[] tests;

    ClassTest(String className, Test[] tests) {
        this.className = className;
        this.tests = tests;
    }

    String getClassName() {
        return className;
    }

    Test[] getTests() {
        return tests;
    }
}

class Test {
    private String name;
    private Runnable test;

    Test(String name, Runnable test) {
        this.name = name;
        this.test = test;
    }

    String getName() {
        return name;
    }

    Runnable getTest() {
        return test;
    }
}