package groups;

public class Groups {
   Group[] groups = new Group[4]; // GroupType 의 type 개수

    private Groups(){
        groups[0] = new Group(GroupType.None);
        groups[1] = new Group(GroupType.GENERAL);
        groups[2] = new Group(GroupType.VIP);
        groups[3] = new Group(GroupType.VVIP);
    }

    private  static final Groups GROUPS = new Groups(); // 싱글톤 패턴

    public static  Groups getInstance(){
        return GROUPS;
    }

    public Group[] getGroups(){
        return groups;
    }
}
