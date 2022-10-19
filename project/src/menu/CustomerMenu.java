package menu;

import customer.Customer;
import exception.CustomerException;
//import project.customer.Customer;
//import project.exception.CustomerException;
//import project.exception.CustomerNameforematException;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu extends  Menu{

    public CustomerMenu (){

    }

    public void dispCustomerMenu(){
        while(true){
            System.out.println("");
            System.out.println("====================");
            System.out.println("1. 회원 정보 추가");
            System.out.println("2. 회원 정보 열람");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 정보 삭제");
            System.out.println("5. 프로그램 종료");
            System.out.println("====================");

            int menuChoice = menuSelect();
            System.out.println();

            if(menuChoice == 1){
                    addCustomer();
            } else if (menuChoice == 2 ) {
                    printCustomerList();
            }else if(menuChoice == 3){
                updateCustomer();
            }else if(menuChoice == 4){
                printCustomerList();
                deleteCustomer();
                printCustomerList();
            }else if(menuChoice == 5){

                return;
            }else{
                System.out.println(" 잘못된 번호입력 입니다.");
            }
        }
    }

    public void addCustomer(){ //1 번 회원 추가
        int num = numToAdd();

        for(int i =0; i< num; i++){
            System.out.println("======회원 " + (i+1)+ "정보입니다.");
            Customer customer = new Customer();
            selectInformation(customer);
        }
    }

    public void printCustomerList(){ // 회원 정보 열람
        Customer[] list = customers.getCustomers();

        System.out.println("=======회원 정보=======");
        for(int i =0; i<list.length; i++){
            System.out.println((i+1)+"번 회원 =>" + list[i]);
        }

    }

    public void deleteCustomer(){/// 회원 정보 삭제
        //printCustomerList();
        Customer customer = selectCustomer();

        customers.remove(customer);

        System.out.println("선택한 회원이 삭제되었습니다.");
        //printCustomerList();
    }

    public void updateCustomer(){ // 회원 정보 수정
        printCustomerList();
        Customer customer = selectCustomer();

        selectInformation(customer);
    }




    public Customer selectCustomer(){
        Customer[] list = customers.getCustomers();
        System.out.println("회원의 번호를 입력하세요. (1~" + list.length+") :");
        int input = sc.nextInt();
        return list[input - 1];
    }
    public void selectInformation(Customer customer){
        while(true){
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 이름");
            System.out.println("2. ID");
            System.out.println("3. 이용 시간");
            System.out.println("4. 총 결제 금액");
            System.out.println("5. 돌아가기");
            System.out.println("==============================");

            int input = menuSelect();
            System.out.println();

            if(input == 1){ // 이름
                while(true){

                    try{
                        editCustomerName(customer);
                        break;

                    }catch(CustomerException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }else if(input == 2){//ID
                while(true){

                    try{
                        editCustomerID(customer);
                        break;
                    }catch(CustomerException e){
                        System.out.println(e.getMessage());
                    }

                }
            }else if(input == 3){ //  이용시간
                while(true){

                    try{
                        editCustomerTime(customer);
                        customers.setCustomers_groupType();
                        break;

                    }catch(InputMismatchException ime){
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다.");
                    }catch(CustomerException e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if(input == 4){ // 총 결제 금액
                while(true){

                    try{
                        editCustomerPrice(customer);
                        customers.setCustomers_groupType();
                        break;
                    }catch(InputMismatchException ime){
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다.");
                    }catch(CustomerException e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if(input==5){
                return;
            }else{
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요");
            }
        }
    }

    public void editCustomerName(Customer customer)throws CustomerException{
        System.out.println("회원의 이름을 입력하세요 ( 알파벳 3글자 이상)");
        String name = sc. next();
        customer.setCusName(name);
    }

    public void editCustomerID(Customer customer)throws  CustomerException{
        System.out.println("회원의 ID를 입력하세요 (알파벳,숫자,\'_\' 사용 가능 / 5~12글자 / 알파벳으로 시작) :");
        String ID = sc.next();
        customer.setCusId(ID);
    }

    public void editCustomerTime(Customer customer) throws CustomerException , InputMismatchException{
        System.out.println("회원의 이용시간을 입력하세요");
        int Time = sc.nextInt();
        customer.setSpentTime(Time);
    }

    public void editCustomerPrice(Customer customer) throws CustomerException, InputMismatchException{
        System.out.println("회원의 총 사용한 금액을 입력하세요");
        int Price  = sc.nextInt();
        customer.setTotalPrice(Price);
    }















    public int numToAdd(){
        System.out.println("**\'-1\'을 입력하면 메뉴로 되돌아갑니다.");
        System.out.println("고객을 몇 명 추가하시겠습니까?");
        int input = -1;

        try{
            input =sc.nextInt();

        }catch(InputMismatchException e){
            sc = new Scanner(System.in);
            System.out.println("잘못된 값을 입력했습니다. 정수만 입력해주세요");
        }
        return input;

    }

}
