package front.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AuthorNoFoundException extends RuntimeException {

	private static final String MESSAGE = "L'auteur n'existe pas pour l'id ";
	
	private static final long serialVersionUID = 6049294732771408784L;
	
    public AuthorNoFoundException(Long id) {
        super(MESSAGE + id);
    }
    public AuthorNoFoundException(Throwable cause, Long id) {
        super(MESSAGE + id, cause);
    }

}
