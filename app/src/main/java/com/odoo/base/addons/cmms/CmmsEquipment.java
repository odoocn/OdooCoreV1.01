package com.odoo.base.addons.cmms;

import android.content.Context;
import android.net.Uri;

import com.odoo.core.orm.OModel;
import com.odoo.core.orm.fields.OColumn;
import com.odoo.core.orm.fields.types.OVarchar;
import com.odoo.core.support.OUser;

/**
 * Created by burol on 02/12/2015.
 */
public class CmmsEquipment extends OModel {
    public static final String AUTHORITY = "com.odoo.addons.Equipment.Equipment";
    public static final String TAG = CmmsEquipment.class.getSimpleName();
    OColumn name = new OColumn("name", OVarchar.class);
    OColumn type = new OColumn("type", OVarchar.class);
  //  OColumn equipment = new OColumn("equipment", CmmsEquipment.class, OColumn.RelationType.ManyToOne);

    public CmmsEquipment(Context context, OUser user) {
        super(context, "cmms.equipment", user);
        setDefaultNameColumn("name");
    }
    @Override
    public Uri uri() {
        return buildURI(AUTHORITY);
    }
}
