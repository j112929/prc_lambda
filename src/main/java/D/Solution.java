package D;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Feel free to add any imports you need

public class Solution {
    public static void main(String[] args) throws Exception {
        byte[] input = new InputParser().getStdin();
        WAL wal = new WAL(input);
        System.out.println("Events:");
        System.out.println(String.join("\n", wal.getEvents()));
    }

    /**
     * Test class which wraps a raw binary WAL and reconstructs DML Events.
     */
    public static class WAL {
        private final ArrayList<String> eventsList;
        private final Map<Integer, String> IDToName = new HashMap<Integer, String>() {{
            put(0, "INSERT");
            put(1, "UPSERT");
            put(2, "DELETE");
        }};

        /**
         * Construct the WAL
         *
         * @param input the raw binary WAL
         */
        public WAL(byte[] input) {
            eventsList = new ArrayList<>();
            int i = 0;
            final int BYTE_ARRAY_LENGTH = input.length;
            while (i < BYTE_ARRAY_LENGTH) {
                StringBuilder sb = new StringBuilder();
                Long epochMilli = ByteBuffer.wrap(input, i, 8).getLong();
                String epochMilliString = String.valueOf(epochMilli);
                sb.append(epochMilliString).append("|");
                i += 8;

                int id = input[i] & 0xFF;
                String name = IDToName.get(id);
                sb.append(name).append("|");
                i += 1;

                Short keyLength = ByteBuffer.wrap(input, i, 2).getShort();
                i += 2;
                Charset charSet = StandardCharsets.US_ASCII;
                String key = new String(input, i, keyLength, charSet);
                sb.append(key);
                i += keyLength;

                if (name.equals("DELETE")) {

                } else {
                    Short valueLength = ByteBuffer.wrap(input, i, 2).getShort();
                    i += 2;
                    String value = new String(input, i, valueLength, charSet);
                    sb.append("|").append(value);
                    i += valueLength;
                }
                eventsList.add(sb.toString());
            }

        }

        /**
         * Retrieve all events contained within the WAL as their string values in time order
         * DML Event String Format: "<epoch_milli>|<message_name>|<key>|<value>"
         *
         * @return a time-ordered sequence of DML Event strings
         */
        public ArrayList<String> getEvents() {
            return eventsList;
        }
    }

    public static class InputParser {
        private byte[] hex2bytes(String hex) {
            int len = hex.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                        + Character.digit(hex.charAt(i + 1), 16));
            }
            return data;
        }

        public byte[] getStdin() {
            Scanner scanner = new Scanner(System.in);
            return hex2bytes(scanner.next().trim());
        }
    }
}