package com.example.demo.controllerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.ConstantMsg;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exception.DemoException;
import com.example.demo.service.ControlErrorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class HandleErrorControllerImpl {
	@Autowired
	private ControlErrorService controlErrorService;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
		return controlErrorService.getErrorValidation(ex.getBindingResult());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DemoException.class)
	public ResponseDTO handleCustomValidationExceptionsSieca(DemoException ex) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.getError().setCodError(ex.getCodError());
		responseDTO.getError().setMessError(ex.getMessage());
		return responseDTO;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ResponseDTO handleValidationExceptions(BindException ex) {
		return controlErrorService.getErrorValidation(ex.getBindingResult());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseDTO handleAllUncaughtException(Exception exception) {
		ResponseDTO responseDTO = new ResponseDTO();
		String guidError = java.util.UUID.randomUUID().toString();
		log.error(ConstantMsg.ERROR_KEY + guidError, exception);
		responseDTO.getError().setCodError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		responseDTO.getError().setMessError(
				ConstantMsg.ERROR_474 + "(" + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + ") " + guidError);
		return responseDTO;
	}
}
