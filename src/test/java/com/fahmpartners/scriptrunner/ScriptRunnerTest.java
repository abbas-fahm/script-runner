package com.fahmpartners.scriptrunner;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Randy May
 *         Date: 2016-05-13
 */
public class ScriptRunnerTest {
    @Test
    public void testProcess() throws Exception {

    }

    @Test
    public void testShowHelp() throws Exception {
        ScriptRunner runner = new ScriptRunner();

        runner.showHelp();
    }

    @Test
    public void testBuildUrl() throws Exception {
        ScriptRunner runner = new ScriptRunner();
        CommandArguments arguments =
                CommandArgumentsParser.parseArguments(
                        "-fileName", "/scripts/script1",
                        "-dbName", "DATABASE",
                        "-serverName", "SERVER",
                        "-userName", "USER",
                        "-password", "PASSWORD");

        String actual = runner.buildUrl(arguments);

        String expected = "jdbc:mysql://SERVER/DATABASE?user=USER&password=PASSWORD";

        assertEquals(expected, actual);
    }

}