/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This app displays an order form to order coffee.
     */

    /**
     * This method is called when the order button is clicked incremental.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked decremental.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);

        calculatePrice(quantity, 10);

    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @param pricePerCup is the price of one cup of coffee
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    private String createOrderSummary(int price){
        String priceMessage = "Name: TemiT";
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage +  "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank You!";
        return priceMessage;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummarytextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummarytextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number));
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummarytextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummarytextView.setText(message);
    }
}