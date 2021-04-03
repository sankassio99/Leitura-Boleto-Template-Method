import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class LeituraRetorno {
    private static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public LeituraRetorno() {

    }

    public static Boleto processarLinhaBancoBrasil(String[] vetor){
        Boleto boleto = new Boleto();
        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));

        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));

        return boleto ;
    }

    public static Boleto processarLinhaBradesco(String[] vetor){
        Boleto boleto = new Boleto();
        boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(0, 0, 0));

        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));

        // tag::class-end[]
        return boleto ;
    }
}
