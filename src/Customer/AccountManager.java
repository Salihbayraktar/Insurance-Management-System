package Customer;

import Address.Address;
import Address.BusinessAddress;
import Address.HomeAddress;
import Insurance.Insurance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {

    static TreeSet<Account> accounts = new TreeSet<>(Comparator.comparing((o1 -> o1.getUser().getName())));

    static {
        Address salihBusinessAddress = new BusinessAddress(1,"Salih Business Address 1", 123123);
        Address salihHomeAddress = new HomeAddress(2,"Salih Home Address 1", 321321);

        ArrayList<Address> salihAddressList = new ArrayList<>();
        salihAddressList.add(salihBusinessAddress);
        salihAddressList.add(salihHomeAddress);

        User salihUser = new User("Salih", "BAYRAKTAR", "bayraktar.salih@hotmail.com", "1234", "Java Developer", 25, salihAddressList, LocalDate.of(2021, 6, 15));

        ArrayList<Insurance> salihInsuranceList = new ArrayList<>();

        accounts.add(new Individual(salihUser,salihInsuranceList,AuthenticationStatus.FAIL));

        //--------------------------------------------------------------------
        Address ahmetBusinessAddress = new BusinessAddress(1,"Ahmet Business Address 1", 85151);
        Address ahmetHomeAddress = new HomeAddress(2,"Ahmet Home Address 1", 9455);

        ArrayList<Address> ahmetAddressList = new ArrayList<>();
        ahmetAddressList.add(ahmetBusinessAddress);
        ahmetAddressList.add(ahmetHomeAddress);

        User ahmetUser = new User("Ahmet", "YILMAZ", "yilmaz.ahmet@hotmail.com", "4321", "Android Developer", 22, ahmetAddressList, LocalDate.of(2021, 6, 10));

        ArrayList<Insurance> ahmetInsuranceList = new ArrayList<>();

        accounts.add(new Individual(ahmetUser,ahmetInsuranceList,AuthenticationStatus.FAIL));

        //------------------------------------------------------------------------------------

        Address merveBusinessAddress = new BusinessAddress(1,"Merve Business Address 1", 51616);
        Address merveHomeAddress = new HomeAddress(2,"Merve Home Address 1", 89491);

        ArrayList<Address> merveAddressList = new ArrayList<>();
        merveAddressList.add(merveBusinessAddress);
        merveAddressList.add(merveHomeAddress);

        User merveUser = new User("Merve", "DELEN", "delen.merve@hotmail.com", "98765", "Python Developer", 24, merveAddressList, LocalDate.of(2021, 6, 5));

        ArrayList<Insurance> merveInsuranceList = new ArrayList<>();

        accounts.add(new Individual(merveUser,merveInsuranceList,AuthenticationStatus.FAIL));
        //------------------------------------------------------------------------------------


        Address ayseBusinessAddress = new BusinessAddress(1,"Ayse Business Address 1", 6521);
        Address ayseHomeAddress = new HomeAddress(2,"Ayse Home Address 1", 94106);

        ArrayList<Address> ayseAddressList = new ArrayList<>();
        ayseAddressList.add(ayseBusinessAddress);
        ayseAddressList.add(ayseHomeAddress);

        User ayseUser = new User("Ayse", "ISIK", "isik.ayse@hotmail.com", "8414", "Javascript Developer", 28, ayseAddressList, LocalDate.of(2021, 6, 1));

        ArrayList<Insurance> ayseInsuranceList = new ArrayList<>();

        accounts.add(new Individual(ayseUser,ayseInsuranceList,AuthenticationStatus.FAIL));
        //---------------------------------------------------------------------------------------

        Address hakanBusinessAddress = new BusinessAddress(1,"Hakan Business Address 1", 45466);
        Address hakanHomeAddress = new HomeAddress(2,"Hakan Home Address 1", 5294);

        ArrayList<Address> hakanAddressList = new ArrayList<>();
        hakanAddressList.add(hakanBusinessAddress);
        hakanAddressList.add(hakanHomeAddress);


        User hakanUser = new User("Hakan", "CAGLAR", "caglar.hakan@hotmail.com", "5165", "React Developer", 32, hakanAddressList, LocalDate.of(2021, 2, 20));

        ArrayList<Insurance> hakanInsuranceList = new ArrayList<>();

        accounts.add(new Individual(hakanUser,hakanInsuranceList,AuthenticationStatus.FAIL));

        //---------------------------------------------------------------------------------------------

        Address garantiBusinessAddress = new BusinessAddress(1,"Garanti Business Address 1", 45466);

        ArrayList<Address> garantiAddressList = new ArrayList<>();

        garantiAddressList.add(garantiBusinessAddress);

        User garantiUser = new User("Garanti", "BBVA", "bbva.garanti@hotmail.com", "8558", "Bank", 170, garantiAddressList, LocalDate.of(2021, 2, 20));

        ArrayList<Insurance> garantiInsuranceList = new ArrayList<>();

        accounts.add(new Enterprise(garantiUser, garantiInsuranceList, AuthenticationStatus.FAIL));


        //------------------------------------------------------------------------------------------------------

        Address patikaBusinessAddress = new BusinessAddress(1,"Patika Business Address 1", 498456);

        ArrayList<Address> patikaAddressList = new ArrayList<>();

        patikaAddressList.add(patikaBusinessAddress);

        User patikaUser = new User("Patika", "dev", "dev.patika@hotmail.com", "8498", "Software", 1, patikaAddressList, LocalDate.of(2021, 2, 20));

        ArrayList<Insurance> patikaInsuranceList = new ArrayList<>();

        accounts.add(new Enterprise(patikaUser, patikaInsuranceList, AuthenticationStatus.FAIL));


        //-----------------------------------------------------------------------------------------------------------

        Address kodluyoruzBusinessAddress = new BusinessAddress(1,"Kodluyoruz Business Address 1", 45466);

        ArrayList<Address> kodluyoruzAddressList = new ArrayList<>();
        kodluyoruzAddressList.add(kodluyoruzBusinessAddress);

        User kodluyoruzUser = new User("Kodluyoruz", "org", "org.kodluyoruz@hotmail.com", "8558", "Bank", 170, kodluyoruzAddressList, LocalDate.of(2021, 2, 20));

        ArrayList<Insurance> kodluyoruzInsuranceList = new ArrayList<>();

        accounts.add(new Enterprise(kodluyoruzUser, kodluyoruzInsuranceList, AuthenticationStatus.FAIL));

    }

    public static TreeSet<Account> getAccounts() {
        return accounts;
    }


    public static Account login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the email : ");

         String emailInput = scanner.nextLine();

       // String emailInput = "bayraktar.salih@hotmail.com";

        System.out.println("Please enter the password : ");

         String passwordInput = scanner.nextLine();

        //String passwordInput = "1234";

        Account selectedAccount = null;
        try {
            selectedAccount = accounts.stream()
                    .filter(account -> account.getUser().getEmail().equalsIgnoreCase(emailInput) && account.getUser().getPassword().equals(passwordInput))
                    .findFirst()
                    .orElseThrow(InvalidAuthenticationException::new);

            selectedAccount.setAuthenticationStatus(AuthenticationStatus.SUCCESS);

        } catch (InvalidAuthenticationException e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            assert selectedAccount != null;
        }

        System.out.print("""
                Login successful
                Welcome to the insurance management system
                """);
        selectedAccount.showUserInfo();

        selectedAccount.getUser().setLastLoginDate(LocalDate.now());

        return selectedAccount;
    }

}
