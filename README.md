# Projeto Base Automação Web - Selenium, Java & Cucumber

## Ferramentas utilizadas:
- [Maven](https://maven.apache.org/ "Maven")
- [Java](https://www.java.com/pt_BR/ "Java")
- [JUnit](https://junit.org/junit4/ "JUnit")
- [Selenium](https://www.seleniumhq.org/ "Selenium")
- [ChromeDriver](https://chromedriver.chromium.org/downloads "ChromeDriver")
- [Cucumber](https://cucumber.io/ "Cucumber")
- [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory "PageFactory")
- [PageObject (pattern)](https://martinfowler.com/bliki/PageObject.html "PageObject")

## Arquitetura:

```
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        │   ├── pages
        │   │   ├── CommonPage.java
        │   │   ├── EcommerceMainPage.java
        │   │   └── EcommerceMainPageElementMap.java
        │   ├── steps
        │   │   ├── CommonSteps.java
        │   │   └── EcommerceMainSteps.java
        │   ├── tests
        │   │   └── RunTest.java
        │   └── util
        │       ├── TestRule.java
        │       └── Utils.java
        └── resources
            ├── drivers
            │   └── READ.txt
            └── features
                └── Pesquisa.feature
```


### Arquitetura - Bibliotecas utilizadas

Neste projeto foram utilizadas 4 bibliotecas:
- [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java "selenium-java")
- [junit](https://mvnrepository.com/artifact/junit/junit "junit")
- [cucumber-java](https://mvnrepository.com/artifact/info.cukes/cucumber-java "cucumber-java")
- [cucumber-junit](https://mvnrepository.com/artifact/info.cukes/cucumber-junit "cucumber-junit")

A biblioteca selenium-java possui as implementações de: *WebDriver, DesiredCaps, ChromeDriver, ExpectedConditions, WebDriverWait, Actions, WebElement, FindBy, PageFactory*, utilizadas no projeto.

A biblioteca junit possui as implementações de: *TestWatcher, Description, ClassRule, RunWith, Assert*, utilizadas no projeto.

A biblioteca cucumber-java possui as implementações de: *Scenario, Before, After, Dado, E, Entao, CucumberOptions*, utilizadas no projeto.

A biblioteca cucumber-junit possui a implementação da classe *Cucumber.class*, utilizada da classe RunTest como ferramenta de execução.

### Arquitetura - Mapeamento dos elementos
Para mapear os elementos utilizamos a biblioteca do selenium PageFactory, responsável por abstrair os elementos para uma classe única e para facilitar a escrita e manutenção. Por padrão os elementos são armazenados nas classes com o padrão <NomeClasse>PageElementMap. Detalhes da implementação e exemplos:
- WebElement - responsável por identificar os elementos como Web;
- FindBy - responsável por mapear, através de anotações, os seletores dos WebElements
- CommonPage - responsável por abstrair ações comuns a todas as classes de Page e PageElementMap

Após mapeados, é necessário "inicializar" os elementos na classe em que serão utilizadas. Por padrão, os elementos são utilizados nas classe <NomeDaClasse>Page correspondentes. Para inicializar os elementos, siga o exemplo abaixo:

`PageFactory.initElements(driver, classe)`

### Arquitetura - Interação com elementos da página
Para interagir com elementos da página, conforme o padrão Page Objects, criamos uma classe de Page para cada página ou grupo de páginas do sistema. Abaixo detalhes da implementação e exemplos:
- PageFactory: responsável pela inicialização dos elementos na página
- TestRule: responsável por gerenciar a execução do teste como um todo. Neste caso, captura qual o driver que está sendo utilizado.
- Utils: responsável por armazenar funções úteis para criação e execução dos testes.

### Arquitetura - Classe Base (CommonPage)
Nesta classe são definidas ações comuns a todas a outras Pages que serão criadas no projeto, como:
- captura de screenshots
- logs
- waits (estáticos e explícitos)

### Arquitetura - Cucumber e Definições de steps
Para criação dos testes, o passo a passo é definido em arquivos .feature, dentro do diretório resources/features. Estes arquivos contém o detalhamento do teste que será executado. Para isso utilizamos o Cucumber.
Para cada passo utilizado neste arquivo, deve ser criada uma definição de Steps
correspondente. Os arquivos de steps serão criados no diretório steps.

### Arquitetura - Execução dos testes
Para execução dos testes, utilizamos classe JUnit, em conjunto com anotações do CucumberOptions para facilitar a criação de suítes de testes com diferentes configurações.

Para executar o teste, basta clicar com o botão direito sobre a classe, e selecionar "Run <NomeDaClasseDeExecucao>". É possível executar com maven também, através do comando: `mvn test -Dtest=NomeDaClasseDeExecucao`

### Arquitetura - Utilitários e TestRule
Para configuração do ciclo de vida do teste, geração de relatórios e criação de métodos auxiliares, utilizamos as classes TestRule e Utils, respectivamente. Alguns dos métodos mais importantes são:
**TestRule**
- ***starting, beforeCenario e afterCenario*** - métodos que definem os comportamentos antes, durante e após a execução dos testes em geral e de cada cenário.
- ***abrirNavegador*** - método responsável por um abrir um navegador Chrome.

**Utils**
- ***setDriverByOS*** - método para definir o driver de acordo com o sistema operacional.

### Arquitetura - ChromeDriver

Por conveniência, faça o download do chromedriver adequado para o seu sistema operacional e adicione no diretório resources/drivers.
Local para download: https://chromedriver.chromium.org/downloads


------------

