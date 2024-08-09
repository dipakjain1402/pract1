import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ise {
    public static void main(String[] args) {
        int vowels = 0, consonants = 0, characters = 0;

        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                characters += line.length();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                        vowels++;
                    } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                        consonants++;
                    }
                }
            }
            sc.close();

            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + consonants);
            System.out.println("Characters: " + characters);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
