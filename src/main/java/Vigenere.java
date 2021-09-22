import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        key = generateKey(message, key);
        String cipher_text="";
        System.out.println(key);
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                int x = (message.charAt(i) + key.charAt(i)) % 26;
                x += 'A';
                cipher_text += (char) (x);
            }
            else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
                int x = (message.charAt(i) + Character.toLowerCase(key.charAt(i)) % 26);
                x += 'a';
                cipher_text += (char) (x);
            }
            else {
                cipher_text += message.charAt(i);
            }
        }
        return cipher_text;
    }
    public static String generateKey(String message, String key) {
        int x = key.length();
        int j = 0;
        String keyf = "";
        for (int i = 0; keyf.length() == message.length(); i++) {
            j++;
            System.out.println(j);
            if (message.charAt(j) >= 'A' && message.charAt(j) <= 'Z' || message.charAt(j) >= 'a' && message.charAt(j) <= 'z') {
                if (x == i) {
                    i = 0;
                }
                keyf += (key.charAt(i));
            }
            else {
                keyf += (char) 0;
            }
        }
        return keyf;
//        int x = key.length();
//        int j = 0;
//        String keyf = "";
//        for (char i : message.toCharArray()) {
//            if ( i >= 'A' && i <= 'Z' || i >= 'a' && i <= 'z') {
//               j++;
//               keyf += key.charAt(j % x);
//            }
//            else {
//                keyf += (char) 0;
//            }
//        }
//        return keyf;
    }

    public static String decryptVigenere(String message, String key) {
        return message;
        // REPLACE THIS WITH YOUR CODE
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(generateKey("I hAte", "BBC"));
//        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
//        String command = scan.nextLine().trim().toLowerCase();
//
//        if (command.equals("encrypt")) {
//            System.out.println("Please enter your message to be encrypted: ");
//            String message = scan.nextLine();
//            System.out.println("Please enter the key for your message: ");
//            String key = scan.nextLine().trim().toUpperCase();
//            System.out.println("Here is your encrypted message: ");
//            System.out.println(encryptVigenere(message, key));
//        }
//        else if (command.equals("decrypt")) {
//            System.out.println("Please enter your message to be decrypted: ");
//            String message = scan.nextLine();
//            System.out.println("Please enter the key for your message: ");
//            String key = scan.nextLine().trim().toUpperCase();
//            System.out.println("Here is your decrypted message: ");
//            System.out.println(decryptVigenere(message, key));
//        }
//        else {
//            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
//        }

        scan.close();
    }
}
