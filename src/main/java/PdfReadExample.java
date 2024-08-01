
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfReadExample {

    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
//        fileNames.add("C:\\temp\\docs\\01 contrato-alteração\\01 Contrato.pdf");
//        fileNames.add("C:\\temp\\docs\\01 contrato-alteração\\3 alteração.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\01 contrato-alteração\\04 aprovado Junta.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\02- certificados e linceças\\AMMA.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\02- certificados e linceças\\bombeiros.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\02- certificados e linceças\\VIGILANCIA SANITARIA.pdf");//talvez

//        fileNames.add("C:\\temp\\docs\\03- Documento pessoas\\Habilitação Lásaro Marcos.pdf"); //não
//        fileNames.add("C:\\temp\\docs\\03- Documento pessoas\\RG Ronan.pdf");//não

//        fileNames.add("C:\\temp\\docs\\04- contrato prestação serviço\\3M MOVEIS.doc");

//        fileNames.add("C:\\temp\\docs\\05- Defins\\2018\\Declaracao DEFIS-044900672018001.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\05- Defins\\2018\\Recibo DEFIS-044900672018001.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\05- Defins\\2019\\DeclaracaoDEFIS-044900672019002.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\05- Defins\\2019\\ReciboDEFIS-044900672019002.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\05- Defins\\2020\\Declaração 2020.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\05- Defins\\2020\\Recibo 2020.pdf");//talvez
//        fileNames.add("C:\\temp\\docs\\06- IRPF\\2021\\Wagner Amaral DECLARAÇÃO.pdf"); //não
//        fileNames.add("C:\\temp\\docs\\06- IRPF\\2021\\Wagner Amaral RECIBO.pdf"); //não
        fileNames.add("C:\\temp\\docs\\07- Rais\\2018\\declaração - EstabelecimentoCompleto.pdf");//talvez
        fileNames.add("C:\\temp\\docs\\07- Rais\\2018\\Recibo- Protocolo.pdf");//talvez
        fileNames.add("C:\\temp\\docs\\07- Rais\\2020\\rais.pdf");//talvez
        fileNames.add("C:\\temp\\docs\\07- Rais\\2020\\recibo.pdf");//talvez

        for (String fileName : fileNames) {
            System.out.println("---------------------------------------------");
            System.out.println("Lendo arquivo :" + fileName);
            PdfReader reader = new PdfReader(fileName);
            PdfDocument doc = new PdfDocument(reader);
            PdfPage page = doc.getPage(1);
            System.out.println(PdfTextExtractor.getTextFromPage(page));
        }

    }

}
