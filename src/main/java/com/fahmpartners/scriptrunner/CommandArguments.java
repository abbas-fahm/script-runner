package com.fahmpartners.scriptrunner;

import java.util.HashMap;

/**
 * @author Randy May
 *         Date: 2016-05-12
 */
public class CommandArguments extends HashMap<Argument, String> {
    protected String getScriptName() {
        return verifyAndReturnValue(Argument.SCRIPT_NAME_ARGUMENT);
    }
    protected String getServerName() {
        return verifyAndReturnValue(Argument.SERVER_NAME_ARGUMENT);
    }
    protected String getDatabaseName() {
        return verifyAndReturnValue(Argument.DATABASE_NAME_ARGUMENT);
    }
    protected String getUserName() {
        return verifyAndReturnValue(Argument.USER_NAME_ARGUMENT);
    }
    protected String getPassword() {
        return verifyAndReturnValue(Argument.PASSWORD_ARGUMENT);
    }
    protected boolean isHelpRequested() {
        return (this.containsKey(Argument.HELP_ARGUMENT) || this.containsKey(Argument.HELP_SHORT_ARGUMENT));
    }

    private String verifyAndReturnValue(Argument argument) {
        if (!this.containsKey(argument)) {
            throw new MissingKeyException("Missing key: " + argument.getKey());
        }
        return this.get(argument);
    }
}
