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

import myfan.models.Fanatico;
import myfan.models.ResultResponse;
import myfan.models.User;
import static sqlConstants.ConstantsQueries.*;

@Controller
public class ProfileController {
	UsersFactory factory;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@RequestMapping(value = "/profileFan", method = RequestMethod.POST)
	public @ResponseBody Fanatico registerFan(@RequestBody Fanatico pFan){	
		factory= new UsersFactory();
		Fanatico result= (Fanatico) factory.createUser("fanatico");
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlprofileFan,new Object[] { pFan.getLogin() } );
		
		Map<String, Object> hashMapResult = rows.get(0);
		result=prepareResult(result,hashMapResult);
		
		return result;
	}
	
	private Fanatico prepareResult(Fanatico result,Map<String, Object> hashMapResult ){
		result.setNombre(hashMapResult.get("nombre").toString());
		result.setFechaN(hashMapResult.get("fechaNacimiento").toString());
		//result.setGenero(hashMapResult.get().toString());

		
		return result;
		
		
	}
	
	
	
	
	
}
