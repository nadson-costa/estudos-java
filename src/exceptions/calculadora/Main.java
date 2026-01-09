package exceptions.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double n1, n2, total = 0;
        String x;

        System.out.println("\n=== CALCULADORA ===");
        while(true){

            System.out.println("Digite o primeiro número: ");
            try{
                n1 = sc.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("-> ERRO: Digite apenas números!");
                sc.close();
                return;
            }

            System.out.println("Digite o segundo número: ");
            try{
                n2 = sc.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("-> ERRO: Digite apenas números!");
                sc.close();
                return;
            }

            sc.nextLine();
            System.out.println("Digite a operação: ");
            x = sc.nextLine();


            if(!x.equals("+") && !x.equals("*") &&
                    !x.equals("/") && !x.equals("-")) {
                System.out.println("-> Erro: Digite uma operação válida! (+, -, *, /)");
                sc.close();
                return;
            }

            if(x.equals("+")){
                total =  n1 + n2;
            }else if (x.equals("-")){
                total = n1 - n2;
            }else if(x.equals("/")){
                if(n2 == 0){
                    System.out.println("-> Erro: Não é possível dividir por 0!");
                    sc.close();
                    return;
                }
                total = n1 / n2;
            }else if(x.equals("*")){
                total = n1 * n2;
            }

            System.out.println("\n-> Resultado da operação: " + total + "\n");

            System.out.println("\nDeseja fazer outra operação?(S/N): ");
            String continuar = sc.nextLine();
            if(continuar.equalsIgnoreCase("N")){
                System.out.println("Até mais!");
                break;
            }

        }
        sc.close();


    }

}
