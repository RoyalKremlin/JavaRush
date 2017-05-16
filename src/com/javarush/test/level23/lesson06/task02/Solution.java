package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants{
        final static String serverNotAccessible = "Server is not accessible for now." ;
        final static String unauthorizedUser = "User is not authorized.";
        final static String bannedUser = "User is banned.";
        final static String restriction = "Access is denied.";


    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(new Constants().serverNotAccessible);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(new Constants().serverNotAccessible, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(new Constants().unauthorizedUser);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(new Constants().unauthorizedUser, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(new Constants().bannedUser);
        }

        public BannedUserException(Throwable cause) {
            super(new Constants().bannedUser, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(new Constants().restriction);
        }

        public RestrictionException(Throwable cause) {
            super(new Constants().restriction, cause);
        }
    }
}
