package net.diyotech.student_management_system.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //annotation for global handling
public class GlobalExceptionHandling {

        @ExceptionHandler(NullPointerException.class)
        public ResponseEntity<String> handleNullPointerException(NullPointerException e){
            System.out.println("Inside null pointer exception");
            return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
            public ResponseEntity<String> handleArrayIndexException(ArrayIndexOutOfBoundsException e){
            System.out.println("Inside handle array index exception");
            return ResponseEntity.internalServerError().body(e.getMessage());

        }
}
