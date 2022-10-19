package menu;

import project.customer.Customers;
import project.groups.Group;
import project.groups.Groups;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static Scanner  sc = new Scanner(System.in);

    Group[] groups = Groups.getInstance().getGroups();

    Customers customers = Customers.getInstance();

    public Menu(){

    }

    public int displayMainMenu(){
        System.out.println("");
        System.out.println("==============================");
        System.out.println("1. 회원 등급 분류 기준 설정");
        System.out.println("2. 회원 관리");
        System.out.println("3. 회원 목록 요약");
        System.out.println("4. 프로그램 종료");
        System.out.println("==============================");
        return menuSelect();
    }

    public int menuSelect(){
        int input = -1;
        while(true){
            System.out.println(" 메뉴(번호)를 입력하세요 : ");
            try{
                input = sc.nextInt();
                break;
            }catch (InputMismatchException miss){
                sc = new Scanner(System.in);
                System.out.println("잘못된 값을 입력했습니다.\n");
            }
        }
        return input;
    }
}
