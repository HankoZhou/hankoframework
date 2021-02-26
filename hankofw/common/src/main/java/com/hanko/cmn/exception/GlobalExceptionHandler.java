package com.hanko.cmn.exception;

import com.hanko.cmn.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.nio.file.AccessDeniedException;
import java.util.List;


/**
 * <p>
 * 全局异常处理器结合sentinel 全局异常处理器
 * </p>
 *
 * @author hanko
 * @date 2021-02-22
 */

@Slf4j
public class GlobalExceptionHandler {


/**
	 * 全局异常.
	 * @param e the e
	 * @return R
	 */

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleGlobalException(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		// 业务异常交由 sentinel 记录
//		TraceResult.trace(e);
		return Result.failed(e.getLocalizedMessage());
	}


/**
	 * AccessDeniedException
	 * @param e the e
	 * @return R
	 */

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Result handleAccessDeniedException(AccessDeniedException e) {
		log.error("拒绝授权异常信息 ex={}", e.getMessage(), e);
		return Result.failed(e.getLocalizedMessage());
	}


/**
	 * validation Exception
	 * @param exception
	 * @return R
	 */

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleBodyValidException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}


/**
	 * validation Exception (以form-data形式传参)
	 * @param exception
	 * @return R
	 */

	@ExceptionHandler({ BindException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result bindExceptionHandler(BindException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}

}

