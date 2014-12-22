package courseracapstone.org.mutibo.client;

import java.util.Collection;
import java.util.List;

import courseracapstone.org.mutibo.repository.MutiboUser;
import courseracapstone.org.mutibo.repository.SetQuestion;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface MutiboSvcApi {

	public static final String RATING_PARAMETER = "rating";
	public static final String USERID_PARAMETER = "userid";
	
	public static final String TOKEN_PATH = "/oauth/token";
	
	// The path where we expect the MutiboSvc to live
	public static final String MUTIBO_SVC_PATH = "/mutibo";
	public static final String MUTIBO_SETS_REFRESH = MUTIBO_SVC_PATH + "/refresh";
	public static final String MUTIBO_USERS = MUTIBO_SVC_PATH + "/users";
	
	
	@GET(MUTIBO_SVC_PATH)
	public List<SetQuestion> getSetList();
	
	@POST(MUTIBO_SVC_PATH)
	public SetQuestion addSet(@Body SetQuestion sets);
	
	@POST(MUTIBO_USERS)
	public MutiboUser getUserDetails(@Body MutiboUser u);

	@POST(MUTIBO_SETS_REFRESH)
	public List<SetQuestion> refreshSetRatings(@Body List<SetQuestion> setUserList);



}
