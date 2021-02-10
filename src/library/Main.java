package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k,m,d;
        int allbooks=0;
        int daybooks=1;
        int count=0;
        Scanner scanner=new Scanner(System.in);
        k=scanner.nextInt();
        m=scanner.nextInt();
        d=scanner.nextInt();
        if((d==6)||(d==7)){
            allbooks=m;
        }
        else{
            allbooks=m+k;
        }
        while(daybooks<=allbooks){
            if(d<6){
               allbooks=allbooks+k;
            }
            count++;
            allbooks=allbooks-daybooks;
            daybooks++;
            if(d!=7){
                d++;
            }
            else{
                d=1;
            }
                    }
        System.out.println(count);
    }
}
