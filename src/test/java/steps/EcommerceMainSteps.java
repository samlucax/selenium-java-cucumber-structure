package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;
import pages.EcommerceMainPage;

public class EcommerceMainSteps {

    @E("pesquiso o produto \"(.*)\"")
    public void pesquisarProduto(String produto){
        EcommerceMainPage ecommerceMainPage = new EcommerceMainPage();
        ecommerceMainPage.pesquisarProduto(produto);
    }

    @Entao("a pesquisa deve retornar resultados")
    public void validarQuePesquisaRetornouResultados(){
        EcommerceMainPage ecommerceMainPage = new EcommerceMainPage();
        Assert.assertTrue("O resultado da pesquisa está vazio.", ecommerceMainPage.isPesquisaRetornouResultados());
    }
}
