package br.qziul.dataStructure.exercicios;

import java.util.Set;
import java.util.Stack;

/*
    Verifica se uma expressão matemática é válida.
 */

public class BalanceamentoDeParanteses {
    public static boolean resolucaoExpressao(String expressao) {
        Set<Character> aberturaSimbolos = Set.of('(', '{', '[');
        Set<Character> fechamentoSimbolos = Set.of(')', '}', ']');

        //  Utiliza-se uma Pilha para resolução.
        Stack<Character> stack = new Stack<>();

        for(char simbolo : expressao.toCharArray()) {
            if(aberturaSimbolos.contains(simbolo))  stack.push(simbolo);

            if(fechamentoSimbolos.contains(simbolo)) {
                if(stack.isEmpty()) return false;

                char simboloAbertura = stack.pop();
                if(simboloAbertura == '(' && simbolo != ')') return false;
                if(simboloAbertura == '{' && simbolo != '}') return false;
                if(simboloAbertura == '[' && simbolo != ']') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(resolucaoExpressao("2*(3+4+5*[2+3)]"));
        System.out.println(resolucaoExpressao("[2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]"));
    }
}
