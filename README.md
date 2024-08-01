# Greport 
A classe Report é um modelo que representa um relatório configurável, com funcionalidades para definir títulos, fontes, margens, orientações e layouts de grid. Ela permite configurar a aparência e o conteúdo do relatório, além de adicionar elementos como cabeçalhos e rodapés.

Orientation: Enumeração que define a orientação do relatório, podendo ser PORTRAIT (vertical) ou LANDSCAPE (horizontal).

## Campos
titles: Lista de títulos do relatório.

pageWidth: Largura da página do relatório.

pageHeight: Altura da página do relatório.

topMargin, rightMargin, bottomMargin, leftMargin: Margens da página do relatório.

backgroundFileName: Nome do arquivo de fundo do relatório.

orientation: Orientação do relatório.

headerGrid: Grid que representa o cabeçalho do relatório.

grids: Lista de grids que representam o corpo do relatório.

footerGrid: Grid que representa o rodapé do relatório.

currentGrid: Grid atual sendo manipulado.

decorator: Decorador para configurar bordas, margens e preenchimentos do relatório.

titleDecorator: Decorador específico para títulos.

titleFont: Fonte utilizada para os títulos do relatório.

font: Fonte utilizada para o conteúdo do relatório.

### Construtor
Report(): Inicializa um novo objeto Report com configurações padrão de fonte e estilo para títulos e corpo.

## Métodos
### Métodos para configuração de fontes
getTitleFont(): Retorna a fonte dos títulos.

setTitleFont(Font titleFont): Define a fonte dos títulos.

getTitleFontName(): Retorna o nome da fonte dos títulos.

setTitleFontName(String name): Define o nome da fonte dos títulos.

getTitleFontSize(): Retorna o tamanho da fonte dos títulos.

setTitleFontSize(Integer size): Define o tamanho da fonte dos títulos.

isTitleFontBold(): Verifica se a fonte dos títulos é negrito.

setTitleFontBold(): Define a fonte dos títulos como negrito.

isTitleFontItalic(): Verifica se a fonte dos títulos é itálico.

setTitleFontItalic(): Define a fonte dos títulos como itálico.

isTitleFontUnderline(): Verifica se a fonte dos títulos é sublinhada.

setTitleFontUnderline(): Define a fonte dos títulos como sublinhada.

getTitleFontColor(): Retorna a cor da fonte dos títulos.

setTitleFontColor(Color color): Define a cor da fonte dos títulos.

getTitleBackgroundColor(): Retorna a cor de fundo dos títulos.

setTitleBackgroundColor(Color color): Define a cor de fundo dos títulos.

getFont(): Retorna a fonte do corpo do relatório.

getFontName(): Retorna o nome da fonte do corpo do relatório.

setFontName(String name): Define o nome da fonte do corpo do relatório.

getFontSize(): Retorna o tamanho da fonte do corpo do relatório.

setFontSize(Integer size): Define o tamanho da fonte do corpo do relatório.

setFontBold(): Define a fonte do corpo do relatório como negrito.

isFontBold(): Verifica se a fonte do corpo do relatório é negrito.

setFontItalic(): Define a fonte do corpo do relatório como itálico.

isFontItalic(): Verifica se a fonte do corpo do relatório é itálico.

setFontUnderline(): Define a fonte do corpo do relatório como sublinhada.

isFontUnderline(): Verifica se a fonte do corpo do relatório é sublinhada.

getFontColor(): Retorna a cor da fonte do corpo do relatório.

setFontColor(Color color): Define a cor da fonte do corpo do relatório.

getBackgroundColor(): Retorna a cor de fundo do corpo do relatório.

setBackgroundColor(Color color): Define a cor de fundo do corpo do relatório.

### Métodos para configuração de layout

addNewPage(): Adiciona uma nova página ao relatório.

addTitle(String title): Adiciona um título ao relatório.

getTitles(): Retorna a lista de títulos do relatório.

setPageSize(Float width, Float height): Define o tamanho da página do relatório.

getPageWidth(): Retorna a largura da página.

setPageWidth(Float pageWidth): Define a largura da página.

getPageHeight(): Retorna a altura da página.

setPageHeight(Float pageHeight): Define a altura da página.

getOrientation(): Retorna a orientação do relatório.

setOrientation(Orientation orientation): Define a orientação do relatório.

getBackgroundFileName(): Retorna o nome do arquivo de fundo.

setBackgroundFileName(String backgroundFileName): Define o nome do arquivo de fundo.

getTopMargin(): Retorna a margem superior da página.

setTopMargin(float topMargin): Define a margem superior da página.

getRightMargin(): Retorna a margem direita da página.

setRightMargin(float rightMargin): Define a margem direita da página.

getBottomMargin(): Retorna a margem inferior da página.

setBottomMargin(float bottomMargin): Define a margem inferior da página.

getLeftMargin(): Retorna a margem esquerda da página.

setLeftMargin(float leftMargin): Define a margem esquerda da página.

setMargins(float margin): Define as margens superior, direita, inferior e esquerda da página com o mesmo valor.

setMargins(float topMargin, float rightMargin, float bottomMargin, float leftMargin): Define as margens superior, direita, inferior e esquerda da página de forma individual.

### Métodos para manipulação de grids

getGrids(): Retorna a lista de grids do relatório.

addGrid(): Adiciona um novo grid ao relatório.

addHeaderGrid(): Adiciona um grid ao cabeçalho do relatório.

addFooterGrid(): Adiciona um grid ao rodapé do relatório.

getHeaderGrid(): Retorna o grid do cabeçalho do relatório.

getFooterGrid(): Retorna o grid do rodapé do relatório.

Métodos para configuração de bordas, margens e preenchimentos

getDecorator(): Retorna o decorador do relatório.

setBorder(Borders border): Define as bordas do relatório.

getBorderTop(): Retorna a borda superior do relatório.

setBorderTop(Borders borderTop): Define a borda superior do relatório.

getBorderRight(): Retorna a borda direita do relatório.

setBorderRigth(Borders borderRight): Define a borda direita do relatório.

getBorderBottom(): Retorna a borda inferior do relatório.

setBorderBottom(Borders borderBottom): Define a borda inferior do relatório.

getBorderLeft(): Retorna a borda esquerda do relatório.

setBorderLeft(Borders borderLeft): Define a borda esquerda do relatório.

### Métodos para configuração de bordas, margens e preenchimentos dos títulos

getTitleDecorator(): Retorna o decorador específico dos títulos.

getTitleBorderTop(): Retorna a borda superior dos títulos.

setTitleBorderTop(Borders titleBorderTop): Define a borda superior dos títulos.

getTitleBorderRight(): Retorna a borda direita dos títulos.

setTitleBorderRigth(Borders borderRight): Define a borda direita dos títulos.

getTitleBorderBottom(): Retorna a borda inferior dos títulos.

setTitleBorderBottom(Borders titleBorderBottom): Define a borda inferior dos títulos.

getTitleBorderLeft(): Retorna a borda esquerda dos títulos.

setTitleBorderLeft(Borders titleBorderLeft): Define a borda esquerda dos títulos.


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
