package GE.softgen.Softlab.ZK.Experiment1.Validator;

import java.util.List;

public class ValidatorService {
    public static void validate(List<Validator>valid) throws ValidatorException {
        for (Validator X:valid)
        {
            if(!X.isValid())
            {
                throw new ValidatorException(X.ThrowExceptionMessage());
            }
        }
    }
}
