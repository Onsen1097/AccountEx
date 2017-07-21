package com.ubu.it.myaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TritharaGames on 7/21/2017.
 */

public class AccountAdapter extends ArrayAdapter<Account> {
    private ArrayList<Account> accounts;
    Context mContext;
    int resource;

    private static class ViewHolder {
        TextView accountTextName;
        TextView accountTextTel;
        TextView accountTextEmail;
        ImageView accountIcon;
    }

    public AccountAdapter(Context context, int resource, ArrayList<Account> accounts) {
        super(context, resource, accounts);

        this.accounts = accounts;
        this.mContext = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Account account = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resource, parent, false);
            viewHolder.accountTextName = (TextView) convertView.findViewById(R.id.account_name);
            viewHolder.accountTextTel = (TextView) convertView.findViewById(R.id.account_tel);
            viewHolder.accountTextEmail = (TextView) convertView.findViewById(R.id.account_email);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.accountTextName.setText(account.getName());
        viewHolder.accountTextTel.setText(account.getTel());
        viewHolder.accountTextEmail.setText(account.getEmail());

        return convertView;
    }
}
