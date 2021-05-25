package com.example.doodlzapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

public class LanguageDialogFragment extends DialogFragment
{
   @Override
   public Dialog onCreateDialog(Bundle bundle)
   {
      final String[] listItems = {"English", "Việt Nam"};
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      builder.setTitle(R.string.language_dialog);
      builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            switch (which) {
               case 0: //English
                  setLocaleRequest("en");
                  break;
               case 1: //Vietnamese
                  setLocaleRequest("vi");
                  break;
            }
            dialog.dismiss();
            getActivity().recreate();
         }
      });
      return builder.create();
   }

   private void setLocaleRequest(String lang) {
      SharedPreferences.Editor sharePref = getActivity().getSharedPreferences("Language", Context.MODE_PRIVATE).edit();
      sharePref.putString("My_Lang", lang);
      sharePref.apply();
   }
}

