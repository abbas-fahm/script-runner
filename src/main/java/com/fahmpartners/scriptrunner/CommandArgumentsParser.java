package com.fahmpartners.scriptrunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Randy May
 *         Date: 2016-05-12
 */
public class CommandArgumentsParser {
    public static CommandArguments parseArguments(String... args) {
        CommandArguments arguments = new CommandArguments();

        for (int index = 0; index < args.length; index++) {
            String value = args[index];

            if (value.startsWith("-")) {
                // Value is a key
                String nextValue = null;

                // Get the value
                if (index + 1 < args.length) {
                    nextValue = args[index + 1];
                    if (nextValue.startsWith("-")) {
                        // Next value is a key, so the value
                        // for the current key is null
                        nextValue = null;
                    }
                }

                Argument key = Argument.getValue(value);
                if (key == null) {
                    throw new InvalidKeyException("Invalid Key '" + value + "' found.");
                }
                arguments.put(key, nextValue);
            }

        }

        return arguments;
    }
}
