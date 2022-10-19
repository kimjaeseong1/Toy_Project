package groups;

import java.util.Objects;

public class Parameter {
    private int spentTime;

    private int TotalPrice;

    //생성자

    public Parameter(){

    }

    public Parameter(int spentTime, int TotalPrice){
        this.spentTime = spentTime;
        this.TotalPrice = TotalPrice;
    }

    // getter, setter

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        if(spentTime >=0){
            this.spentTime = spentTime;
            System.out.println("최소 이용 시간이 입력되었습니다.");
        }else{
            // 에러 메세지
        }
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        if(totalPrice >= 0){
            this.TotalPrice = totalPrice;
            System.out.println("최고 이용 금액이 입력되었습니다.");
        }else{
            // 에러 메세지
        }
    }


    @Override
    public String toString() {
        return "Parameter{" +
                "spentTime=" + spentTime +
                ", TotalPrice=" + TotalPrice +
                '}';
    }
}
