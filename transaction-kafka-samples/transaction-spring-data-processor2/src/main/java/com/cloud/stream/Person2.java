package com.cloud.stream;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person2")
public class Person2 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		if (this==o) {
			return true;
		}
		if (o==null||getClass()!=o.getClass()) {
			return false;
		}
		Person2 person=(Person2)o;
		return Objects.equals(id, person.id) && Objects.equals(name, person.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
}
