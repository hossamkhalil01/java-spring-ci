package com.valeo.example_project.commons.logging;


/**
 * Utility class that contains all the messages formats for trace messages.
 *
 * @author Hossam Khalil
 */
public abstract class LogMessages {

  private static final String METHOD_ENTRY = "Starting execution of method [%s]..";
  private static final String METHOD_EXITING = "Exiting [%s] with status [%s]; exec time (ms): %s";
  private static final String ERROR = "Error while executing [%s] : %s";

  public static String methodEntry(String methodName) {
    return String.format(METHOD_ENTRY, methodName);
  }

  public static String methodExit(String methodName, String status, String execTime) {
    return String.format(METHOD_EXITING, methodName, status, execTime);
  }

  public static String methodError(String methodName, String error) {
    return String.format(ERROR, methodName, error);
  }
}
