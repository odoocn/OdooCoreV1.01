package com.odoo.addons.Equipment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.odoo.App;
import com.odoo.R;
import com.odoo.base.addons.ir.feature.OFileManager;
import com.odoo.addons.Equipment.providers.CmmsEquipment;
import com.odoo.core.orm.ODataRow;
import com.odoo.core.orm.OValues;
import com.odoo.core.orm.fields.OColumn;
import com.odoo.core.utils.IntentUtils;
import com.odoo.core.utils.OAppBarUtils;
import com.odoo.widgets.parallax.ParallaxScrollView;

import odoo.controls.OField;
import odoo.controls.OForm;
import odoo.controls.OSelectionField;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_detail);
        cmmsEquipment = new CmmsEquipment(this, null);
        extras = getIntent().getExtras();
        record = cmmsEquipment.browse(extras.getInt(OColumn.ROW_ID));
        OForm mform  = (OForm) findViewById(R.id.equipmentForm);
        mform.setEditable(true);
        mform.initForm(record);

        newImage = "fdsfdsfds";
    }


    @Override
    public void onFieldValueChange(OField field, Object value) {

    }

    @Override
    public void onClick(View v) {

    }
}
