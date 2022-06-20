package ds.ArrayList;

public class _12 {
    /** runtime: 7 ms 73.23%
     *  memory usage: 45.5 MB 54.52% */
    public String intToRoman_1(int num){
        StringBuilder sb = new StringBuilder();

        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                num -= vals[i];
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }

    /** Constraint: 1 <= num <= 3999
     *  runtime: 16 ms 25.50%
     *  memory usage: 42.6 MB 76.89% */
    public String intToRoman_2(int num){
        //0,1000,2000,3000
        String[] M = {"","M","MM","MMM"};
        //0,100,200,300,400,500,600,700,800,900
        String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        //0,10,20,30,40,50,60,70,80,90
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        //0,1,2,3,4,5,6,7,8,9
        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
    }

}
