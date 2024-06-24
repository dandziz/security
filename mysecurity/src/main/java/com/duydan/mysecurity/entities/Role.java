package com.duydan.mysecurity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	private String name;

	public Role(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	private List<User> users = new ArrayList<>();

	@Override
	public String toString() {
		return "Role [name=" + name + "]" + "[id=" + id + "]";
	}
}
