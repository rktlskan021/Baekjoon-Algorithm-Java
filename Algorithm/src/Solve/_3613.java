package Solve;

import java.util.*;

public class _3613 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        boolean isCpp = false;
        boolean isJava = false;
        boolean isError = false;
        if (str.charAt(0) < 91 || str.charAt(0) == '_' || str.contains("__")) {
            isError = true;
        } else{
            for(int i = 1;i<str.length()-1;i++){
                char tmp = str.charAt(i);
                if(tmp == '_'){
                    isCpp = true;
                    if(isJava){
                       isError = true;
                    }
                }
                if(Character.isUpperCase(tmp)){
                    isJava = true;
                    if(isCpp){
                       isError = true;
                    }
                }
            }
            if(str.charAt(str.length()-1) == '_' || (Character.isUpperCase(str.charAt(str.length()-1)) && isCpp)){
                isError = true;
            }
        }
        if(isError){
            System.out.println("Error!");
        }
        else{
            if (isCpp){
                for(int i = 0;i<str.length()-1;i++){
                    if(str.charAt(i)=='_'){
                        char[] tmp = str.toCharArray();
                        tmp[i+1] = (char)(tmp[i+1]-32);
                        str = String.valueOf(tmp);
                    }
                }
                str = str.replace("_", "");
            }
            else{
                StringBuilder buf = new StringBuilder(str);
                int count = 0;
                for(int i = 0;i<str.length();i++){
                    if((int)str.charAt(i) < 91){
                        buf.insert(i+count, "_");
                        count++;
                    }
                }
                str = buf.toString();
                str = str.toLowerCase();
            }
            System.out.println(str);
        }
    }
}
