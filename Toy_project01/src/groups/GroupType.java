package groups;

public enum GroupType {
    None("준회원",0),GENERAL("일반회원",1),VIP("우수회원",2),VVIP("최우수회원",3);

    private String label ="";
    private final int index;

    GroupType(String label, int index){
        this.label = label;
        this.index = index;
    }

    public String getLabel(){
        return label;
    }

    public int getIndex(){
        return index;
    }



}
