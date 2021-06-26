package Insurance;

import Customer.Account;
import Customer.Enterprise;

import java.time.LocalDate;
import java.util.Scanner;

public class CarInsurance extends Insurance {

    private double carValue;
    private int carModelYear;
    private int numberOfAccidents;
    private int insuranceYear;


    public CarInsurance(Account account) {
        super(account);
    }

    @Override
    public void getInputsFromUser() {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the car value");
            this.carValue = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter the car model year");
            this.carModelYear = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the number of accidents");
            this.numberOfAccidents = scanner.nextInt();
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

        super.setInsuranceName("Car Insurance");
        super.setStartAndExpiryDateByYear(insuranceYear);

        double insuranceFee = ((carValue * (Math.max(0.5, 1 - ((LocalDate.now().getYear() - carModelYear) * 0.05))) * (1 + (numberOfAccidents * 0.1))) * 0.04) * (insuranceYear * 0.95);

        if(super.getAccount() instanceof Enterprise) {
            insuranceFee *= 0.8;
        }
        // Formül aracın değerinin yüzde 4 ünü temel alarak oluşturuldu. Aracın eskidiği her yıl için sigorta ücreti yüzde 5 düşüyor (en fazla yüzde 50 düşebilir) ve kaza başına yüzde 10 artıyor. (üst sınır yok)
        // Ve son olarak sigorta yapılan yıl başına yüzde 5 ek indirim sağlıyor.
        System.out.println("Car insurance fee : " + insuranceFee);

        super.setInsuranceFee(insuranceFee);
        //return 0.0;
    }
}
