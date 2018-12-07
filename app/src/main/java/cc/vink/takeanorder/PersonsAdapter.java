package cc.vink.takeanorder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


class PersonsAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final ArrayList<Person> persons;

    public PersonsAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView itemView = (CardView) inflater.inflate(R.layout.person_list_view_item, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(itemView);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        String text;

        holder.name.setText(person.name);

        text = person.getBamiOrderText();
        holder.orderBami.setText(text);
        holder.orderBami.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);

        text = person.getFrikandelOrderText();
        holder.orderFrikandel.setText(text);
        holder.orderFrikandel.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);

        text = person.getKroketOrderText();
        holder.orderKroket.setText(text);
        holder.orderKroket.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);

        holder.extraLayout.setVisibility(person.isOpen ? View.VISIBLE : View.GONE);

        holder.bamiCount.setText("" + person.bami);
        holder.brBamiCount.setText("" + person.broodjeBami);
        holder.frikandelCount.setText("" + person.frikandel);
        holder.brFrikandelCount.setText("" + person.broodjeFrikandel);
        holder.kroketCount.setText("" + person.kroket);
        holder.brKroketCount.setText("" + person.broodjeKroket);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
