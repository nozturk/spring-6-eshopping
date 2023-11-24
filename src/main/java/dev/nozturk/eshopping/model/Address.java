package dev.nozturk.eshopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	private Customer customer;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (!(o instanceof Address))
            return false;
 
        Address other = (Address) o;
 
        return id != null &&
               id.equals(other.getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	

}
