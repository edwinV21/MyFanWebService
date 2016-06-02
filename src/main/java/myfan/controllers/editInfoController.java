package myfan.controllers;

import static sqlConstants.ConstantsQueries.sqlprofileFan;

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
import static sqlConstants.ConstantsQueries.sqlEditInfoFan;

@Controller
public class editInfoController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	
	@RequestMapping(value = "/editInfoFan", method = RequestMethod.POST)
	public @ResponseBody ResultResponse editInfoFan(@RequestBody Fanatico pFan){	
		ResultResponse responseUpdate= new ResultResponse();
		try {
			jdbcTemplate.update(sqlEditInfoFan, new Object[] { pFan.getNombre(),pFan.getGenero(),pFan.getFechaN(),pFan.getUbicacion(),pFan.getCorreo(),pFan.getLogin() }); 
			responseUpdate.setResult("1");
		} catch (Exception e) {
			responseUpdate.setResult("0");
		}
		
		return responseUpdate;
	}
	
	

}
