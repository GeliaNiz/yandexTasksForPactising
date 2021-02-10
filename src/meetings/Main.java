package meetings;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static ArrayList<Meeting> m = new ArrayList<>();

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        String s = "";
        String[] command;
        N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            s = scanner.nextLine();
            command = s.split(" ", 2);
            switch (command[0]) {
                case "APPOINT" -> {
                    Meeting meeting = Meeting.parser(command[1]);
                    List<Meeting> meets = m.stream().filter(a -> {
                        int start = meeting.getBegin_time();
                        int end = meeting.getEnd_time();
                        return meeting.isFree(a.getMembers()) && a.getBegin_time() < end && a.getEnd_time() > start;
                            }
                    ).collect(Collectors.toList());
                    if (meets.isEmpty()) {
                        m.add(meeting);
                        m.sort(Comparator.comparingInt(Meeting::getBegin_time));
                        System.out.println("OK");
                    } else {
                        System.out.println("FAIL");
                    }

                }
                case "PRINT" -> {
                    String[] pr;
                    List<Meeting> meetings;
                    pr = command[1].split(" ");
                    meetings = m.stream().filter(meeting -> (meeting.getDay() == Integer.parseInt(pr[0])) &&
                            (meeting.getMembers().contains(pr[1]))).collect(Collectors.toList());
                    for (int j = 0; j < meetings.size(); j++) {
                        System.out.println(meetings.get(j));
                    }
                }
            }

        }
    }
}


