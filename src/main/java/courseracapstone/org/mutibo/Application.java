package courseracapstone.org.mutibo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import courseracapstone.org.mutibo.auth.OAuth2SecurityConfiguration;
import courseracapstone.org.mutibo.repository.MutiboUserRepository;
import courseracapstone.org.mutibo.repository.SetQuestion;
import courseracapstone.org.mutibo.repository.SetQuestionRepository;

//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring to turn on WebMVC (e.g., it should enable the DispatcherServlet
// so that requests can be routed to our Controllers)
@EnableWebMvc
// Tell Spring that this object represents a Configuration for the
// application
@Configuration
// Tell Spring to go and scan our controller package (and all sub packages) to
// find any Controllers or other components that are part of our applciation.
// Any class in this package that is annotated with @Controller is going to be
// automatically discovered and connected to the DispatcherServlet.
@ComponentScan

//Tell Spring to automatically create a JPA implementation of our
//VideoRepository
//@EnableJpaRepositories(basePackageClasses = VideoRepository.class)
//@EnableJpaRepositories(basePackageClasses = SetQuestionRepository.class)
@EnableJpaRepositories(basePackageClasses = { 
		SetQuestionRepository.class,
		MutiboUserRepository.class})

//We use the @Import annotation to include our OAuth2SecurityConfiguration
//as part of this configuration so that we can have security and oauth
//setup by Spring
@Import(OAuth2SecurityConfiguration.class)
public class Application extends RepositoryRestMvcConfiguration  {
	
//	@Autowired
//	private SetQuestionRepository setQuestions;
//	
//	@Autowired
//	private MutiboUserRepository userList;

	// The app now requires that you pass the location of the keystore and
	// the password for your private key that you would like to setup HTTPS
	// with. In Eclipse, you can set these options by going to:
	//    1. Run->Run Configurations
	//    2. Under Java Applications, select your run configuration for this app
	//    3. Open the Arguments tab
	//    4. In VM Arguments, provide the following information to use the
	//       default keystore provided with the sample code:
	//
	//       -Dkeystore.file=src/main/resources/private/keystore -Dkeystore.pass=changeit
	//
	//    5. Note, this keystore is highly insecure! If you want more securtiy, you 
	//       should obtain a real SSL certificate:
	//
	//       http://tomcat.apache.org/tomcat-7.0-doc/ssl-howto.html
	//
	// Tell Spring to launch our app!
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		// TODO:  load database users here
	}

	
    // This version uses the Tomcat web container and configures it to
	// support HTTPS. The code below performs the configuration of Tomcat
	// for HTTPS. Each web container has a different API for configuring
	// HTTPS. 
	//
	// The app now requires that you pass the location of the keystore and
	// the password for your private key that you would like to setup HTTPS
	// with. In Eclipse, you can set these options by going to:
	//    1. Run->Run Configurations
	//    2. Under Java Applications, select your run configuration for this app
	//    3. Open the Arguments tab
	//    4. In VM Arguments, provide the following information to use the
	//       default keystore provided with the sample code:
	//
	//       -Dkeystore.file=src/main/resources/private/keystore -Dkeystore.pass=changeit
	//
	//    5. Note, this keystore is highly insecure! If you want more securtiy, you 
	//       should obtain a real SSL certificate:
	//
	//       http://tomcat.apache.org/tomcat-7.0-doc/ssl-howto.html
	//
	
//    @Bean
//    EmbeddedServletContainerCustomizer containerCustomizer(
//            @Value("${keystore.file:src/main/resources/private/keystore}") String keystoreFile,
//            @Value("${keystore.pass:changeit}") final String keystorePass) throws Exception {
//
//		// If you were going to reuse this class in another
//		// application, this is one of the key sections that you
//		// would want to change
//    	
//        final String absoluteKeystoreFile = new File(keystoreFile).getAbsolutePath();
//
//        return new EmbeddedServletContainerCustomizer () {
//
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//		            TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//		            tomcat.addConnectorCustomizers(
//		                    new TomcatConnectorCustomizer() {
//								@Override
//								public void customize(Connector connector) {
//									connector.setPort(8443);
//			                        connector.setSecure(true);
//			                        connector.setScheme("https");
//
//			                        Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
//			                        proto.setSSLEnabled(true);
//			                        proto.setKeystoreFile(absoluteKeystoreFile);
//			                        proto.setKeystorePass(keystorePass);
//			                        proto.setKeystoreType("JKS");
//			                        proto.setKeyAlias("tomcat");
//								}
//		                    });
//		    
//			}
//        };
//    }
	
		

	
	

}