package ir.blog.stack.smartlabelproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ir.blog.stack.smartlabel.SmartLabel;


public class MainActivity extends Activity implements SmartLabel.OnBodyClickListener{
    private SmartLabel smartLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smartLabel = (SmartLabel) findViewById(R.id.smart_label);
        smartLabel.setOnBodyClickListener(this);
    }

    @Override
    public void onBodyClick(TextView body) {
        Toast.makeText(getApplicationContext(), "HelloSmartLabel! :)", Toast.LENGTH_SHORT).show();
    }
}
