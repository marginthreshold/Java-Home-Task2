import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
// Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …

public class CreateSelect {
    
    public static void main(String[] args) {
        String str = new String("{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}");
        StringBuilder sqlRequest = new StringBuilder("select * from students where ");
        String str1 = str.replace(":", ",").replace(" ", "").
        replace("{", "").replace("}", "").replace("\'", "\"");
        ArrayList<String> listToRequest = new ArrayList<>(Arrays.asList(str1.split(",")));
        
        for (int i = 1; i < listToRequest.size(); i += 2) {
            if (!listToRequest.get(i).equals("\"null\"")){
                sqlRequest.append(" and "+listToRequest.get(i-1)+" = "+ listToRequest.get(i));
            }
            }
        System.out.println(sqlRequest.toString().replace("where  and ", "where "));
        
    }
}
