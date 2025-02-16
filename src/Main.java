public class Main {
    public static void main(String[] args) {

        String line_1 = "aaabbacccc";
        String line_2 = "abc";
        String line_3 = "";

        String result = compress(line_1);

        System.out.println(result);

        result = decompress(result);

        System.out.println(result);
    }
    public static String compress(String line){
        int k = 1; // number of times character repeats consecutively
        StringBuilder result = new StringBuilder();
        line += " ";
        Character previous = line.charAt(0);

        if (line.length() == 1) return "";    // if given line is empty

        for (int i = 1; i < line.length(); i++) {
            if (previous.equals(line.charAt(i))) {
                k++;   // counting repeats if previous character is the same as current
            }
            else {
                result.append(previous).append(k);
                k = 1;
                previous = line.charAt(i);
            }
        }
        return result.toString();
    }
    public static String decompress(String line){
        StringBuilder result = new StringBuilder();

        if(line.isEmpty()) return "";    // if given line is empty

        for(int i = 0; i < line.length(); i+=2){
            Character character = line.charAt(i);                // character to repeat
            int k = Integer.parseInt(line.substring(i+1, i+2));  // number of times to repeat a character

            result.append(String.valueOf(character).repeat(k));
        }

        return result.toString();
    }
}