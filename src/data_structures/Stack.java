package data_structures;

import java.util.Scanner;
import java.util.Stack;

/*
 * O código verifica se uma sequência de parênteses, colchetes e chaves está balanceada usando uma pilha. 
 * Ele adiciona os símbolos de abertura à pilha e, ao encontrar símbolos de fechamento, 
 * verifica se correspondem ao topo da pilha, removendo-o se houver correspondência. 
 * Ao final, se a pilha estiver vazia, significa que todos os pares foram balanceados e o programa imprime true; 
 * caso contrário, imprime false.
 */

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            // Pilha para armazenar parênteses de abertura
            Stack<Character> s = new Stack<>();

            // Percorre cada caractere da string
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '{' || c == '(' || c == '[') { // Parênteses de abertura
                    s.push(c); // Adiciona à pilha
                }
                // Verifica se o caractere atual fecha corretamente o último aberto
                else if (s.size() != 0 &&
                        ((c == '}' && s.peek() == '{') ||
                                (c == ')' && s.peek() == '(') ||
                                (c == ']' && s.peek() == '['))) {
                    s.pop(); // Remove o par correspondente
                } else {
                    s.push(c); // Caracteres sem par, adicionados à pilha
                }
            }

            // Se a pilha está vazia, a string está balanceada
            if (s.size() == 0)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
