
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("C:/Users/DELL/Downloads/WebLogProgram/short-test_log");
        la.printAll();
    }
    
    public void testUniqueIps()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("C:/Users/DELL/Downloads/WebLogProgram/short-test_log");
        int cnt = la.countUniqueIPs();
        System.out.println(cnt);
    }
    
    public void testuniqueIPVisitsOnDay()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("C:/Users/DELL/Downloads/WebLogProgram/short-test_log");
        la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("done");
    }
}
