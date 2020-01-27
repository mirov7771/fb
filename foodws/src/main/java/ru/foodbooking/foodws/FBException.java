package ru.foodbooking.foodws;

/**
 * класс с исключениями
 * @author Stas Smal
 */


public class FBException extends Exception {

    private Long errorCode;

    public FBException(Long errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public FBException(Long errorCode, String errorMessage, Exception e){
        super(errorMessage, e);
        this.errorCode = errorCode;
    }

    public Long getErrorCode(){
        return errorCode;
    }
}
