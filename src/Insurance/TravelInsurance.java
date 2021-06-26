package Insurance;

import Customer.Account;
import Customer.Enterprise;

import java.util.Scanner;

public class TravelInsurance extends Insurance {

    private int ticketPrice;
    private int insuranceMonth;


    public TravelInsurance(Account account) {
        super(account);
    }

    @Override
    public void getInputsFromUser() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the ticket price");
            ticketPrice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many months do you want to have insurance?");
            insuranceMonth = scanner.nextInt();
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        calculate();
    }

    @Override
    void calculate() {

        super.setInsuranceName("Travel Insurance");

        super.setStartAndExpiryDateByMonth(insuranceMonth);

        double insuranceFee = ticketPrice * 0.15 * (1 + (0.07 * insuranceMonth));

        if(super.getAccount() instanceof Enterprise) {
            insuranceFee *= 0.8;
        }
        // Sigorta fiyatı bilet bedelinin yüzde 15 i ve her ilave ay başına yüzde 7 fazla olacak şekilde hesaplandı.

        System.out.println("Travel insurance fee travel : " + insuranceFee);

    }
}
