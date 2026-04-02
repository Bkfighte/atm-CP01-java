import java.util.Scanner;

public class FiapBankAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir nome do cliente
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = scanner.nextLine().trim();
        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Ola, " + primeiroNome + "! Bem-vindo(a) ao FIAP Bank!");

        scanner.close();
    }
}
