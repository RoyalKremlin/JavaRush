package com.javarush.test.level28.lesson15.big01.model;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) throws IOException{

        String url ="http://javarush.ru/testdata/big28data.html";
        String url2 = String.format(URL_FORMAT,searchString,page);
        return Jsoup.connect(url2).userAgent("Mozilla/5.0 (jsoup)").referrer("http://google.ru").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<>();
        Document doc = null;
        int i = 0;
        while (i<1)
        {
            try {
                doc = getDocument(searchString,i++);
            } catch (IOException e) {
            }
            Elements all = doc.select("[data-qa=\"vacancy-serp__vacancy\"]");
            if (all.size() > 0) {
                for (Element e : all) {
                    Vacancy vac = new Vacancy();
                    vac.setTitle(e.select("[data-qa=\"vacancy-serp__vacancy-title\"]").text());
                    vac.setCompanyName(e.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").text());
                    vac.setCity(e.select("[data-qa=\"vacancy-serp__vacancy-address\"]").text());
                    vac.setSiteName("http://hh.ua/");
                    vac.setUrl(e.select("[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));
                    vac.setSalary(e.select("[data-qa=\"vacancy-serp__vacancy-compensation\"]").text());
                    list.add(vac);
                }
            } else {
                break;
            }
        }
        return list;
    }
}




