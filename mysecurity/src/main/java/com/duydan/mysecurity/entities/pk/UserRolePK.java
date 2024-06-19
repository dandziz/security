package com.duydan.mysecurity.entities.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class UserRolePK implements Serializable {
	private Long userId;
	private Long roleId;
}
