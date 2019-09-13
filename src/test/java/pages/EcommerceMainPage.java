package pages;

import org.openqa.selenium.support.PageFactory;

public class EcommerceMainPage extends EcommerceMainPageElementMap {

    public EcommerceMainPage(){
        PageFactory.initElements(driver, this);
    }

    public void pesquisarProduto(String produto){
        txtPesquisarProduto.sendKeys(produto);
        btnPesquisarProduto.click();
    }

    public boolean isPesquisaRetornouResultados(){
        return !lblQtdResultadosEncontrados.getText().contains("0");
    }

}
