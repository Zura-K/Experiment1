package GE.softgen.Softlab.ZK.Experiment1.Implementations;
import GE.softgen.Softlab.ZK.Experiment1.Validator.Validator;

public class IDValidator implements Validator{
    private static String EntityID;

    public IDValidator(String EntityID){
        IDValidator.EntityID = EntityID;
    }

    @Override
    public boolean isValid() {
        if(EntityID==null)
        {
            return false;
        }
        return EntityID.length() == 11;
    }

    @Override
    public String ThrowExceptionMessage() {
        if(EntityID==null)
        {
            return "ID field cannot be Empty";
        }
        if(EntityID.length()!=11)
        {
            return "ID should be 11 digit long number";
        }
        return "Invalid ID input";
    }
}
