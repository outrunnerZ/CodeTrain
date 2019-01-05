package Test.ArrayandString;
import java.util.HashMap;

public class Day20190104 {
    static Boolean isUniqueString(String str){
        HashMap<Character,Boolean>map = new HashMap<Character,Boolean>();
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==Boolean.TRUE){
                return false;
            } else{
                map.put(str.charAt(i),true);
            }
        }
        return true;
    }
    //假设字符串是a~z
    static Boolean isUniqueString2(String str){
        int cheker = 0;
        for(int i=0; i<str.length();++i){
            int val = str.charAt(i);
            if((cheker & (1<<val))>1){
                return false;
            }else{
                cheker |= (1<<val);
            }
        }
        return true;
    }

    static void removeDupliacate(char[] str){
        // JAVA数组长度确定，则不能修改, lenth 是 Final 类型
        int checker = 0;
        int cur = 0;
        //边界考虑
        if(str == null) return;
        if(str.length<2) {
            System.out.print(str[0]);
            return;
        }

        for(int i=0; i<str.length; ++i){
            int val = str[i];
            if((checker & (1<<val)) == 0){
                checker |= (1<<val);
                str[cur] = str[i];
                System.out.print(str[cur]);
                cur ++;
            }
        }
        System.out.println();
    }

    static String removeDuplicate(String str){
        StringBuffer stringBuffer = new StringBuffer();
        //边界
        if(str.length()<2 || str==null) return str;
        for(int i=0; i<str.length();i++){
            if(!stringBuffer.toString().contains(String.valueOf(str.charAt(i)))){
                stringBuffer.append(str.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    //Write a method to decide if two strings are anagrams or not.
    static Boolean isRevearse(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        if(str1 == null || str2 ==null) return false;
        int length = str1.length();
        for(int i=0 ;i< length;i++){
            if(str1.charAt(i)!=str2.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    //Write a method to replace all spaces in a string with ‘%20’.
    //初级版本，由于StringBuffer.replace的时间复杂度是O(N),空间复杂度为O(Length),如有M个空格，则时间复杂度是M x O(N)
    static  String replaceSpacesWith1(String str, String repaceTest){
        StringBuffer stringBuffer = new StringBuffer(str);
        int start,end;
        start = end = 0;
        int spaceTrack = 0;
        for(int i=0;i<stringBuffer.length();i++){
            if(stringBuffer.charAt(i)== " ".charAt(0) && spaceTrack == 0){
                start = i;
                spaceTrack = 1;
            }else if(spaceTrack == 1 && stringBuffer.charAt(i)!=" ".charAt(0)){
                end = i;
                spaceTrack = 0;
                stringBuffer.replace(start,end,repaceTest);
            }
        }
        if(spaceTrack==1){
            stringBuffer.replace(start,stringBuffer.length(),repaceTest);
        }
        return stringBuffer.toString();
    }

//修改版本时间复杂度为O(N),空间复杂度为O(Length)
    static String replaceSpacesWith2(String str, String replaceText){
        StringBuffer stringBuffer = new StringBuffer();
        int start,end;
        start=end=0;
        int spaceTrack = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==" ".charAt(0) && spaceTrack == 0){
                spaceTrack = 1;
            }else if(str.charAt(i)!=" ".charAt(0)&& spaceTrack==1){
                spaceTrack = 0;
                stringBuffer.append(replaceText);
                stringBuffer.append(str.charAt(i));
            }else if(str.charAt(i)!=" ".charAt(0)) {
                stringBuffer.append(str.charAt(i));
            }
        }
         if(spaceTrack == 1){
             stringBuffer.append(replaceText);
         }

        return stringBuffer.toString();

    }

    //修改版本时间复杂度为O(N),空间复杂度为O(Length)
    static String replaceSpacesWith3(String str, String replaceText){
        StringBuilder stringBuffer = new StringBuilder();
        int start,end;
        start=end=0;
        int spaceTrack = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==" ".charAt(0) && spaceTrack == 0){
                spaceTrack = 1;
            }else if(str.charAt(i)!=" ".charAt(0)&& spaceTrack==1){
                spaceTrack = 0;
                stringBuffer.append(replaceText);
                stringBuffer.append(str.charAt(i));
            }else if(str.charAt(i)!=" ".charAt(0)) {
                stringBuffer.append(str.charAt(i));
            }
        }
        if(spaceTrack == 1){
            stringBuffer.append(replaceText);
        }

        return stringBuffer.toString();

    }

    public static void main(String[] args) {

//        if(isRevearse("abcd","dcbd")){
//            System.out.println("Ture");
//        }else {
//            System.out.println("False");
//        }
//
//        char[] str = "ASSBCDSS".toCharArray();
//        removeDupliacate(str);

//        System.out.println(repalceSpacewith("abcdss ss   s  ","%20"));
//        System.out.println(replaceSpacesWith2("abcdss ss   s  ","%20"));
        long startTime,endTime;
        String str = "abcdss ss   s  abcdss ss   s  abcdss ss   s  abcdss ss   s  abcdss ss   s  abcdss ss   s  abcdss ss   s  abcdss ss   s  ";
        //Test StringBuilder Replace
        startTime=System.nanoTime();   //获取开始时间
        System.out.println(replaceSpacesWith1(str,"%20"));
        endTime = System.nanoTime();
        System.out.println("replaceSpacesWith1 use "+(endTime-startTime) + "ns");

        //Test StringBuffer
        startTime=System.nanoTime();   //获取开始时间
        System.out.println(replaceSpacesWith2(str,"%20"));
        endTime = System.nanoTime();
        System.out.println("replaceSpacesWith2 use "+(endTime-startTime) + "ns");

        //Test StringBuffer Replace
        startTime=System.nanoTime();   //获取开始时间
        System.out.println(replaceSpacesWith3(str,"%20"));
        endTime = System.nanoTime();
        System.out.println("replaceSpacesWith3 use "+(endTime-startTime) + "ns");
    }
}
