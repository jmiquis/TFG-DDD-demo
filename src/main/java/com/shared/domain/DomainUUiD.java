package com.shared.domain;

import java.util.UUID;

import javax.persistence.MappedSuperclass;

/**
 * Esta clase tiene dependencias de Java y aún así está en la capa de dominio.
 * La razón es que podemos consguir las mismas funcionalidades picandolas nosotros pero nos ahorramos tiempo al importarlas.
 * Cambiará en próximas iteraciones.
 * @author jorge
 *
 */

@MappedSuperclass
public abstract class DomainUUiD {
	
	protected String value;
	
	public DomainUUiD() {}
	
	public DomainUUiD(String generatedUUiD) {
		validator(generatedUUiD);
		validateUUiD(generatedUUiD);
		this.value=generatedUUiD;
	}
	
	
	public void validateUUiD(String domainUUid) throws IllegalArgumentException {
		 UUID.fromString(domainUUid);
	}


	
	public boolean equals(DomainUUiD other) {		
		return ( this.toString().equals(other.toString()));	
	}
	
	public String value() {
        return value;
    }
	
	protected void validator(String value) throws IllegalArgumentException{
    	if (null==value || value.isBlank()|| value.isEmpty()) {
			throw new IllegalArgumentException("The UUiD "+value+" is an invalid one");
		}	
	}
	
	/**
	 * TODO check if the id is unique in the ENTIRE app
	 * @body every id should be unique
	 */
	protected void checkIfUUiDIsUniqueInTheEntireApp(String propossedId) {
		
	}
	
	
	
	
}
