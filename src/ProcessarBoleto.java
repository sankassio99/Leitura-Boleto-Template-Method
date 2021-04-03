import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ProcessarBoleto {

    private Function<String[], Boleto> processarLinhaArquivo ;

    public ProcessarBoleto(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public List<Boleto> processar(String nomeArquivo){
        try {
            BufferedReader reader =
                    Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = new processarLinhaArquivo.apply(vetor);
                boleto.add(boleto);
                System.out.println(boleto);
                // end::class-start[]
            }
            return boletos;
        }catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
