package advanced;

import java.security.MessageDigest;
import java.util.Scanner;

public class Sha256 {

    public static void main(String[] args) throws Exception {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        // Cria uma instância para calcular o hash SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        Scanner scanner = new Scanner(System.in); // Lê a entrada do usuário

        // Adiciona os bytes da entrada ao algoritmo de hash
        md.update(scanner.nextLine().getBytes());

        // Calcula o hash e o imprime em formato hexadecimal
        for (byte b : md.digest())
            System.out.print(String.format("%02x", b));
    }
}