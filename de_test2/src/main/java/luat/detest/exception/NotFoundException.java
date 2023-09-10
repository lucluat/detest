package luat.detest.exception;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException( String message){
        super(message);
    }
}
