package meetings;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private ArrayList<String> members;
    private int day;
    private int begin_time;
    private int end_time;
    private String time;
    public Meeting(int day, int begin_time, int end_time,ArrayList<String> members,String time) {
        this.members = members;
        this.day = day;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.time=time;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(int begin_time) {
        this.begin_time = begin_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static Meeting parser(String s){
        ArrayList<String> people=new ArrayList<>();
       String[]data= s.split("[ :]");
        String time=data[1]+":"+data[2];
       for(int i=5;i< data.length;i++) {
           people.add(data[i]);
       }
       return new Meeting(Integer.parseInt(data[0]),Integer.parseInt(data[0])*1440+Integer.parseInt(data[1])*60+Integer.parseInt(data[2]),
               Integer.parseInt(data[3])+Integer.parseInt(data[0])*1440+Integer.parseInt(data[1])*60+Integer.parseInt(data[2])
                       ,people,time);
    }
    public boolean isFree(List<String> memb) {
        for (String s : members) {
            if(memb.contains(s))return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String memb="";
        for (String member : members) {
            memb += member + " ";
        }
        return  time +" "
                 + (end_time-begin_time) +" "
                +memb;
    }
}
