package itmb.qr2011.candysplitting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math.*;
/***
 * https://code.google.com/codejam/contest/975485/dashboard#s=p2
 *Sean and Patrick are brothers who just got a nice bag of candy from their parents. Each piece of candy has some positive integer value, and the children want to divide the candy between them. First, Sean will split the candy into two piles, and choose one to give to Patrick. Then Patrick will try to calculate the value of each pile, where the value of a pile is the sum of the values of all pieces of candy in that pile; if he decides the piles don't have equal value, he will start crying.
 *
 * Unfortunately, Patrick is very young and doesn't know how to add properly. He almost knows how to add numbers in binary; but when he adds two 1s together, he always forgets to carry the remainder to the next bit. For example, if he wants to sum 12 (1100 in binary) and 5 (101 in binary), he will add the two rightmost bits correctly, but in the third bit he will forget to carry the remainder to the next bit:
 *
 *   1100
 * + 0101
 * ------
 *   1001
 * So after adding the last bit without the carry from the third bit, the final result is 9 (1001 in binary). Here are some other examples of Patrick's math skills:
 *
 * 5 + 4 = 1
 * 7 + 9 = 14
 * 50 + 10 = 56
 * Sean is very good at adding, and he wants to take as much value as he can without causing his little brother to cry. If it's possible, he will split the bag of candy into two non-empty piles such that Patrick thinks that both have the same value. Given the values of all pieces of candy in the bag, we would like to know if this is possible; and, if it's possible, determine the maximum possible value of Sean's pile.
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case is described in two lines. The first line contains a single integer N, denoting the number of candies in the bag. The next line contains the N integers Ci separated by single spaces, which denote the value of each piece of candy in the bag.
 *
 * Output
 * For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1). If it is impossible for Sean to keep Patrick from crying, y should be the word "NO". Otherwise, y should be the value of the pile of candies that Sean will keep.
 *
 * Limits
 * 1 ≤ T ≤ 100.
 * 1 ≤ Ci ≤ 106.
 * Small dataset
 * 2 ≤ N ≤ 15.
 *
 * Large dataset
 * 2 ≤ N ≤ 1000.
 *
 * Sample
 *
 * Input
 *
 * Output
 *
 * 2
 * 5
 * 1 2 3 4 5
 * 3
 * 3 5 6
 * Case #1: NO
 * Case #2: 11
 *
 *
 * NOTE: Pattrick is calculating using XOR, in XOR, sum of two equal values is 0
 *
 * */
public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner s = new Scanner(new File("C-large-practice.in"));
        BufferedWriter bf = new BufferedWriter(new FileWriter("C-large-practice.out"));
         int T = s.nextInt();
         s.nextLine();
         for (int i=0; i< T; i++){
             int N = s.nextInt();
             int[] candies = new int[N];
             int test = 0;
             long minVal = Long.MAX_VALUE , sum = 0, maxVal = 0;
             for (int j = 0 ; j< N; j++){
                 candies[j] = s.nextInt();
                 sum = sum + candies[j];
                 minVal = Math.min(minVal,candies[j]);
                 test = test ^ candies[j];
             }
             if(test !=0){
                 System.out.println("Case #" + (i+1)+": NO");
                 bf.write("Case #" + (i+1)+": NO\n");
             } else {
                 maxVal = sum - minVal;
                 System.out.println("Case #" + (i+1)+": " + maxVal);
                 bf.write("Case #" + (i+1)+": " + maxVal + "\n");
             }
         }
         bf.flush();
         bf.close();
    }
}
