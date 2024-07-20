import java.util.ArrayList;
import java.util.Scanner;

public class Guerreiro extends Personagem{
    private String nome;
    private int saude;
    private int energia;
    private int forca;
    private int habilidade;
    private int defesa;
    private int defesaAux;
    private int x;
    private int y;
    private boolean meuTurno;
    private ArrayList <Item> listaDeItens = new ArrayList<>();
    private ArrayList <Item> itensEquipados = new ArrayList<>();

    public Guerreiro(int saude, int energia, int forca, int habilidade, int defesa, boolean meuTurno) {
        this.saude = saude;
        this.energia = energia;
        this.forca = forca;
        this.habilidade = habilidade;
        this.defesa = defesa;
        this.defesaAux = defesa;
        this.meuTurno = meuTurno;
    }
  
    public String getNome() {
        return nome;
    }
    public int getSaude() {
        return saude;
    }
    public void setSaude(int saude) {
        this.saude = saude;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public int getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public void setDefesaAux(int defesa) {
        this.defesaAux= defesa;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setMeuTurno(boolean meuTurno) {
        this.meuTurno = meuTurno;
    }
    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }
    @Override
    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }
    public ArrayList<Item> getItensEquipados() {
        return itensEquipados;
    }
    @Override
    public void setItensEquipados(ArrayList<Item> itensEquipados) {
        this.itensEquipados = itensEquipados;
    }

    public int mostraItens(Scanner sc){
        int itemEscolhido = 0;

        System.out.println("*** Lista de itens possuidos pelo personagem                 ***");
        System.out.println("*** Selecione o item desejado ou pressione '0' para cancelar ***");

        for(int i = 0; i < this.listaDeItens.size(); i++){
            System.out.print((i + 1) + ") " + this.listaDeItens.get(i).getNome() + " - " + this.listaDeItens.get(i).getDescricao() + " - ");
            
            if(this.listaDeItens.get(i).getCategoria() == 1){
                System.out.println("Arma");

            }else if(this.listaDeItens.get(i).getCategoria() == 2){
                System.out.println("Armadura");
            
            }else if(this.listaDeItens.get(i).getCategoria() == 3){
                System.out.println("Pocao");

            }
        }

        itemEscolhido = sc.nextInt();
        sc.nextLine();

        if (itemEscolhido < 0 || itemEscolhido > this.listaDeItens.size()) {
            System.out.println("*** Índice inválido. ***");
            return -1;
        } else if (itemEscolhido == 0) {
            System.out.println("*** Nenhum item escolhido ***\n");
            return -1;
        } else {
            return itemEscolhido - 1;
        }
    }


    public void criacaoDePersonagem(Scanner sc){
        String atribuiPonto; 
        String nome = ""; 
        int saude = this.saude;
        int energia = this.energia;
        int forca = this.forca;
        int habilidade = this.habilidade;
        int defesa = this.defesa;
        int pontos = 0;
        int itemEscolhido = 0;

        System.out.println("*** Escolha o nome de seu personagem ***");
        nome = sc.nextLine();
        System.out.println("\n*** Atributos de personagem: ***");
        System.out.println("--Nome......: " + nome);
        System.out.println("--Saude.....: " + saude);
        System.out.println("--Energia...: " + energia);
        System.out.println("--Forca.....: " + forca);
        System.out.println("--Habilidade: " + habilidade);
        System.out.println("--Defesa....: " + defesa);
        System.out.println();
        System.out.println("*** Voce tem 5 pontos para distribuir entre os atributos, escolha com sabedoria.               ***");
        System.out.println("*** Para adicionar ou remover um ponto a um atributo digite a operacao '+' aumenta '-' diminui ***");
        System.out.println("*** a inicial do atributo em maiusculo mais a quantidade de pontos                             ***");
        System.out.println("*** Ex: + S 2 == +2 pontos em saude. - S 2 == -2 pontos em saude                               ***");
        System.out.println("*** Quando estiver satisfeito digite 'start'                                                   ***");

        do{ 
            atribuiPonto = sc.nextLine();
            if (atribuiPonto.length() <= 4 ){
                System.out.println("^^^^ Estao faltando parametros ^^^^");
            
            }else if (atribuiPonto.substring(0,1).equals("+") ){
                pontos += Integer.parseInt(atribuiPonto.substring(4));
                if(pontos > 5){
                    pontos -= Integer.parseInt(atribuiPonto.substring(4));
                    System.out.println("^^^^ Quantidade de pontos não deve passsar de 5 ^^^^");
                }else{

                    if (atribuiPonto.substring(2,3).equals("S") ){
                        saude = saude + (Integer.parseInt(atribuiPonto.substring(4)) * 10);
                
                    }else if (atribuiPonto.substring(2,3).equals("E") ){
                        energia = energia + (Integer.parseInt(atribuiPonto.substring(4))* 10);
    
                    }else if (atribuiPonto.substring(2,3).equals("F") ){
                        forca = forca + (Integer.parseInt(atribuiPonto.substring(4)));
    
                    }else if (atribuiPonto.substring(2,3).equals("H") ){
                        habilidade = habilidade + (Integer.parseInt(atribuiPonto.substring(4)));
    
                    }else if (atribuiPonto.substring(2,3).equals("D") ){
                        defesa = defesa + (Integer.parseInt(atribuiPonto.substring(4)));
    
                    }
                }

            }else if (atribuiPonto.substring(0,1).equals("-") ){

                if (atribuiPonto.substring(2,3).equals("S") ){
                    saude = saude - (Integer.parseInt(atribuiPonto.substring(4)) * 10);
                    if(saude < 0){
                        saude = saude + (Integer.parseInt(atribuiPonto.substring(4)) * 10);
                        System.out.println("^^^^ Quantidade de pontos removido da vida deve ser menor que: " + (saude / 10) + " ^^^^");
                    }else{
                        pontos -= Integer.parseInt(atribuiPonto.substring(4, 5));
                    }
            
                }else if (atribuiPonto.substring(2,3).equals("E") ){
                    energia = energia - (Integer.parseInt(atribuiPonto.substring(4)) * 10);
                    if(energia < 0){
                        energia = energia + (Integer.parseInt(atribuiPonto.substring(4)) * 10);
                        System.out.println("^^^^ Quantidade de pontos removido da energia deve ser menor que: " + (energia / 10) + " ^^^^");
                    }else{
                        pontos -= Integer.parseInt(atribuiPonto.substring(4, 5));
                    }

                }else if (atribuiPonto.substring(2,3).equals("F") ){
                    forca = forca - (Integer.parseInt(atribuiPonto.substring(4)));                    
                    if(forca < 0){
                        forca = forca + (Integer.parseInt(atribuiPonto.substring(4)));
                        System.out.println("^^^^ Quantidade de pontos removido da forca deve ser menor que: " + (forca) + " ^^^^");
                    }else{
                        pontos -= Integer.parseInt(atribuiPonto.substring(4, 5));
                    }

                }else if (atribuiPonto.substring(2,3).equals("H") ){
                    habilidade = habilidade - (Integer.parseInt(atribuiPonto.substring(4)));
                    if(habilidade < 0){
                        habilidade = habilidade + (Integer.parseInt(atribuiPonto.substring(4)));
                        System.out.println("Quantidade de pontos removido da habilidade deve ser menor que: " + (habilidade));
                    }else{
                        pontos -= Integer.parseInt(atribuiPonto.substring(4, 5));
                    }

                }else if (atribuiPonto.substring(2,3).equals("D") ){
                    defesa = defesa - (Integer.parseInt(atribuiPonto.substring(4)));
                    if(defesa < 0){
                        defesa = defesa + (Integer.parseInt(atribuiPonto.substring(4)));
                        System.out.println("^^^^ Quantidade de pontos removido da defesa deve ser menor que: " + (defesa) + " ^^^^");
                    }else{
                        pontos -= Integer.parseInt(atribuiPonto.substring(4, 5));
                    }
                }
            }

            System.out.println("\n*** Atributos de personagem: ***");
            System.out.println("--Nome......: " + nome);
            System.out.println("--Saude.....: " + saude);
            System.out.println("--Energia...: " + energia);
            System.out.println("--Forca.....: " + forca);
            System.out.println("--Habilidade: " + habilidade);
            System.out.println("--Defesa....: " + defesa);
            System.out.println("*** Pontos restantes: " + (5 - pontos) + " ***\n");

        }while(!atribuiPonto.equals("start"));

        Pocao pocaoCura = new Pocao(1, "Pocao de cura", "Restaura sua saude em 50 pts", 3, 1, 50);
        Arma espadaCurta = new Arma(2, "Espada enferrujada", "Aumenta o dano que voce causa nos inimigos", 1, 1, 3);
        Armadura armaduraCouro = new Armadura(3, "Armadura de Couro", "Aumenta a sua Defesa", 2, 3);
        ArrayList <Item> itemInicial = new ArrayList<>();
        itemInicial.add(pocaoCura);
        itemInicial.add(espadaCurta);
        itemInicial.add(armaduraCouro);


        for (int i = 0; i < itemInicial.size(); i++){
            System.out.println("*** " + itemInicial.get(i).getNome() + " adicionado ao seu inventario ***");   
            
            if(itemInicial.get(i).getCategoria() != 3){
                itemInicial.get(i).usarItem(this);
                this.getItensEquipados().add(itemInicial.get(i));
            }else{
                this.getListaDeItens().add(itemInicial.get(i));
            }
        }

        salvarPersonagem(nome, saude, energia, forca, habilidade, defesa, sc);
    }

    public void salvarPersonagem(String nome, int saude, int energia, int forca, int habilidade, int defesa, Scanner sc){
        this.nome = nome;
        this.saude = saude;
        this.energia = energia;
        this.forca = forca;
        this.habilidade = habilidade;
        this.defesa = defesa;
        this.x = 15;
        this.y = 40;
        
        System.out.println("\n**** Este é o mapa do Jogo                                 ****");
        System.out.println("**** 'P' representa seu personagem                         ****");
        System.out.println("**** 'M' representam os monstros                           ****");
        System.out.println("**** '.' representa um terreno vazio                       ****");
        System.out.println("**** Derrote todos os Monstros para enfrentar o chefão 'C' ****");
        System.out.println("**** Derrote o Chefão para vencer                          ****");
        System.out.println("**** Pressione 'Enter' para continuar                      ****");
        sc.nextLine();

    }


    public void atacar(Monstro monstro){
        int forca  = this.forca * 3;
        int defesa = monstro.getDefesa();
        int danoSofrido = forca - defesa;

        if (danoSofrido > 0){
            monstro.setSaude(monstro.getSaude() - danoSofrido);
            
            System.out.println("\n*** Voce Desferiu um ataque ***");
            System.out.println("Status do Monstro: " + monstro.getNome());
            System.out.println("~~Saude.....: " + monstro.getSaude());
            System.out.println("~~Energia...: " + monstro.getEnergia());
            System.out.println("~~Forca.....: " + monstro.getForca());
            System.out.println("~~Habilidade: " + monstro.getHabilidade());
            System.out.println("~~Defesa....: " + monstro.getDefesa());
        }
    }


    public void usarHabilidade(Monstro monstro, Scanner sc){
        int forca;
        int defesa = monstro.getDefesa();
        int danoSofrido = 0;
        int habilidade;
        
        System.out.println("***                           Escolha a habilidade ou aperte zero pra voltar                           ***");
        System.out.println("*** 1) Grito de Guerra - Aumenta todos seus atributos em 2 pontos e cura 20 de vida - Custa 20 energia ***");
        System.out.println("*** 2) Investida       - Faz uma investida que causa dano e atordoa o inimigo       - Custa 10 energia ***");
        System.out.println("*** 3) Ataque Duplo    - Ataque em dobro, dano em dobro                             - Custa 20 energia ***");
        habilidade = sc.nextInt();
        sc.nextLine();

        // monstro.setSaude(monstro.getSaude() - danoSofrido);
        switch (habilidade) {
            case 1:
                if(this.energia - 20 > 0){
                    this.saude += 20;
                    this.defesa += 2;
                    this.forca += 2;
                    this.habilidade += 2;
                    this.energia -= 20;
                    this.meuTurno = false;
                    break;

                }else {
                    System.out.println("\n*** Não possui energia suficiente para usar habilidade ***");
                    this.usarHabilidade(monstro, sc);
                }
            case 2:
                if(this.energia - 10 >= 0){
                    forca = this.habilidade * 5;
                    danoSofrido = forca;

                    if(danoSofrido > 0){
                        monstro.setSaude(monstro.getSaude() - danoSofrido);
                    }
                    this.energia -= 10;
                    this.meuTurno = true;
                    break;

                }else {
                    System.out.println("\n*** Não possui energia suficiente para usar habilidade ***");
                    this.usarHabilidade(monstro, sc);
                }
            case 3:
                if(this.energia - 20 >= 0){

                    forca = this.forca * 5;
                    danoSofrido = forca - defesa;
                    if(danoSofrido > 0){
                        monstro.setSaude(monstro.getSaude() - danoSofrido);
                    }
                    this.energia -= 20;
                    this.meuTurno = true;
                    break;

                }else {
                    System.out.println("\n*** Não possui energia suficiente para usar habilidade ***");
                    this.usarHabilidade(monstro, sc);
                }
            default:
                this.acoesDeCombate(monstro, sc);
                break;
        }

     
        if (danoSofrido > 0){
            System.out.println("\n*** Voce Desferiu um ataque ***");
            System.out.println("Status do Monstro: " + monstro.getNome());
            System.out.println("~~Saude.....: " + monstro.getSaude());
            System.out.println("~~Energia...: " + monstro.getEnergia());
            System.out.println("~~Forca.....: " + monstro.getForca());
            System.out.println("~~Habilidade: " + monstro.getHabilidade());
            System.out.println("~~Defesa....: " + monstro.getDefesa());
        }
    }
    
    
    public void acoesDeCombate(Monstro monstro, Scanner sc){
        int acao = 0;
        int item = 0;
        System.out.println("Escolha um acao: ");
        System.out.println("1 - Atacar          2 - Habilidades          3 - Defender          4 - Escolher item");

        acao = sc.nextInt();
        sc.nextLine();
        this.defesa = this.defesaAux;

        if (acao == 1){
            this.atacar(monstro);
            this.meuTurno = false;

        }else if (acao == 2){
            this.usarHabilidade(monstro, sc);

        }else if (acao == 3){
            this.defesa = this.defesa * 2;
            this.meuTurno = false;

        }else if (acao == 4){
            item = this.mostraItens(sc);
            if(item >= 0){
                if (this.getListaDeItens().get(item).getCategoria() != 3){
                    this.meuTurno = true;

                }else {
                    this.meuTurno = false;

                }
                this.getListaDeItens().get(item).usarItem(this);

            }else{
                this.acoesDeCombate(monstro, sc);
            }
        }

    }


    public boolean combate(Monstro monstro, Scanner sc){
        System.out.println("*** Voce encontrou o monstro " + monstro.getNome() + " entrando em combate ***");
        System.out.println("Informacoes do " + monstro.getNome());
        System.out.println("~~Saude.....: " + monstro.getSaude());
        System.out.println("~~Energia...: " + monstro.getEnergia());
        System.out.println("~~Forca.....: " + monstro.getForca());
        System.out.println("~~Habilidade: " + monstro.getHabilidade());
        System.out.println("~~Defesa....: " + monstro.getDefesa());

        do{
            if(this.meuTurno == true){
                this.acoesDeCombate(monstro, sc); 
            }else{
                if(monstro.getSaude() > 0){
                    monstro.atacar(this);
                }
            }

        }while(monstro.getSaude() > 0 && this.saude > 0);

        if (this.saude <= 0){
            System.out.println("*** Voce Morreu***");
            return true;
            
        } else{
            this.meuTurno = true;
            System.out.println("\n*** Voce Derrotou o " + monstro.getNome() + " ***");
            monstro.drop(this);
            System.out.println("*** Pressione 'enter' para continuar ***");
            sc.nextLine();
            return false;
        }
    }


    public void movimentar(Scanner sc){
        String movimento;

        System.out.println("*** Para se Mover selecione uma direcao e escolha a quantidade de casas ***");
        System.out.println("***   N   ***");
        System.out.println("*** O + L ***");
        System.out.println("***   S   ***");
        System.out.println("*** Ex: S 5 para mover 5 casas ao sul ***");

        movimento = sc.nextLine();

        if (movimento.length() <= 2){
            System.out.println("^^^^ Estao faltando parametros ^^^^");
            this.movimentar(sc);

        } else{
            if (movimento.substring(0,1).equals("S") ){
                if (this.x + Integer.parseInt(movimento.substring(2)) >= 30){
                    System.out.println("^^^^ Andar essa quantidade te fara cair pra fora do mapa ^^^^");
                    sc.nextLine();
                
                }else{
                    this.x = this.x + Integer.parseInt(movimento.substring(2));
                }
            
            }else if (movimento.substring(0,1).equals("N") ){
                if (this.x - Integer.parseInt(movimento.substring(2)) <= 0){
                    System.out.println("^^^^ Andar essa quantidade te fara cair pra fora do mapa ^^^^");
                    sc.nextLine();
                
                }else{
                    this.x = this.x - Integer.parseInt(movimento.substring(2));
                }

            }else if (movimento.substring(0,1).equals("L") ){
                if (this.y + Integer.parseInt(movimento.substring(2)) >= 80){
                    System.out.println("^^^^ Andar essa quantidade te fara cair pra fora do mapa ^^^^");
                    sc.nextLine();
                
                }else{
                    this.y = this.y + Integer.parseInt(movimento.substring(2));
                }
                
            }else if (movimento.substring(0,1).equals("O") ){
                if (this.y - Integer.parseInt(movimento.substring(2)) <= 0){
                    System.out.println("^^^^ Andar essa quantidade te fara cair pra fora do mapa ^^^^");
                    sc.nextLine();

                }else{
                    this.y = this.y - Integer.parseInt(movimento.substring(2));
                }
            }
        }
    }
}