import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

//Ben Braniff

public class passValidate {    
    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.out.println("Please try again and input a valid password");
            System.exit(1);
        } 
        String password = args[0];
        System.out.println("your pass: " + password);
        int len = password.length();
        if (len < 8 || len > 16) {
            System.out.println("Please try again and input a valid password between 8 and 16");
            System.exit(1);
        }

        TreeSet<Character> upperCaseLetters = new TreeSet<>();
        TreeSet<Character> lowerCaseLetters = new TreeSet<>();
        TreeSet<Character> numbers = new TreeSet<>();
        TreeSet<Character> specialSymbols = new TreeSet<>();

        Map<String, Integer> count = new TreeMap<>();

        for ( int i = (int)'A'; i <= (int)'Z'; i++) {
            Character c = (char) i;
            upperCaseLetters.add(c);
            lowerCaseLetters.add(Character.toLowerCase(c));
        }
        for ( int i = (int)'0'; i <= (int)'9'; i++) {
            Character c = (char) i;
            numbers.add(c);
        }

        String str = "~!@#$%^&*()-=+_";
        for (Character c: str.toCharArray()) {
            specialSymbols.add(c);
        }

        for (Character c: password.toCharArray()) {
            String key = "lowerCaseLetters";
            if (lowerCaseLetters.contains(c)) {
                if(count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);

                }else {
                    count.put(key, 1);
                }
            }
            key = "upperCaseLetters";
            if (upperCaseLetters.contains(c)) {
                if(count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);

                }else {
                    count.put(key, 1);
                }
            }
            key = "numbers";
            if (numbers.contains(c)) {
                if(count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);

                }else {
                    count.put(key, 1);
                }
            }
            key = "specialSymbols";
            if (specialSymbols.contains(c)) {
                if(count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);

                }else {
                    count.put(key, 1);
                }
            }
        }



        for (java.util.Map.Entry<String, Integer> entry: count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        if(count.size() < 3) {
            System.out.println("Please try again and input a valid password with atleast 3 different combination of categories");
            System.exit(1);
        }

        System.out.println("Great job, your password is good");
    }
}
