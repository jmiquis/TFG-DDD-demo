package com.shared.domain;

import java.util.Objects;



public abstract class IntValueObject {

	
	
	    private Integer value;

	    public IntValueObject(Integer value) {
	        this.value = value;
	    }

	    public Integer value() {
	        return value;
	    }
	    

	    @Override
	    public boolean equals(Object o) {
	        return (o instanceof IntValueObject && this.value()==((IntValueObject) o).value());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(value);
	    }
	

}
