package com.shared.domain;

import java.io.Serializable;
import java.util.Objects;




public abstract class StringValueObject implements Serializable{

	
	private static final long serialVersionUID = 1L;
	protected String value;

	
	public String value() {
        return value;
    }
	
	
	
	@Override
	public String toString() {
		return value;
	}
	
	//same class and value 
	public abstract boolean equals(StringValueObject other);

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    protected void validator(String value){
    	if (null==value || value.isBlank()|| value.isEmpty()) {
			throw new IllegalArgumentException("The value "+value+" is an invalid one");
		}	
	}
    
   
    
    
   
    
    
}
