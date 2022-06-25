package substringmatch;

public class SubStringMatch {
    public static int bruteforce(String s, String t){
        if(s.length() < t.length()){
            return -1;
        }
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i + j) != t.charAt(j)){
                    break;
                }
                if(j == t.length() - 1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "hello, this is liuyubobobo";
        String t = "is";
        System.out.println(bruteforce(s, t));
    }
}
