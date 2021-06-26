package Insurance;

import Customer.Account;
import Customer.Enterprise;

import java.time.LocalDate;
import java.util.Scanner;

public class ResidenceInsurance extends Insurance {

    private int housePrice;
    private int buildingYear;
    private int area;
    private int insuranceYear;

    public ResidenceInsurance(Account account) {
        super(account);
    }

    @Override
    public void getInputsFromUser() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the house price");
            housePrice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the building year");
            buildingYear = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the area");
            area = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many years do you want to have insurance?");
            insuranceYear = scanner.nextInt();
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        calculate();
    }

    @Override
    void calculate() {

        super.setInsuranceName("Residence Insurance");
        super.setStartAndExpiryDateByYear(insuranceYear);
        double insuranceFee = ((area / 30.0) * (housePrice / 1000.0)) * (1 + (0.02 * (LocalDate.now().getYear() - buildingYear))) * (insuranceYear * 0.95);

        if(super.getAccount() instanceof Enterprise) {
            insuranceFee *= 0.8;
        }
        // Temel sigorta fiyatı metrekare başına 0.3 ve ev fiyatının binde biri olacak şekilde belirlendi. Her bina yaşı başına temel fiyat yüzde 2 oranında arttırıldı ve
        // sigorta yapılacak yıl başına yüzde 5 indirim sağlanıyor.

        System.out.println("Residence insurance fee : " + insuranceFee);

    }
}
