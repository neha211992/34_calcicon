package com.example.calcicon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Convertor extends Activity implements OnItemSelectedListener {
  EditText resval;
	Spinner unit1,unit2,unit3;
	Double result1;
	Spinner spinner1,spinner2,spinner3;
	

   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convertor);
		 resval=(EditText)findViewById(R.id.editText2);
		//takes value from another activity
		resval.setText(getIntent().getExtras().getString("result"));
		 spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.unittochange,android.R.layout.simple_spinner_item);
	    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter1);
	    spinner1.setOnItemSelectedListener(this);
	     spinner2 = (Spinner) findViewById(R.id.spinner2);
	    	 spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom1,android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter3);
	}
	
       public void convert( View v)
       {
    	   unit1=(Spinner)findViewById(R.id.spinner1);	
    	   unit2=(Spinner)findViewById(R.id.spinner2);
    	   unit3=(Spinner)findViewById(R.id.spinner3);
    	 double val=0;
    	   String str = resval.getText().toString();
    	   result1=Double.valueOf(str);
    	   if (unit1.getSelectedItem().toString().equals("temperature"))
    	   {
    		   if(unit2.getSelectedItem().toString().equals("feh"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("cel"))
    			   {
    				   val=(result1-32)*0.55555555555555555555555555555556;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kel"))
    			   {
    				   val = 0.55555555555555555555555555555556* (result1 - 32) + 273;
    			   }
    		   }
    		   else if (unit2.getSelectedItem().toString().equals("cel"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("feh"))
    			   {
    				  val = 1.8* ( result1) + 32 ; 
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kel"))
    			   {
    				  val = result1 + 273.15;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("kel"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("feh"))
    			   {
    				  val= 1.8*(result1- 273) + 32;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cel"))
    			   {
    				   val=result1-273.15;
    			   }
    		   }
    		
    	   }
    		 //temp end
    	   //lenght start
    	   else if(unit1.getSelectedItem().toString().equals("weight"))
    	   {
    		   if(unit2.getSelectedItem().toString().equals("ounces"))                  //1
    		   {
    			   if(unit3.getSelectedItem().toString().equals("gram"))
    			   {
    				   val=result1*28;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("pounds"))
    			   {
    			  val=result1*0.062500;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kilogram"))
    			   {
    				   val=result1/35.274;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("carat"))
    			   {
    				   val=result1/0.0070548;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("metericton"))
    			   {
    				   val =result1 * 0.0044643;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("gram"))                      //2
    		   {
    			   if(unit3.getSelectedItem().toString().equals("ounces"))
    			   {
    				   val=result1/28;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("pounds"))
    			   {
    				   val =result1 * 0.0022046;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kilogram"))
    			   {
    				   val =result1/ 1000.0  ;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("carat"))
    			   {
    				   val =result1 * 5.0000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("metericton"))
    			   {
    				   val=result1*1000000;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("pounds"))                  //3
    		   {
    			   if(unit3.getSelectedItem().toString().equals("ounces"))
    			   {
    				   val=result1/0.062500;   
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("gram"))
    			   {
    				  val  =result1/ 0.0022046;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kilogram"))
    			   {
    				   val=result1/2.2046;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("carat"))
    			   {
    				   val =result1 * 2268.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("metericton"))
    			   {
    				 val= result1 /2204.6;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("kilogram"))               //4
    		   {
    			   if(unit3.getSelectedItem().toString().equals("ounces"))
    			   {
    				   val=result1*35.274;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("gram"))
    			   {
    				   val =result1* 1000.0  ;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("pounds"))
    			   {
    				   val=result1*2.2046;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("carat"))
    			   {
    				   val=result1*5000.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("metericton"))
    			   {
    				   val= result1/1000.0;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("carat"))                  //5
    		   {
    			   if(unit3.getSelectedItem().toString().equals("ounces"))
    			   {
    				   val=result1*0.0070548;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("gram"))
    			   {
    				   val =result1 / 5.0000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("pounds"))
    			   {
    				   val =result1 / 2268.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kilogram"))
    			   {
    				   val=result1/5000.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("metericton"))
    			   {
    					  val=result1/5000000;
    			   }
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("metericton"))                   //6
    		   {
    			   if(unit3.getSelectedItem().toString().equals("ounces"))
    			   {
    				   val =result1 / 0.0044643;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("gram"))
    			   {
    				   val=result1/1000000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("pounds"))
    			   {
    				   val= result1 *2204.6;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("kilogram"))
    			   {
    				   val= result1*1000.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("carat"))
    			   {
    				  val=result1*5000000;
    			   }
    		   }
    		   }
    	   //end weight
    	   //start lenght
    	   else if(unit1.getSelectedItem().toString().equals("length"))
    	   {
    		   if(unit2.getSelectedItem().toString().equals("inches"))//1
    		   {
    			 
    			   if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1* 0.083333;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1* 0.027778;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1*2.54;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1/39.370;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1/0.04;
    			   }
    			   
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/39370;
    			   }
    			   
    			  
    				   
    		   }
    		 
    		   else if(unit2.getSelectedItem().toString().equals("feet"))//3
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1* 12.000;
    			   }
    			  
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1*  0.33333;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1/0.032808;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1/3.2808;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1/0.0032808;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/3280.8;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("miles"))
    			   {
    				   val=result1*0.00018939;
    			   }
    				   
    		   }
    		
    		   else if(unit2.getSelectedItem().toString().equals("yards"))//4
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1*36.000;
    			   }
    			 
    			   else if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1* 3.0000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1/0.010936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1/1.0936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1/0.0010936;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/1093.6;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("miles"))
    			   {
    				   val=result1* 0.00056818;
    			   }
    				   
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("cm"))//5
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1* 0.39370;
    			   }
    			 
    			   else if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1*0.032808;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1*0.010936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1*0.010000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1/0.10000;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/100000;
    			   }
    			 
    			  
    				   
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("meter"))//6
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1*39.370;
    			   }
    			   
    			   else if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1 * 3.2808;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1* 1.0936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1/0.010000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1/0.0010000;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/1000.0;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("miles"))
    			   {
    				   val=result1 * 0.00062137;
    			   }
    				   
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("millimeter"))//
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1*0.04;
    			   }
    			 
    			   else if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1*0.0010936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1*0.0010936;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1*0.0010000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1*0.10000;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/1000000;
    			   }
    			      			  
    				   
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("kilometer"))//8
    		   {
    			   if(unit3.getSelectedItem().toString().equals("inches"))
    			   {
    				   val=result1*39370;
    			   }
    			   
    			   else if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1*3280.8;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1*1093.6;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1*1000.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cm"))
    			   {
    				   val=result1*100000;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("millimeter"))
    			   {
    				   val=result1*1000000;
    			   }
    			   else if (unit3.getSelectedItem().toString().equals("miles"))
    			   {
    				   val=result1* 0.62137;
    			   }
    			  
    				   
    		   }
    		   else if(unit2.getSelectedItem().toString().equals("miles"))//9
    		   {
    			   
    			   if(unit3.getSelectedItem().toString().equals("feet"))
    			   {
    				   val=result1/0.00018939;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("yards"))
    			   {
    				   val=result1/ 0.00056818;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("meter"))
    			   {
    				   val=result1 / 0.00062137;
    			   }
    			  
    			     else if (unit3.getSelectedItem().toString().equals("kilometer"))
    			   {
    				   val=result1/0.62137;
    			   }
    			  
    				   
    		   }
    		   
    	   }
    	   //end lenght
    	   //start area
    	   else if (unit1.getSelectedItem().toString().equals("area"))
    	   {
    		   if(unit2.getSelectedItem().toString().equals("sqinches"))//1
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1*0.0069444;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1* 0.00077160;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqcm"))
    			 {
    				val=result1/0.15500; 
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/1550.0;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/1550000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/15500000;
    			 }
    			
    		   }

    		   else	   if(unit2.getSelectedItem().toString().equals("sqfeet"))//2
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1/0.0069444;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1* 0.11111;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqcm"))
    			 {
    				 val=result1/0.0010764;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/10.764;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/10764000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/107640;
    			 }
    			 
    		   }

    		   else	   if(unit2.getSelectedItem().toString().equals("sqyards"))//3
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1* 9.0000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1 * 1296.0;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqcm"))
    			 {
    				 val=result1/0.00011960;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/1.1960;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/1196000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/11960;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("acres"))
    			 {
    				 val=result1*0.00020661;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmiles"))
    			 {
    				 val=result1/ 3097600;
    			 }
    		   }

    		   else	   if(unit2.getSelectedItem().toString().equals("sqmiles"))//4
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1 * 27878000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1* 3097600;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/0.38610;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/0.0038610;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("acres"))
    			 {
    				 val=result1* 640.00;
    			 }
    		   }

    		   else   if(unit2.getSelectedItem().toString().equals("sqcm"))//5
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1* 0.0010764;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1* 0.00011960;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1/0.15500;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/10000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/1000000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/100000000;
    			 }
    			
    		   }

    		   else  if(unit2.getSelectedItem().toString().equals("sqmeter"))//6
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1* 10.764;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1* 1.1960;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqcm"))
    			 {
    				 val=result1/0.00010000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1*1550.0;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/1000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/10000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("acres"))
    			 {
    				 val=result1* 0.00024711;
    			 }
    		   }

    		   else   if(unit2.getSelectedItem().toString().equals("sqkilometer"))//7
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1*10764000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1*1196000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmiles"))
    			 {
    				 val=result1*0.38610;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqcm"))
    			 {
    				 val=result1*1000000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1*1000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1*1550000000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/0.010000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("acres"))
    			 {
    				 val=result1* 247.11;
    			 }
    		   }

    		   else  if(unit2.getSelectedItem().toString().equals("hectares"))//8
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				val=result1 * 107640;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1 * 11960;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmiles"))
    			 {
    				 val=result1* 0.0038610;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/0.00010000;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/100.00;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1* 15500000;
                  }
    			 else if(unit3.getSelectedItem().toString().equals("acres"))
    			 {
    				 val=result1*2.4711;
    			 }
    		   }
    		   else   if(unit2.getSelectedItem().toString().equals("acres"))//9
    		   {
    			 if(unit3.getSelectedItem().toString().equals("sqfeet"))
    			 {
    				 val=result1 * 43560;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqyards"))
    			 {
    				 val=result1 * 4840.0;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqmiles"))
    			 {
    				 val=result1 * 0.0015625;
    			 }
    			
    			 else if(unit3.getSelectedItem().toString().equals("sqmeter"))
    			 {
    				 val=result1/0.00024711;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqkilometer"))
    			 {
    				 val=result1/247.11;
    			 }
    			 else if(unit3.getSelectedItem().toString().equals("sqinches"))
    			 {
    				 val=result1* 6272600;
                  }
    			 else if(unit3.getSelectedItem().toString().equals("hectares"))
    			 {
    				 val=result1/2.4711;
    			 }
    		   }
    		   
    	   }
    	   //end area
    	   //star volume
    	   if(unit1.getSelectedItem().toString().equals("volume"))
    	   {
    		   if(unit2.getSelectedItem().toString().equals("liter"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("milliliter"))
    			   {
    				   val=result1/0.0010000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("quarts"))
    			   {
    				   val=result1*0.95;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("gallons"))
    			   {
    				   val=result1/3.8;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cubicmeter"))
    			   {
    				   val=result1*0.0010000;
    			   }
    		   }
    		   if(unit2.getSelectedItem().toString().equals("milliliter"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/1000.0;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("quarts"))
    			   {
    				   val=result1* 0.0010567;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("gallons"))
    			   {
    				   val=result1 * 0.00026417;
    			   }
    		   }
    		   if(unit2.getSelectedItem().toString().equals("quarts"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("milliliter"))
    			   {
    				   val=result1/0.0010567;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/1.0567;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("gallons"))
    			   {
    				   val=result1* 0.25000;
    			   }
    		   }
    		   if(unit2.getSelectedItem().toString().equals("gallons"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("milliliter"))
    			   {
    				   val=result1/0.00026417;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("quarts"))
    			   {
    				   val=result1* 4.0000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/0.26417;
    			   }
    			  
    			   
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("cubicmeter"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("cubicfeet"))
    			   {
    				   val=result1*35;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cubicyards"))
    			   {
    				   val=result1*1.3;
    				}
    			   else if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/0.0010000;
    			   }
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("cubicfeet"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("cubicmeter"))
    			   {
    				val=result1*0.03;   
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cubicyards"))
    			   {
    				   val=result1 * 0.037037;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/0.035315;
    			   }
    		
    		   }
    		   else  if(unit2.getSelectedItem().toString().equals("cubicyards"))
    		   {
    			   if(unit3.getSelectedItem().toString().equals("cubicfeet"))
    			   {
    				   val=result1* 27.000;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("cubicmeter"))
    			   {
    				   val=result1*0.76;
    			   }
    			   else if(unit3.getSelectedItem().toString().equals("liter"))
    			   {
    				   val=result1/0.0013080;
    			   }
    		   }
    		   }
    	   resval.setText(String.valueOf(val));
    	   
    }
      public void moveon( View v1)
   	{
    	 // Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    	  //convert value of edittext box into string
   		String conval=resval.getText().toString();
   	//switches from one activity to another
   		Intent k = new Intent(v1.getContext(),MainActivity.class);
   		Bundle b =new Bundle();
   		//pass value of edittext box
        k.putExtra("result1", conval);
        setResult(RESULT_OK,k);
   		 v1.getContext().startActivity(k);
   	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_convertor, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		spinner1.setSelection(arg2);
		
		String typecon=(String) spinner1.getSelectedItem();
		if(typecon.equals("temperature"))
		{
		ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Changefrom1,android.R.layout.simple_spinner_item);
		 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter2);
	    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom1,android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter3);
		}
		if(typecon.equals("weight"))
		{
			ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Changefrom3,android.R.layout.simple_spinner_item);
			 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2.setAdapter(adapter2);
		    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom3,android.R.layout.simple_spinner_item);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3.setAdapter(adapter3);
		}
		if(typecon.equals("length"))
		{
			ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Changefrom2,android.R.layout.simple_spinner_item);
			 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2.setAdapter(adapter2);
		    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom2,android.R.layout.simple_spinner_item);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3.setAdapter(adapter3);
		}
		if(typecon.equals("area"))
		{
			ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Changefrom4,android.R.layout.simple_spinner_item);
			 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2.setAdapter(adapter2);
		    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom4,android.R.layout.simple_spinner_item);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3.setAdapter(adapter3);
		}
		if(typecon.equals("volume"))
		{
			ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Changefrom5,android.R.layout.simple_spinner_item);
			 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2.setAdapter(adapter2);
		    ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.Changefrom5,android.R.layout.simple_spinner_item);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3.setAdapter(adapter3);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		return;
	}


	




}
