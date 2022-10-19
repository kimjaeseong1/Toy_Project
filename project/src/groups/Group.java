package groups;



public class Group {

    private GroupType GType;

    private Parameter parameter;

    private  int customer_num = 0;

    private boolean isInitialized;
    // 초기화 시켜주기 위해 사용함

    public Group(GroupType groupType){
        GType = groupType;
        parameter = new Parameter();
        isInitialized = false;
    }

    //getter ,setter


    public GroupType getGType() {
        return GType;
    }

    public void setGType(GroupType GType) {
        this.GType = GType;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public int getCustomer_num() {
        return customer_num;
    }

    public void setCustomer_num(int customer_num) {
        this.customer_num = customer_num;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }
}
