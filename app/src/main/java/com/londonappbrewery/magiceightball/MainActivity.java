package com.londonappbrewery.magiceightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public void exitApp()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ballDisplay = findViewById(R.id.image_8ball);

        final int[] ballArray = {R.drawable.ball1,
                                 R.drawable.ball2, R.drawable.ball3,
                R.drawable.ball4,R.drawable.ball5};


        Button askButton = findViewById(R.id.askButton);

        final Button exitButton = findViewById(R.id.exit_button);


//      on click listener for Ask button. It generates random images and sets in the image view .
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random randomNumberGenerator = new Random();

                int randomNumber = randomNumberGenerator.nextInt(5);

                ballDisplay.setImageResource(ballArray[randomNumber]);



            }
        });

//      on click listener for exit button.
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });


    }
}
