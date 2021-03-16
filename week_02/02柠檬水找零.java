class Solution {
    public boolean lemonadeChange(int[] bills) {
        int num5=0, num10=0, num20 = 0;
        boolean res = true;
        for(int n=0; n<bills.length;n++){
            if(bills[n]==5){
                num5++;
            }else if(bills[n]==10){
                if(num5>=1){
                    num5--;
                    num10++;
                }else{
                    res=false;
					break;
                }          
            }else{
                if(num5>=1&&num10>=1){
                    num20++;
                    num5--;
                    num10--;                    
                }else if(num5>=3){
                    num20++;
                    num5-=3;
                }else{
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
}