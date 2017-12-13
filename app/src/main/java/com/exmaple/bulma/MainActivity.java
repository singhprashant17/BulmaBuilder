package com.exmaple.bulma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.exmaple.bulma.model.AppVersionResponse;
import com.exmaple.bulma.model.AppVersionResponseBuilder;
import com.exmaple.bulma.model.VersionBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppVersionResponse build = new AppVersionResponseBuilder()
                .setStatus("status")
                .setVersion(
                        new VersionBuilder()
                                .setAndroidLatest(-1)
                                .setOptionalUpdate(true)
                                .build()
                )
                .build();

        Log.d("", "" + build);
        ((TextView) findViewById(R.id.txt)).setText(build.toString());
    }
}
