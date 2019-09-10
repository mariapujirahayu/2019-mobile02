package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int angka, randomNum;
	private Random random;
	private EditText angkaForm;
	private Button guessButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		angkaForm = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		random = new Random();
		initRandomNumber();

	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		randomNum = random.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String numInputString = angkaForm.getText().toString();
		if (numInputString.equalsIgnoreCase("")){
			Toast.makeText(this,"Input harus angka!", Toast.LENGTH_SHORT).show();
		}
		else{
			angka = Integer.parseInt(numInputString);
			if (angka == randomNum){
				Toast.makeText(this,"Tebakan anda benar!", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
			}
			if (angka > randomNum){
				Toast.makeText(this,"Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
			}
			else if (angka < randomNum){
				Toast.makeText(this,"Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		angkaForm.setText("");
		initRandomNumber();
		guessButton.setEnabled(true);
	}
}
