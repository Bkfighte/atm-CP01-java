import java.util.Scanner;

public class FiapBankAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir nome do cliente
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = scanner.nextLine().trim();
        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Ola, " + primeiroNome + "! Bem-vindo(a) ao FIAP Bank!");

        // cadastro de senha
        String senhaForte = "";
        boolean senhaValida = false;

        while (!senhaValida) {
            System.out.print("Crie uma senha forte: ");
            senhaForte = scanner.nextLine();

            if (senhaForte.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-_+=?><]).{8,}$")) {
                senhaValida = true;
                System.out.println("Senha cadastrada com sucesso!");
            } else {
                System.out.println("Senha fraca! A senha deve ter no minimo 8 caracteres, uma letra maiuscula, um numero e um caractere especial.");
            }
        }

        // login
        int tentativasLogin = 0;
        boolean loginOk = false;

        while (tentativasLogin < 3) {
            System.out.print("Digite sua senha para entrar: ");
            String senhaDigitada = scanner.nextLine();

            if (senhaDigitada.equals(senhaForte)) {
                loginOk = true;
                System.out.println("Login realizado com sucesso!");
                break;
            } else {
                tentativasLogin++;
                int restantes = 3 - tentativasLogin;
                if (restantes > 0) {
                    System.out.println("Senha incorreta! Voce tem " + restantes + " tentativa(s) restante(s).");
                }
            }
        }

        if (!loginOk) {
            System.out.println("ACESSO BLOQUEADO");
            scanner.close();
            System.exit(0);
        }

        scanner.close();
    }
}
