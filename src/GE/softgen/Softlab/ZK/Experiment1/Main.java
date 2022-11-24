package GE.softgen.Softlab.ZK.Experiment1;

import GE.softgen.Softlab.ZK.Experiment1.Implementations.GenderValidator;
import GE.softgen.Softlab.ZK.Experiment1.Implementations.IDValidator;
import GE.softgen.Softlab.ZK.Experiment1.Implementations.ISODateValidator;
import GE.softgen.Softlab.ZK.Experiment1.Validator.ValidatorException;
import GE.softgen.Softlab.ZK.Experiment1.Validator.ValidatorService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] arg) throws ValidatorException
    {
        Scanner EntityInput = new Scanner(System.in);
        System.out.println("Please Enter Your Data:");

        do {
            var EntityID = EntityInput.nextLine();
            var BirthDate = EntityInput.nextLine();
            var Gender = EntityInput.nextLine();

            try {
                ValidatorService.validate(List.of(new IDValidator(EntityID), new ISODateValidator(BirthDate), new GenderValidator(Gender)));
                System.out.println("Information uploaded Successfully!");
                break;
            } catch (ValidatorException e) {
                System.err.println(e.getMessage());
            }
        }
        while(true);
    }
}