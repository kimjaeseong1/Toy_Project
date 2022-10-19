package menu;

import exception.LessThanZeroException;
import groups.Group;
import groups.GroupType;
//import project.exception.CustomerException;
//import project.exception.LessThanZeroException;
//import project.groups.Group;
//import project.groups.GroupType;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class GroupMenu extends Menu{

    public GroupMenu(){

    }

    public void dispGroupMenu(){ // 메인
        while(true){
            System.out.println("");
            System.out.println("==============================");
            System.out.println("1. 분류 기준 설정");
            System.out.println("2. 분류 기준 확인");
            System.out.println("3. 분류 기준 수정");
            System.out.println("4. 돌아가기");
            System.out.println("==============================");
            int select = sc.nextInt();
            System.out.println();

            if(select == 1){
                setParameter();
            }else if(select == 2){
                printParameter();
            }else if(select == 3){
                updateParameter();
            }else if(select == 4){
                return;
            }else {
                System.out.println("잘못된 번호를 입력했습니다.");
            }

        }

    }

    public void setParameter(){ // 1번 메뉴
        while(true){
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if(input.equals("END")){
                return;
            }

            if(input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")){
                GroupType groupType = null;
                // 해당 등급이 오면 초괴화를 시켜주고 값을 입력 받아야 하기 때문에 초기화를 시켜준다.
                for(GroupType gy: GroupType.values()){
                        if(gy.name().equals(input)) {
                            groupType = gy;
                        }

                }
                if(isGrade(groupType)){
                    System.out.println("해당 등급 분류 기준이 이미 존재합니다.\n");
                    continue;
                }
                groups[groupType.getIndex()].setInitialized(true);
                selectParameter(groupType);

            }else{
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요");
            }
        }
    }

    public void printParameter(){
        while(true){
            String input = selectGrade().toUpperCase(Locale.ROOT);

            if(input.equals("END")){
                return;
            }

            if(input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")){
                GroupType groupType = null;

                for(GroupType gy : GroupType.values()){
                    if(gy.name().equals(input)){
                        groupType = gy;
                    }

                }

                if(!isGrade(groupType)){
                    System.out.println("해당 등급 분류 기준이 존재하지 않습니다.");
                    continue;
                }

                Group group = groups[groupType.getIndex()];
                System.out.println("[그룹]" + groupType.getLabel());
                System.out.println("이용 시간:" + group.getParameter().getSpentTime());
                System.out.println("총 결제 금액" + group.getParameter().getTotalPrice());

            }else{
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요");
            }
        }
    }


    public void updateParameter(){
        while (true){
            String input = selectGrade().toUpperCase(Locale.ROOT);
            if(input.equals("END")){
                return;
            }

            if(input.equals("GENERAL") || input.equals("VIP") || input.equals("VVIP")){
                GroupType groupType = null;

                for(GroupType gy : GroupType.values()){

                    if(gy.name().equals(input)){
                        groupType = gy;
                    }
                }

                if(!isGrade(groupType)){
                    System.out.println("해당 등급 뷴류 기준이 존재하지 않습니다.");
                    continue;
                }
                Group group =  groups[groupType.getIndex()];
                System.out.println("그룹: " + groupType.getLabel());
                System.out.println("[현재 조건] 이용 시간:" + group.getParameter().getSpentTime());
                System.out.println("결제 금액" + group.getParameter().getTotalPrice() + "\n");

                selectParameter(groupType);
            }else{
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요.\n");
            }
        }
    }

    public void selectParameter(GroupType groupType){
        while(true){
            System.out.println("==============================");
            System.out.println("1. 최소 이용 시간");
            System.out.println("2. 최소 결제 금액");
            System.out.println("3. 돌아가기");
            System.out.println("==============================");

            int input = menuSelect();
            System.out.println();

            if(input == 1){
                while(true){

                    try{
                        editspentTime(groups[groupType.getIndex()]);
                        customers.setCustomers_groupType();
                        break;
                    }catch(InputMismatchException ime){
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다.");
                    }catch(LessThanZeroException e){
                        System.out.println(e.getMessage());
                    }
                }

            }else if(input == 2){
                while(true){

                    try{
                        editspentPrice(groups[groupType.getIndex()]);
                        customers.setCustomers_groupType();
                        break;
                    }catch(InputMismatchException ime){
                        sc = new Scanner(System.in);
                        System.out.println("잘못된 값을 입력했습니다.");
                    }catch(LessThanZeroException e){
                        System.out.println(e.getMessage());
                    }
                }
            }else if(input == 3){
                return;
            }else{
                System.out.println("잘못된 번호를 입력했습니다.");
            }

        }
    }


    public String selectGrade() {
        System.out.println("\'end\'를 입력하면 메뉴로 돌아갑니다.");
        System.out.println("등급을 선택하세요, (GENERAL,VIP,VVIP)");

        String input = sc.next();
        return input;
    }

    public boolean isGrade(GroupType groupType){
        if(groups[groupType.getIndex()].isInitialized()){
            return true;
        }else {
            return false;
        }
    }

    public void editspentTime(Group group) throws LessThanZeroException , InputMismatchException {
        System.out.println(group.getGType().getLabel()+"의 최소 사용 시간을 입력하세요");
        int time = sc.nextInt();
        System.out.println();
        group.getParameter().setSpentTime(time);

    }
    public void editspentPrice(Group group)throws LessThanZeroException,InputMismatchException{
        System.out.println(group.getGType().getLabel()+"최초 결제금액을 입력하세요 ");
        int pay = sc.nextInt();
        System.out.println();
        group.getParameter().setTotalPrice(pay);
    }

}
