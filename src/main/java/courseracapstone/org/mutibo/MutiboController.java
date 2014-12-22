package courseracapstone.org.mutibo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import retrofit.http.Body;
import retrofit.http.GET;

import com.google.common.collect.Lists;

import courseracapstone.org.mutibo.client.MutiboSvcApi;
import courseracapstone.org.mutibo.repository.MutiboUser;
import courseracapstone.org.mutibo.repository.MutiboUserRepository;
import courseracapstone.org.mutibo.repository.SetQuestion;
import courseracapstone.org.mutibo.repository.SetQuestionRepository;

@Controller
public class MutiboController {	
	
	@Autowired
	private SetQuestionRepository setQuestions;
	
	@Autowired
	private MutiboUserRepository userList;
	
	
	@RequestMapping(value=MutiboSvcApi.MUTIBO_SVC_PATH, method=RequestMethod.POST)
	public @ResponseBody SetQuestion addSet(@RequestBody SetQuestion s)
	{
		setQuestions.save(s);

		return setQuestions.findOne(s.getId());
		
	}
	
	@RequestMapping(value=MutiboSvcApi.MUTIBO_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody List<SetQuestion> getSetList()
	{
		return Lists.newArrayList(setQuestions.findAll());
	}

	@RequestMapping(value=MutiboSvcApi.MUTIBO_USERS, method=RequestMethod.POST)
	
	public  @ResponseBody MutiboUser getUserDetails(@Body MutiboUser u)
	{
		MutiboUser us = null;
		
		us = userList.findByName(u.getName());
		
		if (us!= null)
		{
			if (us.getPassword().equals(u.getPassword()))
			{
				return us;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		
	} 
	
	

	
	@RequestMapping(value=MutiboSvcApi.MUTIBO_SETS_REFRESH, method=RequestMethod.POST)
	public @ResponseBody List<SetQuestion> refreshSetRatings(@RequestBody List<SetQuestion> setUserList)
	{
		
//		// SETS ARE CREATED WITH RATING EQUAL TO 5 POINTS
//		// MAXIMUM RATE IS 10 PONITS
//		// MINIMUM RATE WILL BE 0;
//		
//		
		//convert to iterable to be able to iterate within the sets
		Iterable<SetQuestion> sets = setQuestions.findAll();
		int finalRate;
		
		for(SetQuestion s: sets)
		{
			// get needed sets
			Long indexInt = s.getId();
			int indexLong = indexInt.intValue();
					

			SetQuestion  setInCurse = setUserList.get(indexLong-1);
					
			// if current set rating of server is different from set rating comming from user 
			// refresh the set between 10 and 0 rating points.
			if (s.getRating() != setInCurse.getRating())
			{
				//setQuestions.findOne(s.getId()).setRating(setInCurse.getRating());

				if (s.getRating()<10)
			    {
					
					// RATING THE SET AS GOOD
					finalRate = setQuestions.findOne(s.getId()).getRating();
					finalRate++;
					setQuestions.findOne(s.getId()).setRating(finalRate);
			    }
				else
				{
					if (s.getRating()>0)
			        {
						// RATING THE SET AS BAD
						
						finalRate = setQuestions.findOne(s.getId()).getRating();
						finalRate++;
						setQuestions.findOne(s.getId()).setRating(finalRate);

						// IF RATING REACHES 0 POINTS THIS SET WILL BE DELETED						
						if (setQuestions.findOne(s.getId()).getRating()==0)
						{
							setQuestions.delete(s.getId());
						}
			        }
			     }			
			}			
		}
		
		List<SetQuestion> resposnse = (List<SetQuestion>) setQuestions.findAll(); 
		return resposnse;
	}
}
