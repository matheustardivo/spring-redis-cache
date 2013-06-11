package net.tardivo.spring.redis.cache;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hello implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String message;

	private HelloRelated related;

	public Hello(String name, String message) {
		this.name = name;
		this.message = message;
	}
}
