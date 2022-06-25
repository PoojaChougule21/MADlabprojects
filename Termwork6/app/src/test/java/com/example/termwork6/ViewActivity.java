package com.example.termwork6;



import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.*;
import android.widget.*;

import org.json.JSONObject;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;

    public class ViewActivity extends AppCompatActivity {
        TextView lblXmlData,lblJsonData;
        int mode=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lblXmlData=(TextView)findViewById(R.id.button);
            lblJsonData=(TextView)findViewById(R.id.button2);
            mode=getIntent().getIntExtra("mode",0);
            if(mode==1)
                parseJson();
            else
                parseXmlDocument();
        }
        public String parseXmlDocument()
        {
            try {
                InputStream is = getAssets().open("input.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
                Document doc = dbuilder.parse(is);
                Element
                        element=doc.getDocumentElement();
                element.normalize();
                NodeList nList = doc.getElementsByTagName("employee");
                for(int i=0;i< nList.getLength();i++)
                {
                    Node node = nList.item(i);
                    if(node.getNodeType()==Node.ELEMENT_NODE)
                    {
                        Element element2 = (Element) node;
                        lblXmlData.setText("City Name : "+getValue("City_name",element2)+"\n");
                        lblXmlData.append("Latitude : "+ getValue("Latitide",element2)+"\n");
                        lblXmlData.append("Longitude : "+getValue("Longitude",element2)+"\n");
                        lblXmlData.append("Temprature : "+getValue("Temprature",element2)+"\n");
                        lblXmlData.append("Humidity : "+getValue("Humidity",element2)+"\n");

                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        private static String getValue(String tag , Element element)
        {
            NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = nodeList.item(0);
            return node.getNodeValue();
        }
        public void parseJson()
        {
            try{
                InputStream inputStream = getAssets().open("input.json");
                byte[] data = new byte[inputStream.available()];
                inputStream.read(data);
                String readData = new String(data);
                JSONObject jsonObject = new JSONObject(readData);
                JSONObject jsonObject1=jsonObject.getJSONObject("employee");
                lblJsonData.setText("city name:"+jsonObject1.getString("city_name")+"\n");
                lblJsonData.append("Latidude :"+jsonObject1.getString("Latitude")+"\n");
                lblJsonData.append("Longitude"+jsonObject1.getString("Longitude")+"\n");
                lblJsonData.append("Temprature:"+jsonObject1.getInt("Temprature")+"\n");
                lblJsonData.append("Humidity :"+jsonObject1.getString("Humidity")+"\n");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

