import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/2/15
 * @Description:
 */
public class books {
    private String name;
    private String autor;
    private String price;
    private String id;
    public books() {
    }

    public books(String name, String autor, String price, String id) {
        this.name = name;
        this.autor = autor;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "books{" +
                "name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", price='" + price + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) {
        try {
            // 得到一个解析器
            SAXReader reader = new SAXReader();
            // 代码技巧 debug看成员属性
            Document document = reader.read(new File("src/books.xml"));
            // System.out.println(document);
            Element rootElement = document.getRootElement();
            List<Element> book = rootElement.elements("book");

            //写一个数组存储book对象
            ArrayList<books> booksArrayList = new ArrayList<>();

            for (Element element : book) {
                Element name = element.element("name");
                Element author = element.element("author");
                Element price = element.element("price");
                String id = element.attributeValue("id");
                // System.out.println(id);
                booksArrayList.add(new books(name.getText(), author.getText(), price.getText(), id));
            }

            for (books books : booksArrayList) {
                System.out.println(books);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}
