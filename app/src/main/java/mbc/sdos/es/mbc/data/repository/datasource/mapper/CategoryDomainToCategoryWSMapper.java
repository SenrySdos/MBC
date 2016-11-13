package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.CategoryApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.CategoryDomain;

public class CategoryDomainToCategoryWSMapper extends Mapper<CategoryDomain, CategoryApi> {

    @Inject
    public CategoryDomainToCategoryWSMapper() {
    }

    @Override
    public CategoryApi map(CategoryDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CategoryDomain reverseMap(CategoryApi value) {
        CategoryDomain categoryDomain = null;
        if (value != null) {
            categoryDomain = new CategoryDomain();
            categoryDomain.setUuid(value.getUuid());
            categoryDomain.setType(value.getType());
            categoryDomain.setTitle(value.getTitle());
        }
        return categoryDomain;
    }
}
