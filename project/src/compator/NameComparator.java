package compator;

import customer.Customer;
//import project.customer.Customer;

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {

    int sign =1;
    public NameComparator(int isAscending){
        sign *= isAscending;
    }

    @Override
    public int compare(Customer o1, Customer o2){

        String  Name1 = o1.getCusName();
        String  Name2 = o1.getCusName();

        if(Name1 == null && Name2 != null){
            return -1 * sign;
        }else if(Name1 != null && Name2 ==null){
            return 1 * sign;
        }else if(Name1 == Name2){
            return 0;
        }else{
            int result = Name1.compareToIgnoreCase(Name2);
            if(result != 0){
                return result * sign;
            }
        }
        return  o1.getSerialNum().compareToIgnoreCase(o2.getSerialNum());
    }

}
