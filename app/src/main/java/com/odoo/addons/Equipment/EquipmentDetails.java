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
        OAppBarUtils.setAppBar(this, false);
        fileManager = new OFileManager(this);
        actionBar = getSupportActionBar();
        actionBar.setTitle("");
        if (savedInstanceState != null) {
            mEditMode = savedInstanceState.getBoolean(KEY_MODE);
            newImage = savedInstanceState.getString(KEY_NEW_IMAGE);
        }
        app = (App) getApplicationContext();
        parallaxScrollView = (ParallaxScrollView) findViewById(R.id.parallaxScrollView);
        parallaxScrollView.setActionBar(actionBar);
       //userImage = (ImageView) findViewById(android.R.id.icon);
        mTitleView = (TextView) findViewById(android.R.id.title);
        cmmsEquipment = new CmmsEquipment(this, null);
        extras = getIntent().getExtras();
        if (extras == null)
            mEditMode = true;
        mForm = (OForm) findViewById(R.id.equipmentForm);
        findViewById(R.id.equipmentFormEdit).setVisibility(View.GONE);
        findViewById(R.id.parallaxScrollView).setVisibility(View.VISIBLE);
        setupActionBar();
    }

    private void setMode(Boolean edit) {
        if (mMenu != null) {
            mMenu.findItem(R.id.menu_customer_detail_more).setVisible(!edit);
            mMenu.findItem(R.id.menu_customer_edit).setVisible(!edit);
            mMenu.findItem(R.id.menu_customer_save).setVisible(edit);
            mMenu.findItem(R.id.menu_customer_cancel).setVisible(edit);
        }
        int color = Color.DKGRAY;
//        if (record != null) {
//            color = OStringColorUtil.getStringColor(this, record.getString("name"));
//        }
        if (edit) {
            if (extras != null)
                actionBar.setTitle(R.string.label_edit);
            else
                actionBar.setTitle(R.string.label_new);
            actionBar.setBackgroundDrawable(new ColorDrawable(color));
            mForm = (OForm) findViewById(R.id.equipmentFormEdit);
            //captureImage = (ImageView) findViewById(R.id.captureImage);
          //  captureImage.setOnClickListener(this);
           // userImage = (ImageView) findViewById(android.R.id.icon1);
            findViewById(R.id.parallaxScrollView).setVisibility(View.GONE);
            findViewById(R.id.equipmentFormEdit).setVisibility(View.VISIBLE);
         //   OField is_company = (OField) findViewById(R.id.is_company_edit);
       //     is_company.setOnValueChangeListener(this);
        } else
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_shade));
           // userImage = (ImageView) findViewById(android.R.id.icon);

        }
       setColor(color);
    }

    private void setupActionBar() {
        if (extras == null) {
            setMode(mEditMode);
            userImage.setColorFilter(Color.parseColor("#ffffff"));
            mForm.setEditable(mEditMode);
            mForm.initForm(null);
        } else {
            int rowId = extras.getInt(OColumn.ROW_ID);
            record = cmmsEquipment.browse(rowId);
            record.put("full_address", cmmsEquipment.getAddress(record));

            checkControls();
            setMode(mEditMode);
            mForm.setEditable(mEditMode);
           mForm.initForm(record);
            mTitleView.setText(record.getString("name"));
           // setCustomerImage();
//            if (record.getInt("id") != 0 && record.getString("large_image").equals("false")) {
//                BigImageLoader bigImageLoader = new BigImageLoader();
//                bigImageLoader.execute(record.getInt("id"));
//            }
        }

    }
    private void initFormValues() {
        record = cmmsEquipment.browse(extras.getInt(OColumn.ROW_ID));
        if (record == null) {
            finish();
        }

//        if (!record.getString("type").equals("lead")) {
//            actionBar.setTitle(R.string.label_opportunity);
//            type = "opportunity";
//            findViewById(R.id.opportunity_controls).setVisibility(View.VISIBLE);
//        } else {
//            actionBar.setTitle(R.string.label_lead);
//        }
        mForm.initForm(record);
    }
    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.full_address:
//                IntentUtils.redirectToMap(this, record.getString("full_address"));
//                break;
////            case R.id.website:
////                IntentUtils.openURLInBrowser(this, record.getString("website"));
////                break;
////            case R.id.email:
////                IntentUtils.requestMessage(this, record.getString("email"));
////                break;
////            case R.id.phone_number:
////                IntentUtils.requestCall(this, record.getString("phone"));
////                break;
////            case R.id.mobile_number:
////                IntentUtils.requestCall(this, record.getString("mobile"));
////                break;
////            case R.id.captureImage:
////                fileManager.requestForFile(OFileManager.RequestType.IMAGE_OR_CAPTURE_IMAGE);
////                break;
//        }
    }

    private void checkControls() {
  //      findViewById(R.id.full_address).setOnClickListener(this);
//        findViewById(R.id.website).setOnClickListener(this);
//        findViewById(R.id.email).setOnClickListener(this);
//        findViewById(R.id.phone_number).setOnClickListener(this);
//        findViewById(R.id.mobile_number).setOnClickListener(this);
    }
//
//    private void setCustomerImage() {
//        if (!record.getString("image_small").equals("false")) {
//            userImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            userImage.setColorFilter(null);
//            String base64 = newImage;
//            if (newImage == null) {
//                if (!record.getString("large_image").equals("false")) {
//                    base64 = record.getString("large_image");
//                } else {
//                    base64 = record.getString("image_small");
//                }
//            }
//            userImage.setImageBitmap(BitmapUtils.getBitmapImage(this, base64));
//        } else {
//            userImage.setColorFilter(Color.parseColor("#ffffff"));
//        }
//    }

    private void setColor(int color) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.parallax_view);
        frameLayout.setBackgroundColor(color);
        parallaxScrollView.setParallaxOverLayColor(color);
        parallaxScrollView.setBackgroundColor(color);
        mForm.setIconTintColor(color);
        findViewById(R.id.parallax_view).setBackgroundColor(color);
        findViewById(R.id.parallax_view_edit).setBackgroundColor(color);
        findViewById(R.id.equipmentFormEdit).setBackgroundColor(color);
        if (captureImage != null) {
            GradientDrawable shapeDrawable =
                    (GradientDrawable) getResources().getDrawable(R.drawable.circle_mask_primary);
            shapeDrawable.setColor(color);
            captureImage.setBackgroundDrawable(shapeDrawable);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_customer_save:
                OValues values = mForm.getValues();
                if (values != null) {
//                    if (newImage != null) {
//                        values.put("image_small", newImage);
//                        values.put("large_image", newImage);
//                    }
                    if (record != null) {
                        cmmsEquipment.update(record.getInt(OColumn.ROW_ID), values);
                        Toast.makeText(this, R.string.toast_information_saved, Toast.LENGTH_LONG).show();
                        mEditMode = !mEditMode;
                        setupActionBar();
//                    } else {
//                        values.put("customer", "true");
//                        final int row_id = resPartner.insert(values);
//                        if (row_id != OModel.INVALID_ROW_ID) {
//                            finish();
//                        }
                    }
                }
                break;
            case R.id.menu_customer_cancel:
                if (record == null) {
                    finish();
                    return true;
                }
            case R.id.menu_customer_edit:
                mEditMode = !mEditMode;
                setMode(mEditMode);
              //  mForm.setEditable(mEditMode);
                mForm.initForm(record);
              //  setCustomerImage();
                break;
//            case R.id.menu_customer_share:
//                ShareUtil.shareContact(this, record, true);
//                break;
//            case R.id.menu_customer_import:
//                ShareUtil.shareContact(this, record, false);
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customer_detail, menu);
        mMenu = menu;
        setMode(mEditMode);
        return true;
    }

    @Override
    public void onFieldValueChange(OField field, Object value) {
        if (field.getFieldName().equals("is_company")) {
            Boolean checked = Boolean.parseBoolean(value.toString());
            int view = (checked) ? View.GONE : View.VISIBLE;
            findViewById(R.id.parent_id).setVisibility(view);
        }
    }

//
//    private class BigImageLoader extends AsyncTask<Integer, Void, String> {
//
//        @Override
//        protected String doInBackground(Integer... params) {
//            String image = null;
//            try {
//                Thread.sleep(300);
//                OdooFields fields = new OdooFields();
//                fields.addAll(new String[]{"image_medium"});
//                OdooResult record = resPartner.getServerDataHelper().read(null, params[0]);
//                if (record != null && !record.getString("image_medium").equals("false")) {
//                    image = record.getString("image_medium");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return image;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
////            if (result != null) {
////                if (!result.equals("false")) {
////                    OValues values = new OValues();
////                    values.put("large_image", result);
////                    resPartner.update(record.getInt(OColumn.ROW_ID), values);
////                    record.put("large_image", result);
////                    setCustomerImage();
////                }
////            }
//        }
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_MODE, mEditMode);
        outState.putString(KEY_NEW_IMAGE, newImage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        OValues values = fileManager.handleResult(requestCode, resultCode, data);
//        if (values != null && !values.contains("size_limit_exceed")) {
//            newImage = values.getString("datas");
//            userImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            userImage.setColorFilter(null);
//            userImage.setImageBitmap(BitmapUtils.getBitmapImage(this, newImage));
//        } else if (values != null) {
//            Toast.makeText(this, R.string.toast_image_size_too_large, Toast.LENGTH_LONG).show();
//        }
    }
}
