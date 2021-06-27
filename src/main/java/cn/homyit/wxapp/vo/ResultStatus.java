package cn.homyit.wxapp.vo;


import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Getter
public enum ResultStatus {
    //Http中已定义状态
    SUCCESS(HttpStatus.OK,200,"OK"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,400,"Bad Request"),
    FORBIDDEN(HttpStatus.FORBIDDEN,403, "Forbidden"),
    NOT_FOUND(HttpStatus.NOT_FOUND,404, "Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,500,"Internal Server Error"),
    BAD_GATEWAY(HttpStatus.BAD_GATEWAY,502, "Bad Gateway"),
    //自定义状态
    WRONG_PASSWORD(1001,"Wrong Password"),
    USER_DOES_NOT_EXIST(1002,"User Does Not Exist"),
    PHONE_DOES_NOT_EXIST(1003,"Phone Does Not exist"),
    USER_ALREADY_EXIST(1004,"User Already Exist"),
    THE_PHONE_NUMBER_HAS_BEEN_REGISTERED(1005,"The Phone Number Has Been Registered"),
    SERVER_INTERNAL_ERROR(1006,"Server Internal Error"),
    MISSING_PARAMETERS(1007,"Missing Parameters"),
    INFORMATION_DOES_NOT_MATCH(1008,"Information_Does_Not_Match"),
    PHONE_ALREADY_EXIST(1009,"Phone Already Exist"),
    CHECK_CODE_WRONG(1010,"Check Code Wrong"),
    VERIFY_FAILED(1011,"Verify Failed"),
    THE_USER_IS_NOT_LOGGED_IN(1012,"The User Is Not Logged In"),
    THE_ARTICLE_ALREADY_EXIST(1013,"The Article Already Exist"),
    THE_MOVIE_DOES_NOT_EXIST(1014,"Movie Does Not exist"),
    NOTHING_HAS_BEEN_UPDATE(1015,"Nothing has been updated"),
    EMPTY_NAME(1016,"Empty Movie name"),
    ID_IS_EMPTY_OR_WRONG(1017,"Id is empty"),;
    /**返回的HTTP状态码,符合http请求*/
    private HttpStatus httpStatus;
    /**业务异常嘛*/
    private Integer code;
    /**业务异常信息描述*/
    private String message;
    ResultStatus(HttpStatus httpStatus,Integer code,String message){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
    ResultStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
