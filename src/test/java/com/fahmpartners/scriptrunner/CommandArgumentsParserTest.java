package com.fahmpartners.scriptrunner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Randy May
 *         Date: 2016-05-12
 */
public class CommandArgumentsParserTest {

    @Test
    public void testSimpleFileName() throws Exception {
        CommandArguments arguments = CommandArgumentsParser.parseArguments("-fileName", "/scripts/script1");

        assertEquals(arguments.getScriptName(), "/scripts/script1");
    }

    @Test
    public void testNullFileName() throws Exception {
        CommandArguments arguments = CommandArgumentsParser.parseArguments("-fileName");

        assertNull(arguments.getScriptName());
    }

    @Test
    public void testMissingParam() throws Exception {
        CommandArguments arguments = CommandArgumentsParser.parseArguments("-fileName", "-dbName");

        assertNull(arguments.getScriptName());
        assertNull(arguments.getDatabaseName());
    }

    @Test
    public void testFull() throws Exception {
        CommandArguments arguments =
                CommandArgumentsParser.parseArguments(
                        "-fileName", "/scripts/script1",
                        "-dbName", "DATABASE",
                        "-serverName", "SERVER",
                        "-userName", "USER",
                        "-password", "PASSWORD");

        assertEquals(arguments.getScriptName(), "/scripts/script1");
        assertEquals(arguments.getDatabaseName(), "DATABASE");
        assertEquals(arguments.getServerName(), "SERVER");
        assertEquals(arguments.getUserName(), "USER");
        assertEquals(arguments.getPassword(), "PASSWORD");
    }

    @Test
    public void testHelpShort() throws Exception {
        CommandArguments arguments =
                CommandArgumentsParser.parseArguments("-h");

        assertTrue(arguments.isHelpRequested());
    }

    @Test
    public void testHelp() throws Exception {
        CommandArguments arguments =
                CommandArgumentsParser.parseArguments("-help");

        assertTrue(arguments.isHelpRequested());
    }
}