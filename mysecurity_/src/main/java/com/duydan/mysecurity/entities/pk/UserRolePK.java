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

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	public UserRolePK(Long id, Long id1) {
		userId = id;
		roleId = id1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRolePK other = (UserRolePK) obj;
		return Objects.equals(roleId, other.roleId) && Objects.equals(userId, other.userId);
	}

}
