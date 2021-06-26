package regex_to_dfa;

import java.util.Scanner;
import java.util.regex.*;

public class REGEX_TO_DFA {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        int state = 0;

        int i = 0;
        boolean reachedEmail = false;
        boolean reachedWebsite = false;

        try{
            loop:
            while (true) {
                switch (state) {

                    //===============================================    CASE 0    ==========================================================================
                    case 0:
                        if (i == length - 1) {
                            break loop;
                        }
                        char c = s.charAt(i);
                        i++;
                        String ch = String.valueOf(c);

                        Pattern p = Pattern.compile("[A-Za-z]");
                        Matcher m = p.matcher(ch);

                        if (m.matches()) {
                            state = 1;

                            System.out.print(m.group());
                            System.out.println(", state 0 eh " + ch + " paisi, ekhon state 1 eh jabo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 1    ==========================================================================  
                    case 1:
                        if (i == length) {
                            break loop;
                        }
                        char c2 = s.charAt(i);
                        i++;
                        String ch2 = String.valueOf(c2);
                        if (".".equals(ch2)) {
                            ch2 = ",";
                        }

                        Pattern p2 = Pattern.compile("[A-Za-z0-9._]");
                        Matcher m2 = p2.matcher(ch2);

                        Pattern p2_2 = Pattern.compile("@");
                        Matcher m2_2 = p2_2.matcher(ch2);

                        Pattern p2_3 = Pattern.compile("[,]");
                        Matcher m2_3 = p2_3.matcher(",");

                        if (m2.matches()) {
                            state = 1;

                            System.out.print(m2.group());
                            System.out.println(", state 1 eh " + ch2 + " paisi, ekhon state 1 ei thakbo");
                        } else if (m2_2.matches()) {
                            state = 2;

                            System.out.print("@");
                            System.out.println(", state 1 eh " + ch2 + " paisi, ekhon state 2 te jabo");
                        } else if (m2_3.matches()) {
                            state = 8;

                            System.out.print(".");
                            System.out.println(", state 1 eh . paisi, ekhon state 8 te jabo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 2    ==========================================================================  
                    case 2:
                        if (i == length - 1) {
                            break loop;
                        }
                        char c3 = s.charAt(i);
                        i++;
                        String ch3 = String.valueOf(c3);

                        Pattern p3 = Pattern.compile("[A-Za-z]");
                        Matcher m3 = p3.matcher(ch3);

                        if (m3.matches()) {
                            state = 3;

                            System.out.print(m3.group());
                            System.out.println(", state 2 eh " + ch3 + " paisi, ekhon state 3 te jabo");
                        } else {
                            state = 100;
                        }
                        break;
                    //ei projonto thikase ekdom

                    //===============================================    CASE 3    ==========================================================================  
                    case 3:
                        if (i == length - 1) {
                            break loop;
                        }
                        char c4 = s.charAt(i);
                        i++;
                        String ch4 = String.valueOf(c4);
                        if (".".equals(ch4)) {
                            ch4 = ",";
                        }

                        Pattern p4 = Pattern.compile("[A-Za-z0-9._]");
                        Matcher m4 = p4.matcher(ch4);

                        Pattern p4_2 = Pattern.compile("[,]");
                        Matcher m4_2 = p4_2.matcher(",");

                        if (m4.matches()) {
                            state = 3;

                            System.out.print(m4.group());
                            System.out.println(", state 3 eh " + ch4 + " paisi, ekhon state 3 ei thakbo");
                        } else if (m4_2.matches()) {
                            state = 4;

                            System.out.print(".");
                            System.out.println(", state 3 eh .  paisi, ekhon state 4 te jabo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 4    ==========================================================================   
                    case 4:
                        if (i == length - 1) {
                            break loop;
                        }
                        char c5 = s.charAt(i);
                        i++;
                        String ch5 = String.valueOf(c5);

                        Pattern p5 = Pattern.compile("[A-Za-z.]");
                        Matcher m5 = p5.matcher(ch5);

                        if (m5.matches()) {
                            state = 5;

                            System.out.print(m5.group());
                            System.out.println(", state 4 eh " + ch5 + " paisi, ekhon state 5 eh jabo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 5    ==========================================================================  
                    case 5:
                        if (i == length - 1) {
                            break loop;
                        }
                        char c6 = s.charAt(i);
                        i++;
                        String ch6 = String.valueOf(c6);

                        Pattern p6 = Pattern.compile("[A-Za-z.]");
                        Matcher m6 = p6.matcher(ch6);

                        if (m6.matches()) {
                            state = 6;

                            System.out.print(m6.group());
                            System.out.println(", state 5 eh " + ch6 + " paisi, ekhon state 6 eh jabo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 6    ==========================================================================  
                    case 6:
                        if (i == length) {
                            break loop;
                        }

                        char c7 = s.charAt(i);
                        i++;
                        String ch7 = String.valueOf(c7);

                        Pattern p7 = Pattern.compile("[A-Za-z.]");
                        Matcher m7 = p7.matcher(ch7);

                        if (m7.matches()) {
                            state = 6;
                            reachedEmail = true;
                            System.out.print(m7.group());
                            System.out.println(", state 6 eh " + ch7 + " paisi, ekhon state 6 ei thakbo");
                        } else {
                            state = 100;
                        }
                        break;

                    //===============================================    CASE 8    ==========================================================================  
                    case 8:

                        if (i == length - 1) {
                            break loop;
                        }

                        char c8 = s.charAt(i);
                        i++;
                        String ch8 = String.valueOf(c8);
                        if (".".equals(ch8)) {
                            ch8 = ",";
                        }

                        Pattern p8 = Pattern.compile("[A-Za-z0-9]");
                        Matcher m8 = p8.matcher(ch8);

                        Pattern p8_2 = Pattern.compile("[,]");
                        Matcher m8_2 = p8_2.matcher(",");

                        if (m8.matches()) {
                            state = 8;
                            System.out.print(m8.group());
                            System.out.println(", state 8 eh " + ch8 + " paisi, ekhon state 8 ei thakbo");
                        } else if (m8_2.matches()) {
                            state = 9;
                            System.out.print(".");
                            System.out.println(", state 8 eh . paisi, ekhon state 9 ei thakbo");
                        } else {
                            state = 100;
                        }

                        break;

                    //===============================================    CASE 9   ==========================================================================  
                    case 9:
                        if (i == length) {
                            break loop;
                        }
                        char c9 = s.charAt(i);
                        i++;
                        String ch9 = String.valueOf(c9);

                        Pattern p9 = Pattern.compile("[A-Za-z0-9]");
                        Matcher m9 = p9.matcher(ch9);

                        if (m9.matches()) {
                            state = 9;
                            reachedWebsite = true;
                            System.out.print(m9.group());
                            System.out.println(", state 9 eh " + ch9 + " paisi, ekhon state 9 ei thakbo");
                        }

                        break;

                    //===============================================    CASE 100    ==========================================================================  
                    case 100:
                        break loop;

                }

            }

        } 
        catch (Exception e) {

            System.out.println();

            System.out.println("This is neither an E-mail or a Website");
        }

        System.out.println();

        if (reachedEmail == true) {
            System.out.println("This is an E-mail");
        } else if (reachedWebsite == true) {
            System.out.println("This is Website");
        } else {
            System.out.println("This is neither an E-mail or a Website");
        }
    }

}
