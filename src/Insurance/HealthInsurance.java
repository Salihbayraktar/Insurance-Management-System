package Insurance;

import Customer.Account;
import Customer.Enterprise;

import java.util.Scanner;

public class HealthInsurance extends Insurance {

    private int age;
    private int insuranceYear;
    private int height;
    private int weight;

    public HealthInsurance(Account account) {
        super(account);
    }

    @Override
    public void getInputsFromUser() {

        try {

            Scanner scanner = new Scanner(System.in);

            this.age = super.getAccount().getUser().getAge();

            System.out.println("Please enter your height");
            this.height = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter your weight");
            this.weight = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many years do you want to have insurance?");
            this.insuranceYear = scanner.nextInt();
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        calculate();
    }

    @Override
    void calculate() {

        super.setInsuranceName("Health Insurance");
        super.setStartAndExpiryDateByYear(insuranceYear);

        double bmi = weight / (Math.pow(height, 2)) * 10000;
        double insuranceFee = Math.pow(bmi, 1.5) * (double) (age / 3) * (insuranceYear * 0.95);

        if(super.getAccount() instanceof Enterprise) {
            insuranceFee *= 0.8;
        }
        // Vücut kitle indeksinin 1.5 üncü kuvveti ve yaşının 3 te 1 ini yıllık ücret olarak alıyor.
        // Sigorta yapılacak yıl başına yüzde 5 indirim sağlanıyor.

        System.out.printf("Health insurance fee  : %.1f \n", insuranceFee);
        super.setInsuranceFee(insuranceFee);
    }
}
