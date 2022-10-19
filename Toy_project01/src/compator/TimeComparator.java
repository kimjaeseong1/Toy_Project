package compator;

import project.customer.Customer;

import java.util.Comparator;

public class TimeComparator implements Comparator<Customer> {
    int sign=1;

    public TimeComparator(int Ascending){
        sign *= Ascending;
    }


    @Override
    public int compare(Customer o1, Customer o2) {

        int Time1 = o1.getSpentTime();
        int Time2 = o1.getSpentTime();

        if(Time1 == Time2){
            return o1.getSerialNum().compareToIgnoreCase(o2.getSerialNum());
        }else{
            return sign * (Time1 - Time2);
        }
    }
}
