package org.jpmorgan.assignment.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpmorgan.assignment.Instruction;
import org.jpmorgan.assignment.util.SortingUtil;

/**
 * This class converts instruction list into Map.
 * The key of map consist of entity name and instruction type using dash
 * Then elements of map is ordered my map value
 * @author ekber
 *
 */
public class RankingReport implements Report {

	private Map<String, Ranking> sortedMap;
	
    public RankingReport(List<Instruction> list) {
    	
        Map<String, Ranking> map = new HashMap<>();
        
        for(Instruction instruction : list){
        	String key = instruction.getEntity() + "-" + instruction.getInstructionType().getAbbreviation();
        	if(!map.containsKey(key)){
        		map.put(key, new Ranking(instruction.getEntity(), instruction.getTradeAmount(), instruction.getInstructionType()));
        	} else{
        		Ranking rankingEntry = map.get(key);
	        	rankingEntry.addAmount(instruction.getTradeAmount());
	        	map.put(key, rankingEntry);
        	}	   	
        }
        
        sortedMap = SortingUtil.sortReportContents(map);
    }
    
    public void generateReport() {    	
        for (Map.Entry<String, Ranking> entry : sortedMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    
    public String getGeneratedReport() {  
    	StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Ranking> entry : sortedMap.entrySet()) {
            sb.append(entry.getValue() + "\n");
        }
        
        return sb.toString();
    }

}
