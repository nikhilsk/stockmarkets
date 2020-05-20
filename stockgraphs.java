package com.example.demo;

import javafx.application.Application;
 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.LineChart; 
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.lang.*;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

import org.json.simple.parser.JSONPrser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

         
@SuppressWarnings("restriction")
public class stockgraphs extends Application {
	OkHttpClient client = new OkHttpClient();
    
	public static Map<String,String> address;
	public static Map<String,String> address1;
	public static Map<String,String> address2;
	public static Map<String,String> address3;
	public static Map<String,String> address4;
	public static Map<String,String> address5;
	public static Map<String,String> address6;
	public static Map<String,String> address7;
	public static Map<String,String> address8;
	public static Map<String,String> address9;
	public static Map<String,String> address10;
	public static Map<String,String> address11;
	static String a;
	static String a1;
	static String a2;
	static String a3;
	static String a4;
	static String a5;
	static String a6;
	static String a7;
	static String a8;
	static String a9;
	static String a10;
	static String a11;
	static int mini;
	static int maxi;
	static float ex;
	static int ex1;
	   
	 String doGetRequest(String url) throws IOException {
	        Request request = new Request.Builder()
	            .url(url)
	            .build();

	        Response response = client.newCall(request).execute();
	        return response.body().string();
	      }

	
   @Override 
   public void start(Stage stage) {
      //Defining the x axis             
      NumberAxis xAxis = new NumberAxis(1,13, 1); 
      xAxis.setLabel("YEARLY ANALYSIS"); 
        
      //Defining the y axis   
      NumberAxis yAxis = new NumberAxis   (mini-((maxi-mini)/6), maxi+((maxi-mini)/6), (maxi-mini)/6); 
      yAxis.setLabel("STOCK OPENING PRICES"); 
        
      //Creating the line chart 
      LineChart linechart = new LineChart(xAxis, yAxis);  
        
      //Prepare XYChart.Series objects by setting data 
      XYChart.Series series = new XYChart.Series(); 
      series.setName("STOCK ANALYSIS"); 
        
      series.getData().add(new XYChart.Data(1, Float.parseFloat(a))); 
      series.getData().add(new XYChart.Data(2, Float.parseFloat(a1))); 
      series.getData().add(new XYChart.Data(3, Float.parseFloat(a2))); 
      series.getData().add(new XYChart.Data(4, Float.parseFloat(a3))); 
      series.getData().add(new XYChart.Data(5, Float.parseFloat(a4))); 
      series.getData().add(new XYChart.Data(6, Float.parseFloat(a5)));
      series.getData().add(new XYChart.Data(7, Float.parseFloat(a6))); 
      series.getData().add(new XYChart.Data(8, Float.parseFloat(a7))); 
      series.getData().add(new XYChart.Data(9, Float.parseFloat(a8))); 
      series.getData().add(new XYChart.Data(10, Float.parseFloat(a9))); 
      series.getData().add(new XYChart.Data(11, Float.parseFloat(a10))); 
      series.getData().add(new XYChart.Data(12, Float.parseFloat(a11))); 
            
      //Setting the data to Line chart    
      linechart.getData().add(series);        
        
      //Creating a Group object  
      Group root = new Group(linechart); 
         
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 400);  
      
      //Setting title to the Stage 
      stage.setTitle("Line Chart"); 
         
      //Adding scene to the stage 
      stage.setScene(scene);
	   
      //Displaying the contents of the stage 
      stage.show();         
   } 
   static int max(int a,int b)
   {
	   if(a>b) {return a;}
	   else return b;
   }
   static int min(int a,int b)
   {
	   if(a>b) {return b;}
	   else return a;
   }
   public static void main(String args[]) throws Exception
   { 
	   
   		//Object obj = new JSONParser().parse(new FileReader("JSONexample3.json")); 
   		
   		//JSONObject jo = (JSONObject) obj; 
	   stockgraphs example = new stockgraphs();
       String getResponse = example.doGetRequest("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=AAPL&apikey=ACWO9AEVU7KHJ94");
      System.out.println(getResponse);
       JSONParser parser = new JSONParser();
       JSONObject mts = (JSONObject) parser.parse(getResponse);
      
      JSONObject jo = (JSONObject)mts.get("Monthly Time Series");
      // String studentName = (String)studentDetails.get("name");
		
   		 address = ((Map)jo.get("2019-05-31")); 
		 address1 = ((Map)jo.get("2019-06-28")); 
		 address2 = ((Map)jo.get("2019-07-31")); 
		 address3 = ((Map)jo.get("2019-08-30")); 
		 address4 = ((Map)jo.get("2019-09-30")); 
   		 address5 = ((Map)jo.get("2019-10-31")); 
 		 address6 = ((Map)jo.get("2019-11-29")); 
   		 address7 = ((Map)jo.get("2019-12-31")); 
   		 address8 = ((Map)jo.get("2020-01-31")); 
   		 address9 = ((Map)jo.get("2020-02-28")); 
   		 address10 = ((Map)jo.get("2020-03-31")); 
   		 address11 = ((Map)jo.get("2020-04-30")); 
   		
    		
   		//Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
   		//while (itr1.hasNext()) { 
   			//Map.Entry pair = itr1.next(); 
   			//String a=(String) pair.getValue();
   		//	System.out.println(a); 
   		//} 
   		// String a;
		int count;
		 maxi=0;
		 mini=99999;
		 
		count=0;
   		for(String k:address.keySet())
   		{	
   			count+=1;
   			 a=address.get(k);
   			
   			if(count==3) {break;}
   		}
   		ex=Float.parseFloat(a);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		//System.out.print(ex1);
   		count=0;
   		for(String k1:address1.keySet())
   		{	
   			count+=1;
   			 a1=address1.get(k1);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a1);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k2:address2.keySet())
   		{	
   			count+=1;
   			 a2=address2.get(k2);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a2);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k3:address3.keySet())
   		{	
   			count+=1;
   			 a3=address3.get(k3);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a3);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k4:address4.keySet())
   		{	
   			count+=1;
   			 a4=address4.get(k4);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a4);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k5:address5.keySet())
   		{	
   			count+=1;
   			 a5=address5.get(k5);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a5);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k6:address6.keySet())
   		{	
   			count+=1;
   			 a6=address6.get(k6);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a6);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k7:address7.keySet())
   		{	
   			count+=1;
   			 a7=address7.get(k7);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a7);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k8:address8.keySet())
   		{	
   			count+=1;
   			 a8=address8.get(k8);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a8);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		count=0;
   		for(String k9:address9.keySet())
   		{	
   			count+=1;
   			 a9=address9.get(k9);
   			//System.out.println(Float.parseFloat(a9));
   	   		
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a9);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		
   		count=0;
   		for(String k10:address10.keySet())
   		{	
   			count+=1;
   			 a10=address10.get(k10);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a10);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		//System.out.println(Float.parseFloat(a10));
   		count=0;
   		for(String k11:address11.keySet())
   		{	
   			count+=1;
   			 a11=address11.get(k11);
   			
   			if(count==3) {break;}
   		}

   		ex=Float.parseFloat(a11);
   		ex1=(int)ex;
   		mini=min(mini,ex1);
   		maxi=max(maxi,ex1);
   		//System.out.println(Float.parseFloat(a11));
	   		
   		launch(args); 
   	   
   } 
}