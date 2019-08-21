

        package com.example.assignment_one;

        import android.content.Context;
        import android.net.Uri;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;

public class Hotels extends Fragment {
    View view;
    public static TextView tvData;
    public static ImageView img;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_hotels, container, false);

        //show button
        Button btn = (Button) view.findViewById(R.id.jsonBtn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new JsonTack().execute("http://fortunagate.com/Amaya/service.php?q=hotels");
            }
        });

        img = (ImageView) view.findViewById(R.id.HotelImages);
        Picasso.with(getActivity()).load("http://www.fortunagate.com//Amaya//image//data//signature//_S9A8259_iphone.jpg").into(Hotels.img);

        //find the text view
        tvData = (TextView) view.findViewById(R.id.textView);
        return view;
    }
}

class JsonTack extends AsyncTask<String , String , String> {

    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection connection = null;
        BufferedReader bf = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream Stream = connection.getInputStream();
            bf = new BufferedReader(new InputStreamReader(Stream));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line = bf.readLine()) != null){
                buffer.append(line);
            }

            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
            if(bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        JSONObject jobject = null;
        JSONArray jarray = null;
        JSONObject finalobject = null;
        String s = null;
        String url = null;
        super.onPostExecute(result);

        try {

            jobject = new JSONObject(result);
            jarray = jobject.getJSONArray("topimages");
            finalobject = jarray.getJSONObject(0);
            s = finalobject.getString("title");
            url = finalobject.getString("image_large");
            Log.d("My App",jobject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(result == null){
            Hotels.tvData.setText("null");
        }
        else{
            if (jobject != null) {
                Hotels.tvData.setText(s);
            }
        }

    }
}

