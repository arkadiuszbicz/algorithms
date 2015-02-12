package pl.arkadiuszbicz;

public class FindPalindrom {
    public static void main(String[] args) {
        String palindrom = "sds12344321gsdsf";
        int firstIndex =0, lastIndex = 0;
        for(int i = 0; i < palindrom.length() && i < (palindrom.length() -  firstIndex + lastIndex); i++) {
            for(int l = palindrom.length()-1; l > i && (l-i) > (lastIndex - firstIndex);  l--) {
                if ((palindrom.charAt(i) == palindrom.charAt(l)) && isPalindrom(palindrom, i, l)) {
                    firstIndex = i;
                    lastIndex = l;
                }
            }
        }
        System.out.println(firstIndex + " " + lastIndex);
    }

    public static boolean isPalindrom(String str, int startIndex, int stopIndex) {
        int n = stopIndex - startIndex+1;
        for(int i=startIndex; i < (n/2 + startIndex); i++) {
            if(str.charAt(i) != str.charAt(startIndex+stopIndex-i))
                return false;
        }
        return true;
    }
}
