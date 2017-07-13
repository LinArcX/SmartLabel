package ir.blog.stack.smartlabelproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import ir.blog.stack.smartlabel.SmartLabel;

public class MainActivity extends AppCompatActivity implements SmartLabel.OnBodyClickListener{
    private SmartLabel smartLabelHelp;
    private SmartLabel smartLabelFolder;
    private SmartLabel smartLabelDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smartLabelHelp = (SmartLabel) findViewById(R.id.smart_label_help);
        smartLabelHelp.setOnBodyClickListener(new SmartLabel.OnBodyClickListener() {
            @Override
            public void onBodyClick(TextView body) {

            }
        });

        smartLabelFolder = (SmartLabel) findViewById(R.id.smart_label_folder);
        smartLabelFolder.setOnBodyClickListener(new SmartLabel.OnBodyClickListener() {
            @Override
            public void onBodyClick(TextView body) {

            }
        });

        smartLabelDefault = (SmartLabel) findViewById(R.id.smart_label_default);
        smartLabelDefault.setOnBodyClickListener(this);

    }

    @Override
    public void onBodyClick(TextView body) {
        Toast.makeText(getApplicationContext(), "Hello SmartLabel :)", Toast.LENGTH_SHORT).show();
    }
}
