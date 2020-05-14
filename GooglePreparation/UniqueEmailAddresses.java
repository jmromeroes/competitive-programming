class Solution {
    
    private String cleanEmail(String email, int currentIndex, boolean ignoreCharacters, String result, boolean inLocalName){
        if(currentIndex >= email.length()){
            return result;
        }
        
        switch(email.charAt(currentIndex)){
            case '+':
                if(inLocalName){
                    return cleanEmail(email, currentIndex + 1, true, result, inLocalName);
                }
            case '@':
                return cleanEmail(email, currentIndex + 1, false, result+"@", false) ;
            case '.':
                if(ignoreCharacters){
                    return cleanEmail(email, currentIndex + 1, true, result, inLocalName);
                } else if(!inLocalName){
                    return cleanEmail(email, currentIndex + 1, false, result+'.', inLocalName);
                } else {
                    return cleanEmail(email, currentIndex + 1, false, result, inLocalName);
                }
            default:
                if(ignoreCharacters)
                    return cleanEmail(email, currentIndex + 1, true, result, inLocalName);
                else
                    return cleanEmail(email, currentIndex + 1, false, result+email.charAt(currentIndex), inLocalName);
        }
    }
    
    public int numUniqueEmails(String[] emails){
        HashSet<String> emailSet = new HashSet();
        
        for(String email: emails){
            String cleanedEmail = cleanEmail(email, 0, false, "", true);
            emailSet.add(cleanedEmail);
        }
        
        return emailSet.size();
    }
}
