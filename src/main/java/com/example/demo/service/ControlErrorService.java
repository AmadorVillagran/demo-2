package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.example.demo.constant.ConstantMsg;
import com.example.demo.dto.ResponseDTO;


@Service
public class ControlErrorService {
	public ResponseDTO getErrorValidation(BindingResult ex) {
		ResponseDTO responseDTO = new ResponseDTO();

		Optional<ObjectError> errorLongitud = ex.getAllErrors().stream()
				.filter(filterLength -> filterLength.getCode().equals("Length")
						|| filterLength.getCode().equals("Digits") || filterLength.getCode().equals("DecimalMax"))
				.findFirst();

		Optional<ObjectError> invalidValue = ex.getAllErrors().stream()
				.filter(filterLength -> filterLength.getCode().equals("Pattern") || filterLength.getCode().equals("Min")
						|| filterLength.getCode().equals("Max") || filterLength.getCode().equals("typeMismatch"))
				.findFirst();

		Optional<ObjectError> errorGeneric = ex.getAllErrors().stream()
				.filter(filterLength -> filterLength.getCode().equals("GenericDTOValidator")
						|| filterLength.getCode().equals("EstadosDTOValidator")
						|| filterLength.getCode().equals("TipoOperadorDTOValidator"))
				.findFirst();

		if (errorLongitud.isPresent()) {
			responseDTO.getError().setCodError(ConstantMsg.CODE_462);
			responseDTO.getError()
					.setMessError(String.format(ConstantMsg.ERROR_462, ((FieldError) errorLongitud.get()).getField()));
		} else if (invalidValue.isPresent()) {
			responseDTO.getError().setCodError(ConstantMsg.CODE_463);
			responseDTO.getError()
					.setMessError(String.format(ConstantMsg.ERROR_463, ((FieldError) invalidValue.get()).getField()));
		} else if (errorGeneric.isPresent()) {
			responseDTO = getErrorGenericDTO(errorGeneric.get());
		} else {
			Optional<ObjectError> errorObligatoriedad = ex.getAllErrors().stream().findFirst();
			responseDTO.getError().setCodError(ConstantMsg.CODE_460);
			responseDTO.getError()
					.setMessError(String.format(ConstantMsg.ERROR_460,
							errorObligatoriedad.isPresent() ? ((FieldError) errorObligatoriedad.get()).getField()
									: "missingField"));
		}

		return responseDTO;
	}

	public ResponseDTO getErrorGenericDTO(ObjectError objectError) {
		ResponseDTO responseDTO = new ResponseDTO();

		FieldError fieldError = (FieldError) objectError;
		String errorMessage = fieldError.getDefaultMessage();

		if (errorMessage != null && !errorMessage.contains("|")) {
			responseDTO.getError().setCodError(ConstantMsg.CODE_460);
			responseDTO.getError().setMessError(String.format(ConstantMsg.ERROR_460, fieldError.getField()));
		} else {
			String messageError = fieldError.getDefaultMessage() == null ? "|" : fieldError.getDefaultMessage();
			String[] splitError = messageError == null ? "|".split("\\|") : messageError.split("\\|");

			if (splitError[0].equals("Length")) {
				responseDTO.getError().setCodError(ConstantMsg.CODE_462);
				responseDTO.getError().setMessError(String.format(ConstantMsg.ERROR_462,
						String.format("%s%s", fieldError.getField(), splitError[1])));
			} else {
				responseDTO.getError().setCodError(ConstantMsg.CODE_463);
				responseDTO.getError().setMessError(String.format(ConstantMsg.ERROR_463,
						String.format("%s%s", fieldError.getField(), splitError[1])));
			}
		}

		return responseDTO;
	}

}
