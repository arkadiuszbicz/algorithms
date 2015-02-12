package pl.arkadiuszbicz;

public class BigInteger {

  public static void main(String[] args) {

      System.out.println("123 x 45 " + 123 * 45);
      System.out.println("Final Result " + multiply("123", "45"));
  }

   static String multiply(String a, String b) {
        String result = "";
        String zeroPadding ="";
        for (int i = a.length()-1; i >= 0 ; i--) {
            String tmp = "";
            int rest = 0;
            for (int l =  b.length() -1; l >= 0; l--) {
                int ai = a.charAt(i) - '0';
                int bl = b.charAt(l) - '0';
                tmp = ((ai * bl) % 10 + rest) + tmp;
                rest = ai * bl / 10;
            }
            tmp = rest + tmp +  zeroPadding;
            zeroPadding += "0";
            System.out.println(tmp);
            int sumRest = 0;
            String tmpSum = "";
            int maxLen = Math.max(tmp.length(), result.length());

            for(int k=0; k < maxLen; k++) {
                int tk = (tmp.length() - k - 1) >= 0 ? tmp.charAt(tmp.length() - k - 1) - '0' : 0;
                int rk = (result.length() - k - 1) >= 0 ? result.charAt(result.length() - k - 1) - '0' : 0;
                System.out.println(" tk " + tk + " rk " + rk);
                tmpSum = (((tk + rk) % 10) + sumRest) + tmpSum;
                sumRest = (tk + rk) / 10;
            }
            result =  sumRest + tmpSum;
            System.out.println("result " + result);
        }

        int indexLastZero = 0;
        for(int k =0; k < result.length(); k++) {
            if(result.charAt(k) != '0')
                break;
            indexLastZero += 1;
        }
        return result.substring(indexLastZero);
    }
}