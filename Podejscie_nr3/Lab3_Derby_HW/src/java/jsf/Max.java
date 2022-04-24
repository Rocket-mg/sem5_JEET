/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author student
 */
@ManagedBean(name="Max")

public class Max {
    private final String xmlFile = "/home/student/Desktop/JEETlabs/podejscie_nr3/Lab3_Derby_HW/web/WEB-INF/wyniki.xml";
    private int number = 5; //default number of random parameters
    private int max;

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setNumber(int number) throws Exception {
        this.number = number;
        Random rand = new Random(); //instance of random class
        int[] data = new int[number];
        
        for (int i = 0; i < number; i++) {
            data[i] = rand.nextInt()*10;
            System.out.println(data[i]);
        }
        this.max = calcMax(data);
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        
        Element root = document.getDocumentElement();

        Collection<Wynik> results = new ArrayList<Wynik>();
        results.add(new Wynik(this.max));

        for (Wynik wynik : results) {
            Element newWynik = document.createElement("wynik");

            Element result = document.createElement("result");
            result.appendChild(document.createTextNode(Double.toString(wynik.getMax())));
            newWynik.appendChild(result);
            
            root.appendChild(newWynik);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }

    public int getNumber() {
        return number;
    }
    
    public static int calcMax(int[] data) {
	int maxx = data[0];

	for (int i = 1; i < data.length; i++) {
		if(maxx<data[i]){
                    maxx = data[i];
                }
	}
	return maxx; 
    }
    
    public static int calculateMax(int number) {
        Random rand = new Random(); //instance of random class
        int[] data = new int[5];
        for (int i = 0; i < number; i++) {
            data[i] = rand.nextInt();
        }
        return calcMax(data);
    }
    
    public Max() {}
    
    private static class Wynik {
        double max;
        
        public double getMax() {
            return this.max;
        }
        
        public Wynik(double max) {
            this.max = max;
        }
    }
}

/*
public class Max {
    private final String xmlFile = "/home/student/Desktop/JEETlabs/podejscie_nr3/Lab3_Derby_HW/web/WEB-INF/wyniki.xml";
    private int number = 5; 
    
    public static void pom(String nr){
        Pom pom = new Pom();
        dodajWynik(Integer.parseInt(nr));
    }
    public static int MaxNumber(int[] data) {
        Random rand = new Random(); //instance of random class
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt();
        }
	int max= -1000;

	for (int i = 1; i < data.length; i++) {
		if(data[i]>max)
                {
                    max = data[i];
                }
	}
	return max;
    }
    public void setNumber(int number) {
    this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setMax(int max) {
    this.max = max;
}
    public int getMax() {
        return max;
    }
    private int max;
    public void dodajWynik(int number) throws Exception {
        this.number = number;
        Random rand = new Random(); //instance of random class
        int[] data = new int[number];
        for (int i = 0; i < number; i++) {
            data[i] = rand.nextInt();
        }
        this.max = MaxNumber(data);
        
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile); 
        Element root = document.getDocumentElement();

        Collection<Wynik> results = new ArrayList<Wynik>();
        results.add(new Wynik(this.max));

        for (Wynik wynik : results) {
            Element newWynik = document.createElement("wyniki");

            Element result = document.createElement("result");
            result.appendChild(document.createTextNode(Double.toString(wynik.getMax())));
            newWynik.appendChild(result);
            
            root.appendChild(newWynik);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }
    
    public Max() {
    }
    private static class Wynik {
        double max;
        
        public double getMax() {
            return this.max;
        }
        
        public Wynik(double max) {
            this.max = max;
        }
    }
    
}*/
