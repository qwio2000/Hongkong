//package com.jeiglobal.hk.common.config;
//
//import org.springframework.cache.*;
//import org.springframework.cache.annotation.*;
//import org.springframework.cache.ehcache.*;
//import org.springframework.context.annotation.*;
//import org.springframework.core.io.*;
//
///**
// * 클래스명 : CacheConfig.java
// *
// * 버전 정보 : 1.0
// *
// * 작성자 : 전승엽(IT지원팀)
// * 
// * 설명
// */
//@Configuration
//@EnableCaching
//public class CacheConfig {
//
//	@Bean
//	public CacheManager cacheManager(){
//		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
//	}
//	
//	@Bean
//	public EhCacheManagerFactoryBean ehCacheCacheManager(){
//		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
//		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		cmfb.setShared(true);
//		return cmfb;
//	}
//}
