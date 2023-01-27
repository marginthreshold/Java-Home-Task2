// 3) ** Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.



package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("file.json")) {
            JSONArray jsobj = (JSONArray) parser.parse(reader);

            List<People> peopleList = new ArrayList<>();
            for (Object item : jsobj) {
                JSONObject peopleJsonObject = (JSONObject) item;

                String surname1 = (String) peopleJsonObject.get("фамилия");
                String rate1 = (String) peopleJsonObject.get("оценка");
                String subj1 = (String) peopleJsonObject.get("предмет");
                System.out.println("Студент "+surname1+" полчил(а) "+rate1+" по предмету "+subj1);
                People people = new People(surname1, rate1, subj1);
                peopleList.add(people);
            }
        
        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
    }
}
class People{  
    String surname;
    String rate;
    String subj;

public People(String surname, String rate, String subj){
    this.surname = surname;
    this.rate=rate;
    this.subj=subj;
}
}



