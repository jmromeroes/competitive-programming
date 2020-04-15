class Solution {
    
    public int romanToInt(String s) {
        
        int i = s.length() - 1;
        int res = 0;
        
        for(; i>= 0; i--){
            char currentCharacter = s.charAt(i);
            
            switch(currentCharacter) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    if(i != 0 && s.charAt(i - 1) == 'I'){
                        res += 4;
                        i--;
                    } else {
                        res += 5;
                    }
                    break;
                case 'X':
                    if(i != 0 && s.charAt(i - 1) == 'I'){
                        res += 9;
                        i--;
                    } else {
                        res += 10;
                    }
                    break;
                case 'L':
                    if(i != 0 && s.charAt(i - 1) == 'X'){
                        res += 40;
                        i--;
                    } else {
                        res += 50;
                    }
                    break;
                case 'C':
                    if(i != 0 && s.charAt(i - 1) == 'X'){
                        res += 90;
                        i--;
                    } else {
                        res += 100;
                    }
                    break;
                case 'D':
                    if(i != 0 && s.charAt(i - 1) == 'C'){
                        res += 400;
                        i--;
                    } else {
                        res += 500;
                    }
                    break;
                case 'M':
                    if(i != 0 && s.charAt(i - 1) == 'C'){
                        res += 900;
                        i--;
                    } else {
                        res += 1000;
                    }
            }
            
        }
        
        return res;
    }
}
