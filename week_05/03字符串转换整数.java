class Solution {
    public int myAtoi(String s) {
        // 思维是不要在每一步都去改变这个s【Java中的String是immutable，一直改变会增加额外的内存空间】
        if(s==null||s.isEmpty()) return 0;
        int index = 0, sign = 1;
        long res = 0l;
        while(index<s.length() && s.charAt(index)==' '){
            index++; // 这样就移动到了第一个不是空格的元素
        }

        if(index<s.length() && (s.charAt(index)=='-' || s.charAt(index)=='+')){
             sign = s.charAt(index)=='-'?-1:1;
             index++; // 把符号位也判断出来了
        }

        long min = 2147483648l;
        long max = 2147483647l;

        while(index<s.length()){ // 始终注意这个条件！
            int num = s.charAt(index)-'0';
            if(num<0||num>9) break; // 不是数字了！

            long temp = res;

            res = res * (long)10 + (long)num;

            // 然后要比较了！-2147483648 至 2147483647

            if(sign == -1 && res>=min){
                res = min;
                break;
            }else if(sign == 1 && res>=max){
                res = max;
                break;
            }

            index++;
        }

        return Integer.valueOf(res * sign +"");
    }
}