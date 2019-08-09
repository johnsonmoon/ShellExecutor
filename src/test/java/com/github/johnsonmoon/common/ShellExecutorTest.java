package com.github.johnsonmoon.common;

import org.junit.Test;

/**
 * Create by johnsonmoon at 2018/10/31 11:33.
 */
public class ShellExecutorTest {
    private static String userDir = System.getProperty("user.dir");

    @Test
    public void testSimple() throws ShellExecutor.CommandTimeoutException {
        System.out.println(
                ShellExecutor.execute(
                        "pwd",
                        userDir + "/scripts",
                        null,
                        ((message, process) -> System.out.println(message))
                )
        );
    }

    @Test
    public void test() throws ShellExecutor.CommandTimeoutException {
        int result = ShellExecutor.execute(
                userDir + "/scripts/test.sh",
                null,
                null,
                (message, process) -> System.out.println(String.format("Communication[1]: %s", message)),
                (message, process) -> System.out.println(String.format("Communication[2]: %s", message)),
                (message, process) -> System.out.println(String.format("Communication[3]: %s", message))
        );
        System.out.println(result);
    }

    @Test
    public void testMavenBuild() throws ShellExecutor.CommandTimeoutException {
        System.out.println(ShellExecutor.execute(
                userDir + "/scripts/testMvnInstall.sh",
                null,
                null,
                (message, process) -> System.out.println(message))
        );
    }

    @Test
    public void simpleTest() {
        try {
            int exitValue = ShellExecutor.execute(
                    "./test.sh",
                    System.getProperty("user.dir") + "/scripts",
                    null,
                    (message, process) -> System.out.println(message)
            );
            System.out.println("exitValue: " + exitValue);
        } catch (ShellExecutor.CommandTimeoutException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void complexCommandTest() {
        try {
            int exitValue = ShellExecutor.execute(
                    "ps -ef | grep java | grep -v grep",
                    System.getProperty("user.dir"),
                    null,
                    (message, process) -> System.out.println(message)
            );
            System.out.println("exitValue: " + exitValue);
        } catch (ShellExecutor.CommandTimeoutException e) {
            System.out.println(e.getMessage());
        }
    }
}
