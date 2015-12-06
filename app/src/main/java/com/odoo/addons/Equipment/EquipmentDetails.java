package com.odoo.addons.Equipment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.odoo.App;
import com.odoo.base.addons.ir.feature.OFileManager;
import com.odoo.base.addons.res.CmmsEquipment;
import com.odoo.core.orm.ODataRow;
import com.odoo.widgets.parallax.ParallaxScrollView;

import odoo.controls.OField;
import odoo.controls.OForm;

/**
 * Created by Sylwek on 05/12/2015.
 */
public class EquipmentDetails extends AppCompatActivity
        implements View.OnClickListener, OField.IOnFieldValueChangeListener {

    public static final String TAG = EquipmentDetails.class.getSimpleName();
    private final String KEY_MODE = "key_edit_mode";
    private final String KEY_NEW_IMAGE = "key_new_image";
    private ActionBar actionBar;
    private Bundle extras;
    private CmmsEquipment cmmsEquipment;
    private ODataRow record = null;
    private ParallaxScrollView parallaxScrollView;
    private ImageView userImage = null, captureImage = null;
    private TextView mTitleView = null;
    private OForm mForm;
    private App app;
    private Boolean mEditMode = false;
    private Menu mMenu;
    private OFileManager fileManager;
    private String newImage = null;







    @Override
    public void onFieldValueChange(OField field, Object value) {

    }

    @Override
    public void onClick(View v) {

    }
}
