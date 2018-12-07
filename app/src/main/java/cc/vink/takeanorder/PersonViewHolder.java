package cc.vink.takeanorder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


class PersonViewHolder extends RecyclerView.ViewHolder {

    final public LinearLayout container;
    final public TextView name;
    final public TextView orderBami;
    final public TextView orderFrikandel;
    final public TextView orderKroket;

    final public GridLayout extraLayout;
//    final public Button bamiPlus;
//    final public Button bamiMin;
    final public TextView bamiCount;
//    final public Button brBamiPlus;
//    final public Button brBamiMin;
    final public TextView brBamiCount;
//    final public Button frikandelPlus;
//    final public Button frikandelMin;
    final public TextView frikandelCount;
//    final public Button brFrikandelPlus;
//    final public Button brFrikandelMin;
    final public TextView brFrikandelCount;
//    final public Button kroketPlus;
//    final public Button kroketMin;
    final public TextView kroketCount;
//    final public Button brKroketPlus;
//    final public Button brKroketMin;
    final public TextView brKroketCount;

    private Person person;

    public PersonViewHolder(CardView itemView) {
        super(itemView);

        container        = (LinearLayout) itemView.findViewById(R.id.container);
        name             = (TextView)     itemView.findViewById(R.id.name);
        orderBami        = (TextView)     itemView.findViewById(R.id.orderBami);
        orderFrikandel   = (TextView)     itemView.findViewById(R.id.orderFrikandel);
        orderKroket      = (TextView)     itemView.findViewById(R.id.orderKroket);

        extraLayout      = (GridLayout)   itemView.findViewById(R.id.extra);

        bamiCount        = (TextView)     itemView.findViewById(R.id.bamiCount);
        brBamiCount      = (TextView)     itemView.findViewById(R.id.brBamiCount);

        frikandelCount   = (TextView)     itemView.findViewById(R.id.frikandelCount);
        brFrikandelCount = (TextView)     itemView.findViewById(R.id.brFrikandelCount);

        kroketCount      = (TextView)     itemView.findViewById(R.id.kroketCount);
        brKroketCount    = (TextView)     itemView.findViewById(R.id.brKroketCount);
    }

//        // Bami
//        bamiCount.setText("" + person.bami);
//        bamiPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.bami++;
//                bamiCount.setText("" + person.bami);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        bamiMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.bami = Math.max(person.bami - 1, 0);
//                bamiCount.setText("" + person.bami);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        // Broodje Bami
//        final TextView brBamiCount = (TextView) personView.findViewById(R.id.brBamiCount);
//        Button brBamiPlus = (Button) personView.findViewById(R.id.brBamiPlus);
//        Button brBamiMin = (Button) personView.findViewById(R.id.brBamiMin);
//
//        brBamiCount.setText("" + person.broodjeBami);
//        brBamiPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeBami++;
//                brBamiCount.setText("" + person.broodjeBami);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        brBamiMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeBami = Math.max(person.broodjeBami - 1, 0);
//                brBamiCount.setText("" + person.broodjeBami);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//
//        // Frikandel
//        final TextView frikandelCount = (TextView) personView.findViewById(R.id.frikandelCount);
//        Button frikandelPlus = (Button) personView.findViewById(R.id.frikandelPlus);
//        Button frikandelMin = (Button) personView.findViewById(R.id.frikandelMin);
//
//        frikandelCount.setText("" + person.frikandel);
//        frikandelPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.frikandel++;
//                frikandelCount.setText("" + person.frikandel);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        frikandelMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.frikandel = Math.max(person.frikandel - 1, 0);
//                frikandelCount.setText("" + person.frikandel);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//
//        // Broodje Frikandel
//        final TextView brFrikandelCount = (TextView) personView.findViewById(R.id.brFrikandelCount);
//        Button brFrikandelPlus = (Button) personView.findViewById(R.id.brFrikandelPlus);
//        Button brFrikandelMin = (Button) personView.findViewById(R.id.brFrikandelMin);
//
//        brFrikandelCount.setText("" + person.broodjeFrikandel);
//        brFrikandelPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeFrikandel++;
//                brFrikandelCount.setText("" + person.broodjeFrikandel);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        brFrikandelMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeFrikandel = Math.max(person.broodjeFrikandel - 1, 0);
//                brFrikandelCount.setText("" + person.broodjeFrikandel);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//
//        // Kroket
//        final TextView kroketCount = (TextView) personView.findViewById(R.id.kroketCount);
//        Button kroketPlus = (Button) personView.findViewById(R.id.kroketPlus);
//        Button kroketMin = (Button) personView.findViewById(R.id.kroketMin);
//
//        kroketCount.setText("" + person.kroket);
//        kroketPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.kroket++;
//                kroketCount.setText("" + person.kroket);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        kroketMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.kroket = Math.max(person.kroket - 1, 0);
//                kroketCount.setText("" + person.kroket);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//
//        // Broodje Kroket
//        final TextView brKroketCount = (TextView) personView.findViewById(R.id.brKroketCount);
//        Button brKroketPlus = (Button) personView.findViewById(R.id.brKroketPlus);
//        Button brKroketMin = (Button) personView.findViewById(R.id.brKroketMin);
//
//        brKroketCount.setText("" + person.broodjeKroket);
//        brKroketPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeKroket++;
//                brKroketCount.setText("" + person.broodjeKroket);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
//        brKroketMin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                person.broodjeKroket = Math.max(person.broodjeKroket - 1, 0);
//                brKroketCount.setText("" + person.broodjeKroket);
//                setOrderTexts(personView, person);
//                updateTotalView();
//            }
//        });
}
