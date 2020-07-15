package com.company.test724.web.screens.test;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.QueryUtils;
import com.haulmont.cuba.gui.components.SuggestionPickerField;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Aleksandr Khodyko on 15.07.2020.
 */
@UiController("test724_TestScreen")
@UiDescriptor("test-screen.xml")
public class TestScreen extends Screen {

    @Inject
    protected SuggestionPickerField testScreenField;

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
            MetaClass entityMetaClass = AppBeans.get(Metadata.class).getClassNN("test724_Person");
            Class entityClass = entityMetaClass.getJavaClass();
            testScreenField.setSearchExecutor((searchString, searchParams) -> {
                searchString = QueryUtils.escapeForLike(searchString);
                return AppBeans.get(DataManager.class).load(entityClass)
                        .query("e.name like ?1 order by e.name", "%" + searchString + "%")
                        .list();
            });
    }


}