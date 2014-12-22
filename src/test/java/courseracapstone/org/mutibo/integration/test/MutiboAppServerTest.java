package courseracapstone.org.mutibo.integration.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import courseracapstone.org.mutibo.auth.User;
import courseracapstone.org.mutibo.client.MutiboSvcApi;
import courseracapstone.org.mutibo.client.SecuredRestBuilder;
import courseracapstone.org.mutibo.repository.SetQuestion;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.ApacheClient;

public class MutiboAppServerTest {
	
	private class ErrorRecorder implements ErrorHandler {

		private RetrofitError error;

		@Override
		public Throwable handleError(RetrofitError cause) {
			error = cause;
			return error.getCause();
		}

		public RetrofitError getError() {
			return error;
		}
	}

	private final String TEST_URL = "https://localhost:8443";

	private final String USERNAME1 = "admin";
	private final String USERNAME2 = "user0";
	private final String PASSWORD = "pass";
	private final String CLIENT_ID = "mobile";
	
	private MutiboSvcApi MutiboSvcUser1 = new SecuredRestBuilder()
			.setClient(new ApacheClient(UnsafeHttpsClient.createUnsafeClient()))
			.setEndpoint(TEST_URL)
			.setLoginEndpoint(TEST_URL + MutiboSvcApi.TOKEN_PATH)
			.setLogLevel(LogLevel.FULL)
			.setUsername(USERNAME1).setPassword(PASSWORD).setClientId(CLIENT_ID)
			.build().create(MutiboSvcApi.class);
	

	
	/*
	@Test
	public void testAddMetadata() throws Exception {
		SetQuestion question = MutiboSvcUser1.addSet(testSet);
		
		assertEquals(question.getTitle1(), testSet.getTitle1());
		assertEquals(question.getTitle2(), testSet.getTitle2());
		assertEquals(question.getTitle3(), testSet.getTitle3());
		assertEquals(question.getTitle4(), testSet.getTitle4());
		assertEquals(question.getOdd(),    testSet.getOdd());  
		assertEquals(question.getAnswer(), testSet.getAnswer());
		assertEquals(question.getRating(), testSet.getRating());
		
	}
	
	
	@Test
	public void testAddGetVideo() throws Exception {
		MutiboSvcUser1.addSet(testSet);
		Collection<SetQuestion> stored = MutiboSvcUser1.getSetList();
		assertTrue(stored.contains(testSet));
	}
	*/
	
	@Test
	public void testAddGameSets() throws Exception {
	
		SetQuestion set1 = new SetQuestion("American Pie","Mean Girls","Titanic", "The Breakfast Club",3,"By Genre: Titanic is not a High school movie");
		MutiboSvcUser1.addSet(set1);		
		SetQuestion set2 = new SetQuestion("The Hunger Games","Breakfast at Tiffanies","Slumdog Millionaire", "Django Unchained",2,"By Age: While the others movies are quite recent, Breakfast at tiffanies is a very old movie");
		MutiboSvcUser1.addSet(set2);
		SetQuestion set3 = new SetQuestion("Unbreakable","The Sixth Sense","The Village", "12 Monkeys",4,"By Director: 12 Monkeys is not a movie by M. Night Shyamalan");
		MutiboSvcUser1.addSet(set3);
		SetQuestion set4 = new SetQuestion("Monsters Inc.","Toy Story","Shrek", "Finding Nemo",3,"By Studio: Shrek is not a movie by Pixar");
		MutiboSvcUser1.addSet(set4);
		SetQuestion set5 = new SetQuestion("Zombieland","Saw","Dawn of the Dead", "28 Days Later",2,"By Subgenre: Saw is not a zombie movie");
		MutiboSvcUser1.addSet(set5);
		SetQuestion set6= new SetQuestion("The Shining","Pet Sematary","It", "Poltergeist",4,"By Writer: Poltergeist is not based on a Stephen King book");
		MutiboSvcUser1.addSet(set6);
		SetQuestion set7 = new SetQuestion("The Matrix","X-Men: Days of Future Past","Forrest Gump", "Lucy",3,"By Genre: Forrest Gump is not a science Fiction movie");
		MutiboSvcUser1.addSet(set7);
		SetQuestion set8 = new SetQuestion("Taken","Run","Leon: The Professional", "The Transporter",3,"By Director: Leon: The Professional is not a movie by Luc Besson");
		MutiboSvcUser1.addSet(set8);
		SetQuestion set9 = new SetQuestion("Mad Max","The Year of Living Dangerously","Braveheart", "Revolutionary Road",4,"By Actor: Mel Gibson does not appear in Revolutionary Road");
		MutiboSvcUser1.addSet(set9);
		SetQuestion set10 = new SetQuestion("Avatar","Spiderman","Superman", "My Name is Khan",4,"By Origin: My Name is Khan is the only Bollywood movie");
		MutiboSvcUser1.addSet(set10);

		SetQuestion set11 = new SetQuestion("House of Wax","Cast Away","Paa", "What Lies Beneath",3,"By Origin: Paa is the only Bollywood movie");
		MutiboSvcUser1.addSet(set11);
		SetQuestion set12 = new SetQuestion("Maverick","Rounders","21", "Good Will Hunting",4,"By Genre: Good Will Hunting is not a card movie");
		MutiboSvcUser1.addSet(set12);
		SetQuestion set13 = new SetQuestion("Red State","Clerks","Tusk", "Office Space",4,"By Director: Kevin Smith has directed all the movies except Office Space.");
		MutiboSvcUser1.addSet(set13);
		SetQuestion set14 = new SetQuestion("Titanic","Gladiator","American Beauty", "King's Speech",1,"By Oscar Win: All the rest, won best movie and best Actor ");
		MutiboSvcUser1.addSet(set14);
		SetQuestion set15 = new SetQuestion("München ","The Last King of Scotland","Argo", "The Town",4,"By Background: The Town is the only one not based on a real life event");
		MutiboSvcUser1.addSet(set15);
		SetQuestion set16 = new SetQuestion("The Matador","GoldenEye","Moonraker", "Skyfall",1,"By Character: The Matador is not a James Bond movie");
		MutiboSvcUser1.addSet(set16);
		SetQuestion set17 = new SetQuestion("The Pledge","The Wolf of Wall Street","Mars Attacks!", "One Flew Over the Cuckoo's Nest",2,"By Actor: The Wolf of Wall Street is the only one without Jack Nicholson ");
		MutiboSvcUser1.addSet(set17);
		SetQuestion set18 = new SetQuestion("JFK","Sleepers","Goodfellas", "A Few Good Men",3,"By Actor: Kevin Bacon does not appear in Goodfellas.");
		MutiboSvcUser1.addSet(set18);
		SetQuestion set19 = new SetQuestion("Ghosts of Mississippi","JFK","This is Spinal Tap", "Stand By Me",2,"By Director: Rob Reiner did not direct JFK.");
		MutiboSvcUser1.addSet(set19);
		SetQuestion set20 = new SetQuestion("Tom Jones","Rocky","Citizen Kane", "The Greatest Show on Earth",3,"By Oscar Win: Citizen Kane did not win Best Picture");
		MutiboSvcUser1.addSet(set20);
		
		SetQuestion set21 = new SetQuestion("James Mason","Cary Grant","Rod Taylor", "Sean Connery",4,"By Actor: All but Sean Connery turned down the James Bond role.");
		MutiboSvcUser1.addSet(set21);
		SetQuestion set22 = new SetQuestion("Waterworld","Gigli","The Postman", "Mars Needs Moms",1,"By Success: While Waterworld is considered a flop, it actually turned a significant profit. The others lost money.");
		MutiboSvcUser1.addSet(set22);
		SetQuestion set23 = new SetQuestion("Superman","Batman","Spiderman", "Hulk",2,"Batman do not have any super powers");
		MutiboSvcUser1.addSet(set23);
		SetQuestion set24 = new SetQuestion("The Thomas Crowne Affair","Entrapment","Cowboys vs. Aliens", "Master and Commander: The Far Side of the World",4,"All but Master and Commander: The Far Side of the World featured an actor who played James Bond ");
		MutiboSvcUser1.addSet(set24);
		SetQuestion set25 = new SetQuestion("Kill Bill Vol1 ","Reservoir Dogs","Inglorious Basterds", "Schindler's List",4,"By Director: Quentin Tarantino did not worked in Schindler's List");
		MutiboSvcUser1.addSet(set25);
		SetQuestion set26 = new SetQuestion("Jaws","E.T.","Jurassic Park", "King Kong",4,"By Director: King Kong was not directed by Steven Spielberg");
		MutiboSvcUser1.addSet(set26);
		SetQuestion set27 = new SetQuestion("Terminator","Commando","Rocky", "Predator",3,"By Actor: Arnold Schwarzenegger was not in Rocky ");
		MutiboSvcUser1.addSet(set27);
		SetQuestion set28 = new SetQuestion("Saving Private Ryan","Black Hawk Down","La Vita e bella", "The thin red line",3,"By Subgenre: Black Hawk Down is not set in World War II");
		MutiboSvcUser1.addSet(set28);
		SetQuestion set29 = new SetQuestion("Roman Polanski","Stanley Kubric","Steven Spielberg", "Martin Scorcesee",2,"By Director: All but Stanley Kubric are alive");
		MutiboSvcUser1.addSet(set29);
		SetQuestion set30 = new SetQuestion("The Matrix","Pulp Fiction","Mad Max", "The Godfather",2,"By Movie Trilogy: Pulp Fiction is the only one not part of a trilogy");
		MutiboSvcUser1.addSet(set30);
		
		SetQuestion set31 = new SetQuestion("Black Swan","Melancholia","Virgin Suicides", "Marie Antoinette",1,"By Actor: Black Swan is starred by Natalie Portman while the others are starred by Kirsten Dunst");
		MutiboSvcUser1.addSet(set31);
		SetQuestion set32 = new SetQuestion("Training Day","Man on Fire","Departed", "Deja Vu",3,"By Actor: Denzel Washington does not appear in Departed");
		MutiboSvcUser1.addSet(set32);
		SetQuestion set33 = new SetQuestion("A Dangerous Method","Inglourious Basterds","Prometheus", "The Grand Budapest Hotel",4,"By Actor: Michael Fassbender appears in all but The Grand Budapest Hotel where Ralph Fiennes stars");
		MutiboSvcUser1.addSet(set33);
		SetQuestion set34 = new SetQuestion("X-Men","X-Men 2","X-Men: The Last Stand", "X-Men: Days of Future Past",3,"By Director: All but X-Men: Last Stand were directed by Bryan Singer");
		MutiboSvcUser1.addSet(set34);
		SetQuestion set35 = new SetQuestion("The Fellowship of the Ring","The Two Towers","The Return of the King", "An Unexpected Journey",4,"By Series: An Unexpected Journey is part of The Hobbit trilogy");
		MutiboSvcUser1.addSet(set35);
		SetQuestion set36 = new SetQuestion("Moneyball","World War Z","Megamind", "Mission: Impossible - Ghost Protocol",4,"By Actor: Brad Pitt did not appear in Mission: Impossible - Ghost Protocol");
		MutiboSvcUser1.addSet(set36);
		SetQuestion set37 = new SetQuestion("The Dark Knight Rises","The Avengers","The Amazing Spider-Man", "The Incredible Hulk",4,"By Year: All but The Incredible Hulk are 2012 movies");
		MutiboSvcUser1.addSet(set37);
		SetQuestion set38 = new SetQuestion("Iron Man","The Amazing Spider-Man","Captain America: The First Avenger", "The Dark Knight",4,"By Publisher: All but The Dark Knight are part of the Marvel Universe");
		MutiboSvcUser1.addSet(set38);
		SetQuestion set39 = new SetQuestion("Carrie","Alien","Saw", "Titanic",4,"By Genre: All but Titanic are Horrors");
		MutiboSvcUser1.addSet(set39);
		SetQuestion set40 = new SetQuestion("12 Monkeys","Mr. Nobody","Butterfly Effect", "The Aviator",4,"By Theme: All but The Aviator involve time travelling plots");
		MutiboSvcUser1.addSet(set40);
		
		SetQuestion set41 = new SetQuestion("Family Guy","American Dad","Cleveland Show", "South Park",4,"By Creator: All but the South Park are created by Seth MacFarlene");
		MutiboSvcUser1.addSet(set41);
		SetQuestion set42 = new SetQuestion("Horrible Bosses","Minority Report","In Bruges", "The Departed",4,"By Actor: Colin Farrell did not appear in The Departed");
		MutiboSvcUser1.addSet(set42);
		SetQuestion set43 = new SetQuestion("The Hunger Games","Kill Bill","Salt", "The Social Network",4,"By Actor: All but The Social Network have a female lead role");
		MutiboSvcUser1.addSet(set43);
		SetQuestion set44 = new SetQuestion("Total Recall","Dredd","Alien", "Back to the Future I",4,"By Time: All but Back to the Future I take place in the future");
		MutiboSvcUser1.addSet(set44);
		SetQuestion set45 = new SetQuestion("The Godfather","Scarface","Dog Day Afternoon", "Casino",4,"By Actor: Al Pacino does not appear on Casino");
		MutiboSvcUser1.addSet(set45);
		SetQuestion set46 = new SetQuestion("Goodfellas","Casino","Taxi Driver", "Scarface",4,"By Actor: Robert de Niro does not apppear on Scarface");
		MutiboSvcUser1.addSet(set46);
		SetQuestion set47 = new SetQuestion("Exodus: Gods and Kings","Ben Hur","The Passion of Christ", "Cleopatra",4,"By Theme: All but Cleopatra were based on biblical stories");
		MutiboSvcUser1.addSet(set47);
		SetQuestion set48 = new SetQuestion("Charade","The Amazing Spider-Man","Captain America: The First Avenger", "Vertigo",1,"By Director: All but Charade were directed by Alfred Hitchcock");
		MutiboSvcUser1.addSet(set48);
		SetQuestion set49 = new SetQuestion("2001: A space Odyssey","20,000 Leagues Under the Sea","2012", "2010: Moby Dick",2,"By Title: Distance, not time");
		MutiboSvcUser1.addSet(set49);
		SetQuestion set50 = new SetQuestion("Harry Potter and the Philosopher's Stones","Harry Potter and the Chamber of Secrets","Harry Potter and the Prisoner of Azkaban", "First Blood",4,"By Theme: All but First Blood are Harry Potter movies.");
		MutiboSvcUser1.addSet(set50);

		
	}	
	
	
//	@Test
//	public void testAddUsers() throws Exception {
//		// Create a service that has the credentials for all our clients
//		ClientDetailsService csvc = new InMemoryClientDetailsServiceBuilder()
//				// Create a client that has "read" and "write" access to the
//		        // video service
//				.withClient("mobile").authorizedGrantTypes("password")
//				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.scopes("read","write").resourceIds("video")
//				.and()
//				// Create a second client that only has "read" access to the
//				// video service
//				.withClient("mobileReader").authorizedGrantTypes("password")
//				.authorities("ROLE_CLIENT")
//				.scopes("read").resourceIds("video")
//				.accessTokenValiditySeconds(3600).and().build();
//
//		// Create a series of hard-coded users. 
////		UserDetailsService svc = new InMemoryUserDetailsManager(
////				Arrays.asList(
////						User.create("admin", "pass", "ADMIN", "USER"),
////						User.create("user0", "pass", "USER"),
////						User.create("user1", "pass", "USER"),
////						User.create("user2", "pass", "USER"),
////						User.create("user3", "pass", "USER"),
////						User.create("user4", "pass", "USER"),
////						User.create("user5@server.com", "password", "USER")
////						));
//		
//		Collection<User> userList = new ArrayList<User>();
//
//		
//		User u1 = (User) User.create("pep1@server.com", "password", "authorities");
//		
//		UserDetails u1 = new UserDetails() {
//			
//
//			
//		UserDetailsService svc = new InMemoryUserDetailsManager();
//
//	}
	

}
