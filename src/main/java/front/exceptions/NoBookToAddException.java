package front.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoBookToAddException extends RuntimeException {

	private static final String MESSAGE = "Aucun livre à ajouter";
	
	private static final long serialVersionUID = 6049294732771408784L;
	
    public NoBookToAddException() {
        super(MESSAGE);
    }
    public NoBookToAddException(Throwable cause) {
        super(MESSAGE, cause);
    }

}
