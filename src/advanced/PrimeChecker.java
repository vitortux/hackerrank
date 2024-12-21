package advanced;

import static java.lang.System.in; // Para contornar o problema do Buffered Reader

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/*
 * You are given a class Solution and its main method in the editor. Your task is to create a class Prime. 
 * The class Prime should contain a single method checkPrime. 
 * The locked code in the editor will call the checkPrime method with one or more integer arguments. 
 * You should write the checkPrime method in such a way that the code prints only the prime numbers.
 */
class Prime {
    void checkPrime(int... numbers) {
        for (int num : numbers) {
            if (num < 2) {
                continue; // Nenhum número menor do que 2 é primo
            }

            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                // Números primos não são divisíveis por nenhum outro número entre 2 e eles
                if ((num % i) == 0) {
                    isPrime = false;
                    break;
                }
            }

            // Imprime o núumero se ele for primo
            if (isPrime) {
                System.out.print(num + " ");
            }
        }

        System.out.println(); // Expected Output
    }
}

public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}