package org.jpmorgan.assignment.reports;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jpmorgan.assignment.Instruction;
import org.jpmorgan.assignment.util.SortingUtil;

/**
 * This class converts instruction list into Map.
 * The key of map consist of settlement date and instruction type using dash
 * Then elements of map is ordered my map value
 * @author ekber
 *
 */
public class DailyReport implements Report {

    private Map<String, Daily> sortedMap;

    public DailyReport(List<Instruction> instructions) {
    	
        Map<String, Daily> map = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        
        for(Instruction instruction : instructions){
        	String key = dateFormat.format(instruction.getSettlementDate()) + "-" + instruction.getInstructionType().getAbbreviation();
        	if(!map.containsKey(key)){
        		map.put(key, new Daily(instruction.getSettlementDate(), instruction.getTradeAmount(), instruction.getInstructionType()));
        	} else{
        		Daily daily = map.get(key);
        		daily.addAmount(instruction.getTradeAmount());
	        	map.put(key, daily);
        	}	   	
        }
    	
        sortedMap = SortingUtil.sortReportContents(map);
    }

    public void generateReport() {
    	StringBuilder incoming = new StringBuilder();
    	incoming.append("Daily Incoming\n");
    	
    	StringBuilder outgoing = new StringBuilder();
    	outgoing.append("Daily Outgoing\n");
    	
        for (Map.Entry<String, Daily> entry : sortedMap.entrySet()) {
        	if(entry.getKey().contains("incoming")){
        		incoming.append(entry.getValue() + "\n");
        	} else{
        		outgoing.append(entry.getValue() + "\n");
        	}
        }
        System.out.println(incoming.toString());
        System.out.println(outgoing.toString());
    }

    /**
     * this method is used for test
     * @return
     */
    public String getGeneratedReport() {  
    	StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Daily> entry : sortedMap.entrySet()) {
            sb.append(entry.getValue() + "\n");
        }
        
        return sb.toString();
    }
}
