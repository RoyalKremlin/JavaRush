package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanya on 02.03.2017.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://https://moikrug.ru/vacancies?page=%d&q=java+%s";

    protected Document getDocument(String searchString, int page) throws IOException
    {

        String url = "http://javarush.ru/testdata/big28data2.html";
        String url2 = String.format(URL_FORMAT, page, searchString);
        return Jsoup.connect(url).userAgent("Mozilla/5.0 (jsoup)").referrer("http://google.ru").get();
    }

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        int i = 0;
        Document doc = null;
        try
        {
            doc = getDocument(searchString, i);
        }
        catch (IOException e)
        {

        }
        List<Vacancy> vacancies = new ArrayList<>();
        Elements elements = doc.getElementsByClass("job");
        while (elements.size() != 0)
        {
            for (Element element : elements)
            {
                Vacancy vac = new Vacancy();
                vac.setSiteName(doc.title());
                vac.setCompanyName(element.getElementsByAttributeValue("class", "company_name").first().getElementsByTag("a").text());
                vac.setTitle(element.getElementsByAttributeValue("class", "title").first().text());
                vac.setUrl("https://moikrug.ru" + element.getElementsByAttributeValue("class", "title").first().getElementsByTag("a").attr("href"));
                Elements el = element.getElementsByAttributeValue("class", "salary");
                if (el == null)
                {
                    vac.setSalary("");
                } else
                {
                    vac.setSalary(el.text());
                }
                el = element.getElementsByAttributeValue("class", "location");
                if (el == null)
                {
                    vac.setCity("");
                } else
                {
                    vac.setCity(el.text());
                }
                vacancies.add(vac);
            }
            i++;
            break;
        }
        return vacancies;
    }
}