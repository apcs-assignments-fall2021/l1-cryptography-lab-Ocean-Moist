import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        key = generateKey(message, key);
        String cipher_text = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                int x = (message.charAt(i) + key.charAt(i)) % 26;
                x += 'A';
                cipher_text += (char) (x);
            }
            else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
                String keyl = key.toLowerCase();
                int x = (message.charAt(i) + keyl.charAt(i) + 14) % 26; // magic number ftw
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
        int j = -1; // lazy fix lol
        String keyf = "";
        for (char i : message.toCharArray()) {
            if (i >= 'A' && i <= 'Z' || i >= 'a' && i <= 'z') {
                j++;
                keyf += key.charAt(j % key.length());
            }
            else {
                keyf += (char) 0;
            }
        }
        return keyf;
    }

    public static String decryptVigenere(String message, String key) {
        String fin = "";
        String keyf = "";
        for (char i : key.toCharArray()) {
            keyf += (char) (-i - 16);
        }
        for (char i : encryptVigenere(message, keyf).toCharArray()) {
            if  (i >= 'a' && i <= 'z') {
                i += 6; //magic number
                i = (char) ((char) ((i - 'a') % 26) + 'a'); // I dont want to talk about it
            }
            fin += i;
        }
        return fin;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
