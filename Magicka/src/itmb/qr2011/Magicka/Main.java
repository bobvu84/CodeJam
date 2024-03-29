package itmb.qr2011.Magicka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     *https://code.google.com/codejam/contest/975485/dashboard#s=p1
     * Introduction
     * Magicka™ is an action-adventure game developed by Arrowhead Game Studios. In Magicka you play a wizard, invoking and combining elements to create Magicks. This problem has a similar idea, but it does not assume that you have played Magicka.
     *
     * Note: "invoke" means "call on." For this problem, it is a technical term and you don't need to know its normal English meaning.
     *
     * Problem
     * As a wizard, you can invoke eight elements, which are the "base" elements. Each base element is a single character from {Q, W, E, R, A, S, D, F}. When you invoke an element, it gets appended to your element list. For example: if you invoke W and then invoke A, (we'll call that "invoking WA" for short) then your element list will be [W, A].
     *
     * We will specify pairs of base elements that combine to form non-base elements (the other 18 capital letters). For example, Q and F might combine to form T. If the two elements from a pair appear at the end of the element list, then both elements of the pair will be immediately removed, and they will be replaced by the element they form. In the example above, if the element list looks like [A, Q, F] or [A, F, Q] at any point, it will become [A, T].
     *
     * We will specify pairs of base elements that are opposed to each other. After you invoke an element, if it isn't immediately combined to form another element, and it is opposed to something in your element list, then your whole element list will be cleared.
     *
     * For example, suppose Q and F combine to make T. R and F are opposed to each other. Then invoking the following things (in order, from left to right) will have the following results:
     *
     * QF → [T] (Q and F combine to form T)
     * QEF → [Q, E, F] (Q and F can't combine because they were never at the end of the element list together)
     * RFE → [E] (F and R are opposed, so the list is cleared; then E is invoked)
     * REF → [] (F and R are opposed, so the list is cleared)
     * RQF → [R, T] (QF combine to make T, so the list is not cleared)
     * RFQ → [Q] (F and R are opposed, so the list is cleared)
     * Given a list of elements to invoke, what will be in the element list when you're done?
     *
     * Input
     * The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line, containing the following space-separated elements in order:
     *
     * First an integer C, followed by C strings, each containing three characters: two base elements followed by a non-base element. This indicates that the two base elements combine to form the non-base element. Next will come an integer D, followed by D strings, each containing two characters: two base elements that are opposed to each other. Finally there will be an integer N, followed by a single string containing N characters: the series of base elements you are to invoke. You will invoke them in the order they appear in the string (leftmost character first, and so on), one at a time.
     *
     * Output
     * For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is a list in the format "[e0, e1, ...]" where ei is the ith element of the final element list. Please see the sample output for examples.
     *
     * Limits
     * 1 ≤ T ≤ 100.
     * Each pair of base elements may only appear together in one combination, though they may appear in a combination and also be opposed to each other.
     * No base element may be opposed to itself.
     * Unlike in the computer game Magicka, there is no limit to the length of the element list.
     *
     * Small dataset
     * 0 ≤ C ≤ 1.
     * 0 ≤ D ≤ 1.
     * 1 ≤ N ≤ 10.
     * Large dataset
     * 0 ≤ C ≤ 36.
     * 0 ≤ D ≤ 28.
     * 1 ≤ N ≤ 100.
     * Sample
     *
     * Input
     *
     * Output
     *
     * 5
     * 0 0 2 EA
     * 1 QRI 0 4 RRQR
     * 1 QFT 1 QF 7 FAQFDFQ
     * 1 EEZ 1 QE 7 QEEEERA
     * 0 1 QW 2 QW
     * Case #1: [E, A]
     * Case #2: [R, I, R]
     * Case #3: [F, D, T]
     * Case #4: [Z, E, R, A]
     * Case #5: []
     *
     *
     *
     * */


    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner s = new Scanner(new File("B-large-practice.in"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("B-large-practice.out"));
        int T = Integer.parseInt(s.nextLine());
        for (int zz = 0 ; zz < T; zz ++ ){
            int C = s.nextInt();
            String[] combines = new String[C];
            for (int i =0; i< C; i++){
                combines[i] = s.next();
            }
            int D = s.nextInt();
            String[] opposed = new String[D];
            for (int i = 0; i< D; i++){
                opposed[i] = s.next();
            }
            int N = s.nextInt();
            String words = s.next();
            ArrayList<Character> list = new ArrayList<Character>();
            for (int i = 0; i< N; i++){
                list.add(words.charAt(i));
                if (list.size()>=2){
                    Character l1, l2;
                    l1 = list.get(list.size()-1);
                    l2 = list.get(list.size()-2);
                    for (String combine: combines){
                        Character c1,c2,c3;
                        c1 = combine.charAt(0);
                        c2 = combine.charAt(1);
                        c3 = combine.charAt(2);
                        if ((l1 == c1 && l2 == c2) || (l1 ==c2 && l2 ==c1 )) {
                            list.remove(list.size() -1);
                            list.remove(list.size() -1);
                            list.add(c3);
                            break;
                        }

                    }

                    done:
                    for (int j = 0; j < list.size(); j ++) {
                        for (int k = 0; k< list.size(); k ++){
                            if (j < k) {
                                for (String opp: opposed) {
                                    Character o1, o2;
                                    o1 = opp.charAt(0);
                                    o2 = opp.charAt(1);
                                    if ((list.get(j) == o1 && list.get(k) == o2) || (list.get(j) == o2 && list.get(k)==o1)){
                                        list = new ArrayList<Character>();
                                        break done;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            System.out.println("Case #" + (zz +1 ) + ": " + list.toString());
            bf.write("Case #" + (zz +1 ) + ": " + list.toString() + "\n");
        }
        bf.flush();
    }
}
