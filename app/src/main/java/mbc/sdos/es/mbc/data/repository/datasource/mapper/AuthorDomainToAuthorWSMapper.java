package mbc.sdos.es.mbc.data.repository.datasource.mapper;

import javax.inject.Inject;

import mbc.sdos.es.mbc.data.entity.dto.object.AuthorApi;
import mbc.sdos.es.mbc.data.repository.datasource.Mapper;
import mbc.sdos.es.mbc.domain.model.AuthorDomain;

public class AuthorDomainToAuthorWSMapper extends Mapper<AuthorDomain, AuthorApi> {

    @Inject
    public AuthorDomainToAuthorWSMapper() {
    }

    @Override
    public AuthorApi map(AuthorDomain value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AuthorDomain reverseMap(AuthorApi value) {
        AuthorDomain authorDomain = null;
        if (value != null) {
            authorDomain = new AuthorDomain();
            authorDomain.setTitle(value.getTitle());
            authorDomain.setDescription(value.getDescription());
            authorDomain.setFacebook(value.getFacebook());
            authorDomain.setGmail(value.getGmail());
            authorDomain.setImage(value.getImage());
            authorDomain.setName(value.getName());
            authorDomain.setTwitter(value.getTwitter());
            authorDomain.setType(value.getType());
            authorDomain.setUuid(value.getUuid());
            authorDomain.setWeb(value.getWeb());
        }
        return authorDomain;
    }


}
