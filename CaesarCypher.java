import java.util.Scanner;

public class CaesarCypher {
    public static void main(String[] args){
        String userInput;
        int count=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type E to encrypt and D to decrypt a message.");
        userInput = scanner.nextLine();
        
        while(!userInput.equals("E") && !userInput.equals("D")){
            count++;
            System.out.println("Please only type the letter E or D");
            userInput = scanner.nextLine();
            if(count==5){
                scanner.close();
                System.out.println("Nope, bye.");
                return;
            }
        }

        if(userInput.equals("E")){
            System.out.println("What message do you wish to encrypt?");
            String message = scanner.nextLine();

            int shift=0;
            System.out.println("What shift was used to encrypt this message?");
            while (true) {
                try {
                    shift = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer for the shift value.");
                }
            }

            System.out.println(encrypt(message, shift));

        }else{
            System.out.println("What message do you wish to decrypt?");
            String message = scanner.nextLine();

            int shift=0;
            System.out.println("What shift was used to encrypt this message?");
            while (true) {
                try {
                    shift = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer for the shift value.");
                }
            }
            System.out.println(decrypt(message,shift));
        }

        scanner.close();

        return;
    }

    private static String encrypt(String messageToEncrypt, int shift){
        char[] charsOfWord = messageToEncrypt.toUpperCase().toCharArray();
        for(int i=0; i<charsOfWord.length; i++){
            if(charsOfWord[i]>='A' && charsOfWord[i]<='Z'){
                charsOfWord[i] = (char) ((charsOfWord[i] - 'A'+ shift)%26+'A');
            }
        }
    
        String encryptedMessage = new String(charsOfWord);
        return encryptedMessage;
    }

    private static String decrypt(String messagetoDecrypt, int shift){
        return encrypt(messagetoDecrypt, -shift);
    }
}
