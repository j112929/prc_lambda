package C;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Solution {
    public static void printReport(HashTable table) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .withZone(ZoneId.of("UTC"));
        System.out.println("High Watermark: " + formatter.format(table.getHighWatermark()));
        System.out.println("\nTable State:");
        TreeMap<String, String> sortedTable = new TreeMap<>(table.getTable());
        if (!sortedTable.isEmpty()) {
            sortedTable.forEach((x, y) -> System.out.println("\t" + x + ": " + y));
        }
    }

    public static ArrayList<String> getStdin() {
        Scanner s = new Scanner(System.in);
        ArrayList<String> rawEvents = new ArrayList<String>();
        while (s.hasNext()) {
            rawEvents.add(s.next());
        }
        s.close();

        return rawEvents;
    }

    public static void main(String[] args) throws Exception {
//        ArrayList<String> rawEvents = getStdin();
//        HashTable table = new HashTable(rawEvents);
//        printReport(table);
        String a = "1563454984001|INSERT|test|123";
        String[] split = a.split("\\|");
        System.out.println(split.length);
    }

    /**
     * Test class which constructs a view of the Hash Table's state given the input DML Events.
     */
    public static class HashTable {
        private final Map<String, String> table;
        private long highWatermark = -1;

        public HashTable(ArrayList<String> rawEvents) {
            table = new HashMap<>();
            for (int i = 0; i < rawEvents.size(); i++) {
                String[] eInfo = rawEvents.get(i).split("|");
                String type = eInfo[1];
                String key = eInfo[2];
                highWatermark = Long.valueOf(eInfo[0]);
                if (type.equals("INSERT")) {
                    if (!table.containsKey(key)) {
                        table.put(key, eInfo[3]);
                    }
                } else if (type.equals("UPSERT")) {
                    table.put(key, eInfo[3]);
                } else if (type.equals("DELETE")) {
                    table.remove(key);
                }
            }
        }

        /**
         * Retrieve the state of the HashTable after applying all input events
         *
         * @return a Map representing the Keys and Values of the current state
         */
        public Map<String, String> getTable() {
            return table;
        }

        /**
         * Retrieve the high-watermark of the HashTable as the millisecond epoch timestamp
         * of the latest event read or Instant.EPOCH in the case where no event occurred.
         *
         * @return an Instant representing the high watermark
         */
        public Instant getHighWatermark() {
            return highWatermark == -1 ? Instant.EPOCH : Instant.ofEpochSecond(highWatermark);
        }
    }

}