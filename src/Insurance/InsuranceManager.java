package Insurance;

import Customer.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsuranceManager {

    private final ArrayList<Insurance> insurances;

    public InsuranceManager(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public Insurance createCarInsurance(Account selectedAccount) {
        CarInsurance carInsurance = new CarInsurance(selectedAccount);
        carInsurance.getInputsFromUser();
        return carInsurance;
    }

    public Insurance createHealthInsurance(Account selectedAccount) {
        HealthInsurance healthInsurance = new HealthInsurance(selectedAccount);
        healthInsurance.getInputsFromUser();
        return healthInsurance;
    }

    public Insurance createResidenceInsurance(Account selectedAccount) {
        ResidenceInsurance residenceInsurance = new ResidenceInsurance(selectedAccount);
        residenceInsurance.getInputsFromUser();
        return residenceInsurance;
    }

    public Insurance createTravelInsurance(Account selectedAccount) {
        TravelInsurance travelInsurance = new TravelInsurance(selectedAccount);
        travelInsurance.getInputsFromUser();
        return travelInsurance;
    }

    public void deleteInsuranceByName() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the Name of the Insurance do you want to delete");
            String nameInput = scanner.nextLine();
            insurances.removeIf(insurance -> insurance.getInsuranceName().equalsIgnoreCase(nameInput));
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInsuranceByStartDate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the start date of the insurance do you want to delete (20/5/2021, 5/7/2020)");
            String startDateInput = scanner.nextLine();
            int[] datesAsInt = Arrays.stream(startDateInput.split("/")).mapToInt(Integer::parseInt).toArray();
            LocalDate date = LocalDate.of(datesAsInt[2], datesAsInt[1], datesAsInt[0]);

            insurances.removeIf(insurance -> insurance.getInsuranceStartDate().equals(date));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInsuranceByExpiryDate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the expiry date of the insurance do you want to delete (Have to be like this : 20/5/2021, 5/7/2020, 30/3/2025)");
            String expiryDateInput = scanner.nextLine();
            int[] datesAsInt = Arrays.stream(expiryDateInput.split("/")).mapToInt(Integer::parseInt).toArray();
            LocalDate date = LocalDate.of(datesAsInt[2], datesAsInt[1], datesAsInt[0]);

            insurances.removeIf(insurance -> insurance.getInsuranceExpiryDate().equals(date));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
