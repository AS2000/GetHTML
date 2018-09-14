package lt.vianet.gethtml.Actions;

import lt.vianet.gethtml.cleaning_process.ReplaceTabWithSpaces;
import lt.vianet.gethtml.cleaning_process.TrimSpaces;
import lt.vianet.gethtml.io.SaveHTMLData;
import lt.vianet.gethtml.io.URLReader;
import lt.vianet.gethtml.page_adapters.WebPage;

public class Actions {

    public void startApp() {

        doActions();
    }

    private void doActions() {

        WebPage webPage = new WebPage("https://skrendu.lt/");
        webPage.setEncoding("UTF-8");

         webPage = cleanHTML(getHTML(webPage));

        saveHTML(webPage);
    }


    private WebPage getHTML(WebPage webPage) {

        return new URLReader(webPage).readThePage();
    }


    private WebPage cleanHTML(WebPage webPage) {

        webPage = new ReplaceTabWithSpaces(webPage).cleanTheHTML();
        webPage = new TrimSpaces(webPage).getTrimedHTML();

        return webPage;
    }


    private void saveHTML(WebPage webPage) {

        new SaveHTMLData(webPage).saveHTML();
    }

}
