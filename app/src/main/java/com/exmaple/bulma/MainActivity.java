package com.exmaple.bulma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.exmaple.bulma.model.AgeBeanBuilder;
import com.exmaple.bulma.model.FirstNameBeanBuilder;
import com.exmaple.bulma.model.LastNameBean;
import com.exmaple.bulma.model.ModelClass;
import com.exmaple.bulma.model.ModelClassBuilder;
import com.exmaple.bulma.model.PropertiesBean;
import com.exmaple.bulma.model.PropertiesBeanBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ModelClass modelClassObj = new ModelClassBuilder()
                .setRequired(new ArrayList<String>())
                .setTitle("title")
                .setType("type")
                .build();

        final PropertiesBean propertiesBeanObj = new PropertiesBeanBuilder()
                .setAge(
                        new AgeBeanBuilder()
                                .setDescription("description")
                                .setMinimum(2)
                                .setType("type")
                                .build()
                )
                .setFirstName(
                        new FirstNameBeanBuilder()
                                .setType("type")
                                .build()
                )
                .setLastName(new LastNameBean())
                .build();

        Log.d("TAG", modelClassObj + "\n" + propertiesBeanObj);
    }
}
