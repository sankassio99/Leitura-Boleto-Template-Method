import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Escolha um banco");
        System.out.println("Banco do Brasil: 1");
        System.out.println("Bradesco: 2");
        int op = new Scanner(System.in).nextInt();

        String nomeArquivo = "";
        ProcessarBoleto processarBoleto ;

        if(op==1){
            nomeArquivo = "banco-brasil-1.csv" ;
            processarBoleto = new ProcessarBoleto(LeituraRetorno::processarLinhaBancoBrasil);
        }else{
            nomeArquivo = "bradesco-1.csv" ;
            processarBoleto = new ProcessarBoleto(LeituraRetorno::processarLinhaBradesco);
        }

        System.out.println("Lendo Boleto: "+nomeArquivo);

        processarBoleto.processar(nomeArquivo);

    }

}
