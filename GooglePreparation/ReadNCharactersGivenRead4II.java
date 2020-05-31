/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */

public class Solution extends Reader4 {

    private char[] buf2 = new char[4];
    private int currentIndex = 0;
    private int lastAddedInBuf = 0;
    private int charactersRead = 0;
    private boolean reachedMaxInFile = false;
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        currentIndex += n;
        
        int added = 0;
        
        while(lastAddedInBuf < currentIndex){
            int readCharacters = 0;
            
            if(lastAddedInBuf >= charactersRead){
                readCharacters = read4(buf2);
                if(readCharacters < 4){
                    reachedMaxInFile = true;
                }

                charactersRead += readCharacters;
            }
            
            int i = 0;
            while(i < 4){     
                if(added >= n){
                    break;
                }
                
                
                if(!(lastAddedInBuf >= charactersRead)){
                    buf[added++] = buf2[(lastAddedInBuf)%4];
                    lastAddedInBuf++;
                }
                
                
                i++;
            }
            
            if(lastAddedInBuf >= charactersRead && reachedMaxInFile){
                break;
            }
        }
        
        return added;
    }
}
