package com.spring.netehache.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.LruPolicy;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "com.spring.netehcache")
public class AppConfiguration extends CachingConfigurerSupport {
	
	@Value("${custom.ehcache.timetolive}")
	private int timetolive;
	
	@Value("${custom.ehcache.maxEntries}")
	private int maxEntries;
	
	@Bean
	public CacheManager ehCacheManager() {

		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		
		cacheConfiguration.setName("cachingStudent");
		cacheConfiguration.setMemoryStoreEvictionPolicy(LruPolicy.NAME);
		cacheConfiguration.setTimeToLiveSeconds(timetolive);
		cacheConfiguration.setMaxEntriesLocalHeap(maxEntries);
		
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(cacheConfiguration);
		
		return CacheManager.newInstance(config);
	}
	
	@Bean
	@Override
	public org.springframework.cache.CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
	
	
}
