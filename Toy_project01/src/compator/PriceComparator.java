package compator;

import project.customer.Customer;

import java.util.Comparator;

public class PriceComparator implements Comparator<Customer> {
    int sign = 1;

    public PriceComparator(int Ascending){sign *= Ascending;}

    @Override
    public int compare(Customer o1 , Customer o2){

        int Price1 = o1.getTotalPrice();
        int Price2 = o2.getTotalPrice();

        if(Price1 == Price2){
            return o1.getSerialNum().compareToIgnoreCase(o2.getSerialNum());

        }else {
            return sign * (Price1 - Price2);
        }
    }
}
