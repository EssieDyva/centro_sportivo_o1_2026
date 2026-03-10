package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class UtenteDTO {
	
	private String userName;
	private String pwd;
	private String email;
	private String role;

}
