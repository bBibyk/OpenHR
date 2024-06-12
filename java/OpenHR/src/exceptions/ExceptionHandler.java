package exceptions;

public class ExceptionHandler {
    public static void handleException(Exception e, String solution) {
        System.out.println("\tException : " + e.getMessage());
        if(solution != null) {
            System.out.println("\t" + solution);
        }
    }
}
