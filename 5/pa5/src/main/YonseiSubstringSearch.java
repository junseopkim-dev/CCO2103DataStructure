/*
 * Name: Junseop Kim
 * Student ID #: 2019134006
 */

/*
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class YonseiSubstringSearch implements IYonseiSubstringSearch {

    // KMP 알고리즘 적용
    /*
     * you may declare variables here
     */

    public YonseiString text;

    //custom methods starts
    private int[] matchTable(YonseiString p) {
        int[] lps = new int[p.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i < p.length()) {

            if(p.charAt(i) == p.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            else {

                if(len != 0) {
                    len = lps[len-1];
                }

                else {
                    lps[i] = len;
                    i++;
                }

            }
        }
        return lps;
    }
    //custom methods ends



    YonseiSubstringSearch(YonseiString t) {
        /*
         * implement your constructor here.
         */
        this.text = t;
    }




    @Override
    public int countPattern(YonseiString p) {
        /*
         * Function input:
         *  + p: pattern to match in the target string.
         *
         * Does:
         * returns the number of occurrences of the pattern as a substring of the text given from the constructor.
         */

        int count = 0;
        int[] lps = matchTable(p);
        int i = 0;
        int j = 0;
        while(i < text.length()) {
            if(text.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            if(j == p.length()) {
                count++;
                j = lps[j-1];
            }
            else if(i < text.length() && text.charAt(i) != p.charAt(j)) {
                if(j != 0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return count;
    }


}
