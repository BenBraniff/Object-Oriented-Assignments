import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        String fileName = "words.txt";
        
        // this code creates the count file, once created we dont know need to run the code anymore

        // String[] words = {"Hello","world","java"};
        // Random random = new Random();
        // int numOfLines = 100;
        // try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName)) ) {
        //     for(int i =0; i < numOfLines; i++) {
        //         bufferedWriter.write(words[random.nextInt(words.length)] + "\n");
        //     }
        // } 

        String line;
        Map<String, Integer> counts = new TreeMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while((line = bufferedReader.readLine()) != null) {
                line = line.toLowerCase();
                if(counts.containsKey(line)) {
                    counts.put(line, counts.get(line) + 1);
                } else {
                    counts.put(line, 1);
                }
            }
        }
    
        String fileOutName = "count.txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutName))) {
            for(Entry<String, Integer> entry: counts.entrySet()) {
                bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }
    }
}
