package kondru.kritin.com.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             final Intent int1=new Intent(Intent.ACTION_SENDTO);
             int1.setData(Uri.parse("smsto:"+Uri.encode("+1 9197719866")));
             int1.putExtra("sms_body","Kondru Kritin");
             startActivity(int1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final Intent int2=new Intent(Intent.ACTION_DIAL);
            int2.setData(Uri.parse("tel:9100265303"));
            startActivity(int2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Android_Studio"));
                startActivity(int3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Hyderabad,+Telangana,+India/@17.4126274,78.267957,11z/data=!3m1!4b1!4m5!3m4!1s0x3bcb99daeaebd2c7:0xae93b78392bafbc2!8m2!3d17.385044!4d78.486671"));
                startActivity(int4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final Intent int5=new Intent(Intent.ACTION_SEND);
            int5.setType("text/plain");
            int5.putExtra(Intent.EXTRA_SUBJECT,"CS639");
            int5.putExtra(Intent.EXTRA_TEXT,"Join CS639");
            startActivity(Intent.createChooser(int5,"Share the love"));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(MainActivity.this, NewActivity.class);
                startActivity(int6);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_help:
              //  Toast.makeText(this, "Help is clicked", Toast.LENGTH_SHORT).show();
                Intent help=new Intent(this,HelpActivity.class);
                startActivity(help);
               return true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings is clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}