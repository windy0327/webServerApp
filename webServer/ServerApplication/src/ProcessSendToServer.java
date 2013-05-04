import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProcessSendToServer {
    public static void startWork() throws IOException {
        String messageSend="{hostPhone:\"1234567890000\",[{phone:\"65736543277\",message:\"hello world\"}]}";
        URL url=new URL("http://127.0.0.1:8807/home");
        HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");
        String request=messageSend;
        OutputStream out=urlConnection.getOutputStream();
        out.write(request.getBytes());
        out.flush();
        out.close();
        while (urlConnection.getContentLength()!=-1){
            InputStream in=urlConnection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String dataInputFromKeyBoard="";
            while ((dataInputFromKeyBoard=reader.readLine())!=null){
                System.out.println("server response:"+dataInputFromKeyBoard);
            }

            reader.close();
            in.close();
            urlConnection.disconnect();
        }
    }
    public static void main(String args[]) throws IOException {
        startWork();
    }
}
