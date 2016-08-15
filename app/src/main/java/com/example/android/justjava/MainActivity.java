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
    private String priceMessage = "Total: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(numberOfCoffees);
        //displayPrice(numberOfCoffees * PRICE_PER_COFFEE);
        //displayMessage(priceMessage);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        if (numberOfCoffees != 0) {
            displayMessage(createOrderSummary(PRICE_PER_COFFEE));
        } else {
            displayMessage("Total: $0.00");
        }
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

        displayQuantity(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("Item count: " + number);
    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//
//    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        //priceTextView.setText(message + NumberFormat.getCurrencyInstance().format(calculatePrice(numberOfCoffees)) + "\nThank you!");
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * PRICE_PER_COFFEE;
        return price;
    }

    private String createOrderSummary(int price) {
        return "Name: Michael Kuehn\nQuantity: " + numberOfCoffees + "\nTotal: " + NumberFormat.getCurrencyInstance().format(calculatePrice(numberOfCoffees)) + "\nThank you!";
    }
}