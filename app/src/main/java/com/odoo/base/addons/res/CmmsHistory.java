package com.odoo.base.addons.res;

import android.content.Context;
import android.net.Uri;

import com.odoo.core.orm.OModel;
import com.odoo.core.orm.fields.OColumn;
import com.odoo.core.orm.fields.types.OVarchar;
import com.odoo.core.support.OUser;

/**
 * Created by Sylwek on 05/12/2015.
 */
public class CmmsHistory extends OModel {
    public static final String AUTHORITY = "com.odoo.addons.Equipment.Equipment";
    public static final String TAG =  CmmsHistory.class.getSimpleName();
//    OColumn name = new OColumn("name", OVarchar.class);
//    OColumn type = new OColumn("type", OVarchar.class);
//    //  OColumn equipment = new OColumn("equipment", CmmsEquipment.class, OColumn.RelationType.ManyToOne);

    public  CmmsHistory(Context context, OUser user) {
        super(context, " cmms.history", user);
        setDefaultNameColumn("name");
    }
    @Override
    public Uri uri() {
        return buildURI(AUTHORITY);
    }
}