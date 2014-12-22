package courseracapstone.org.mutibo.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import courseracapstone.org.mutibo.client.MutiboSvcApi;

@RepositoryRestResource(path = MutiboSvcApi.MUTIBO_SVC_PATH)
public interface SetQuestionRepository extends CrudRepository<SetQuestion, Long> { 

	// Find all videos with a matching title (e.g., Video.name)
	public List<SetQuestion> findByRating(
		// The @Param annotation tells Spring Data Rest which HTTP request
		// parameter it should use to fill in the "title" variable used to
		// search for Videos
		@Param(MutiboSvcApi.RATING_PARAMETER) String rating);	
}
