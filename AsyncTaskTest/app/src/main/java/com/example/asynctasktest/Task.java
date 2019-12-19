package com.example.asynctasktest;
import android.os.AsyncTask;
import android.os.Message;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
public class Task extends AsyncTask<Integer,Integer,Void> {
    private TextView textView;
    public Task(TextView textView){
        super();
        this.textView=textView;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int counter=0;
        while(true){

            publishProgress(new Integer(counter));
            try{
                Thread.sleep(2000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            counter=counter+1;
            if (counter>1000){
                counter=0;
            }

        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0].toString());
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}

