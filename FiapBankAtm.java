import java.util.Scanner;

public class FiapBankAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // pedir nome do cliente
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = scanner.nextLine().trim();
        String primeiroNome = nomeCompleto.split(" ")[0];
        System.out.println("Ola, " + primeiroNome + "! Bem-vindo(a) ao FIAP Bank!\n");

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

        // login do usuario
        System.out.println();
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

        // menu principal
        double saldo = 0.00;
        boolean menuAtivo = true;

        while (menuAtivo) {
            System.out.println("\n===== FIAP Bank =====");
            System.out.println("[ 1 ] Consultar Saldo");
            System.out.println("[ 2 ] Fazer Deposito");
            System.out.println("[ 3 ] Fazer Saque");
            System.out.println("[ 4 ] Sair");
            System.out.print("Escolha uma opcao: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                        break;
                    case 2:
                        System.out.print("Digite o valor do deposito: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        if (valorDeposito <= 0) {
                            System.out.println("Valor invalido! O deposito deve ser maior que zero.");
                        } else {
                            saldo += valorDeposito;
                            System.out.printf("Deposito de R$ %.2f realizado com sucesso!%n", valorDeposito);
                        }
                        break;
                    case 3:
                        System.out.print("Digite o valor do saque: R$ ");
                        double valorSaque = scanner.nextDouble();
                        if (valorSaque <= 0) {
                            System.out.println("Valor invalido! O saque deve ser maior que zero.");
                        } else if (valorSaque > saldo) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            saldo -= valorSaque;
                            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valorSaque);
                        }
                        break;
                    case 4:
                        System.out.println("O FIAP Bank agradece sua preferencia!");
                        menuAtivo = false;
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                        break;
                }
            } else {
                System.out.println("Opcao invalida! Tente novamente.");
                scanner.next(); // limpar entrada invalida
            }
        }

        scanner.close();
    }
}
