package com.hanko.auth.exception;

import com.hanko.cmn.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * <p>
 * 全局异常处理器结合sentinel 全局异常处理器
 * </p>
 *
 * @author hanko
 * @date 2021-02-22
 */

@Slf4j
@ControllerAdvice
public class GlobalAuthExceptionHandler  extends GlobalExceptionHandler {


}

