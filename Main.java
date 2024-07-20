import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Monstro Bruxa = new Bruxa("Bruxa aquatica", 60, 30, 4, 7, 5, 2, 40);
        Monstro Grifo = new Grifo("Grifo", 70, 20, 7, 3, 6, 11, 5);
        Monstro Carnical = new Carnical("Carnical", 30, 40, 10, 3, 5, 11, 75);
        Monstro Afogador = new Afogador("Afogador", 60, 30, 5, 6, 5, 25, 20);
        Monstro Wyvern = new Wyvern("Wyvern", 80, 10, 8, 3, 5, 25, 60);
        Monstro Liche = new Liche("Liche", 200, 100, 15, 13, 12, 15, 40);
        ArrayList <Item> listaDeItens = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean perdeu = false;
        Personagem personagem;

        System.out.println("*** Criacao de Personagem ***");
        System.out.println("***  Escolha sua Classe   ***");
        System.out.println("*** 1 - Guerreiro ***");
        System.out.println("*** 2 - Bruxo     ***");
        System.out.println("*** 3 - Mago      ***");
        int escolha = sc.nextInt();
        sc.nextLine();
        
        if (escolha == 1){
            personagem = new Guerreiro(100, 30, 8, 2, 7, true);

        }else if (escolha == 2){
            personagem = new Bruxo(110, 40, 6, 5, 4, true);    

        }else {
            personagem = new Mago(80, 70, 3, 7, 5, true);
        }
        
        personagem.criacaoDePersonagem(sc);
        do {

            System.out.println();
            for (int i = 0; i < 30; i ++){
                for(int j = 0; j < 80; j ++){
                    if(Bruxa.getSaude() > 0 || Grifo.getSaude() > 0 || Carnical.getSaude() > 0 || Afogador.getSaude() > 0 || Wyvern.getSaude() > 0){

                        if(i == 0){
                            System.out.print(j -(10 *(j / 10)));
                        }else if (j == 0){
                            System.out.print(i -(10 *(i / 10)));

                        }else if(i == Bruxa.getX() && j == Bruxa.getY() && Bruxa.getSaude() > 0){
                            System.out.print("M");
                        }else if(i == Grifo.getX() && j == Grifo.getY() && Grifo.getSaude() > 0){
                            System.out.print("M");
                        }else if(i == Carnical.getX() && j == Carnical.getY() && Carnical.getSaude() > 0){
                            System.out.print("M");
                        }else if(i == Afogador.getX() && j == Afogador.getY() && Afogador.getSaude() > 0){
                            System.out.print("M");
                        }else if(i == Wyvern.getX() && j == Wyvern.getY() && Wyvern.getSaude() > 0){
                            System.out.print("M");
                        }else if (i == personagem.getX() & j == personagem.getY()){
                            System.out.print("P");
                        }else{
                            System.out.print(".");
                        }
                    }else {
                        
                        if(i == 0){
                            System.out.print(j -(10 *(j / 10)));
                        }else if (j == 0){
                            System.out.print(i -(10 *(i / 10)));

                        }else if(i == Liche.getX() && j == Liche.getY() && Liche.getSaude() > 0){
                            System.out.print("C");

                        }else if (i == personagem.getX() & j == personagem.getY()){
                            System.out.print("P");
                        }else{
                            System.out.print(".");
                        }
                    }
                }
                System.out.print("\n");
            }
            
            personagem.movimentar(sc);
            if(Bruxa.getSaude() > 0 || Grifo.getSaude() > 0 || Carnical.getSaude() > 0 || Afogador.getSaude() > 0 || Wyvern.getSaude() > 0){

                if (personagem.getX() == Bruxa.getX() && personagem.getY() == Bruxa.getY() && Bruxa.getSaude() > 0){
                    perdeu = personagem.combate(Bruxa, sc);
                }
                if (personagem.getX() == Grifo.getX() && personagem.getY() == Grifo.getY() && Grifo.getSaude() > 0){
                    perdeu = personagem.combate(Grifo, sc);
                }
                if (personagem.getX() == Carnical.getX() && personagem.getY() == Carnical.getY() && Carnical.getSaude() > 0){
                    perdeu = personagem.combate(Carnical, sc);
                }
                if (personagem.getX() == Afogador.getX() && personagem.getY() == Afogador.getY() && Afogador.getSaude() > 0){
                    perdeu = personagem.combate(Afogador, sc);
                }
                if (personagem.getX() == Wyvern.getX() && personagem.getY() == Wyvern.getY() && Wyvern.getSaude() > 0){
                    perdeu = personagem.combate(Wyvern, sc);
                }
            }else{
                if (personagem.getX() == Liche.getX() && personagem.getY() == Liche.getY() && Liche.getSaude() > 0){
                    perdeu = personagem.combate(Liche, sc);
                }
            }
        }while(perdeu == false && Liche.getSaude() >= 0);

        sc.close();

        if (Liche.getSaude() <= 0){
            System.out.println(" .--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--. \r\n" + //
                                "/ .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\\r\n" + //
                                "\\ \\/\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ \\/ /\r\n" + //
                                " \\/ /`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\/ / \r\n" + //
                                " / /\\                                                                        / /\\ \r\n" + //
                                "/ /\\ \\   █████   █████                                                      / /\\ \\\r\n" + //
                                "\\ \\/ /  ░░███   ░░███                                                       \\ \\/ /\r\n" + //
                                " \\/ /    ░███    ░███   ██████   ██████   ██████      ██████                 \\/ / \r\n" + //
                                " / /\\    ░███    ░███  ███░░███ ███░░███ ███░░███    ███░░███                / /\\ \r\n" + //
                                "/ /\\ \\   ░░███   ███  ░███ ░███░███ ░░░ ░███████    ░███████                / /\\ \\\r\n" + //
                                "\\ \\/ /    ░░░█████░   ░███ ░███░███  ███░███░░░     ░███░░░                 \\ \\/ /\r\n" + //
                                " \\/ /       ░░███     ░░██████ ░░██████ ░░██████    ░░██████                 \\/ / \r\n" + //
                                " / /\\        ░░░       ░░░░░░   ░░░░░░   ░░░░░░      ░░░░░░                  / /\\ \r\n" + //
                                "/ /\\ \\                                                                      / /\\ \\\r\n" + //
                                "\\ \\/ /                                                                      \\ \\/ /\r\n" + //
                                " \\/ /                                                                        \\/ / \r\n" + //
                                " / /\\            █████                                      █████            / /\\ \r\n" + //
                                "/ /\\ \\          ░░███                                      ░░███            / /\\ \\\r\n" + //
                                "\\ \\/ /    █████  ░███████    ██████  █████ ███ █████     ███████   ██████   \\ \\/ /\r\n" + //
                                " \\/ /    ███░░   ░███░░███  ███░░███░░███ ░███░░███     ███░░███  ███░░███   \\/ / \r\n" + //
                                " / /\\   ░░█████  ░███ ░███ ░███ ░███ ░███ ░███ ░███    ░███ ░███ ░███████    / /\\ \r\n" + //
                                "/ /\\ \\   ░░░░███ ░███ ░███ ░███ ░███ ░░███████████     ░███ ░███ ░███░░░    / /\\ \\\r\n" + //
                                "\\ \\/ /   ██████  ████ █████░░██████   ░░████░████      ░░████████░░██████   \\ \\/ /\r\n" + //
                                " \\/ /   ░░░░░░  ░░░░ ░░░░░  ░░░░░░     ░░░░ ░░░░        ░░░░░░░░  ░░░░░░     \\/ / \r\n" + //
                                " / /\\                                                                        / /\\ \r\n" + //
                                "/ /\\ \\                                                                      / /\\ \\\r\n" + //
                                "\\ \\/ /                                                                      \\ \\/ /\r\n" + //
                                " \\/ /    ███████████           ████                                          \\/ / \r\n" + //
                                " / /\\   ░░███░░░░░███         ░░███                                          / /\\ \r\n" + //
                                "/ /\\ \\   ░███    ░███  ██████  ░███   ██████                                / /\\ \\\r\n" + //
                                "\\ \\/ /   ░██████████  ███░░███ ░███  ░░░░░███                               \\ \\/ /\r\n" + //
                                " \\/ /    ░███░░░░░███░███ ░███ ░███   ███████                                \\/ / \r\n" + //
                                " / /\\    ░███    ░███░███ ░███ ░███  ███░░███                                / /\\ \r\n" + //
                                "/ /\\ \\   ███████████ ░░██████  █████░░████████                              / /\\ \\\r\n" + //
                                "\\ \\/ /  ░░░░░░░░░░░   ░░░░░░  ░░░░░  ░░░░░░░░                               \\ \\/ /\r\n" + //
                                " \\/ /                                                                        \\/ / \r\n" + //
                                " / /\\.--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--./ /\\ \r\n" + //
                                "/ /\\ \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\/\\ \\\r\n" + //
                                "\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /\r\n" + //
                                " `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--' ");
        }
    }
}