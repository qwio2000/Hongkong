package com.jeiglobal.hk.common;

import java.util.*;

import org.springframework.beans.factory.config.*;
import org.springframework.core.io.*;

/**
 * 클래스명 : ConnectSetting.java
 *
 * 버전 정보 : 1.0
 *
 * 작성자 : 전승엽(IT지원팀)
 * 
 * db.yml에 등록된 DB 정보를 담는 객체
 */
public class ConnectSetting {
static private ConnectSetting connectSetting = new ConnectSetting();
	
	static public String mysqlDriverClassName;
	static public String mysqlUrl;
	static public String mysqlUsername;
	static public String mysqlPassword;
	static public String mssqlDriverClassName;
	static public String mssqlUrl;
	static public String mssqlUsername;
	static public String mssqlPassword;
	
	private ConnectSetting() {
		super();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("db.yml"));
		Properties proper = yaml.getObject();
		mysqlDriverClassName = proper.getProperty("db.mysqlDriverClassName");
		mysqlUrl = proper.getProperty("db.mysqlUrl");
		mysqlUsername = proper.getProperty("db.mysqlUsername");
		mysqlPassword = proper.getProperty("db.mysqlPassword");
		
		mssqlDriverClassName= proper.getProperty("db.mssqlDriverClassName");
		mssqlUrl= proper.getProperty("db.mssqlUrl");
		mssqlUsername= proper.getProperty("db.mssqlUsername");
		mssqlPassword= proper.getProperty("db.mssqlPassword");
	}
	
	public static ConnectSetting getInstance(){
        return connectSetting;
    }
}
