package com.fahmpartners.scriptrunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Tool to run database scripts
 *
 * @author Randy May
 *         Date: 2016-05-12
 */
public class ScriptRunner {
    public static void main(String[] args) {
        ScriptRunner runner = new ScriptRunner();

        try {
            runner.process(args);
        } catch (ClassNotFoundException e) {
            System.err.println("Unable to get mysql driver: " + e);
        } catch (SQLException e) {
            System.err.println("Unable to connect to server: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected void process(String[] args) throws ClassNotFoundException, SQLException, IOException {
        CommandArguments arguments = CommandArgumentsParser.parseArguments(args);
        if (arguments.isHelpRequested()) {
            showHelp();
            return;
        }

        if (!isArgumentsComplete(arguments)) {
            System.err.println("Missing or invalid arguments");
            showHelp();
            return;
        }

        String url = buildUrl(arguments);

        System.out.println("Connection URL: " + url);

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url);

        ScriptExecutor runner = new ScriptExecutor(connection, false, false);
        String file = arguments.getScriptName();

        runner.runScript(new BufferedReader(new FileReader(file)));
    }

    protected boolean isArgumentsComplete(CommandArguments arguments) {
        return arguments.containsKey(Argument.SCRIPT_NAME_ARGUMENT) &&
                arguments.containsKey(Argument.DATABASE_NAME_ARGUMENT) &&
                arguments.containsKey(Argument.USER_NAME_ARGUMENT) &&
                arguments.containsKey(Argument.PASSWORD_ARGUMENT) &&
                arguments.containsKey(Argument.SCRIPT_NAME_ARGUMENT);
    }

    protected void showHelp() {
        System.out.println("The following parameters are used:");

        for (Argument argument : Argument.values()) {
            System.out.println(argument.getKey());
        }

        System.out.println("");
        System.out.println("This is a valid set of arguments: ");
        System.out.println("-fileName /scripts/script1 -dbName DATABASE -serverName SERVER -userName USER -password PASSWORD");
    }

    protected String buildUrl(CommandArguments arguments) {
        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://");
        url.append(arguments.getServerName());
        url.append("/");
        url.append(arguments.getDatabaseName());
        url.append("?user=");
        url.append(arguments.getUserName());
        url.append("&password=");
        url.append(arguments.getPassword());

        return url.toString();
    }
}
