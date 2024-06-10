package pro.sky.EmployeeHomework.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Введенные данные содержат недопустимые символы")
public class StringContainsWrongSymbols extends RuntimeException {
    public StringContainsWrongSymbols() {
        super();
    }

    public StringContainsWrongSymbols(String message) {
        super(message);
    }

    public StringContainsWrongSymbols(String message, Throwable t) {
        super(message, t);
    }

    public StringContainsWrongSymbols(Throwable t) {
        super(t);
    }
}
