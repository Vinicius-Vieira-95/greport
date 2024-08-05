# Greport 
A classe Report é um modelo que representa um relatório configurável, com funcionalidades para definir títulos, fontes, margens, orientações e layouts de grid. Ela permite configurar a aparência e o conteúdo do relatório, além de adicionar elementos como cabeçalhos e rodapés.

Orientation: Enumeração que define a orientação do relatório, podendo ser PORTRAIT (vertical) ou LANDSCAPE (horizontal).

## Campos
- titles: Lista de títulos do relatório.

- pageWidth: Largura da página do relatório.

- pageHeight: Altura da página do relatório.

- topMargin, rightMargin, bottomMargin, leftMargin: Margens da página do relatório.

- backgroundFileName: Nome do arquivo de fundo do relatório.

- orientation: Orientação do relatório.

- headerGrid: Grid que representa o cabeçalho do relatório.

- grids: Lista de grids que representam o corpo do relatório.

- footerGrid: Grid que representa o rodapé do relatório.

- currentGrid: Grid atual sendo manipulado.

- decorator: Decorador para configurar bordas, margens e preenchimentos do relatório.

- titleDecorator: Decorador específico para títulos.

- titleFont: Fonte utilizada para os títulos do relatório.

- font: Fonte utilizada para o conteúdo do relatório.

### Construtor
- Report(): Inicializa um novo objeto Report com configurações padrão de fonte e estilo para títulos e corpo.

## Métodos
### Métodos para configuração de fontes
- getTitleFont(): Retorna a fonte dos títulos.

- setTitleFont(Font titleFont): Define a fonte dos títulos.

- getTitleFontName(): Retorna o nome da fonte dos títulos.

- setTitleFontName(String name): Define o nome da fonte dos títulos.

- getTitleFontSize(): Retorna o tamanho da fonte dos títulos.

- setTitleFontSize(Integer size): Define o tamanho da fonte dos títulos.

- isTitleFontBold(): Verifica se a fonte dos títulos é negrito.

- setTitleFontBold(): Define a fonte dos títulos como negrito.

- isTitleFontItalic(): Verifica se a fonte dos títulos é itálico.

- setTitleFontItalic(): Define a fonte dos títulos como itálico.

- isTitleFontUnderline(): Verifica se a fonte dos títulos é sublinhada.

- setTitleFontUnderline(): Define a fonte dos títulos como sublinhada.

- getTitleFontColor(): Retorna a cor da fonte dos títulos.

- setTitleFontColor(Color color): Define a cor da fonte dos títulos.

- getTitleBackgroundColor(): Retorna a cor de fundo dos títulos.

- setTitleBackgroundColor(Color color): Define a cor de fundo dos títulos.

- getFont(): Retorna a fonte do corpo do relatório.

- getFontName(): Retorna o nome da fonte do corpo do relatório.

- setFontName(String name): Define o nome da fonte do corpo do relatório.

- getFontSize(): Retorna o tamanho da fonte do corpo do relatório.

- setFontSize(Integer size): Define o tamanho da fonte do corpo do relatório.

- setFontBold(): Define a fonte do corpo do relatório como negrito.

- isFontBold(): Verifica se a fonte do corpo do relatório é negrito.

- setFontItalic(): Define a fonte do corpo do relatório como itálico.

- isFontItalic(): Verifica se a fonte do corpo do relatório é itálico.

- setFontUnderline(): Define a fonte do corpo do relatório como sublinhada.

- isFontUnderline(): Verifica se a fonte do corpo do relatório é sublinhada.

- getFontColor(): Retorna a cor da fonte do corpo do relatório.

- setFontColor(Color color): Define a cor da fonte do corpo do relatório.

- getBackgroundColor(): Retorna a cor de fundo do corpo do relatório.

- setBackgroundColor(Color color): Define a cor de fundo do corpo do relatório.

### Métodos para configuração de layout

- addNewPage(): Adiciona uma nova página ao relatório.

- addTitle(String title): Adiciona um título ao relatório.

- getTitles(): Retorna a lista de títulos do relatório.

- setPageSize(Float width, Float height): Define o tamanho da página do relatório.

- getPageWidth(): Retorna a largura da página.

- setPageWidth(Float pageWidth): Define a largura da página.

- getPageHeight(): Retorna a altura da página.

- setPageHeight(Float pageHeight): Define a altura da página.

- getOrientation(): Retorna a orientação do relatório.

- setOrientation(Orientation orientation): Define a orientação do relatório.

- getBackgroundFileName(): Retorna o nome do arquivo de fundo.

- setBackgroundFileName(String backgroundFileName): Define o nome do arquivo de fundo.

- getTopMargin(): Retorna a margem superior da página.

- setTopMargin(float topMargin): Define a margem superior da página.

- getRightMargin(): Retorna a margem direita da página.

- setRightMargin(float rightMargin): Define a margem direita da página.

- getBottomMargin(): Retorna a margem inferior da página.

- setBottomMargin(float bottomMargin): Define a margem inferior da página.

- getLeftMargin(): Retorna a margem esquerda da página.

- setLeftMargin(float leftMargin): Define a margem esquerda da página.

- setMargins(float margin): Define as margens superior, direita, inferior e esquerda da página com o mesmo valor.

- setMargins(float topMargin, float rightMargin, float bottomMargin, float leftMargin): Define as margens superior, direita, inferior e esquerda da página de forma individual.

### Métodos para manipulação de grids

- getGrids(): Retorna a lista de grids do relatório.

- addGrid(): Adiciona um novo grid ao relatório.

- addHeaderGrid(): Adiciona um grid ao cabeçalho do relatório.

- addFooterGrid(): Adiciona um grid ao rodapé do relatório.

- getHeaderGrid(): Retorna o grid do cabeçalho do relatório.

- getFooterGrid(): Retorna o grid do rodapé do relatório.

### Métodos para configuração de bordas, margens e preenchimentos

- getDecorator(): Retorna o decorador do relatório.

- setBorder(Borders border): Define as bordas do relatório.

- getBorderTop(): Retorna a borda superior do relatório.

- setBorderTop(Borders borderTop): Define a borda superior do relatório.

- getBorderRight(): Retorna a borda direita do relatório.

- setBorderRigth(Borders borderRight): Define a borda direita do relatório.

- getBorderBottom(): Retorna a borda inferior do relatório.

- setBorderBottom(Borders borderBottom): Define a borda inferior do relatório.

- getBorderLeft(): Retorna a borda esquerda do relatório.

- setBorderLeft(Borders borderLeft): Define a borda esquerda do relatório.

### Métodos para configuração de bordas, margens e preenchimentos dos títulos

- getTitleDecorator(): Retorna o decorador específico dos títulos.

- getTitleBorderTop(): Retorna a borda superior dos títulos.

- setTitleBorderTop(Borders titleBorderTop): Define a borda superior dos títulos.

- getTitleBorderRight(): Retorna a borda direita dos títulos.

- setTitleBorderRigth(Borders borderRight): Define a borda direita dos títulos.

- getTitleBorderBottom(): Retorna a borda inferior dos títulos.

- setTitleBorderBottom(Borders titleBorderBottom): Define a borda inferior dos títulos.

- getTitleBorderLeft(): Retorna a borda esquerda dos títulos.

- setTitleBorderLeft(Borders titleBorderLeft): Define a borda esquerda dos títulos.

## Exemplo 
```
public static void main(String [] args) throws IOException {
  Report report = new Report().addTitle("Hello World");
  Util.showReport(report);
}
```

Hello World com cabeçalho
```
public static void main(String[] args) throws IOException {
 Report report = new Report().addTitle("Hello World with Grid");
        report.addGrid()
                .addRow().addValue("Hello World");
        Util.showReport(report);
}

```

Grade 3x3
```
public static void main(String [] args) throws IOException {
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
```

Grade 3x3 com cabeçalho
```
public static void main(String [] args) throws IOException {
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
```

Grade com alinhamento de texto
```
public static void main(String [] args) throws IOException {
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
```

Grade com tipo de bordas
```
public static void main(String [] args) throws IOException {
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
```

Grade com estilização de cores
```
public static void main(String [] args) throws IOException {
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
```

Estilizando certificado
```
public static void main(String [] args) throws IOException {
   String texto1 = ""
                + "Certificamos que <b>$NOME</b>"
                + " participou do Evento de Extensão intitulado <b>‘’$PROJETO’’</b>,"
                + " realizado de <b>$DATA</b>,"
                + " com carga horária total de <b>$CH</b>."
                + "";
        String texto2 = "Fortaleza, xx de xxxxx de 2024.";
        String texto3 = "";//Certificado PROEX «N»/2024- CNPJ: 00.000.000/0000-00";
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
```

Relatório com Estilização de imagens
```
public static void main(String [] args) {
  repotSimple();
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
```

#### Saída

## Tipos Enums

### Operation

A classe Operation é uma enum em Java que define um conjunto de constantes que representam diferentes operações que podem ser realizadas 
(como NOTHING, AVERAGE, COUNT, HIGHEST, LOWEST, SUM) e seus rótulos (LABEL_AVERAGE, LABEL_COUNT, LABEL_HIGHEST, LABEL_LOWEST, LABEL_SUM). 
Cada constante pode ter um rótulo associado, que é uma string opcional usada para descrever a operação em termos mais legíveis.

#### Estrutura da Classe
##### Enums:

- NOTHING, AVERAGE, COUNT, HIGHEST, LOWEST, SUM: Constantes que representam as operações básicas.
- LABEL_AVERAGE, LABEL_COUNT, LABEL_HIGHEST, LABEL_LOWEST, LABEL_SUM: Constantes que representam as operações com rótulos descritivos.
Atributos:

- private String label: Uma string que armazena o rótulo associado à operação. Por padrão, é uma string vazia se não for fornecida.
##### Construtores:

- Operation(): Construtor padrão que define o rótulo como uma string vazia.
Operation(String label): Construtor que permite a criação de uma constante enum com um rótulo específico.
##### Métodos:

- public String getLabel(): Retorna o rótulo associado à constante enum.
- public Operation setLabel(String label): Define um novo rótulo para a constante enum e retorna a própria constante, permitindo o encadeamento de chamadas de métodos.

### Borders

A classe Borders é uma enum em Java que define um conjunto de estilos de borda comumente usados para estilizar elementos visuais, como componentes de interface de usuário. Cada constante enum representa um estilo específico de borda.

#### Estrutura da Classe
#### Enums:
- None: Representa a ausência de borda.
- Solid: Representa uma borda sólida.
- Dotted: Representa uma borda pontilhada.
- Dashed: Representa uma borda tracejada.
- Double: Representa uma borda dupla.
- Groove: Representa uma borda em estilo de sulco.
- Inset: Representa uma borda com aparência de reentrância.
- Outset: Representa uma borda com aparência de saliência.
- Ridge: Representa uma borda em estilo de crista.
- RoundDots: Representa uma borda com pontos redondos.

### HAlignment e VAligment

#### HAligment
A classe HAlignment é uma enum em Java que define as opções de alinhamento horizontal para textos ou elementos em uma interface de usuário. Ela especifica como o conteúdo deve ser posicionado horizontalmente dentro de seu contêiner.

#### Estrutura da Classe
##### Enums:
- LEFT: Alinha o conteúdo à esquerda.
- CENTER: Centraliza o conteúdo horizontalmente.
- RIGHT: Alinha o conteúdo à direita.
- JUSTIFIED: Justifica o conteúdo, distribuindo-o uniformemente para alinhar com ambas as margens esquerda e direita.
- JUSTIFIED_ALL: Justifica todo o conteúdo, incluindo a última linha, de modo que ele se alinha uniformemente com as margens esquerda e direita.

#### VAligment
A classe VAlignment é uma enum em Java que define as opções de alinhamento vertical para textos ou elementos em uma interface de usuário. Ela especifica como o conteúdo deve ser posicionado verticalmente dentro de seu contêiner.

#### Estrutura da Classe
##### Enums:
- TOP: Alinha o conteúdo no topo do contêiner.
- MIDDLE: Centraliza o conteúdo verticalmente dentro do contêiner.
- BOTTOM: Alinha o conteúdo na parte inferior do contêiner.

## Baixando a dependência

    </dependencies>
        <dependency>
            <groupId>org.greport</groupId>
            <artifactId>greport</artifactId>
            <version>1.0</version>
            <type>jar</type>
        </dependency>
    </dependencies>
    <repositories>
        <repository>
            <id>gitlab-maven</id>
            <url>https://gitlab.com/api/v4/groups/13274432/-/packages/maven</url>
        </repository>
    </repositories>
