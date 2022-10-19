import menu.CustomerMenu;
import menu.GroupMenu;
import menu.Menu;
import menu.SummaryMenu;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        GroupMenu groupMenu = new GroupMenu();
        SummaryMenu summaryMenu = new SummaryMenu();
        CustomerMenu customerMenu = new CustomerMenu();

        while(true){
            int select = menu.displayMainMenu();

            if(select == 1){
                groupMenu.dispGroupMenu();
            }else if(select == 2){
                customerMenu.dispCustomerMenu();
            }else if(select == 3){
                summaryMenu.dispSummaryMenu();
            }else if(select == 4){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("잘못된 번호를 입력했습니다. 다시 입력하세요! ");
            }

        }


    }
}
