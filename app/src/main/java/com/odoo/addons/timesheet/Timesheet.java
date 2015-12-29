package com.odoo.addons.timesheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.odoo.base.addons.res.ResUsers;

import odoo.controls.OField;

/**
 * Created by Sylwek on 27/12/2015.
 */
public class Timesheet extends AppCompatActivity
        implements View.OnClickListener, OField.IOnFieldValueChangeListener {

    public static final String TAG = Timesheet.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ResUsers resUsers = new ResUsers(this,null);

    }

    @Override
    public void onFieldValueChange(OField field, Object value) {

    }

    @Override
    public void onClick(View v) {

    }
}
