package com.duydan.mysecurity.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserRole implements Serializable {

	private Long userId;
	private Long roleId;

}
