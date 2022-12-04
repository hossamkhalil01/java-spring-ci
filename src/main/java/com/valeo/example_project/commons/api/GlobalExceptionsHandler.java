package com.valeo.example_project.commons.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Handles all global exception across the api.
 *
 * @author Hossam Khalil.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionsHandler.class);
    private static final String INVALID_REQUEST_PARAM_MSG = "Invalid Request Parameter.";
    private static final String UNEXPECTED_ERROR_MSG = "Unexpected Error Occurred.";
    private static final String NOT_FOUND_MSG = "Not Found.";

    /**
     * Handles all un captured exceptions (unexpected) and doesn't include the exception message in the response.
     *
     * @param ex:      the exceptions instance.
     * @param request: the current request.
     * @return Error Response instance with generic message and InternalServerError status code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        log.error("Unexpected error occurred while handling request <{}>.", request.getDescription(true));
        log.error("Exception: <{}> , Error msg: <{}>", ex.getClass().getSimpleName(), ex.getLocalizedMessage());

        ErrorResponse errorResponse = new ErrorResponse(new Date(), UNEXPECTED_ERROR_MSG, "");

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles validation exceptions.
     *
     * @param ex: the exceptions instance.
     * @return Error Response object that includes the validation error message and BadRequest status code.
     */
    @ExceptionHandler({DateTimeParseException.class, InvalidParameterException.class})
    public ResponseEntity<Object> handleInvalidRequestParamsExceptions(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), INVALID_REQUEST_PARAM_MSG, ex.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all NotFound exceptions derived from the abstract ResourceNotFoundException class.
     *
     * @param ex: the exceptions instance.
     * @return Error Response object with NotFound status code.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), NOT_FOUND_MSG, ex.getLocalizedMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
