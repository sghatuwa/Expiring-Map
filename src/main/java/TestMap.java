import net.jodah.expiringmap.ExpiringMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Suresh Ghatuwa on 3/27/2018.
 */
public class TestMap {

    // Create Exipring Map called crunchifyMap with expiry time 5 seconds
    private static Map<String, Double> crunchifyMap = ExpiringMap.builder().expiration(5, TimeUnit.SECONDS).build();

    public static void main(String[] args) {
        {
            // Let's keep running loop for testing
            while (true) {
                try {
                    // Just wait for a second everytime
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Add Element to Map crunchifyMap
                addElement();

                // Print Element to Map crunchifyMap
                printElement();
            }
        }
    }

    private static void printElement() {

        log("crunchifyMap Size: "+crunchifyMap.keySet()+ " >>>> " + crunchifyMap.size() + "\n");
    }

    // NOTE: We are adding Unique Element to Map Every time.
    private static void addElement() {

        double randomValue = Math.random();

        // If the specified key is not already associated with a value (or is mapped to null) associates it with the
        // given value and returns null, else returns the current value.
        crunchifyMap.putIfAbsent("Crunchify " + randomValue, randomValue);

        log("+++++ Element added to crunchifyMap:" + randomValue);

    }

    private static void log(String string) {
        System.out.println(string);

    }
}
