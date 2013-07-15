package com.example.calcicon;

import java.security.PublicKey;
import java.text.DecimalFormat;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity  implements OnClickListener{
  private EditText txtinput;
	
	private  double result =0;
	private String instr ="0";
	private char lastoperator=' ';
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtinput=(EditText)findViewById(R.id.editText1 );

		txtinput.setText("0");
		Intent itn=this.getIntent();
		Bundle b=itn.getExtras();
		if(b!=null){
	String val=	itn.getExtras().getString("result1","0").toString();
		if(val!=null)
		 txtinput.setText(val);
		}
		
		((Button)findViewById(R.id.button1)).setOnClickListener(this);
		((Button)findViewById(R.id.button2)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button3)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button4)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button5)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button6)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button7)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button8)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button9)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button10)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button11)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button12)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button13)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button14)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button15)).setOnClickListener(this);
		 
		((Button)findViewById(R.id.button16)).setOnClickListener(this);
		((Button)findViewById(R.id.button17)).setOnClickListener(this);
		((Button)findViewById(R.id.button18)).setOnClickListener(this);
		((Button)findViewById(R.id.button19)).setOnClickListener(this);
		((Button)findViewById(R.id.button20)).setOnClickListener(this);
		((Button)findViewById(R.id.button21)).setOnClickListener(this);

		((Button)findViewById(R.id.button22)).setOnClickListener(this);	
		((Button)findViewById(R.id.button23)).setOnClickListener(this);
		
	}

	public void onClick(View view)
	{  
		txtinput.setBackgroundColor(getResources().getColor(android.R.color.transparent));
		switch (view.getId()) {
		case R.id.button16:
		case R.id.button15:
		case R.id.button14:
		case R.id.button13:
		case R.id.button11:
		case R.id.button10:
		case R.id.button9:
		case R.id.button7:
		case R.id.button6:
		case R.id.button5:
		String inDigit=((Button)view).getText().toString();
		if(instr.equals(("0")))
				{
			instr=inDigit;
				}
		else
		{    
		
			instr+= inDigit;
		}
		txtinput.setText((instr));
		if(lastoperator == '=')
		{
			result=0;
			lastoperator=' ';
		}
		
		break;
		case R.id.button8:
			compute();
			lastoperator ='+';
			break;
		case R.id.button2:
			compute();
			lastoperator='/';
			break;
		case R.id.button3:
			compute();
			lastoperator ='*';
			break;
		case R.id.button4:
			compute();
			lastoperator='-';
			break;
		case R.id.button12:
			compute();
			lastoperator ='=';
			break;
		case R.id.button17:
			String str = txtinput.getText().toString().trim();


			   if(str.length()!=0)
				   { instr  = str.substring( 0, str.length() - 1 ); 

			    txtinput.setText ( instr );
				   }
			   lastoperator=' ';
			break;
		case R.id.button20:
		compute();
		lastoperator='e';
		break;
		case  R.id.button19:
			compute();
			lastoperator='l';
		case R.id.button21:
		compute();
		lastoperator='^';
		break;
		case R.id.button22:
		compute();
		lastoperator='%';
		break;
		case R.id.button1:
			result = 0;
			instr = "0";
			lastoperator =' ';
			txtinput.setText("0");
			break;
		case  R.id.button18:
			moveon();
			break;	
		case R.id.button23:
			if(!instr.contains("."))
			{
			 instr=instr.concat(".");
			txtinput.setText(instr);
			}
			//lastoperator=' ';
		   break;
		  default:
			break;
		}
	}
	private void compute()
	{  
	double num=Double.parseDouble(instr);
	
		
		instr="0";
		if(lastoperator==' ')
		{
			result=num;
		}
	  if (lastoperator=='+')  
		{    
		 
			result +=num; 
			
		}
		else if(lastoperator =='-')
		{
			
			result -=num;
					
		}
		else if(lastoperator =='*')
		{
			result *=num;
		}
		else if(lastoperator =='/')
		{
			result /=num;
		}
		else if(lastoperator =='%')
		{
			result %=num;
		}
		else if (lastoperator =='^')
		{
			result=Math.pow(result, num);
		}
		else if (lastoperator == 'e')
		{
			result=Math.exp(result);
		}
		else if(lastoperator == 'l')
		{
			result=Math.log10(result);
		}
		  
	   		else if(lastoperator =='=' || lastoperator =='.')
		{
			
		}
	 
	txtinput.setText(String.valueOf(result));
	}
	
	private void moveon()
	{ //convert value of edittext box into string
		String mytext=txtinput.getText().toString();
	//switches from one activity to another
		Intent i = new Intent(this,Convertor.class);
		//pass value of edittext box
	    i.putExtra("result",mytext);
		startActivity(i);
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
