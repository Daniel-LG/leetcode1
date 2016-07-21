package com.lg.questions.leetcode;
import java.util.*;
public class ReconstructItinerary332 {
	public List<String> findItinerary(String[][] tickets) {
        int ticketNum = tickets.length;
        List<String> itinerary = new ArrayList<String>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String[] ticket : tickets){
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from))
                map.put(from, new ArrayList<String>());
            ArrayList<String> dest = map.get(from);
            dest.add(to);
            map.put(from, dest);
        }
        for (String key : map.keySet()){
            ArrayList<String> tmp = map.get(key);
            Collections.sort(tmp);
        }
        itinerary.add("JFK");
        reconstruct(map, "JFK", itinerary, ticketNum);
        return itinerary;
    }
    private void reconstruct(Map<String, ArrayList<String>> map, String start, List<String> itinerary, int ticketNum){
        if (itinerary.size() == ticketNum + 1)
            return;
        List<String> dests = map.get(start);
        if (dests == null || dests.size() == 0)
            return;
        for (int i = 0; i < dests.size(); i++){
            String dest = dests.get(i);
            itinerary.add(dest);
            map.get(start).remove(i);
            reconstruct(map, dest, itinerary, ticketNum);
            if (itinerary.size() == ticketNum + 1)
                return;
            map.get(start).add(i, dest);
            itinerary.remove(itinerary.size() - 1);
        }
    }
    public static void main(String[] args) {
		ReconstructItinerary332 r = new ReconstructItinerary332();
		String[][] tickets = new String[][]{{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"}
					,{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},{"ANU","EZE"},
					{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},
					{"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},
					{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},
					{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},{"ADL","JFK"},
					{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},
					{"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},
					{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},
					{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},
					{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},
					{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},
					{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},
					{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},
					{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},
					{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},
					{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},
					{"AUA","EZE"}};
		r.findItinerary(tickets);
	}
}
