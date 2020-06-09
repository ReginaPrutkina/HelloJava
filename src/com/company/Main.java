package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Client cl;
int arr[]={1,2,3,4,5};
int sum=0;
        {
            cl = new Client();
            cl.sumPrint(12,4);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i==1) break;
                   sum++;
                }
                System.out.println(sum);

            };
            for (int a:arr
                 ) {
             //   System.out.println(a);
                
            };
        }

    }

}
