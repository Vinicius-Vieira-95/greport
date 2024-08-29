
import static org.greport.Report.Orientation.LANDSCAPE;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greport.Borders;
import org.greport.Font;
import org.greport.HAlignment;
import org.greport.LayoutGrid;
import org.greport.Operation;
import static org.greport.Operation.*;
import org.greport.Report;
import org.greport.Util;

/**
 *
 * @author Marcius
 */
public class HelloWorld {

	public static void main(String[] args) throws IOException {
//		helloWorld();
//		helloWorldLandspace();
//		helloWorldWithGrid();
//		grid3x3();
//		grid3x3WithHeader();
//		grid3x3WithHeaderAlignment();
//		gridBorders();
//		gridWithHeaderAlignmentAndBackgroudColumn();
		certificate();
//		reportSimple();
//		htmlEscape();
	}

    @SuppressWarnings("unused")
    private static void helloWorld() throws IOException {
        Report report = new Report().addTitle("Hello World");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void helloWorldLandspace() throws IOException {
        Report report = new Report()
                .setOrientation(LANDSCAPE)
                .addTitle("Hello World (Landscape)");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void helloWorldWithGrid() throws IOException {
        Report report = new Report().addTitle("Hello World with Grid");
        report.addGrid()
                .addRow().addValue("Hello World");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void grid3x3() throws IOException {
        Report report = new Report().addTitle("Grid 3x3");
        report.addGrid()
                .addRow()
                .addValue("Linha <b>1, Coluna 1").addValue("Linha 1,Coluna 2").addValue("Linha 1, Coluna 3")
                .addRow()
                .addValue("Linha 2, Coluna 1").addValue("Linha 2,Coluna 2").addValue("Linha 2, Coluna 3")
                .addRow()
                .addValue("Linha 3, Coluna 1").addValue("Linha 3,Coluna 2").addValue("Linha 3, Coluna 3");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void grid3x3WithHeader() throws IOException {
        Report report = new Report().addTitle("Grid 3x3 with Header");
        report.addGrid()
                .addColumn("Coluna 1")
                .addColumn("Coluna 2")
                .addColumn("Coluna 3")
                .addRow()
                .addValue("Linha 1, Coluna 1").addValue("Linha 1,Coluna 2").addValue("Linha 1, Coluna 3")
                .addRow()
                .addValue("Linha 2, Coluna 1").addValue("Linha 2,Coluna 2").addValue("Linha 2, Coluna 3")
                .addRow()
                .addValue("Linha 3, Coluna 1").addValue("Linha 3,Coluna 2").addValue("Linha 3, Coluna 3");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void grid3x3WithHeaderAlignment() throws IOException {
        Report report = new Report().addTitle("Grid 3x3 with Header Align");
        report.addGrid()
                .addColumn("Column To Left").sethAlignLeft()
                .addColumn("Column To Center").sethAlignCenter()
                .addColumn("Column To Right").sethAlignRight()
                .addRow()
                .addValue("Row 1, Column 1").addValue("Row 1,Column 2").addValue("Row 1, Column 3")
                .addRow()
                .addValue("Row 2, Column 1").addValue("Row 2,Column 2").addValue("Row 2, Column 3")
                .addRow()
                .addValue("Row 3, Column 1").addValue("Row 3,Column 2").addValue("Row 3, Column 3");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void gridBorders() throws IOException {
        Report report = new Report().addTitle("Grid Borders");
        report.addGrid()
                .addRow().setBorder(Borders.None).addValue().addValue("None").addValue()
                .addRow().setBorder(Borders.Dashed).addValue().addValue("Dashed").addValue()
                .addRow().setBorder(Borders.Dotted).addValue().addValue("Dotted").addValue()
                .addRow().setBorder(Borders.Double).addValue().addValue("Double").addValue()
                .addRow().setBorder(Borders.Groove).addValue().addValue("Groove").addValue()
                .addRow().setBorder(Borders.Solid).addValue().addValue("Solid").addValue()
                .addRow().setBorder(Borders.RoundDots).addValue().addValue("RoundDots").addValue();

        report.addGrid()
                .addColumn("None").setBorder(Borders.None).sethAlignCenter()
                .addColumn("Dashed").setBorder(Borders.Dashed).sethAlignCenter()
                .addColumn("Dotted").setBorder(Borders.Dotted).sethAlignCenter()
                .addColumn("Double").setBorder(Borders.Double).sethAlignCenter()
                .addColumn("Groove").setBorder(Borders.Groove).sethAlignCenter()
                .addColumn("Solid").setBorder(Borders.Solid).sethAlignCenter()
                .addColumn("RoundDots").setBorder(Borders.RoundDots).sethAlignCenter()
                .addRow().addValue("None").addValue("Dashed").addValue("Dotted").addValue("Double").addValue("Groove").addValue("Solid").addValue("RoundDots")
                .addRow().addValue("None").addValue("Dashed").addValue("Dotted").addValue("Double").addValue("Groove").addValue("Solid").addValue("RoundDots")
                .addRow().addValue("None").addValue("Dashed").addValue("Dotted").addValue("Double").addValue("Groove").addValue("Solid").addValue("RoundDots");
        Util.showReport(report);
    }

    @SuppressWarnings("unused")
    private static void gridWithHeaderAlignmentAndBackgroudColumn() throws IOException {
        Report report = new Report().addTitle("Grid 3x3 Com Header Align and BackgroundColor");
        report.addGrid()
                .addColumn("Column To Left and Red").sethAlignLeft().setBackgroundColor(Color.RED)
                .addColumn("Column To Center and Green").sethAlignCenter().setBackgroundColor(Color.GREEN)
                .addColumn("Column To Right and Blue").sethAlignRight().setBackgroundColor(Color.BLUE)
                .addRow()
                .addValue("Row 1, Column 1").addValue("Row 1,Column 2").addValue("Row 1, Column 3")
                .addRow()
                .addValue("Row 2, Column 1").addValue("Row 2,Column 2").addValue("Row 2, Column 3")
                .addRow()
                .addValue("Row 3, Column 1").addValue("Row 3,Column 2").addValue("Row 3, Column 3");
        Util.showReport(report);
    }

    static private String html(String s) {
        return ""
                + "  <body style=\"font-size:14.0pt; font-family:Helvetica\">"
                + "    <p>" + s + "</p>"
                + "  </body>";
    }

    public static final String SYMBOLS = "&larr; &darr; &harr; &uarr; &rarr; &euro; &copy; &#9786;";

    @SuppressWarnings("unused")
    private static void certificate() throws IOException {
        String texto1 = ""
                + "Certificamos que <b>$NOME</b>"
                + " participou do Evento de Extensão intitulado <b>‘’$PROJETO’’</b>,"
                + " realizado de <b>$DATA</b>,"
                + " com carga horária total de <b>$CH</b>."
                + "";
        String texto2 = "Fortaleza, xx de xxxxx de 2020.";
        String texto3 = "";//Certificado PROEX «N»/2020- CNPJ: 07.885.809/0001-97";
        String backgroundFileName = Util.getAbsolutePath("certificado.png");

        texto1 = html(texto1.replace("$NOME", "MARCIUS GOMES BRANDAO"));
        Report report = new Report();
        report.setFontSize(13)
                .setPageSize(785f, 555f)
                .setMargins(0)
                .setBackgroundFileName(backgroundFileName)
                .addGrid().addColumn().setBorder(Borders.None)
                .addRow().setHeight(223f).addValue()
                .addRow().setHeight(98f).addValue(texto1).escape().sethAlignJustified().setVAlignTop().setPaddings(0, 50, 0, 52)
                .addRow().setHeight(30f).addValue(texto2).sethAlignRight().setVAlignTop().setPaddings(0, 50, 0, 50)
                .addRow().setHeight(129f).addValue()
                .addRow().setHeight(30f).addValue(texto3).sethAlignLeft().setFontBold().setFontSize(12);

        Util.showReport(report);
    }

    private static void reportSimple() throws IOException {
        List<Product> items = new HelloWorld().products();

        Report report = new Report();

        report.addHeaderGrid()
                .addRow()
                .setBorder(Borders.None)
                .addValue("Report Title")
                .sethAlign(HAlignment.RIGHT);
        
        LayoutGrid grid = report.addGrid()
                .addColumn("Photo").setOperations(Operation.COUNT)
                .addColumn("Product").setOperations(LABEL_SUM, LABEL_AVERAGE, LABEL_HIGHEST, LABEL_LOWEST.setLabel("Menor"))
                .addColumn("Amount").setOperations(SUM, AVERAGE, HIGHEST, LOWEST )
                .getGrid();

        items.forEach(i -> {
            grid.addRow()
                    .addValue(i.getPhoto())
                    .addValue(i.getName())
                    .addValue(i.getAmount());
        });

        Util.showReport(report);
    }

    public List<Product> products() throws IOException {
        List<Product> products = new ArrayList<>();

        //for (int i = 1; i < 10; i++) {
        Product product = new Product();
        product.setName("AMAROK");
        product.setAmount(35);
        product.setPhoto(Util.getResourceAsBytes("amarok.png"));
        products.add(product);

        product = new Product();
        product.setName("NOVO POLO GTS");
        product.setAmount(20);
        product.setPhoto(Util.getResourceAsBytes("novo-polo.png"));
        products.add(product);

        product = new Product();
        product.setName("VIRTUS GTS");
        product.setAmount(6);
        product.setPhoto(Util.getResourceAsBytes("virtus.png"));
        products.add(product);
        //}
        return products;
    }

    public class Product {

        private String name;
        private Integer amount;
        private Double price;
        private Date shelfLife;
        private byte[] photo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Date getShelfLife() {
            return shelfLife;
        }

        public void setShelfLife(Date shelfLife) {
            this.shelfLife = shelfLife;
        }

        public byte[] getPhoto() {
            return photo;
        }

        public void setPhoto(byte[] photo) {
            this.photo = photo;
        }
    }

    private static void htmlEscape() throws IOException {
        String html = ""
                + "<html>"
                + " <head></head>"
                + " <body style=\"font-size:12.0pt; font-family:Arial\">"
                + "  <h1>Test HTML</h1>"
                + "<hr>"
                //                + "<br/>"
                //                + "  <p>Hello World</p>"
                //                + "<br/>"
                //                + "  <p>Special symbols: &larr;  &darr; &harr; &uarr; &rarr; &euro; &copy; &#9786;</p>"
                //                + "<br/>"
                //                  + "  <p><b>Text in Negrito</b></p>"
                //                + "<br/>"

                + "<table style=\"width:100%\" border=1>"
                + "  <tr>"
                + "    <th>Firstname</th>"
                + "    <th>Lastname</th>\n"
                + "    <th>Age</th>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>Jill</td>\n"
                + "    <td>Smith</td>\n"
                + "    <td>50</td>\n"
                + "  </tr>\n"
                + "  <tr>\n"
                + "    <td>Eve</td>\n"
                + "    <td>Jackson</td>\n"
                + "    <td>94</td>\n"
                + "  </tr>\n"
                + "</table>"
                + " </body>"
                + "</html>";
        Report report = new Report().addTitle("HTML Escape");
        report.addGrid()
                .addRow().addValue(html)
                .addRow().addValue(html).escape();
        Util.showReport(report);
    }
}
