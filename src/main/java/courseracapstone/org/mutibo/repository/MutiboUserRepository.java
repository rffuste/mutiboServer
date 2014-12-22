package courseracapstone.org.mutibo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import courseracapstone.org.mutibo.client.MutiboSvcApi;

//@RepositoryRestResource(path = MutiboSvcApi.MUTIBO_SVC_PATH)
//public interface MutiboUserRepository extends CrudRepository<MutiboUser, Long> { 
//
//	// Find all videos with a matching title (e.g., Video.name)
//	public MutiboUser findByUserId(
//		// The @Param annotation tells Spring Data Rest which HTTP request
//		// parameter it should use to fill in the "title" variable used to
//		// search for Videos
//		@Param(MutiboSvcApi.USERID_PARAMETER) String userid);	
//}

@RepositoryRestResource(path = MutiboSvcApi.MUTIBO_USERS)
public interface MutiboUserRepository extends CrudRepository<MutiboUser, Long>
{
	MutiboUser findByName(
			@Param(MutiboSvcApi.MUTIBO_USERS) String user);
}
