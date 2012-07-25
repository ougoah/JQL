package jqlparser;
import java.util.ArrayList;

public class MyJQLParser implements JQLParser
{
    public int[] performQuery(String[] fieldKeys, String[][] fieldValues,
            String query)
    {
//separate queries
    String[] separated = query.split(" AND ");
 //for each query test truth
 //find position of equals
    int[] result = new int[fieldValues.length];
    for (int j = 0; j < fieldValues.length; j++) {
        for (String s : separated) {
            int i = 0;
            while (s.charAt(i) != '=') {
                i++;
            }
            String k = s.substring(0,i);
            String v = s.substring(i+1,s.length());
            int kpos = 0;
//get first occurrence in keys
            for (int m = 0; m < fieldKeys.length; m++) {
                if (fieldKeys[m]==k) {
                    kpos = m;
                }
            }
            if (!fieldValues[j][kpos].equals(v)) {
                result[j] = 5; //marks false ones
            }
        }
    }
    ArrayList<String> al = new ArrayList<String>();
    for (int i = 0; i < result.length; i++) {
        if (result[i] == 0) {
            al.add(Integer.toString(i));
        }
    }
    String[] stresult = new String[al.size()];
    int[] endresult = new int[al.size()];

    al.toArray(stresult);
    
    for (int i = 0 ; i < endresult.length; i++) {
    	endresult[i] = Integer.parseInt(stresult[i]);
    }
    return endresult;
    }
}