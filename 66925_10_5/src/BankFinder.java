import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwsze trzy cyfry numeru konta: ");
        String accountPrefix = scanner.nextLine();

        if (accountPrefix.length() != 3 || !accountPrefix.matches("\\d{3}")) {
            System.out.println("Nieprawidłowy format");
            return;
        }

        try {
            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String regex = "(\\d{3})\\s+(.+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    String bankCode = matcher.group(1);
                    String bankName = matcher.group(2);

                    if (bankCode.equals(accountPrefix)) {
                        System.out.println(accountPrefix + bankName);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Nie znaleziono banku dla podanych trzech cyfr konta.");
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas wczytywania danych: " + e.getMessage());
        }
    }
}