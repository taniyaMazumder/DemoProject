package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoization {

	public static void main(String[] args) {
		System.out.println(isScrambleMem("great","rgeatrtcgc"));

	}

	//FOR STORING THE VALUE 
    static Map<String, Boolean> map = new HashMap<>();
    
    public static boolean isScrambleMem(String s1, String s2) {
        
         String key = s1+" "+s2;
        
        //IF VALUE ALREADY PRESENT THEN RETURN VALUE
        if(map.containsKey(key)){return map.get(key);}
        
        //BASECASE
        if(s1.equals(s2)){return true;}
        if(s1.length() <= 1){return false;}
        
        int n = s1.length();
        
        //        s1     s2
        //      great   eatgr
        
        //CONDITION #1           CHECKS
        //      gr|eat  eat|gr    AND   gr|eat  eat|gr
        //      |___________|               |____|
        
        //CONDITION #2          CHECK
        //      gr|eat  eat|gr    AND   gr|eat  eat|gr
        //      |________|                  |____|
        
        //IF(CONDITON#1 OR CONDITON#2){RETURN TRUE;}
        
        for(int i = 1; i<= n-1; i++)   
        { 
            //IF(CONDITON#1 || CONDITON#2){RETURN TRUE;}
            if( (isScrambleMem(s1.substring(0,i), s2.substring(n-i,n)) && isScrambleMem(s1.substring(i,n), s2.substring(0,n-i)))
                                      ||
                (isScrambleMem(s1.substring(0,i), s2.substring(0,i)) && isScrambleMem(s1.substring(i,n), s2.substring(i,n)))
               )
            { 
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}
