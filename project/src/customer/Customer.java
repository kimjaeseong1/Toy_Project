package customer;


import exception.CustomerIDFormatException;
import exception.CustomerNameforematException;
import exception.LessThanZeroException;
import groups.Group;
import groups.GroupType;
import groups.Groups;
//import project.exception.CustomerIDFormatException;
//import project.exception.CustomerNameforematException;
//import project.exception.LessThanZeroException;
//import project.groups.Group;
//import project.groups.GroupType;
//import project.groups.Groups;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {

    static int count = 1;
    protected String SerialNum;
    protected String cusName; // 알파벳 ,3 글자 이상
    protected String cusId; // 알바벳 / 숫자/ _가능, 5~12 글자 , 첫 글자로 숫자나 _가 올 수 없음
    protected int spentTime;
    protected int totalPrice;

    private GroupType groupType = GroupType.None;
    private Customers customers = Customers.getInstance();

    private  Group[] groups = Groups.getInstance().getGroups();

    public Customer() {
       SerialNum = String.format("%04d",count++);
       customers.add(this);

       int none_num = groups[0].getCustomer_num();
       groups[0].setCustomer_num(none_num +1);

    }

    public String getSerialNum() {
        return SerialNum;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) throws CustomerNameforematException {
        String form = "^[a-zA-Z]{3,}$";
        if(Pattern.matches(form,cusName)){
            this.cusName = cusName;
            System.out.println("회원 이름이 입력되었습니다!");
        }else{
            // 에러 메세지
            throw new CustomerNameforematException("잘못된 이름입니다. 다시 입력해주세요");
        }


    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) throws CustomerIDFormatException {
        String form ="^[a-zA-Z][0-9a-zA-Z_]{4,11}$";
        if(Pattern.matches(form,cusId)){
            this.cusId = cusId;
            System.out.println("아이디가 입력 되었습니다. ");
        }else{
            // 에러메세지
            throw new CustomerIDFormatException("잘못된 아이디 입력입니다 다시 입력해주세요");
        }

    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) throws LessThanZeroException {
        if(spentTime >=0){
            this.spentTime = spentTime;
            System.out.println(this.spentTime+"시간이 입력되었습니다.");
        }else{
            //에러 메시지
            throw new LessThanZeroException("잘못된 시간 입력입니다 다시 입력해주세요! ");
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) throws LessThanZeroException{
        if(totalPrice >= 0){
            this.totalPrice = totalPrice;
            System.out.println(this.totalPrice+"금액이 입력되었습니다. ");
        }else{
            // 에러 메세지
            throw new LessThanZeroException("잘못된 금액 입력입니다. 다시 입력해주세요");
        }
    }

    public GroupType getGroupType(){
        return groupType;
    }


    public Group findGroup(){
        for(int i=0; i< 4; i++){
            if(groups[i].getGType() == this.groupType) return groups[i];

        }
        return null;
    }

    public void setGroupType(){ // 정보 수정을 할 때 사용
        Group now_group = findGroup();
        now_group.setCustomer_num(now_group.getCustomer_num()-1);
        // 정보 수정을 할 때 예를 들어 GENERAL에 있는 사람이 VIP로 올라갈 수 있으니까 GENERAL에 배정된 3사람 중 한 사람을 VIP로 올려주기 위해
        // now_group.getCustomer_num() -1 을 해주고

        int general_time = groups[1].getParameter().getSpentTime();
        int general_price = groups[1].getParameter().getTotalPrice();
        int vip_time = groups[2].getParameter().getSpentTime();
        int vip_price = groups[2].getParameter().getTotalPrice();
        int vvip_time = groups[3].getParameter().getSpentTime();
        int vvip_price = groups[3].getParameter().getTotalPrice();

        if(groups[3].isInitialized() && spentTime >= vvip_time && totalPrice >= vvip_price){
            // vvip가 초기화 되어 있거나 , vvip_time보다 커야지 정보가들어있다는 거스
            this.groupType = GroupType.VVIP;
            groups[3].setCustomer_num(groups[3].getCustomer_num()+1);
            // VVIP쪽에서 다른 등급에서 정보가 수정되어서 들어오면 VVIP 공간이 하나 더 늘어나야 하니까 +1을 해준다 .
        }else if(groups[2].isInitialized() && spentTime >= vip_time && totalPrice >= vip_price){
            this.groupType = GroupType.VIP;
            groups[2].setCustomer_num(groups[2].getCustomer_num()+1);
        } else if (groups[1].isInitialized() && spentTime >= general_time && totalPrice >= general_price) {
            this.groupType = GroupType.GENERAL;
            groups[1].setCustomer_num(groups[1].getCustomer_num()+1);
        }else{
            this.groupType = GroupType.None;
            groups[0].setCustomer_num(groups[0].getCustomer_num()+1);
        }

    }


    @Override
    public String toString() {
        return "Customer{" +
                "SerialNum=" + SerialNum +
                ", cusName='" + cusName + '\'' +
                ", cusId='" + cusId + '\'' +
                ", spentTime=" + spentTime +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
