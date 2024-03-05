package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ViewResult implements View {
/** Имя файла, используемое при сериализации */
private static final String FNAME = "items.bin";
/** Определяет количество значений для вычисления по умолчанию */
private static final int DEFAULT_NUM = 10;
/** Коллекция аргументов и результатов вычислений */
private ArrayList<Item2d> items = new ArrayList<Item2d>();
/** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
* с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
*/
public ViewResult() {
this(DEFAULT_NUM);
}

public ViewResult(int n) {
for(int ctr = 0; ctr < n; ctr++) {
items.add(new Item2d());
}
}

public ArrayList<Item2d> getItems() {
return items;
}

private int calculateOct(int decimalValue) {
    String octNumInStr = "";
    int decimalLocal = decimalValue;
    int octNumber = 0;

    while (decimalLocal > 0) {
        octNumInStr = decimalLocal % 8 + octNumInStr;
        decimalLocal /= 8;
        octNumber++;
    }

    return octNumber;
}

private int calculateHex(int decimalValue) {
    String hexNumInStr = "";
    int decimalLocal = decimalValue;
    int hexNumber = 0;

    while (decimalLocal > 0) {
        hexNumInStr = NumberAsLetter(decimalLocal % 16) + hexNumInStr;
        decimalLocal /= 16;
        hexNumber++;
    }

    return hexNumber;
}
private String NumberAsLetter(int number) {
    if (number < 10) {
        return Integer.toString(number);
    } else {
        switch (number) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return " ";
        }
    }
}


public void init(int stepdecimalValue) {
int decimalLocal = 0;
for(Item2d item : items) {
item.setDecOctHex(decimalLocal, calculateOct(decimalLocal), calculateHex(decimalLocal));
decimalLocal += stepdecimalValue;
}
}
/** Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
* {@inheritDoc}
*/
@Override
public void viewInit() {
init((int)Math.random() * 100000);
}
/** Реализация метода {@linkplain View#viewSave()}<br>
* {@inheritDoc}
*/
@Override
public void viewSave() throws IOException {
ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
os.writeObject(items);
os.flush();
os.close();
}
/** Реализация метода {@linkplain View#viewRestore()}<br>
* {@inheritDoc}
*/
@SuppressWarnings("unchecked")
@Override
public void viewRestore() throws Exception {
ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
items = (ArrayList<Item2d>) is.readObject();
is.close();
}
/** Реализация метода {@linkplain View#viewHeader()}<br>
* {@inheritDoc}
*/
@Override
public void viewHeader() {
System.out.println("Results:");
}
/** Реализация метода {@linkplain View#viewBody()}<br>
* {@inheritDoc}
*/
@Override
public void viewBody() {
for(Item2d item : items) {
System.out.printf("(%.0f; %.3f) ", item.getDecimalValue(), item.getOctNumber());
}
System.out.println();
}
@Override
public void viewFooter() {
System.out.println("End.");
}
@Override
public void viewShow() {
viewHeader();
viewBody();
viewFooter();
}
}
