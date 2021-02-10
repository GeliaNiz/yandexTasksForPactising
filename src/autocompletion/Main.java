package autocompletion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> words = new ArrayList<>();
    public static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String current = "";
        for (int i = 0; i < N; i++) {
            current = scanner.next();
            if ((words.isEmpty()) || (!words.contains(current))) {
                words.add(current);
                result += current.length();
            } else {
                count(current, 0);
            }
        }
        System.out.println(result);
    }

    public static void count(String s, int letter) {
        ArrayList<String> find = words;
        for (int i = 0; i < find.size(); i++) {
            if ((find.get(i).length() != s.length()) || (s.charAt(letter) != find.get(i).charAt(letter))) {
                find.remove(i);
            }
        }
        result++;
        letter++;
        if (find.size() > 1) {
            count(s, letter);
        }
    }
}




