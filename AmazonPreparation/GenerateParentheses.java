class Solution {
    
    ArrayList<String> generatedParentheses = new ArrayList();
    public void generateParenthesis(int n, int openParentheses, int closedParentheses, String s){
        if(closedParentheses >= n) {
            return;
        }
        
        if(closedParentheses + openParentheses == n){
            for(int i=0; i<openParentheses; i++){
                s += ")";
            }
            generatedParentheses.add(s);
        } else {
            if(openParentheses > 0){
                generateParenthesis(n, openParentheses-1, closedParentheses+1, s+")");
                generateParenthesis(n, openParentheses+1, closedParentheses, s+"(");
            } else {
                generateParenthesis(n, openParentheses+1, closedParentheses, s+"(");
            }
            
        }
    }
    
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, 1, 0, "(");
        return generatedParentheses;
    }
}
