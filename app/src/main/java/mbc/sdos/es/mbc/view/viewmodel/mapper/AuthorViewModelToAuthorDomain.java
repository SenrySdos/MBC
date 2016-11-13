package mbc.sdos.es.mbc.view.viewmodel.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.AuthorDomain;
import mbc.sdos.es.mbc.view.viewmodel.AuthorViewModel;

/**
 * Created by jose.fernandez on 12/11/2016.
 */

public class AuthorViewModelToAuthorDomain extends Mapper<AuthorViewModel, AuthorDomain> {

    @Inject
    public AuthorViewModelToAuthorDomain() {
    }

    @Override
    public AuthorDomain map(AuthorViewModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AuthorViewModel reverseMap(AuthorDomain value) {

        AuthorViewModel authorViewModel = null;
        if (value != null) {
            authorViewModel = new AuthorViewModel();
            authorViewModel.setUuid(value.getUuid());
            authorViewModel.setDescription(value.getDescription());
            authorViewModel.setFacebook(value.getFacebook());
            authorViewModel.setGmail(value.getGmail());
            authorViewModel.setImage(value.getImage());
            authorViewModel.setName(value.getName());
            authorViewModel.setTitle(value.getTitle());
            authorViewModel.setTwitter(value.getTwitter());
            authorViewModel.setUuid(value.getUuid());
            authorViewModel.setType(value.getType());
            authorViewModel.setWeb(value.getWeb());
        }
        return authorViewModel;
    }
}
