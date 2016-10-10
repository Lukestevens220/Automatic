package com.example.luke.myproject;


        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.widget.ArrayAdapter;
        import android.widget.Toast;


public class HomeActivity extends Activity {

    //http://stackoverflow.com/questions/15762905/how-can-i-display-a-list-view-in-an-android-alert-dialog
    @Override
   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_home);

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(HomeActivity.this);
        builderSingle.setTitle("Select a channel:-");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                HomeActivity.this,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("12");
        arrayAdapter.add("13");
        arrayAdapter.add("14");
        arrayAdapter.add("15");
        arrayAdapter.add("16");
        arrayAdapter.add("17");
        arrayAdapter.add("18");
        arrayAdapter.add("19");
        arrayAdapter.add("20");

        builderSingle.setNegativeButton(
                "cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    }
                });

        builderSingle.setAdapter(
                arrayAdapter,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String strName = arrayAdapter.getItem(which);

                        AlertDialog.Builder builderInner = new AlertDialog.Builder(
                                HomeActivity.this);
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Channel is");
                        builderInner.setPositiveButton(
                                "Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                        Toast.makeText(HomeActivity.this,
                                                "You are connected to channel " + strName, Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(HomeActivity.this, MainActivity.class));


                                    }
                                });
                        builderInner.show();
                    }
                });
        builderSingle.show();

}
}



