package myfan.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import myfan.models.Artista;
import myfan.models.Fanatico;
import myfan.models.ResultLogin;
import myfan.models.ResultResponse;
import myfan.models.User;
import updateManager.SyncDataArtist;
import static sqlConstants.ConstantsQueries.*;

@Controller
public class SessionController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/registerFan", method = RequestMethod.POST)
	public @ResponseBody ResultResponse registerFan(@RequestBody Fanatico pFan){	
		ResultResponse resultResponse= new ResultResponse();
		pFan.setType("F");
		String result = newUser(pFan);
		if (result.equals("0")){ resultResponse.setResult("0");  return resultResponse;}
		
		jdbcTemplate.update(sqlNewFan, new Object[] { pFan.getLogin(),pFan.getPassword(),pFan.getNombre(),pFan.getFechaN(),pFan.getGenero()  });
		
		resultResponse.setResult(result);
		return resultResponse;
	}
	
	
	@RequestMapping(value = "/registerArtist", method = RequestMethod.POST)
	public @ResponseBody ResultResponse registerArtist(@RequestBody Artista pArtist) throws Exception {	
		ResultResponse resultResponse= new ResultResponse();
		SyncDataArtist newSync= new SyncDataArtist();
		pArtist.setType("A");
		String result = newUser(pArtist);
		if (result.equals("0")) { resultResponse.setResult("0");  return resultResponse;}
		
		jdbcTemplate.update(sqlNewArtist, new Object[] { pArtist.getLogin(),pArtist.getPassword(),pArtist.getNombre(),pArtist.getCorreo() });
		
		resultResponse.setResult(result);	
		
		//newSync.sendDataArtist(pArtist);	
		
		return resultResponse;
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResultLogin loginUser(@RequestBody Fanatico pUser) throws Exception {	
		ResultLogin resultResponse= new ResultLogin();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlLogin,new Object[] { pUser.getLogin() ,pUser.getPassword() } );
		
		if(!rows.isEmpty()) { resultResponse.setType(rows.get(0).get("type").toString() );  }
		
		resultResponse.setResult( Integer.toString(rows.size()) );
		
		
		return resultResponse;
	}

	
	private String newUser(User newUser){
		try {
			jdbcTemplate.update(sqlNewUser, new Object[] { newUser.getLogin(),newUser.getPassword(),newUser.getType()}); 
			return "1";
		}
		catch (Exception e) {
			return "0";
		}
		
	}
	
	

	
}