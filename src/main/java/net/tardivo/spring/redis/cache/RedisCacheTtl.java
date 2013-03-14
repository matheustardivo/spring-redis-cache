package net.tardivo.spring.redis.cache;

public enum RedisCacheTtl {

	MESSAGE(RedisCacheKey.MESSAGE, 5L);

	private String key;

	private Long ttl;

	private RedisCacheTtl(String key, Long ttl) {
		this.key = key;
		this.ttl = ttl;
	}

	public String getKey() {
		return key;
	}

	public Long getTtl() {
		return ttl;
	}

	@Override
	public String toString() {
		return key;
	}
}
