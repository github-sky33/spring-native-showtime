package cn.mindray.showtime.base.exception;

import lombok.Data;

import java.io.PrintWriter;
import java.io.StringWriter;

@Data
public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_MSG = "JWI_CUSTOM_EXCEPTION";

	/**
	 * 异常码，code=0为正常，非0为异常
	 */
	private int code;

	private String msg;

	public BaseException(){
		this(EXCEPTION_MSG);
	}

	public BaseException(Throwable e) {
		this(-1, null);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		this.msg = sw.toString();
	}

	public BaseException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public BaseException(String msg) {
		this(-1,msg);
	}

}
