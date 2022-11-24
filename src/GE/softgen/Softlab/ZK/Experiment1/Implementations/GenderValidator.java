package GE.softgen.Softlab.ZK.Experiment1.Implementations;

import GE.softgen.Softlab.ZK.Experiment1.Validator.Validator;

public class GenderValidator implements Validator {
    private final String Gender;

    public GenderValidator(String Gender) {
        this.Gender = Gender;
    }

    @Override
    public boolean isValid() {
        if(Gender==null)
        {
            return false;
        }
        return (Gender.equals("Male") || Gender.equals("male") || Gender.equals("Female") || Gender.equals("female"));
    }

    @Override
    public String ThrowExceptionMessage() {
        if(Gender==null)
        {
            return "Gender field cannot be Empty";
        }
        return "Gender should be either 'Male' or 'Female'";
    }
}
