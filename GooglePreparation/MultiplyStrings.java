class Solution {
    
    private String removeLeadingZeroes(String s) {
        String s1 = "";
        boolean isLeadingZero = false;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '0' || isLeadingZero){
                System.out.println("hereeee");
                isLeadingZero = true;
                s1 += String.valueOf(s.charAt(i));
            }    
        }
        return s1.length()>0?s1:"0";
    }
    
    private String addTwoNumbers(String s1, String s2){
        int res = 0;
        String result = "";
        int maxStringLength = Math.max(s1.length(), s2.length());
        
        for(int i = 0; i < maxStringLength; i++){
            int indexV1 = s1.length()-i-1;
            int indexV2 = s2.length()-i-1;
            
            int v1 = indexV1 >= 0?s1.charAt(indexV1) - 48:0;
            int v2 = indexV2 >= 0?s2.charAt(indexV2) - 48:0;
            
            String sumResult = Integer.toString(v1 + v2 + res);
            if(sumResult.length() > 1){
                res = sumResult.charAt(0)-48;
                result = String.valueOf(sumResult.charAt(1))+result;
                continue;
            } 
            res = 0;
            result = String.valueOf(sumResult.charAt(0))+result;
        }
        
        return res != 0?Integer.toString(res)+result:result;
    }
    
    private String addResultList(ArrayList<String> resultList){
        System.out.println(resultList);
        
        String res = resultList.get(0);
        for(int i = 1; i < resultList.size(); i++){
            res = addTwoNumbers(res, resultList.get(i));
        }
        
        return res;
    }
    
    private String multiplyOperation(String num1, String num2){
        ArrayList<String> resultList = new ArrayList();
        for(int i=num2.length()-1; i>=0; i--){
            int res = 0;
            int v1 = num2.charAt(i) - 48;
            
            String result = "";
            
            for(int j=num1.length()-1; j>=0; j--){
                int v2 = num1.charAt(j) - 48;
                
                String simpleMultiplicationResult = Integer.toString((v1 * v2)+res);

                if(simpleMultiplicationResult.length()>1){
                    res = simpleMultiplicationResult.charAt(0)-48;
                    result = String.valueOf(simpleMultiplicationResult.charAt(1))+result;
                    continue;
                }
                res = 0;
                result = String.valueOf(simpleMultiplicationResult.charAt(0))+result;
            }
            
            result = res != 0?Integer.toString(res)+result:result;
            
            for(int h = 0; h < num2.length()-1-i; h++){
                result = result+"0";
            }
            
            resultList.add(result);
        }
        
        return addResultList(resultList);
    }
    
    public String multiply(String num1, String num2) {
        if(num1.length() > num2.length()){
            return removeLeadingZeroes(multiplyOperation(num1, num2));
        } else {
            return removeLeadingZeroes(multiplyOperation(num2, num1));
        } 
    }
}
