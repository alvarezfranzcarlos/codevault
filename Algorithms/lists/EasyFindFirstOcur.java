import java.util.HashMap;
import java.util.*;

public class EasyFindFirstOcur {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needLen = needle.length();

        for (int i = 0; i < hayLen - needLen; i++) {
            if (haystack.substring(i, i + needLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        EasyFindFirstOcur easyFindFirstOcur = new EasyFindFirstOcur();

        int result = easyFindFirstOcur.strStr("wesadbutsad", "sad");
        System.out.println("index 1:" + result);

        result = easyFindFirstOcur.strStr("eleetocode", "leeto");
        System.out.println("index 2:" + result);
    }
}
