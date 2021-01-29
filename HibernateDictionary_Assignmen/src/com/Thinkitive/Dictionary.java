package com.Thinkitive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demodictionary")
public class Dictionary {

@Id

@Column(name = "word")
private String word;

public Dictionary() {
	// TODO Auto-generated constructor stub
}
public Dictionary(String word) {
	super();
	this.word = word;
}
@Override
public String toString() {
	return "Dictionary [word=" + word + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((word == null) ? 0 : word.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Dictionary other = (Dictionary) obj;
	if (word == null) {
		if (other.word != null)
			return false;
	} else if (!word.equals(other.word))
		return false;
	return true;
}

}
