package com.msaggik.firstlessonstorediscounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float matPlat = 100; // материнская плата с процессором
    byte matPlatDiscount = 45; // скидка (в процентах)
    float ram = 41; // оперативная память
    byte ramDiscount = 55;
    float rom = 39; // SSD (постоянная память)
    byte romDiscount = 30;
    float cooler = 12; // башенный кулер
    byte coolerDiscount = 25;
    float caseAndPower = 21; // корпус и блок питания
    byte caseAndPowerDiscount = 32;
    float account = 160; // счёт пользователя

    // метод подсчёта стоимости серверного комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (matPlat * (100 - matPlatDiscount) + ram * (100 - ramDiscount)
                + rom * (100 - romDiscount) + cooler * (100 - coolerDiscount)
                + caseAndPower * (100 - caseAndPowerDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки серверного комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить серверный комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить серверный комплект
            possibilityOut.setText("Имеется достаточно средств для покупки серверного комплекта");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки серверного комплекта");
            balanceOut.setText(" - ");
        }
    }
}