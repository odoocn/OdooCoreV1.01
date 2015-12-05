package com.odoo.addons.intervention.providers;

import com.odoo.base.addons.cmms.CmmsIntervention;
import com.odoo.core.orm.provider.BaseModelProvider;

/**
 * Created by Burol on 05/12/2015.
 */
public class InterventionSyncProvider extends BaseModelProvider {
    public static final String TAG = InterventionSyncProvider.class.getSimpleName();

    @Override
    public String authority() {
        return CmmsIntervention.AUTHORITY;
    }

}