package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int numberOfCoffees = 0;
    private static final int PRICE_PER_COFFEE = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * PRICE_PER_COFFEE);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(numberOfCoffees * PRICE_PER_COFFEE);
    }

    public void incrementOrder(View view) {
        numberOfCoffees++;
        updateDisplay();
    }

    public void decrementOrder(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
            updateDisplay();
        }
    }

    private void updateDisplay() {
        display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
}