package net.tardivo.spring.redis.cache;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bye implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	private long times;

}
