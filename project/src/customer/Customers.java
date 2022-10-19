package customer;


//import project.compator.NameComparator;
//import project.compator.PriceComparator;
//import project.compator.TimeComparator;
//import project.groups.Group;
//import project.groups.Groups;

import java.nio.file.FileSystemAlreadyExistsException;
import compator.NameComparator;
import compator.PriceComparator;
import compator.TimeComparator;
import groups.Group;
import groups.Groups;

import java.util.Arrays;


public class Customers {

    private Customer[] customers =  new Customer[0] ;
    private  int size = 0; // 실제 배열 capacity
    private int count = 0; // 실제 인스턴스 개수

    Group[] groups = Groups.getInstance().getGroups();
    private static final Customers CUSTOMERS = new Customers(); // 싱글톤 패턴


    private Customers(){
    }

    public static Customers getInstance(){
        return CUSTOMERS;
    }

   // 고객 추가
    public void add(Customer customer){
        Customer[] temp = new Customer[++size]; // 고객 추가를 할 때 인원을 받으면 받은 수 만큼 반복문을 돌면서 자동으로 하나씩 늘어나게 함
        System.arraycopy(customers,0,temp,0,customers.length);
        temp[size-1] = customer; // 만약 5를 받으면 인덱스는 0~4니까 5 -1을 해서 마지막 인덱스에 넣어주려고 함
        customers = temp;
    }

    //고객 삭제

    public void remove(Customer customer){
        int rindex = 0;
        for(int i = 0; i <size; i++){
            if(customers[i].equals(customer)){
                rindex = i;
                break;
            }
        }
        Customer[] temp = new Customer[--size];
        // 고객을 삭제 할 거니까 기존에 배열 크기에서 하나를 줄여서 배열을 받아준다.

        System.arraycopy(customers,0,temp,0,rindex);
        System.arraycopy(customers,rindex+1, temp, rindex,customers.length-rindex-1);

        customers = temp;

        Group group = groups[customer.getGroupType().getIndex()];
        group.setCustomer_num(group.getCustomer_num() -1);

        customer = null; // 삭제
    }






    // 이름순 정렬
    public void sortByName(int isAscending){
        if(isAscending == 0){
            return;
        }
        Customer[] temp = new Customer[size];
        System.arraycopy(customers,0,temp,0,size);

        Arrays.sort(temp,new NameComparator(isAscending));
         printCustomerSummary(temp);

    }

    public void sortByTime(int isAscending){
        if(isAscending ==0){
            return;
        }
        Customer[] temp = new Customer[size];
        System.arraycopy(customers,0,temp,0,size); //customers에 0 부터 복사할 데이터를 넣고  tmep에서 0부터 size만큼 복사를 한다.

        Arrays.sort(temp,new TimeComparator(isAscending)); // isAscending이 음수이면 내림차순 양수로 받아오면 오름차순
        printCustomerSummary(temp);
    }

    public void sortByPrice(int isAscending){
        if(isAscending == 0){
            return;
        }
        Customer[] temp = new Customer[size];
        System.arraycopy(customers,0,temp,0,size);
        Arrays.sort(temp,new PriceComparator(isAscending));
        printCustomerSummary(temp);
    }

    public void printCustomers(){for(Customer c : customers) System.out.println(c);}

    public void printCustomerSummary(Customer[] customers){
      for(Group group : groups){
          String label = group.getGType().getLabel();
          System.out.println("======================");
          System.out.println(label+"그룹 : " + group.getCustomer_num()+"명");
          System.out.println("[조건]" + group.getParameter());
          for(Customer customer: customers){
              if(customer.getGroupType() == group.getGType()){
                  System.out.println(customer);
              }
          }
          System.out.println("");
      }

    }


    //getter,setter
    public Customer[] getCustomers(){
        return customers;
    }

    public void setCustomers_groupType(){
        for(Customer customer : customers){
            customer.setGroupType();
        }
    }




}
