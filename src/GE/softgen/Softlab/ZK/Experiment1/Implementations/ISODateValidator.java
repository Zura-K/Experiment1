package GE.softgen.Softlab.ZK.Experiment1.Implementations;

import GE.softgen.Softlab.ZK.Experiment1.Validator.Validator;

import java.time.Year;
import java.util.Arrays;

public class ISODateValidator implements Validator {
    private final String BirthDate;

    public ISODateValidator(String BirthDate) {
        this.BirthDate = BirthDate;
    }
    boolean ymd = true;
    boolean exceededlimit = false;
    Integer[] Months31 = new Integer[]{1,3,5,7,8,10,12};
    Integer[] Months30 = new Integer[]{4,6,9,11};
    int CurrentYear = Year.now().getValue();

    @Override
    public boolean isValid(){
        if(BirthDate==null)
        {
            return false;
        }
        String[] DateParts = BirthDate.split("[,./-]+");
        int DataYear = Integer.parseInt(DateParts[0]);
        int DataMonth = Integer.parseInt(DateParts[1]);
        int DataDay = Integer.parseInt(DateParts[2]);

        if (DateParts.length!=3)
        {
            return false;
        }
        if (DateParts[0].length() != 4 || DateParts[1].length() !=2 || DateParts[2].length() !=2)
        {
            ymd = false;
            return false;
        }
        if(!(DateParts[0].matches("[0-9]+")) || CurrentYear<DataYear ||
           !(DateParts[1].matches("[0-9]+")) || 12<DataMonth ||
           !(DateParts[2].matches("[0-9]+")) || (
                (DataMonth==2 && DataDay>28) ||
                (Arrays.asList(Months31).contains(DataMonth) && DataDay>31) ||
                (Arrays.asList(Months30).contains(DataMonth) && DataDay>30) )
        )
        {
            return false;
        }
        return true;
    }

    @Override
    public String ThrowExceptionMessage() {
        if(BirthDate==null)
        {
            return "BrithDate field cannot be Empty";
        }
        if(!ymd) {
            return "Wrong Date Format. Birthdate should be in YYYY-MM-DD format, separated with one of the following: ',' '.' '/' or '-'.";
        }
        if(exceededlimit)
        {
            return "The BirthDate that you have provided is impossible!";
        }
        return "BirthDate input is Invalid. Birthdate should be in YYYY-MM-DD format, separated with one of the following: ',' '.' '/' or '-'.";
    }
}
