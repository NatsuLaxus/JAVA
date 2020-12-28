
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
     
     public int countUniqueIPs()
     {
         ArrayList uniqueIps = new ArrayList();
         for(LogEntry le : records)
         {
             String ip = le.getIpAddress();
             if(!uniqueIps.contains(ip))
             {
                 uniqueIps.add(ip);
             }
         }
         return uniqueIps.size();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         WebLogParser wp = new WebLogParser();
         for(String s: fr.lines())
         {
             LogEntry temp = wp.parseEntry(s);
             records.add(temp);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public void uniqueIPVisitsOnDay(String day)
     {
         
         for(LogEntry le : records)
         {
             String currDate = le.getAccessTime().toString().substring(4,10);
             System.out.println(currDate);
             if(currDate.equals(day))
             {
                 System.out.println(le);
             }
         }
     }
     
}
