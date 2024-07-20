import java.util.ArrayList;

public class Grifo extends Monstro{
    private String nome;
    private int saude;
    private int energia;
    private int forca;
    private int habilidade;
    private int defesa;
    private int x;
    private int y;
    // private int nivel;

    public Grifo(String nome, int saude, int energia, int forca, int habilidade, int defesa, int x, int y) {
        this.nome = nome;
        this.saude = saude;
        this.energia = energia;
        this.forca = forca;
        this.habilidade = habilidade;
        this.defesa = defesa;
        this.x = x;
        this.y = y;
        // this.nivel = nivel;
    }   

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void atacar(Personagem personagem){
        String ataque = "";
        int defesa = personagem.getDefesa();
        int habilidade = (int) (Math.random() * 2) + 1;
        int danoSofrido = 0;
        int forca = 0;

        switch (habilidade) {
            case 1:
                ataque = "Bicada";
                forca = this.habilidade * 3;
                danoSofrido = forca;
                if(danoSofrido >= 0){
                    personagem.setSaude(personagem.getSaude() - danoSofrido);
                }
                personagem.setMeuTurno(true);
                break;
            case 2:
                if(this.energia - 10 >= 0){
                    ataque = "Rasante";
                    forca = this.forca * 3;
                    danoSofrido = forca - defesa;
                    
                    if(danoSofrido > 0){
                        personagem.setSaude(personagem.getSaude() - danoSofrido);
                    }
                    this.energia -= 10;
                    personagem.setMeuTurno(false);
                    break;
                }else {
                    ataque = "Bicada";
                    forca = this.habilidade * 3;
                    danoSofrido = forca;
    
                    if(danoSofrido >= 0){
                        personagem.setSaude(personagem.getSaude() - danoSofrido);
                    }
                    personagem.setMeuTurno(true);
                    break;
                }
        }

        if (danoSofrido > 0){            
            System.out.println("\n*** " + this.getNome() + " realizou o ataque " + ataque + " ***");
            System.out.println("Status do Personagem: " + personagem.getNome());
            System.out.println("--Saude.....: " + personagem.getSaude());
            System.out.println("--Energia...: " + personagem.getEnergia());
            System.out.println("--Forca.....: " + personagem.getForca());
            System.out.println("--Habilidade: " + personagem.getHabilidade());
            System.out.println("--Defesa....: " + personagem.getDefesa());
        }
    }

    public void drop(Personagem personagem){
        ArrayList <Item> itensDrop = new ArrayList<>();
        Pocao elixirGrifo = new Pocao(10, "Elixir de Grifo", "Aumenta sua defesa em 4 pontos", 3, 4, 4);
        Pocao pocaoCura3 = new Pocao(11, "Pocao de cura", "Restaura sua saude em 60 pts", 3, 1, 60);
        itensDrop.add(elixirGrifo);
        itensDrop.add(pocaoCura3);

        if (personagem instanceof Mago){
            Arma cajadoElemental = new Arma(12, "Cajado Elemental", "Aumenta o dano que voce causa nos inimigos", 1, 1, 5);
            itensDrop.add(cajadoElemental);

            for (int i = 0; i < itensDrop.size(); i++){
                System.out.println("*** " + itensDrop.get(i).getNome() + " adicionado ao seu inventario ***");   
            }
            itensDrop.addAll(personagem.getListaDeItens());
            personagem.setListaDeItens(itensDrop);
        }

        if (personagem instanceof Guerreiro){
            Arma espadaAco = new Arma(12, "Espada de Aco", "Aumenta o dano que voce causa nos inimigos", 1, 1, 5);
            itensDrop.add(espadaAco);

            for (int i = 0; i < itensDrop.size(); i++){
                System.out.println("*** " + itensDrop.get(i).getNome() + " adicionado ao seu inventario ***");   
            }
            itensDrop.addAll(personagem.getListaDeItens());
            personagem.setListaDeItens(itensDrop);
        }

        if (personagem instanceof Bruxo){
            Arma espadaGrifo = new Arma(12, "Espada da Escola do Grifo", "Aumenta o dano que voce causa nos inimigos", 1, 1, 5);
            itensDrop.add(espadaGrifo);

            for (int i = 0; i < itensDrop.size(); i++){
                System.out.println("*** " + itensDrop.get(i).getNome() + " adicionado ao seu inventario ***");   
            }
            itensDrop.addAll(personagem.getListaDeItens());
            personagem.setListaDeItens(itensDrop);
        }
    }
}