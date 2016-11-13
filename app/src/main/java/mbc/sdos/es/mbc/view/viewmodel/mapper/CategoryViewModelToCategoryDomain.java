package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.CategoryDomain;
import mbc.sdos.es.mbc.view.viewmodel.CategoryViewModel;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class CategoryViewModelToCategoryDomain extends Mapper<CategoryViewModel, CategoryDomain> {


    @Inject
    public CategoryViewModelToCategoryDomain() {
    }

    @Override
    public CategoryDomain map(CategoryViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CategoryViewModel reverseMap(CategoryDomain value) {

        CategoryViewModel authorViewModel = null;
        if (value != null) {
            authorViewModel = new CategoryViewModel();
            authorViewModel.setType(value.getType());
            authorViewModel.setUuid(value.getUuid());
            authorViewModel.setTitle(value.getTitle());
        }
        return authorViewModel;
    }
}
