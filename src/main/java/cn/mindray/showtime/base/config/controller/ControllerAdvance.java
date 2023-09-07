package cn.mindray.showtime.base.config.controller;

import cn.mindray.showtime.base.entity.Result;
import cn.mindray.showtime.base.exception.BaseException;
import cn.mindray.showtime.base.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description:
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvance {

    @ExceptionHandler
    public Result handlerException(BaseException e){
        log.error(ExceptionUtil.stackTrace(e));
        Result resp = Result.failed(e.getMessage());
        return resp;
    }

    @ExceptionHandler
    public Result handlerException(Exception e){
        log.error(ExceptionUtil.stackTrace(e));
        Result resp = Result.failed(e.getMessage());
        return resp;
    }
}
