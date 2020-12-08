package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class ErroHandler {

	private MessageSource messageSource;

	@Autowired
	public ErroHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroHandleDTO> handle(MethodArgumentNotValidException exception){
		
		List<ErroHandleDTO> erro = new ArrayList<>();
		List<FieldError> fieldErro = exception.getBindingResult().getFieldErrors();
		
		fieldErro.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroHandleDTO dto = new ErroHandleDTO(e.getField(), mensagem);
			
			erro.add(dto);
		});
		
		
		return erro;
	}
	
	
	
}
