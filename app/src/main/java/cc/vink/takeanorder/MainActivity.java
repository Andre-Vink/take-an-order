package cc.vink.takeanorder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> persons = null;
    private View openView = null;

    public MainActivity() {
        super();
        Log.d("TAO", "MainActivity constructor");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("TAO", "MainActivity onCreateOptionsMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("TAO", "MainActivity onOptionsItemSelected");

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_persons:
                Log.d("TAO", "Menu clicked");
                clearPersons();
                MainActivity.this.recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAO", "MainActivity onCreate");

        readPersonsFromStorage();

        setContentView(R.layout.activity_main);

        fillViewWithPersons();
        updateTotalView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAO", "MainActivity onSaveInstanceState");
        writePersonsToStorage();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAO", "MainActivity onPause");
        writePersonsToStorage();
    }

    public void handlePersonItemClick(View view) {
        Log.d("TAO", "Click received on " + view);

        CardView itemView = (CardView) view;
        GridLayout extraView = (GridLayout) itemView.findViewById(R.id.extra);

        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        if (extraView == openView) {
            extraView.setVisibility(View.GONE);
            openView = null;
        } else {
            if (openView != null) {
                openView.setVisibility(View.GONE);
            }
            extraView.setVisibility(View.VISIBLE);
            openView = extraView;
        }
    }

    public void handleAddBami(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.bami++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveBami(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.bami > 0) {
            person.bami--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    public void handleAddBroodjeBami(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.broodjeBami++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveBroodjeBami(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.broodjeBami > 0) {
            person.broodjeBami--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    public void handleAddFrikandel(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.frikandel++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveFrikandel(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.frikandel > 0) {
            person.frikandel--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    public void handleAddBroodjeFrikandel(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.broodjeFrikandel++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveBroodjeFrikandel(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.broodjeFrikandel > 0) {
            person.broodjeFrikandel--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    public void handleAddKroket(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.kroket++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveKroket(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.kroket > 0) {
            person.kroket--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    public void handleAddBroodjeKroket(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        person.broodjeKroket++;

        CardView cardView = getCardViewForButton(button);
        fillViewFromPerson(cardView, person);

        updateTotalView();
    }

    public void handleRemoveBroodjeKroket(View button) {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        TransitionManager.beginDelayedTransition(personsList);

        int position = getPersonPositionForButton(button);

        Person person = persons.get(position);
        if (person.broodjeKroket > 0) {
            person.broodjeKroket--;

            CardView cardView = getCardViewForButton(button);
            fillViewFromPerson(cardView, person);

            updateTotalView();
        }
    }

    private void fillViewWithPersons() {
        LinearLayout personsList = (LinearLayout) findViewById(R.id.persons);
        LayoutInflater inflater = getLayoutInflater();

        for (Person person : persons) {
            CardView personView = (CardView) inflater.inflate(
                    R.layout.person_list_view_item, personsList, false);
            fillViewFromPerson(personView, person);
            personsList.addView(personView);
        }
    }

    private void fillViewFromPerson(CardView personView, Person person) {
        TextView nameView         = (TextView)   personView.findViewById(R.id.name);

        TextView orderBami        = (TextView)   personView.findViewById(R.id.orderBami);
        TextView orderFrikandel   = (TextView)   personView.findViewById(R.id.orderFrikandel);
        TextView orderKroket      = (TextView)   personView.findViewById(R.id.orderKroket);

        TextView bamiCount        = (TextView)   personView.findViewById(R.id.bamiCount);
        TextView brBamiCount      = (TextView)   personView.findViewById(R.id.brBamiCount);
        TextView frikandelCount   = (TextView)   personView.findViewById(R.id.frikandelCount);
        TextView brFrikandelCount = (TextView)   personView.findViewById(R.id.brFrikandelCount);
        TextView kroketCount      = (TextView)   personView.findViewById(R.id.kroketCount);
        TextView brKroketCount    = (TextView)   personView.findViewById(R.id.brKroketCount);

        nameView.setText(person.name);

        String text;
        text = person.getBamiOrderText();
        orderBami.setText(text);
        orderBami.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);
        text = person.getFrikandelOrderText();
        orderFrikandel.setText(text);
        orderFrikandel.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);
        text = person.getKroketOrderText();
        orderKroket.setText(text);
        orderKroket.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);

        bamiCount.setText("" + person.bami);
        brBamiCount.setText("" + person.broodjeBami);
        frikandelCount.setText("" + person.frikandel);
        brFrikandelCount.setText("" + person.broodjeFrikandel);
        kroketCount.setText("" + person.kroket);
        brKroketCount.setText("" + person.broodjeKroket);
    }

    private int getPersonPositionForButton(View button) {
        CardView cardView = getCardViewForButton(button);
        LinearLayout parent = (LinearLayout) cardView.getParent();
        int position = parent.indexOfChild(cardView);
        return position;
    }

    private CardView getCardViewForButton(View button) {
        GridLayout gridLayout = (GridLayout) button.getParent();
        LinearLayout linearLayout = (LinearLayout) gridLayout.getParent();
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.getParent();
        CardView cardView = (CardView) linearLayout2.getParent();
        return cardView;
    }

    private boolean largeTotalView = false;
    public void onTouchTotal(View view) {
        largeTotalView = !largeTotalView;

        LinearLayout viewGroup = (LinearLayout) view;
        TextView normalTextView = (TextView) viewGroup.findViewById(R.id.normal);
        TextView large1TextView = (TextView) viewGroup.findViewById(R.id.large1);
        TextView large2TextView = (TextView) viewGroup.findViewById(R.id.large2);
        TextView large3TextView = (TextView) viewGroup.findViewById(R.id.large3);
        TextView large4TextView = (TextView) viewGroup.findViewById(R.id.large4);

        normalTextView.setVisibility(largeTotalView ? View.GONE : View.VISIBLE);
        large1TextView.setVisibility(largeTotalView ? View.VISIBLE : View.GONE);
        large2TextView.setVisibility(largeTotalView ? View.VISIBLE : View.GONE);
        large3TextView.setVisibility(largeTotalView ? View.VISIBLE : View.GONE);
        large4TextView.setVisibility(largeTotalView ? View.VISIBLE : View.GONE);
    }

    private void readPersonsFromStorage() {
        FileInputStream fis = null;
        try {
            fis = openFileInput("persons");
            ObjectInputStream ois = new ObjectInputStream(fis);
            persons = (ArrayList<Person>) ois.readObject();
        } catch (IOException x) {
            Log.e("TAO", "Cannot read persons in persistent storage", x);
        } catch (ClassNotFoundException x) {
            Log.e("TAO", "Cannot instantiate persons from persistent storage", x);
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException x) {
                Log.e("TAO", "Cannot properly close persons persistent storage", x);
            }
        }

        if (persons == null)
            createPersons();
    }

    private void writePersonsToStorage() {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("persons", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
        } catch (IOException x) {
            Log.e("TAO", "Cannot store persons in persistent storage", x);
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException x) {
                Log.e("TAO", "Cannot properly close persons persistent storage", x);
            }
        }
    }

    private void clearPersons() {
        for (Person person: persons) {
            person.bami = person.broodjeBami = 0;
            person.frikandel = person.broodjeFrikandel = 0;
            person.kroket = person.broodjeKroket = 0;
        }
    }

//    private void scrollViewIntoViewIfNecessary(View view, ViewGroup scrollView) {
//        int topPerson = view.getTop();
//        int btmPerson = view.getBottom();
//        int topScroll = scrollView.getScrollY();
//        int hgtScroll = scrollView.getHeight();
//        int btmScroll = topScroll + hgtScroll;
//
//        if (topPerson < topScroll)
//            scrollView.scrollTo(0, topPerson);
//        else if (btmPerson > btmScroll)
//            scrollView.scrollTo(0, btmPerson - hgtScroll);
//    }

    private void updateTotalView() {
        int bami = 0;
        int frikandel = 0;
        int kroket = 0;
        int broodje = 0;

        for (Person person: persons) {
            bami += person.bami + person.broodjeBami;
            frikandel += person.frikandel + person.broodjeFrikandel;
            kroket += person.kroket + person.broodjeKroket;
            broodje += person.broodjeBami + person.broodjeFrikandel + person.broodjeKroket;
        }

        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.totals);
        TextView normalTextView = (TextView) viewGroup.findViewById(R.id.normal);
        TextView large1TextView = (TextView) viewGroup.findViewById(R.id.large1);
        TextView large2TextView = (TextView) viewGroup.findViewById(R.id.large2);
        TextView large3TextView = (TextView) viewGroup.findViewById(R.id.large3);
        TextView large4TextView = (TextView) viewGroup.findViewById(R.id.large4);

        Resources resources = getResources();

        normalTextView.setText(calcTotalText());
        large1TextView.setText(resources.getString(R.string.bami, bami));
        large2TextView.setText(resources.getString(R.string.frikandel, frikandel));
        large3TextView.setText(resources.getString(R.string.kroket, kroket));
        large4TextView.setText(resources.getString(R.string.broodje, broodje));
    }

    private String calcTotalText() {
        int bami = 0;
        int broodjeBami = 0;
        int frikandel = 0;
        int broodjeFrikandel = 0;
        int kroket = 0;
        int broodjeKroket = 0;

        for (Person person : persons) {
            bami += person.bami;
            broodjeBami += person.broodjeBami;
            frikandel += person.frikandel;
            broodjeFrikandel += person.broodjeFrikandel;
            kroket += person.kroket;
            broodjeKroket += person.broodjeKroket;
        }

        boolean prev = false;
        StringBuilder builder = new StringBuilder();
        if (bami > 0) {
            if (prev) builder.append(", ");
            builder.append(bami).append(" Bami");
            prev = true;
        }
        if (broodjeBami > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeBami).append(" Broodje Bami");
            prev = true;
        }
        if (frikandel > 0) {
            if (prev) builder.append(", ");
            builder.append(frikandel).append(" Frikandel");
            prev = true;
        }
        if (broodjeFrikandel > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeFrikandel).append(" Broodje Frikandel");
            prev = true;
        }
        if (kroket > 0) {
            if (prev) builder.append(", ");
            builder.append(kroket).append(" Kroket");
            prev = true;
        }
        if (broodjeKroket > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeKroket).append(" Broodje Kroket");
        }
        return builder.toString();
    }

    private void createPersons() {
        if (persons == null) {
            Log.d("TAO", "Creating persons....");
            Resources resources = getResources();
            final String[] names = resources.getStringArray(R.array.persons);

            persons = new ArrayList<>();
            for (String name: names) {
                Person person = new Person(name);
                persons.add(person);
            }
        }
    }
}
