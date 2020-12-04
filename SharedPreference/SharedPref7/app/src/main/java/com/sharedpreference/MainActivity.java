package com.sharedpreference;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText Name; 
	Button Insert,Display; 
	TextView Output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);


		Name=(EditText)findViewById(R.id.name); 
		Insert=(Button)findViewById(R.id.insert);
	    Display=(Button)findViewById(R.id.display);
		Output=(TextView)findViewById(R.id.output);

		Insert.setOnClickListener(new View.OnClickListener(){


				@Override
				public void onClick(View view)
				{

					SharedPreferences sharedPreferences = getSharedPreferences("example", Context.MODE_PRIVATE); 
					SharedPreferences.Editor editor = sharedPreferences.edit(); 
					editor.putString("message", Name.getText().toString().trim()); 
					editor.apply(); 
					Toast.makeText(getApplicationContext(), "Insert Successfully", Toast.LENGTH_SHORT).show(); 
				} 
			}); 
			
			
			//Displaying
		Display.setOnClickListener(new View.OnClickListener() { 
				@Override 
	            public void onClick(View view) { 
					SharedPreferences sharedPreferences = getSharedPreferences("example", Context.MODE_PRIVATE); 
					String message = sharedPreferences.getString("message", ""); 
					Output.setText(" "+message); 
				} 
	        }); 
	} 
}
