package front.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.extendedbo.Author;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import services.ServiceAuthor;
import utils.LogUtils;

@RestController
public class AuthorController {

@CrossOrigin
@RequestMapping(path = "/author/get/{authorId}", method = RequestMethod.GET)
@ResponseBody
@ApiOperation(value="return author for id", response = Author.class)
    public Author getById(
    		@ApiParam(value = "Author Id ", required = true)
            @PathVariable("authorId") Long authorId) {
    	
	LogUtils.warn("authorId=" + authorId);
	
//		Long id = new Long(authorId);
	
    	ServiceAuthor svcAuthor = new ServiceAuthor();
    	return svcAuthor.getAuthorById(authorId); 
    }
}
