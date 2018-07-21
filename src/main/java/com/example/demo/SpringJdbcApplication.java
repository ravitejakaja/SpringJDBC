package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {
	
	 @Value("${file.upload.size.limit}")
	    private long size;

	    @Value("${remote.connection.url}")
	    private String remoteConnectionUrl;

	    @Value("${remote.connection.port}")
	    private int remoteConnectionPort;
	    
	    @Value("${env.name}")
	    private String envName;
	    @Value("${remote.connection.username}")
	    private String remoteConnectionUsername;

	    @Value("${remote.connection.password}")
	    private String remoteConnectionPassword;

	    @Value("${remote.https.enabled}")
	    private String remoteHttpsEnabled;

	    
	    @Value("${remote.connection.auth}")
	    private String remoteConnectionAuth;


	public static void main(String[] args) {
		 PropertiesUtils.initProperties();
		 ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		 SpringJdbcApplication mainApplication = context.getBean(SpringJdbcApplication.class);
	        printEnvironmentsProperties(mainApplication);
	        
	}
	
	 private static void printEnvironmentsProperties(SpringJdbcApplication MainApplication) {
	        StringBuilder stringBuilder = new StringBuilder("Properties Files ......\n");

	        stringBuilder.append("env.name").append(" : ").append(MainApplication.envName).append("\n")
	                .append("file.upload.size.limit").append(" : ").append(MainApplication.size).append("\n")
	                .append("remote.connection.url").append(" : ").append(MainApplication.remoteConnectionUrl).append("\n")
	                .append("remote.connection.port").append(" : ").append(MainApplication.remoteConnectionPort).append("\n")
	                .append("remote.connection.username").append(" : ").append(MainApplication.size).append("\n")
	                .append("remote.connection.password").append(" : ").append(MainApplication.remoteConnectionPassword).append("\n")
	                .append("remote.connection.auth").append(" : ").append(MainApplication.remoteConnectionAuth).append("\n")
	                .append("remote.https.enabled").append(" : ").append(MainApplication.remoteHttpsEnabled).append("\n");
	        System.out.println(stringBuilder.toString());
	    }
}
