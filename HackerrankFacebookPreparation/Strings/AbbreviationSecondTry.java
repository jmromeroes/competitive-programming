public class Solution {

    static HashMap<String, String> dp = new HashMap();

    private static String abbreviation(String a, int indexA, String b, int indexB) {
        if(dp.containsKey(String.format("%d-%d", indexA, indexB))) {
            return dp.get(String.format("%d-%d", indexA, indexB));
        } else {
            if(indexA < a.length()){
                if(indexB < b.length()){
                    if(Character.isUpperCase(a.charAt(indexA))){
                        if(a.charAt(indexA) != b.charAt(indexB)){ 
                            dp.put(String.format("%d-%d", indexA, indexB), "NO");
                            return "NO";
                        } else return abbreviation(a, indexA + 1, b, indexB + 1);
                    } else{
                        if(a.charAt(indexA) == Character.toLowerCase(b.charAt(indexB)))
                            if(abbreviation(a, indexA + 1, b, indexB + 1) == "YES" || abbreviation(a, indexA + 1, b, indexB) == "YES"){
                                dp.put(String.format("%d-%d", indexA, indexB), "YES");
                                return "YES";
                            } else{
                                return abbreviation(a, indexA + 1, b, indexB);
                            }
                        else return abbreviation(a, indexA + 1, b, indexB);
                    }
                } else{
                    if(Character.isUpperCase(a.charAt(indexA))) {
                        dp.put(String.format("%d-%d", indexA, indexB), "NO");
                        return "NO";
                    } else{
                        return abbreviation(a, indexA + 1, b, indexB);
                    }
                }
            } else {
                if(indexB < b.length()) return "NO";
                else return "YES";
            }
        }
    }    

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        dp = new HashMap();
        
        return abbreviation(a, 0, b, 0);
    }
}
