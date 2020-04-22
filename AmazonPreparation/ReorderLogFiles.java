import java.util.Arrays;
import java.util.HashSet;
import java.util.Comparator;

class Solution {
    
    private class StringComparator implements Comparator<String>{
        HashSet<Character> digitHashSet = new HashSet();

        StringComparator() {
            digitHashSet.add('0');
            digitHashSet.add('1');
            digitHashSet.add('2');
            digitHashSet.add('3');
            digitHashSet.add('4');
            digitHashSet.add('5');
            digitHashSet.add('6');
            digitHashSet.add('7');
            digitHashSet.add('8');
            digitHashSet.add('9');
        }
        
        private int compareStrings(String str1, String str2) {
            if(str1.equals(str2)) {
                return 0;
            }
            
            int str1Length = str1.length();
            int str2Length = str2.length();
            
            for(int j = 0; j < Math.min(str1Length, str2Length); j++){
                if(str1.charAt(j) > str2.charAt(j)){
                    return 1;
                } else if(str1.charAt(j) < str2.charAt(j)) {
                    return -1;
                }
            }
            
            if(str1Length > str2Length) {
                return 1;
            } else if(str1Length < str2Length) {
                return -1;
            }
            
            return 0;
        }
        
        private int compareStringsCompletely(String[] strArr1, String[] strArr2) {
            int str1ArrLength = strArr1.length;
            int str2ArrLength = strArr2.length;
            
            for(int i = 1; i < Math.min(str1ArrLength, str2ArrLength); i++){
                int stringComparation = compareStrings(strArr1[i], strArr2[i]);
                
                if(stringComparation == 1 || stringComparation == -1) {
                    return stringComparation;
                }
            }
            
            if(str1ArrLength > str2ArrLength) {
                return 1;
            } else if(str1ArrLength < str2ArrLength) {
                return -1;
            }
            
            return compareStrings(strArr1[0], strArr2[0]);
        }
        
        private boolean checkIfDigits(String[] string) {
            return digitHashSet.contains(string[1].charAt(0));
        }
        
        private boolean checkIfDigits(String str){
            return digitHashSet.contains(str.charAt(0));
        }
        
        @Override
        public int compare(String str1, String str2) {
            String[] splittedString1 = str1.split(" ");
            String[] splittedString2 = str2.split(" ");
            
            boolean isDigits1 = checkIfDigits(splittedString1);
            boolean isDigits2 = checkIfDigits(splittedString2);
            if(isDigits1 && !isDigits2){
                return 1;
            } else if(!isDigits1 && isDigits2){
                return -1;
            } else if(isDigits1 && isDigits2){
                return 0;
            } else {
                return compareStringsCompletely(splittedString1, splittedString2);
            }
        }
    }
    
    
    public String[] reorderLogFiles(String[] logs) {
        List<String> logsList = Arrays.asList(logs);
        
        Collections.sort(logsList, new StringComparator());
        
        return logsList.toArray(logs);
    }
}


/*
Very clean alternative solution for studying purposes

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}

 */
