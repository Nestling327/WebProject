package javademo.DButil;

import Vo.Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Spider {
    public static String httpRequest(String url){
        StringBuffer buffer = null;
        BufferedReader bufferedReader =null;
        InputStream inputStream =null;
        InputStreamReader inputStreamReader = null;
        HttpURLConnection httpcon = null;
        try {
            URL url1 = new URL(url);
            httpcon = (HttpURLConnection) url1.openConnection();
            httpcon.setDoInput(true);
            httpcon.setRequestMethod("GET");
            inputStream = httpcon.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine())!=null){
                buffer.append(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpcon.disconnect();
            return buffer.toString();
        }
    }
    public static List<Class> CreatTable(String html){
        List<Class> classes = new ArrayList<>();
        String str1 = "";
        String str2 = "";
        Pattern p = Pattern.compile("(.*)(<div class=\"printTable\">)(.*?)(</div>)(.*)");
        Matcher m = p.matcher(html);
        if (m.matches()){
            str1 = m.group(3);
            p = Pattern.compile("(.*)(<tbody>)(.*?)(</tbody>)(.*)");
            m = p.matcher(str1);
            if (m.matches()){//<td rowspan="2" align="center">理论</td>
                str2 = m.group(3);
                System.out.println(str2);
                p = Pattern.compile("<tr.*?>(.*?)</tr>");//筛查每列
                m = p.matcher(str2);
                List<String> list = new ArrayList<>();
                int i=0;
                Pattern p2 = Pattern.compile("<td.*?>(.*?)</td>");//筛查每行
                Matcher m2 = null;
                String str3 =null;
                while (m.find()){
                    str1 = m.group(1);
                    m2 = p2.matcher(str1);
                    while (m2.find()){
                        str3 = m2.group(1);
                        if (str3.contains("href")||str3==""||str3.equals("")){
                            continue;
                        }
                        i++;
                        list.add(str3);
                    }
                    System.out.print(i+" ");
                    if (i==8) {//当一行含有8列时，表示是船新的课
                        Class cla = new Class();
                        System.out.println(list.get(1));
                        cla.setName(list.get(1));
                        cla.setTeacher(list.get(5));
                        cla.setTime(list.get(6));
                        cla.setLocation(list.get(7));
                        i=0;
                        list.clear();
                        classes.add(cla);
                    }else {
                        i=0;
                        list.clear();
                    }
                }
            }
        }
        return classes;
    }
}
