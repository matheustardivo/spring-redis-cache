package net.tardivo.spring.redis.cache;

import java.util.Arrays;

public class CacheKeySupport {

	public static String generateKey(String prefix, Object... params) {
		if (params == null || params.length == 0) {
			return prefix + prefix.hashCode();
		}

		return prefix + Arrays.hashCode(params);
	}
}
