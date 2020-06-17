//To download this: press "raw" button -> save as Maman14Test.java.
//Place in same package where Ex14 classes is located and run.

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Fully automated tests for maman 14 (OUI).
 * This class will test your Ex14 class and generate a
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
 * Your experience and issues: https://vk.cc/agFZL7
 * <p>
 * Thanks for everyone who leaves a feedback! =)
 * <p>
 *
 * @author Ilya Skornyakov
 * @version 0.5
 * @since JDK 8
 * <p>
 * Updates: https://pastebin.com/0dSf1Z6p
 */

public class Maman14Test {

    private static final ClassTest ex14Tests = new ClassTest("Ex14", new Test[]{
            new Test("[Q1.1] subStrC()", () -> {
                assertEquals(Ex14.subStrC("abcbcabcacabcc", 'c'), 4);
                assertEquals(Ex14.subStrC("abababcabc", 'c'), 0);
                assertEquals(Ex14.subStrC("cccccc", 'c'), 4);
                assertEquals(Ex14.subStrC("ccXXcXcc", 'c'), 3);
                assertEquals(Ex14.subStrC("c", 'c'), 0);
                assertEquals(Ex14.subStrC("cc", 'c'), 0);
                assertEquals(Ex14.subStrC("aacaacaa", 'c'), 0);
                assertEquals(Ex14.subStrC("cacacaaa", 'c'), 1);
                assertEquals(Ex14.subStrC("aaaaaaaaaaaaaa", 'c'), 0);
                assertEquals(Ex14.subStrC("aaaacaaaaaaaaaa", 'c'), 0);
                assertEquals(Ex14.subStrC("aaaacaaaaaaaaaca", 'c'), 0);
                assertEquals(Ex14.subStrC("aaaacaaacaaaaaca", 'c'), 1);
                assertEquals(Ex14.subStrC("aaaacccaaaaaaaaa", 'c'), 1);
                assertEquals(Ex14.subStrC("", 'c'), 0);
            }),
            new Test("[Q1.2] subStrMaxC()", () -> {
                assertEquals(Ex14.subStrMaxC("abcbc", 'c', 1), 1);
                assertEquals(Ex14.subStrMaxC("abcbcabcacab", 'c', 0), 3);
                assertEquals(Ex14.subStrMaxC("abcbcabcacab", 'c', 1), 5);
                assertEquals(Ex14.subStrMaxC("abcbcabcacab", 'c', 2), 6);
                assertEquals(Ex14.subStrMaxC("abcbcabcacab", 'c', 3), 6);
                assertEquals(Ex14.subStrMaxC("abcbcabcacab", 'c', 999), 6);
                assertEquals(Ex14.subStrMaxC("abc", 'c', 2), 0);
                assertEquals(Ex14.subStrMaxC("abc", 'c', 1), 0);
                assertEquals(Ex14.subStrMaxC("abc", 'c', 0), 0);
            }),
            new Test("[Q2] zeroDistance()", () -> {
                int[] arr1 = new int[]{0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1};
                int[] exp1 = new int[]{0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0, 1, 2};
                Ex14.zeroDistance(arr1);
                assertEquals(arr1, exp1);

                int[] arr2 = new int[]{0, 0, 0, 0};
                int[] exp2 = new int[]{0, 0, 0, 0};
                Ex14.zeroDistance(arr2);
                assertEquals(arr2, exp2);

                int[] arr3 = new int[]{0, 1, 1, 1};
                int[] exp3 = new int[]{0, 1, 2, 3};
                Ex14.zeroDistance(arr3);
                assertEquals(arr3, exp3);

                int[] arr4 = new int[]{1, 1, 1, 0};
                int[] exp4 = new int[]{3, 2, 1, 0};
                Ex14.zeroDistance(arr4);
                assertEquals(arr4, exp4);

                int[] arr5 = new int[]{1, 1, 0, 1};
                int[] exp5 = new int[]{2, 1, 0, 1};
                Ex14.zeroDistance(arr5);
                assertEquals(arr5, exp5);

                int[] arr6 = new int[]{1, 1, 0, 1, 1};
                int[] exp6 = new int[]{2, 1, 0, 1, 2};
                Ex14.zeroDistance(arr6);
                assertEquals(arr6, exp6);

                int[] arr7 = new int[]{0, 1, 1, 1, 0};
                int[] exp7 = new int[]{0, 1, 2, 1, 0};
                Ex14.zeroDistance(arr7);
                assertEquals(arr7, exp7);

                int[] arr8 = new int[]{0, 1, 1, 1, 1, 0};
                int[] exp8 = new int[]{0, 1, 2, 2, 1, 0};
                Ex14.zeroDistance(arr8);
                assertEquals(arr8, exp8);

                int[] arr9 = new int[]{0, 1, 1, 1, 0, 1, 1, 0};
                int[] exp9 = new int[]{0, 1, 2, 1, 0, 1, 1, 0};
                Ex14.zeroDistance(arr9);
                assertEquals(arr9, exp9);

                int[] arr10 = new int[]{1, 0, 1, 1, 1, 0, 1, 1};
                int[] exp10 = new int[]{1, 0, 1, 2, 1, 0, 1, 2};
                Ex14.zeroDistance(arr10);
                assertEquals(arr10, exp10);

            }),
            new Test("[Q3] isTrans()", () -> {
                assertTrue(Ex14.isTrans("abbcd", "abbbccd"));
                assertTrue(Ex14.isTrans("abbcd", "aabbccdd"));
                assertTrue(Ex14.isTrans("abbcd", "abbcdddddd"));
                assertTrue(Ex14.isTrans("abbcd", "aaaabbcd"));
                assertTrue(Ex14.isTrans("abbcd", "abbcd"));

                assertFalse(Ex14.isTrans("abbcd", "aaccbbdd"));
                assertFalse(Ex14.isTrans("abbcd", "abcd"));
                assertFalse(Ex14.isTrans("abbcd", "a"));


                assertTrue(Ex14.isTrans("aaaa", "aaaa"));
                assertTrue(Ex14.isTrans("aaaa", "aaaaa"));
                assertTrue(Ex14.isTrans("b", "b"));
                assertTrue(Ex14.isTrans("b", "bb"));

                assertTrue(Ex14.isTrans("ababa", "ababa"));
                assertTrue(Ex14.isTrans("ababa", "abaaba"));
                assertTrue(Ex14.isTrans("ababa", "abbbbaaba"));

                assertFalse(Ex14.isTrans("ababa", "baba"));
                assertFalse(Ex14.isTrans("ababa", "abab"));

                assertFalse(Ex14.isTrans("aa", "ab"));
                assertFalse(Ex14.isTrans("aaaa", "aaa"));
                assertFalse(Ex14.isTrans("a", ""));
            }),
            new Test("[Q4] countPaths()", () -> {
                int arr[][] = new int[][]{{12, 22, 23, 5}, {43, 35, 21, 20}, {34, 21, 43, 21}, {25, 30, 0, 20}, {0, 22, 10, 10}, {20, 13, 3, 45}};
                int arrC[][] = new int[][]{{12, 22, 23, 5}, {43, 35, 21, 20}, {34, 21, 43, 21}, {25, 30, 0, 20}, {0, 22, 10, 10}, {20, 13, 3, 45}};
                assertEquals(Ex14.countPaths(arr), 3);
                assertEquals(arr, arrC, "Do not change an array!");

                int arr2[][] = new int[][]{{10, 2, 11, 11}, {2, 11, 13, 11}, {11, 12, 11, 11}, {11, 11, 11, 1}, {11, 11, 10, 11}};
                assertEquals(Ex14.countPaths(arr2), 3);
            }),
    });

    private static final boolean VERBOSE = false;
    private static final String VERSION = "0.5";
    private static final String UPDATES_LINK = "https://pastebin.com/0dSf1Z6p";
    private static int errorsCurrent = 0;
    private static int errors = 0;
    private static Map<String, Map<String, Integer>> methodErrorsCount = new HashMap<>();
    private static Map<String, Map<String, ArrayList<String>>> methodErrorsMessages = new HashMap<>();
    private static Map<String, Integer> totalErrors = new HashMap<>();
    private static String cClass = "";
    private static String cMethod = "";

    public static void main(String[] args) {
        doTests(ex14Tests);
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


    private static void assertEquals(int[] a, int[] exp) {
        if (a.length != exp.length) {
            failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s] (different lengths)\n", a, exp));
            return;
        }

        StringBuilder aStr = new StringBuilder();
        StringBuilder eStr = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            aStr.append(a[i]).append("\t");
            eStr.append(exp[i]).append("\t");
        }


        for (int i = 0; i < a.length; i++)
            if (a[i] != exp[i]) {
                failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s]\n(element %s at index %d)\n", eStr, aStr, a[i], i));
                return;
            }

        succeedAssert("Arrays are equal");
    }

    private static void assertEquals(int[][] arr, int[][] arrC, String failMsg) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i].length != arrC[i].length)
                    failedAssert(String.format("Expected:\n[%s]\nBut got:\n[%s] (different lengths)\n", arr, arr));
                if (arr[i][j] != arrC[i][j])
                    failedAssert(String.format("Arrays are different (%s)", failMsg));
            }

        succeedAssert("Arrays are equal");
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
                vPrint("✖ Tests revealed %d errors ᕙ(⇀‸↼‶)ᕗ\n", totalErrors);
                methodErrorsCount.get(className).forEach((methodName, count) -> {
                    if (count > 0) {
                        vPrint("\t%s: %d errors\n", methodName, count);
                        methodErrorsMessages.get(className).get(methodName).forEach((msg) -> vPrintln("\t\t" + msg));
                        vPrintln("");
                    }
                });
            } else
                vPrintln("✓ Tests are passed with no errors ┐(￣ヮ￣)┌");
        });

        vPrintln("-----------------------------------------------");


        if (errors > 0)
            vPrint("\t\t\tTotal errors: %d\n", errors);
        else
            vPrint("All classes passed tests with no errors\n");

        vPrintln("===============================================");
        if (errors == 0)
            vPrint("Congratulations!\n☕ Good moment to consider buying me a cup coffee: %s ☕\n", new StringBuilder("iMfxaa/cc.kv//:sptth").reverse().toString());

        vPrintln("");
        vPrintln("What was your experience? Let me know: https://vk.cc/agFZL7 Thanks for your warm words!\n" +
                "Before reporting an issue make sure you use the latest verison.");
        vPrint("You're using version: %s, updates: %s\n\n", VERSION, UPDATES_LINK);

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

    private static class ClassTest {
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

    private static class Test {
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
}