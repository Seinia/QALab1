import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class QALab2 {

    public static boolean checklines(String[] parts){
        String line = parts[0];
        try {
            int number = Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            System.out.printf("Рядок не може бути перетворений в ціле число: %s%n",line);
        }
        return false;
    }
    public static void main(String[] args) {
        HashMap<String,String> items = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\itemList.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\\t");
                if (checklines(parts)){
                    if (items.containsKey(parts[0])){
                        System.out.printf("Товар з кодом - %s вже існує%n",parts[0]);
                    } else if(items.containsValue(String.format("%s; Виробник - %s",parts[1],parts[2]))){
                        System.out.printf("Такий товар - %s від виробника %s вже існує%n",parts[1],parts[2]);
                    }
                    items.put(parts[0],String.format("%s; Виробник - %s",parts[1],parts[2]));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        for (HashMap.Entry<String, String> entry : items.entrySet()) {
            System.out.printf("Номер товару - %s; Товар - %s%n", entry.getKey(), entry.getValue());
        }
    }
}