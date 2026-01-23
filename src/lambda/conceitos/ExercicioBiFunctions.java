package lambda.conceitos;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class ExercicioBiFunctions {
    public static void main(String[] args){

        BiFunction<Integer, Integer, Integer> somar = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> multiplicar = (a, b) -> a * b;
        BiFunction<String, String, String> concatenar = (s1, s2) -> s1 + s2;
        BiFunction<String, String, String> nomeCompleto = (s1, s2) -> s1 + " " + s2;
        BiFunction<Double, Double, Double> potencia = (base, exp) -> Math.pow(base, exp);

        BiPredicate<Integer, Integer> maiorQue = (a, b) -> a > b;
        BiPredicate<String, String> iguaisIgnoreCase = (s1, s2) -> s1.equalsIgnoreCase(s2);
        BiPredicate<Integer, Integer> somaEhPar = (a, b) -> (a + b) % 2 == 0;


        System.out.println("=== TESTES BiFunction ===\n");

        System.out.println("10 + 5 = " + somar.apply(10, 5));
        System.out.println("7 + 3 = " + somar.apply(7, 3));

        System.out.println();

        System.out.println("10 * 5 = " + multiplicar.apply(10, 5));
        System.out.println("7 * 3 = " + multiplicar.apply(7, 3));

        System.out.println();

        System.out.println(concatenar.apply("Java", " é incrível!"));
        System.out.println(concatenar.apply("Lambda", " Expressions"));

        System.out.println();

        System.out.println(nomeCompleto.apply("João", "Silva"));
        System.out.println(nomeCompleto.apply("Maria", "Santos"));

        System.out.println();

        System.out.println("2^3 = " + potencia.apply(2.0, 3.0));
        System.out.println("5^2 = " + potencia.apply(5.0, 2.0));

        System.out.println("\n=== TESTES BiPredicate ===\n");

        System.out.println("10 > 5? " + maiorQue.test(10, 5));
        System.out.println("3 > 7? " + maiorQue.test(3, 7));

        System.out.println();

        System.out.println("'Java' == 'JAVA'? " + iguaisIgnoreCase.test("Java", "JAVA"));
        System.out.println("'Java' == 'Python'? " + iguaisIgnoreCase.test("Java", "Python"));

        System.out.println();

        System.out.println("10 + 5 é par? " + somaEhPar.test(10, 5));
        System.out.println("7 + 3 é par? " + somaEhPar.test(7, 3));
        System.out.println("5 + 4 é par? " + somaEhPar.test(5, 4));
    }
}