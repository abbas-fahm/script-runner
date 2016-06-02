package com.fahmpartners.scriptrunner;

/**
 * @author Randy May
 *         Date: 2016-05-12
 */
public enum Argument {
    HELP_SHORT_ARGUMENT("-h"),
    HELP_ARGUMENT("-help"),
    SCRIPT_NAME_ARGUMENT("-fileName"),
    SERVER_NAME_ARGUMENT("-serverName"),
    DATABASE_NAME_ARGUMENT("-dbName"),
    USER_NAME_ARGUMENT("-userName"),
    PASSWORD_ARGUMENT("-password");

    private String key;

    Argument(String key) {
        this.key = key;
    }

    public static Argument getValue(String key) {
        for (Argument argument : values()) {
            if (argument.key.equals(key)) {
                return argument;
            }
        }

        return null;
    }

    protected String getKey() {
        return key;
    }
}
