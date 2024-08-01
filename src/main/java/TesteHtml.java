
import java.io.IOException;
import org.greport.Report;
import org.greport.Util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcius
 */
public class TesteHtml {

    public static void main(String[] args) throws IOException {
        String html1 = ""
                + "<p><b>OBJETIVO GERAL</b><br />"
                + "Promover a troca de experi&ecirc;ncias daqueles que realizam no momento atividades de ensino, de est&aacute;gio que articulam escola-universidade;"
                + "</p>"
                + "<p>OBJETIVOS ESPEC&Iacute;FICOS <br />"
                + "criar espa&ccedil;o de di&aacute;logo de experi&ecirc;ncias de ensino e aprendizagem em torno que liguem escola e universidade;"
                + "<br />"
                + "Sistematizar de maneira escrita as experi&ecirc;ncias por meio dos resumos;<br />"
                + "Comunicar e dialogar com aqueles que realizam atividades semelhantes;"
                + "</p>"
                + "<p>&nbsp;</p>";
        String html2 = "  <body style=\"font-size:13.0pt; font-family:Helvetica\"; vertical-align: top;>" + html1 + "  </body>";
        String html3 = "Texto com <font color='red'>fonte vermelho</font> no meio";
        String html4 = "  <body>" + "Texto com <font color='red'>fonte vermelho</font> no meio" + "  </body>";
        String html5 = "  <body style=\"font-size:13.0pt; font-family:Helvetica\"; vertical-align: top;>" + "Texto com <font color='red'>fonte vermelho</font> no meio" + "  </body>";
        String html6 = "  <body style=\"font-size:20.0pt; font-family:Arial\"; vertical-align: top;><p>" + "Texto com <font color='red'>fonte vermelho</font> no meio" + " </p></body>";
        
        Report report = new Report().addTitle(html1);
        report.addGrid().addValue(html1).addValue(html2);
        report.addGrid()
                .addRow().addValue(html3)
                .addRow().addValue(html4)
                .addRow().addValue(html5)        
                .addRow().addValue(html6)        
                ;
        Util.showReport(report);
    }
}
